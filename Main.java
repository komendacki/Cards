package code;

/**
 * Created by Artur Komendatskyi on 2017-08-04.
 */
public class Main {

    public static void main(String ... args){

        Deck deck = new Deck();
        System.out.println("List all cards in the new deck:" + System.lineSeparator());
        int cardCount = 0;

        try{
            while (deck.hasCards()){
                cardCount++;
                System.out.println(deck.getTopCard().toString());
            }

        } catch (NoMoreCardsException e){
            System.out.println(e.getMessage());
        }

        System.out.println(System.lineSeparator() + "Cards: " + cardCount + System.lineSeparator());

        boolean anyCardsLeft = deck.hasCards();
        if(anyCardsLeft) System.out.println("There are still cards left" + System.lineSeparator());
        else System.out.println("The deck is empty now" + System.lineSeparator());

        deck.putAllCardsIntoDeck();
        deck.shuffle();
        System.out.println("Shuffling the deck");

        cardCount = 0;

        System.out.println("The deck afterr shuffling:" + System.lineSeparator());
        try{
            while (deck.hasCards()){
                cardCount++;
                System.out.println(deck.getTopCard().toString());
            }

        }catch(NoMoreCardsException e){
            System.out.println(e.getMessage());
        }

        System.out.println(System.lineSeparator() + "Cards: " + cardCount + System.lineSeparator());
    }
}
