package code;

/**
 * Created by Artur Komendatskyi on 2017-08-04.
 */
public enum Rank {
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private int numValue;

    Rank(int numValue){
        this.numValue = numValue;
    }

    public int getNumValue(){
        return numValue;
    }

    @Override
    public String toString(){
        switch(this) {
            case SIX: return "6";
            case SEVEN: return "7";
            case EIGHT: return "8";
            case NINE: return "9";
            case TEN: return "10";
            case JACK: return "J";
            case QUEEN: return "Q";
            case KING: return "K";
            case ACE: return "A";
            default: throw new IllegalArgumentException();
        }
    }
}
