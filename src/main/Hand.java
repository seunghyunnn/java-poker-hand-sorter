package main;

import java.util.*;

public class Hand {
    private List<Card> cards;
    private int rank;

    public Hand(List<Card> cards) {
        this.cards = cards;
        Collections.sort(this.cards);
        this.rank = calculateRank();
    }

    public int getRank() {
        return this.rank;
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
     * @return an integer from 1 to 10 representing the hand's rank
     */
    private int calculateRank() {
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

        // Check if the hand satisfies each rank from highest to lowest
        // Checking from the highest ensures that if a hand matches mutliple patterns,
        // the highest-ranking one is returned.
        if (isFlush && isStraight && this.cards.get(0).getValue() == 14) return 10;
        if (isFlush && isStraight) return 9;
        if (valueCounts.containsValue(4)) return 8;
        if (valueCounts.containsValue(3) && valueCounts.containsValue(2)) return 7;
        if (isFlush) return 6;
        if (isStraight) return 5;
        if (valueCounts.containsValue(3)) return 4;
        if (valueCounts.values().stream().filter(v -> v == 2).count() == 2) return 3;
        if (valueCounts.containsValue(2)) return 2;
        return 1;
    }

    private boolean hasStraight() {
        for (int i = 0; i < this.cards.size() - 1; i++) {
            if(this.cards.get(i).getValue() - 1 != this.cards.get(i + 1).getValue()) {
                return false;
            }
        }
        return true;
    }
}

