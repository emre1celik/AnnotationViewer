package NL.HAN.PG2.main;

import NL.HAN.PG2.FileHandeling.FileHandeling;

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
        test.setFile("C:\\Users\\Chris Cornelisse\\Documents\\GitHub\\AnnotationViewer\\test\\test.fa", 1);
        System.out.println(test.getType());
        test.openFile();
    }
}
