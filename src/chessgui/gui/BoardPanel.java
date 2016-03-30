/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgui.gui;

import chessgui.framework.pieces.MoveType;
import chessgui.framework.pieces.Piece;

import javax.swing.*;
import java.awt.*;


/**
 * @author Christopher.Shafer
 *         TODO:
 *         Change board to 0x88 style.  Make board a 128 integer then bitmask it.
 */

public class BoardPanel extends JPanel {

    public static JPanel squarePanel = new JPanel(new GridLayout(8, 8));
    public static SquareButton[][] squareButtons = new SquareButton[8][8];
    private Piece[] pieces = new Piece[12];
    private int[] board = new int[128];

    public BoardPanel() {
        for (int i = 0; i < board.length; i++) {
            board[i] = i;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                /*
                   Line below creates new squares either white or black.  Calculates color based on if the square position is an even or odd
                 */
                squareButtons[i][j] = (i + j) % 2 == 0 ? new SquareButton(Color.WHITE) : new SquareButton(new Color(150, 150, 150));
                squareButtons[i][j].setBitLocation(((7 - i) * 16) + j);
                //squareButtons[i][j].setText(Integer.toString(squareButtons[i][j].getBitLocation()));
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
        movePiece(new Piece(-5, 19), 117);
        movePiece(new Piece(-6, 20), 19);
        this.add(squarePanel);
    }

    public void movePiece(Piece piece, int location) {
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

    public boolean validMove(Piece piece, int location) {

        return MoveType.INSTANCE.validMove(piece, location);
    }


}
