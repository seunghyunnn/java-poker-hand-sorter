package main;

public class Card implements Comparable<Card> {
    private int value;
    private char suit;

    public Card(int value, char suit) {
        this.value = value;
        this.suit = suit;
    }

    public static Card fromString(String s){
        return new Card(parseValue(s.charAt(0)), s.charAt(1));
    }

    public int compareTo(Card other) {
        return Integer.compare(other.getValue(), this.value); // Descending order
    }

    public int getValue() {
        return this.value;
    }

    public char getSuit() {
        return this.suit;
    }

    private static int parseValue(char c) {
        switch(c) {
            case 'T': return 10;
            case 'J': return 11;
            case 'Q': return 12;
            case 'K': return 13;
            case 'A': return 14;
            default: return c - '0';
        }
    }
}

