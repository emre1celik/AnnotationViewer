package NL.HAN.PG2.SubFrame;

import javax.swing.JInternalFrame;

/**
 * Created by christiaan on 11-3-2015.
 */

public class SubFrame extends JInternalFrame {
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;

    public SubFrame(String header) {
        super(header, true, true, true, true);
        openFrameCount++;
        setSize(300,300);
        setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
    }
}


