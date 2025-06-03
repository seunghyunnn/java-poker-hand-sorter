package main;

import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;
    private HandRank rank;

    public Hand(List<Card> cards) {
        this.cards = cards;
        Collections.sort(this.cards);
        this.rank = calculateRank();
    }

    public HandRank getRank() {
        return this.rank;
    }

    public int compareTo(Hand other) {
        HandRank myRank = this.rank;
        HandRank otherRank = other.getRank();
        if (myRank.getValue() != otherRank.getValue()) {
            return Integer.compare(myRank.getValue(), otherRank.getValue());
        }
        for (int i = 0; i < myRank.getTieBreakingList().size(); i++) {
            int cmp = Integer.compare(myRank.getTieBreakingList().get(i), otherRank.getTieBreakingList().get(i));
            if (cmp != 0) return cmp;
        }
        return 0;
    }

    /**
     * Calculates the rank of the hand.
     *
     * Each rank represents:
     * 10 - Royal flush
     * 9 - Straight flush
     * 8 - Four of a kind
     * 7 - Full house
     * 6 - Flush
     * 5 - Straight
     * 4 - Three of a kind
     * 3 - Two pairs
     * 2 - Pair
     * 1 - High card
     *
     * @return a HandRank instance representing the rank and tie-breaking values
     */
    private HandRank calculateRank() {
        // Count occurrences of each card value and suit.
        Map<Integer, Integer> valueCounts = new HashMap<>();
        Map<Character, Integer> suitCounts = new HashMap<>();
        for (Card card : cards) {
            int value = card.getValue();
            char suit = card.getSuit();
            valueCounts.put(value, valueCounts.getOrDefault(value, 0) + 1);
            suitCounts.put(suit, suitCounts.getOrDefault(suit, 0) + 1);
        }

        // Calculate isFlush and isStraight once, as they are used in multiple checks.
        boolean isFlush = suitCounts.size() == 1;
        boolean isStraight = hasStraight();

        List<Integer> tieBreakingList = buildTieBreakingList(valueCounts);

        // Check if the hand satisfies each rank from highest to lowest
        // Checking from the highest ensures that if a hand matches multiple patterns
        // the highest-ranking one is returned.
        if (isFlush && isStraight && this.cards.get(0).getValue() == 14) return new HandRank(10, tieBreakingList);
        if (isFlush && isStraight) return new HandRank(9, tieBreakingList);
        if (valueCounts.containsValue(4)) return new HandRank(8, tieBreakingList);
        if (valueCounts.containsValue(3) && valueCounts.containsValue(2)) return new HandRank(7, tieBreakingList);
        if (isFlush) return new HandRank(6, tieBreakingList);
        if (isStraight) return new HandRank(5, tieBreakingList);
        if (valueCounts.containsValue(3)) return new HandRank(4, tieBreakingList);
        if (valueCounts.values().stream().filter(v -> v == 2).count() == 2) return new HandRank(3, tieBreakingList);
        if (valueCounts.containsValue(2)) return new HandRank(2, tieBreakingList);
        return new HandRank(1, tieBreakingList);
    }

    private boolean hasStraight() {
        for (int i = 0; i < this.cards.size() - 1; i++) {
            if(this.cards.get(i).getValue() - 1 != this.cards.get(i + 1).getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Builds a list used for tie-breaking.
     * The list is sorted in two steps:
     *  - First, by the occurrence of each card value (i.e., valueCount's value) in descending order.
     *  - Second, by the card value itself (i.e., valueCount's key) in descending order when frequencies are equal.
     * This ensures that card values used to determine the rank appear first (as the rank of  the hand is determined by
     * card with high occurrences), followed by remaining high cards, preserving correct tie-breaking order.
     *
     * @param valueCounts a map of card values to their occurrences
     * @return a list of card values sorted for tie-breaking
     */
    private List<Integer> buildTieBreakingList(Map<Integer, Integer> valueCounts) {
        return valueCounts.entrySet().stream()
                .sorted((a, b) -> {
                    int cmp = Integer.compare(b.getValue(), a.getValue());
                    return cmp != 0 ? cmp : Integer.compare(b.getKey(), a.getKey());
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

