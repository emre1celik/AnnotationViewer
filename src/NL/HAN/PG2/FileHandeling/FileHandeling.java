package NL.HAN.PG2.FileHandeling;

import NL.HAN.PG2.DNA.DNA;

import NL.HAN.PG2.Protein.Protein;
import NL.HAN.PG2.RNA.RNA;
import NL.HAN.PG2.Sequence.Sequence;
import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.RNASequence;

import java.io.*;
import java.util.EmptyStackException;

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

        i = fileadres.lastIndexOf('\\');
        if (i>=0) {
            name = fileadres.substring(i+1);
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

    public String getName() {return name; }

    public Sequence openFile() throws EmptyStackException{
        FileExtension typeenum = FileExtension.valueOf(type);
        switch (typeenum) {
            case gff:
                break;
            case Fasta:
                try {
                    Sequence returner = readFasta(adres);
                    return returner;
                } catch (IOException ioEx) {
                    System.out.println("File does not exist");
                } catch (EmptyStackException emptySt) {
                    System.out.println("File is not fasta!");
                }
                break;
            case Genbank:
                break;
        }
        throw new EmptyStackException();
    }

    public void saveFile(){

    }

    private Sequence readFasta(File fin) throws IOException {
        FileInputStream fis = new FileInputStream(fin);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line = null;
        String header = "";
        String sequence = "";
        int i = 0;

        while ((line = br.readLine()) != null) {
            if(i == 0){
                if(line.charAt(0)!='>'){
                    throw new EmptyStackException();
                }
                header = line;
                i = 1;
            }
            else {
                sequence += line;
            }
        }
        br.close();
        try {
            DNASequence dna = new DNASequence(sequence);
            DNA returnSequence = new DNA();
            returnSequence.setSequence(sequence);
            returnSequence.setName(header);
            return returnSequence;
        }
        catch (CompoundNotFoundException exp){
        }
        try {
            RNASequence rna = new RNASequence(sequence);
            RNA returnSequence = new RNA();
            returnSequence.setSequence(sequence);
            returnSequence.setName(header);
            return returnSequence;
        }
        catch (CompoundNotFoundException exp){
        }
        try {
            ProteinSequence prot = new ProteinSequence(sequence);
            Protein returnSequence = new Protein();
            returnSequence.setSequence(sequence);
            returnSequence.setName(header);
            returnSequence.readingFrame = 0;
        }
        catch (CompoundNotFoundException exp){

        }
        throw new EmptyStackException();
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


