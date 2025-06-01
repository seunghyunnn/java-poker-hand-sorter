package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PokerHandSorter {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int player1WinsCount = 0;
        int player2WinsCount = 0;
        try {
            while ((line=reader.readLine()) != null) {
                List<Card> cards = new ArrayList<>();
                String[] cardsInString = line.strip().split(" ");
                if (cardsInString.length == 0 || cardsInString[0].isEmpty()) break;
                if (cardsInString.length != 10) {
                    System.err.println("Skipping this input due to incorrect number of cards: " + line);
                    continue;
                }
                for (String str : cardsInString) {
                    cards.add(Card.fromString(str));
                }
                Hand hand1 = new Hand(cards.subList(0, 5));
                Hand hand2 = new Hand(cards.subList(5, 10));
                int result = hand1.compareTo(hand2);
                if (result > 0) player1WinsCount++;
                else if (result < 0) player2WinsCount++;
                // If both hands have an identical set, neither wins.
            }
        } catch(IOException e) {
            System.out.println("An error occurred while reading the file. Finishing the program...");
        } finally {
            System.out.println("Player 1: " + player1WinsCount + " hands.");
            System.out.println("Player 2: " + player2WinsCount + " hands.");
        }
    }
}

