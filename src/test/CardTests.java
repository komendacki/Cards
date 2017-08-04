package test;

import code.Card;
import code.Rank;
import code.Suit;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Artur Komendatskyi on 2017-08-04.
 */
public class CardTests {

    @Test
    public void testCreateNewCard(){
        Card card = new Card(Rank.EIGHT, Suit.HEARTS);
        assertNotNull(card);
    }

    @Test
    public void testValuesOfNewCard() {
        Card card = new Card(Rank.ACE, Suit.CLUBS);
        assertEquals(card.getRank(), Rank.ACE);
        assertEquals(card.getSuit(), Suit.CLUBS);
    }

    @Test
    public void testCardsEqual(){
        Card firstCard = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card secondCard = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card thirdCard = new Card(Rank.QUEEN, Suit.SPADES);
        Card fourthCard = new Card(Rank.QUEEN, Suit.SPADES);

        assertEquals(firstCard, secondCard);
        assertEquals(thirdCard, fourthCard);
        assertFalse(firstCard.equals(thirdCard));
        assertFalse(secondCard.equals(fourthCard));
    }

    @Test
    public void testCardToString(){
        Card card = new Card(Rank.JACK, Suit.SPADES);
        String expectedString = Rank.valueOf("JACK").toString() + " " + Suit.valueOf("SPADES").toString();
        assertEquals(expectedString, card.toString());
    }
}
