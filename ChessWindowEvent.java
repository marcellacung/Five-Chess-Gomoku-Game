package chess;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Window event class responsible for handling window close events
class ChessWindowEvent extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    ChessWindowEvent() {
    }
}
