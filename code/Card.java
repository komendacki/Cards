package code;


/**
 * Created by Artur Komendatskyi on 2017-08-04.
 */
public class Card {

    private final Rank rank;

    private final Suit suit;

    public Rank getRank(){
        return this.rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString(){
        return this.getRank().toString() + " " + this.getSuit().toString();
    }

    @Override
    public boolean equals(Object object){

        if (object == this) return true;

        if (object == null || object.getClass() != this.getClass()) return false;

        Card otherCard = (Card) object;
        return (rank == otherCard.rank
                || (rank != null && rank.equals(otherCard.rank)))
                && (suit == otherCard.suit
                || (suit != null && suit.equals(otherCard.suit)));
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        return result;
    }

}
