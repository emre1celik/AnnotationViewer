package NL.HAN.PG2.FileHandeling;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompound;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompoundSet;
import org.biojava.nbio.core.sequence.io.FastaReader;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;
import org.biojava.nbio.core.sequence.io.GenericFastaHeaderParser;
import org.biojava.nbio.core.sequence.io.ProteinSequenceCreator;
/**
 * Created by christiaan on 23-3-2015.
 */
public class FileHandeling {
    private String name;
    private String type;
    private File adres;

    public void setFile(String fileadres){
        String ext = "";
        adres = new File(fileadres);

        int i = fileadres.lastIndexOf('.');
        if (i >= 0) {
            ext = fileadres.substring(i+1);
        }
        FileExtension extenum = FileExtension.valueOf(ext.toLowerCase());

        switch (extenum)
        {
            case fa:
                type = "Fasta";
                break;
            case fasta:
                type = "Fasta";
                break;
            case gff:
                type = "gff";
                break;
            case gbk:
                type = "Genbank";
                break;
        }
    }
    public String getType(){
        return type;
    }
    public void openFile(){
        FileExtension typeenum = FileExtension.valueOf(type);

        switch (typeenum){
            case Fasta:

        }
    }
    public void saveFile(){

    }

    public enum FileExtension{
        fasta,
        fa,
        gff,
        gbk,
        Genbank,
        Fasta
    }

}
