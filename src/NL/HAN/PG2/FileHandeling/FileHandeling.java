package NL.HAN.PG2.FileHandeling;


import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;

import java.io.File;
import java.util.LinkedHashMap;

/**
 * Created by christiaan on 23-3-2015.
 */
public class FileHandeling {
    private String name;
    private String type;
    private File adres;
    private int SeqType;

    public void setFile(String fileadres, int kind){
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
        SeqType = kind;
    }
    public String getType(){
        return type;
    }
    public void openFile(){
        FileExtension typeenum = FileExtension.valueOf(type);

        switch (typeenum){
            case gff:
                break;
            case Fasta:

                break;
            case Genbank:
                break;

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

    private void DNARead() throws Exception{
        FastaReaderHelper temp = new FastaReaderHelper();
        LinkedHashMap<String, DNASequence> DNA = new LinkedHashMap<String, DNASequence>(temp.readFastaDNASequence(adres));
    }
}
