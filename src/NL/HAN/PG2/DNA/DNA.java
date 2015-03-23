package NL.HAN.PG2.DNA;

import NL.HAN.PG2.Polynucleotide.Polynucleotide;
import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence;

/**
 * Created by christiaan on 21-3-2015.
 */
public class DNA extends Polynucleotide {

    public String Transscriber(){
        String rna = "";
        try {
            rna = new DNASequence(this.getSequence()).getRNASequence().toString();
        }
        catch (CompoundNotFoundException exp){
        }
        return rna;
    }
}
