package main;

public class Card {
    private int value;
    private char suit;

    Card(int value, char suit) {
        this.value = value;
        this.suit = suit;
    }

    public static Card fromString(String s){
        return new Card(parseValue(s.charAt(0)), s.charAt(1));
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

    public int getValue() {
        return this.value;
    }

    public char getSuit() {
        return this.suit;
    }
}

