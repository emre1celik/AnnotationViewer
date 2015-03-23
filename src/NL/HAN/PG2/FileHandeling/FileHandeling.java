package NL.HAN.PG2.FileHandeling;

import java.io.*;

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
        try {
            readFile(adres);
        }
        catch (IOException ioEx){
            System.out.println("File does not exsist");
        }
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

    private static void readFile(File fin) throws IOException {
        FileInputStream fis = new FileInputStream(fin);

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

}
