package chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Chessboard panel class responsible for drawing the chessboard and listening to user actions
class MainPanel extends JPanel implements MouseListener, MouseMotionListener {
    private int width, height;
    private ChessModel cm;

    // Constructor, initializes the chessboard panel
    MainPanel(ChessModel mm) {
        cm = mm;
        width = cm.getWidth();
        height = cm.getHeight();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    // Sets the chessboard model
    public void setModel(ChessModel mm) {
        cm = mm;
        width = cm.getWidth();
        height = cm.getHeight();
    }

    // Draws the chessboard and pieces
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int j = 0; j <= height; j++) {
            for (int i = 0; i <= width; i++) {
                int v = cm.getarrMapShow()[i][j];
                draw(g, i, j, v);
            }
        }
    }

    // Draws the details of a piece
    public void draw(Graphics g, int i, int j, int v) {
        int x = 20 * i + 20;
        int y = 20 * j + 20;
        if (i != width && j != height) {
            g.setColor(Color.darkGray);
            g.drawRect(x, y, 20, 20);
        }
        if (v == 1) {
            g.setColor(Color.gray);
            g.drawOval(x - 8, y - 8, 16, 16);
            g.setColor(Color.black);
            g.fillOval(x - 8, y - 8, 16, 16);
        }
        if (v == 2) {
            g.setColor(Color.gray);
            g.drawOval(x - 8, y - 8, 16, 16);
            g.setColor(Color.white);
            g.fillOval(x - 8, y - 8, 16, 16);
        }
        if (v == 3) {
            g.setColor(Color.cyan);
            g.drawOval(x - 8, y - 8, 16, 16);
        }
    }

    // Handles mouse press events
    public void mousePressed(MouseEvent evt) {
        int x = (evt.getX() - 10) / 20;
        int y = (evt.getY() - 10) / 20;
        System.out.println(x + " " + y);
        if (evt.getModifiers() == MouseEvent.BUTTON1_MASK) {
            cm.play(x, y);
            System.out.println(cm.getisOdd() + " " + cm.getarrMapShow()[x][y]);
            repaint();
            if (cm.judgeSuccess(x, y, cm.getisOdd())) {
                cm.showSuccess(this);
                evt.consume();
                ChessFrame.iscomputer = false;
            }
            if (ChessFrame.iscomputer && !cm.getisExist()) {
                cm.computerDo(cm.getWidth(), cm.getHeight());
                repaint();
                if (cm.judgeSuccess(cm.getX(), cm.getY(), cm.getisOdd())) {
                    cm.showDefeat(this);
                    evt.consume();
                }
            }
        }
    }

    public void mouseClicked(MouseEvent evt) {
    }

    public void mouseReleased(MouseEvent evt) {
    }

    public void mouseEntered(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
    }

    public void mouseDragged(MouseEvent evt) {
    }

    public void mouseMoved(MouseEvent evt) {
        int x = (evt.getX() - 10) / 20;
        int y = (evt.getY() - 10) / 20;
        cm.readyplay(x, y);
        repaint();
    }
}
