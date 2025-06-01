package tests;

import main.Card;
import main.Hand;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HandTest {
    private static Hand ROYAL_FLUSH = buildHand(new String[]{"TD", "JD", "QD", "KD", "AD"});
    private static Hand STRAIGHT_FLUSH = buildHand(new String[]{"2H", "3H", "4H", "5H", "6H"});
    private static Hand FOUR_OF_A_KIND = buildHand(new String[]{"5D", "5H", "5S", "5C", "6H"});
    private static Hand FULL_HOUSE = buildHand(new String[]{"5D", "5H", "5S", "TC", "TH"});
    private static Hand FLUSH = buildHand(new String[]{"2S", "3S", "5S", "7S", "TS"});
    private static Hand STRAIGHT = buildHand(new String[]{"8D", "9H", "TS", "JC", "QH"});
    private static Hand THREE_OF_A_KIND = buildHand(new String[]{"3D", "3H", "3S", "4C", "5H"});
    private static Hand TWO_PAIRS = buildHand(new String[]{"3D", "3H", "4S", "4C", "5H"});
    private static Hand PAIR = buildHand(new String[]{"JD", "JH", "4S", "7C", "TH"});
    private static Hand HIGH_CARD = buildHand(new String[]{"AD", "QH", "TS", "7C", "5H"});

    @Test
    public void testGetRank() {
        assertEquals(10, ROYAL_FLUSH.getRank());
        assertEquals(9, STRAIGHT_FLUSH.getRank());
        assertEquals(8, FOUR_OF_A_KIND.getRank());
        assertEquals(7, FULL_HOUSE.getRank());
        assertEquals(6, FLUSH.getRank());
        assertEquals(5, STRAIGHT.getRank());
        assertEquals(4, THREE_OF_A_KIND.getRank());
        assertEquals(3, TWO_PAIRS.getRank());
        assertEquals(2, PAIR.getRank());
        assertEquals(1, HIGH_CARD.getRank());
    }

    private static Hand buildHand(String[] cardsInString) {
        ArrayList<Card> cards = new ArrayList<>();
        for (String str : cardsInString) {
            cards.add(Card.fromString(str));
        }
        return new Hand(cards);
    }
}

