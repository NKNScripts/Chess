/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgui.gui;

import chessgui.framework.pieces.Piece;

import javax.swing.*;
import java.awt.*;


/**
 * @author Christopher.Shafer
 *         <p/>
 *         TODO:
 *         Change board to 0x88 style.  Make board a 128 integer then bitmask it.
 */

public class BoardPanel extends JPanel {

    public static JPanel squarePanel = new JPanel(new GridLayout(8, 8));
    private SquareButton[][] squareButtons = new SquareButton[8][8];
    private Piece[] pieces = new Piece[12];
    private int[] board = new int[128];

    public BoardPanel() {
        for (int i = 0; i < board.length; i++) {
            board[i] = i;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squareButtons[i][j] = (i + j) % 2 == 0 ? new SquareButton(Color.WHITE) : new SquareButton(new Color(150, 150, 150));
                squareButtons[i][j].setBitLocation((i * 16) + j);
                squarePanel.add(squareButtons[i][j]);
            }
        }
        movePiece(new Piece(1, 1), 0);
        movePiece(new Piece(2, 2), 1);
        movePiece(new Piece(3, 3), 2);
        movePiece(new Piece(4, 4), 3);
        movePiece(new Piece(5, 6), 4);
        movePiece(new Piece(6, 7), 5);
        movePiece(new Piece(-1, 17), 6);
        movePiece(new Piece(-2, 18), 7);
        movePiece(new Piece(-3, 19), 16);
        movePiece(new Piece(-4, 20), 17);
        movePiece(new Piece(-5, 19), 18);
        movePiece(new Piece(-6, 20), 19);
        this.add(squarePanel);
    }

    private void movePiece(Piece piece, int location) {
        if((location & 0x88) != 0) {
            System.out.println("Illegal move");
        }
        piece.bitPiece.setBitLocation(location);
        for (SquareButton[] sqArr : squareButtons) {
            for (SquareButton s : sqArr)
                if(s.getBitLocation() == location)
                    s.setPiece(piece);
        }
    }


}
