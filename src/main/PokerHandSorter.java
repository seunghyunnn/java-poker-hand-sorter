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
        try {
            while ((line=reader.readLine()) != null) {
                List<Card> cards = new ArrayList<>();
                String[] cardsInString = line.strip().split(" ");
                for (String str : cardsInString) {
                    cards.add(Card.fromString(str));
                }
                Hand hand1 = new Hand(cards.subList(0, 5));
                Hand hand2 = new Hand(cards.subList(5, 10));
                int rank1 = hand1.getRank();
                int rank2 = hand2.getRank();
            }
        } catch(IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}

