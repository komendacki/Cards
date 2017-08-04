package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Artur Komendatskyi on 2017-08-04.
 */
public class Deck{

    private ArrayList<Card> deque;

    //ArrayDeque might seem like a right structure for a deck of cards, but ArrayList is much better for shuffling

    public Deck(){

        deque = new ArrayList<Card>();

        this.initializeDeck();

    }

    private void initializeDeck(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                deque.add(new Card(rank, suit));
            }
        }
    }

    public Card getTopCard() throws NoMoreCardsException{
        if(deque.isEmpty()) throw new NoMoreCardsException("There are no more cards in the deck!");
        Card topCard = deque.get(0);
        deque.remove(0);
        deque.trimToSize();
        return topCard;

    }

    public void shuffle(){
        int lastCardIndex = deque.size() - 1;
        for(int i= lastCardIndex; i >0; i--){
            int randomCardIndex = ThreadLocalRandom.current().nextInt(0, lastCardIndex);
            Collections.swap(deque, i, randomCardIndex);
        }
    }

    public void putAllCardsIntoDeck(){
        deque.clear();
        this.initializeDeck();
    }

    public boolean hasCards(){
        return !deque.isEmpty();
    }

    @Override
    public boolean equals(Object object){

        if(object == null) return false;

        if(object == this) return false;

        if(object.getClass() != this.getClass()) return false;

        Deck otherDeck = (Deck) object;

        if(deque.equals(otherDeck.deque)) return true;
        else return false;
    }

    @Override
    public int hashCode(){
        return deque.hashCode();
    }
}
