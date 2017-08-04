package test;

import code.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

/**
 * Created by Artur Komendatskyi on 2017-08-04.
 */
public class DeckTests {

    @Test
    public void testCreateNewDeck(){
        Deck deck = new Deck();
        assertNotNull(deck);
    }

    @Test
    public void testNewDeckHasAllCards() throws NoMoreCardsException{
        Deck deck = new Deck();
        List<Card> allCardsList = new ArrayList<Card>();

        for(Suit suit : Suit.values()){
            for(Rank rank: Rank.values()){
                Card card = new Card(rank, suit);
                allCardsList.add(card);
            }
        }

        int cardsDiffer = 0;
        for(Card card: allCardsList){
            if (!card.equals(deck.getTopCard())) cardsDiffer++;
        }

        assertEquals(0, cardsDiffer);
    }

    @Test
    public void testDeckEmpty()throws NoMoreCardsException{
        Deck deck = new Deck();

        while(deck.hasCards()){
            deck.getTopCard();
        }

        boolean thrown = false;

        try{
            deck.getTopCard();

        }catch(NoMoreCardsException e){
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void testDeckEquals(){
        Deck firstDeck = new Deck();
        Deck secondDeck = new Deck();
        Deck thirdDeck = new Deck();
        Deck fourthDeck = new Deck();

        assertEquals(firstDeck, secondDeck);
        assertEquals(secondDeck, thirdDeck);
        assertEquals(thirdDeck, fourthDeck);

        firstDeck.shuffle();

        assertFalse(firstDeck.equals(secondDeck));
    }

    @Test
    public void testShuffleDeck(){
        Deck deck = new Deck();
        Deck untouchedDeck = new Deck();

        deck.shuffle();

        assertFalse(deck.equals(untouchedDeck));
    }

    @Test
    public void testGetTopCard()throws NoMoreCardsException{
        Deck deck = new Deck();
        Card expectedFirstCard = new Card(Rank.SIX, Suit.SPADES);
        Card expectedSecondCard = new Card(Rank.SEVEN, Suit.SPADES);
        Card expectedThirdCard = new Card(Rank.EIGHT, Suit.SPADES);

        assertEquals(expectedFirstCard, deck.getTopCard());
        assertEquals(expectedSecondCard, deck.getTopCard());
        assertEquals(expectedThirdCard, deck.getTopCard());
    }

    @Test
    public void testPutAllCardIntoDeck()throws NoMoreCardsException{
        Deck deck = new Deck();
        Deck controlDeck = new Deck();

        deck.shuffle();
        deck.getTopCard();
        deck.shuffle();
        deck.getTopCard();
        deck.shuffle();
        deck.getTopCard();

        deck.putAllCardsIntoDeck();
        assertEquals(deck, controlDeck);
    }
}
