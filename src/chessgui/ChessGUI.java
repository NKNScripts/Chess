/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgui;

import chessgui.gui.BoardPanel;

import javax.swing.*;

/**
 * @author Christopher.Shafer
 */
public class ChessGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new BoardPanel());
                frame.pack();
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
