package tests;

import main.Card;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {
    @Test
    public void testParseCardsWithNumericValue() {
        Card card1 = Card.fromString("2J");
        Card card2 = Card.fromString("9C");
        assertEquals(2, card1.getValue());
        assertEquals('J', card1.getSuit());
        assertEquals(9, card2.getValue());
        assertEquals('C', card2.getSuit());
    }

    @Test
    public void testParseCardsWithTextValue() {
        Card card1 = Card.fromString("TJ");
        Card card2 = Card.fromString("AC");
        assertEquals(10, card1.getValue());
        assertEquals('J', card1.getSuit());
        assertEquals(14, card2.getValue());
        assertEquals('C', card2.getSuit());
    }
}

