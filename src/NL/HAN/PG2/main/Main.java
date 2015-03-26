package NL.HAN.PG2.main;

import NL.HAN.PG2.DNA.DNA;
import NL.HAN.PG2.FileHandeling.FileHandeling;
import NL.HAN.PG2.Protein.Protein;
import NL.HAN.PG2.RNA.RNA;
import NL.HAN.PG2.Sequence.Sequence;
import NL.HAN.PG2.Viewer.Viewer;

import java.util.EmptyStackException;

/**
 * Created by christiaan on 11-3-2015.
 */
public class Main {

    public static void main(String[] args){
        /*
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Viewer temp = new Viewer();
                temp.createAndShowGUI();
            }
        });
        */
        FileHandeling test = new FileHandeling();
        test.setFile("C:\\Users\\Chris Cornelisse\\Documents\\GitHub\\AnnotationViewer\\test\\test.fa");
        System.out.println(test.getType());
        try {
            Sequence tester = test.openFile();
            if( tester instanceof DNA ){
                System.out.println("Is DNA");
            }
            else if( tester instanceof RNA ){
                System.out.println("Is RNA");
            }
            else if(tester instanceof Protein){
                System.out.println("Is Protein");
            }
            else{
                System.out.println("Is nothing??");
            }
        }
        catch (EmptyStackException e){
            System.out.println("Error file opening");
        }
    }
}
