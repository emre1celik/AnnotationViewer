package NL.HAN.PG2.Feature;

/**
 * Created by christiaan on 21-3-2015.
 */
public class Feature {
    private String name;
    private int begin;
    private int end;
    private byte color;

    public void setFeature(){
    }
    public String getFeature(){
        return name;
    }
    public int getFeature(String name){
        return begin;
    }
    public byte getFeature(byte empty){
        return color;
    }
}
