/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgui;

import chessgui.gui.BoardPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                final BoardPanel panel = new BoardPanel();
                JMenuBar menuBar = new JMenuBar();
                JMenu menuOption = new JMenu("File");
                JMenuItem newGame = new JMenuItem("New Game");
                newGame.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.newGame();
                    }
                });
                menuOption.add(newGame);
                menuBar.add(menuOption);
                frame.setJMenuBar(menuBar);
                frame.add(panel);
                frame.pack();
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
