package NL.HAN.PG2.SubFrame;

import javax.swing.JInternalFrame;
import java.awt.*;

/**
 * Created by christiaan on 11-3-2015.
 */

public class SubFrame extends JInternalFrame {
    static int openFrameCount = 0;
    static final int yOffset = 50;

    public SubFrame(String header) {
        super(header, true, true, true, true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, 200);
        setLocation(0, yOffset*openFrameCount);
        openFrameCount++;
    }
}


