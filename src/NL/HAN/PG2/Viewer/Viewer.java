package NL.HAN.PG2.Viewer;

import NL.HAN.PG2.SubFrame.SubFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


/**
 * Created by christiaan on 11-3-2015.
 */
public class Viewer extends JFrame implements ActionListener {

    JDesktopPane desktop;

    public Viewer(){
        super("Annotation Viewer");
        int inset = 0;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);
        desktop = new JDesktopPane();
        createFrame("Polynucleotide");
        createFrame("Amino acids");
        createFrame("Features");
        setContentPane(desktop);
        setJMenuBar(createMenuBar());

        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        menuBar.add(file);

        JMenuItem menuItem = new JMenuItem("New");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setActionCommand("new");
        menuItem.addActionListener(this);
        file.add(menuItem);

        menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setActionCommand("quit");
        menuItem.addActionListener(this);
        file.add(menuItem);

        JMenu create = new JMenu("Create");
        create.setMnemonic(KeyEvent.VK_C);
        menuBar.add(create);

        menuItem = new JMenuItem("ORF");
        menuItem.setMnemonic(KeyEvent.VK_O);
        create.add(menuItem);

        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        menuBar.add(help);

        menuItem = new JMenuItem("About");
        menuItem.setMnemonic(KeyEvent.VK_A);
        help.add(menuItem);

        return menuBar;
    }

    public void actionPerformed(ActionEvent e) {
        if ("new".equals(e.getActionCommand())) {
            createFrame("Something");
        } else {
            quit();
        }
    }

    protected void createFrame(String header) {
        SubFrame frame = new SubFrame(header);
        frame.setVisible(true);
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }

    protected void quit() {
        System.exit(0);
    }

    public static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        Viewer frame = new Viewer();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

}
