package NL.HAN.PG2.Sequence;


/**
 * Created by christiaan on 21-3-2015.
 */
public class Sequence {
    private static String sequence;

    public static void setSequence(String inputSequence){
        sequence = inputSequence;
    }

    public String getSequence(){
        return sequence;
    }

    public int getLength(){
        return sequence.length();
    }
}
