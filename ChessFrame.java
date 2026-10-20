package chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Main window class responsible for creating the main window and menu of the Five Chess game
class ChessFrame extends JFrame implements ActionListener {
    private String[] strsize = {"Standard Board", "Improved Board", "Enlarged Board"};
    private String[] strmode = {"Human vs. Computer", "Human vs. Human"};
    public static boolean iscomputer = true, checkcomputer = true;
    private int width, height;
    private ChessModel cm;
    private MainPanel mp;

    // Constructor, initializes the main game window
    public ChessFrame() {
        this.setTitle("Five Chess Game");
        cm = new ChessModel(1);
        mp = new MainPanel(cm);
        Container con = this.getContentPane();
        con.add(mp, "Center");
        this.setResizable(false);
        this.addWindowListener(new ChessWindowEvent());
        MapSize(14, 14);
        JMenuBar mbar = new JMenuBar();
        this.setJMenuBar(mbar);
        JMenu gameMenu = new JMenu("Game");
        mbar.add(makeMenu(gameMenu, new Object[]{
            "Start", null, "Board", null, "Mode", null, "Exit"
        }, this));
        JMenu lookMenu = new JMenu("Appearance");
        mbar.add(makeMenu(lookMenu, new Object[]{
            "Type One", "Type Two", "Type Three"
        }, this));
        JMenu helpMenu = new JMenu("Version");
        mbar.add(makeMenu(helpMenu, new Object[]{
            "About"
        }, this));
    }

    // Creates the menu
    public JMenu makeMenu(Object parent, Object items[], Object target) {
        JMenu m = null;
        if (parent instanceof JMenu)
            m = (JMenu) parent;
        else if (parent instanceof String)
            m = new JMenu((String) parent);
        else
            return null;
        for (int i = 0; i < items.length; i++)
            if (items[i] == null)
                m.addSeparator();
            else if (items[i] == "Board") {
                JMenu jm = new JMenu("Board");
                ButtonGroup group = new ButtonGroup();
                JRadioButtonMenuItem rmenu;
                for (int j = 0; j < strsize.length; j++) {
                    rmenu = makeRadioButtonMenuItem(strsize[j], target);
                    if (j == 0)
                        rmenu.setSelected(true);
                    jm.add(rmenu);
                    group.add(rmenu);
                }
                m.add(jm);
            } else if (items[i] == "Mode") {
                JMenu jm = new JMenu("Mode");
                ButtonGroup group = new ButtonGroup();
                JRadioButtonMenuItem rmenu;
                for (int h = 0; h < strmode.length; h++) {
                    rmenu = makeRadioButtonMenuItem(strmode[h], target);
                    if (h == 0)
                        rmenu.setSelected(true);
                    jm.add(rmenu);
                    group.add(rmenu);
                }
                m.add(jm);
            } else
                m.add(makeMenuItem(items[i], target));
        return m;
    }

    // Creates menu items
    public JMenuItem makeMenuItem(Object item, Object target) {
        JMenuItem r = null;
        if (item instanceof String)
            r = new JMenuItem((String) item);
        else if (item instanceof JMenuItem)
            r = (JMenuItem) item;
        else
            return null;
        if (target instanceof ActionListener)
            r.addActionListener((ActionListener) target);
        return r;
    }

    // Creates radio button menu items
    public JRadioButtonMenuItem makeRadioButtonMenuItem(Object item, Object target) {
        JRadioButtonMenuItem r = null;
        if (item instanceof String)
            r = new JRadioButtonMenuItem((String) item);
        else if (item instanceof JRadioButtonMenuItem)
            r = (JRadioButtonMenuItem) item;
        else
            return null;
        if (target instanceof ActionListener)
            r.addActionListener((ActionListener) target);
        return r;
    }

    // Sets the board size
    public void MapSize(int w, int h) {
        setSize(w * 24, h * 27);
        if (checkcomputer)
            iscomputer = true;
        else
            iscomputer = false;
        mp.setModel(cm);
        mp.repaint();
    }

    // Gets whether it is human vs. computer mode
    public boolean getiscomputer() {
        return iscomputer;
    }

    // Restarts the game
    public void restart() {
        int modeChess = cm.getModeChess();
        if (modeChess <= 3 && modeChess >= 0) {
            cm = new ChessModel(modeChess);
            MapSize(cm.getWidth(), cm.getHeight());
        }
    }

    // Menu item event handler
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        try {
            if (arg.equals("Type Three"))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            else if (arg.equals("Type Two"))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            else
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ee) {
        }
        if (arg.equals("Standard Board")) {
            this.width = 14;
            this.height = 14;
            cm = new ChessModel(1);
            MapSize(this.width, this.height);
            SwingUtilities.updateComponentTreeUI(this);
        }
        if (arg.equals("Improved Board")) {
            this.width = 18;
            this.height = 18;
            cm = new ChessModel(2);
            MapSize(this.width, this.height);
            SwingUtilities.updateComponentTreeUI(this);
        }
        if (arg.equals("Enlarged Board")) {
            this.width = 22;
            this.height = 22;
            cm = new ChessModel(3);
            MapSize(this.width, this.height);
            SwingUtilities.updateComponentTreeUI(this);
        }
        if (arg.equals("Human vs. Computer")) {
            checkcomputer = true;
            iscomputer = true;
            cm = new ChessModel(cm.getModeChess());
            MapSize(cm.getWidth(), cm.getHeight());
            SwingUtilities.updateComponentTreeUI(this);
        }
        if (arg.equals("Human vs. Human")) {
            checkcomputer = false;
            iscomputer = false;
            cm = new ChessModel(cm.getModeChess());
            MapSize(cm.getWidth(), cm.getHeight());
            SwingUtilities.updateComponentTreeUI(this);
        }
        if (arg.equals("Start")) {
            restart();
        }
        if (arg.equals("About"))
            JOptionPane.showMessageDialog(null, "Version 1.0", "Version", JOptionPane.PLAIN_MESSAGE);
        if (arg.equals("Exit"))
            System.exit(0);
    }
}
