package NL.HAN.PG2.main;

import NL.HAN.PG2.Viewer.Viewer;

/**
 * Created by christiaan on 11-3-2015.
 */
public class Main {

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Viewer temp = new Viewer();
                temp.createAndShowGUI();
            }
        });
    }
}
