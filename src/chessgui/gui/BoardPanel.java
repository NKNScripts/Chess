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
        newGame();
        this.add(squarePanel);
    }

    public void newGame() {
        MoveType.INSTANCE.clearSquares();
        for (SquareButton[] sqArr : squareButtons) {
            for (SquareButton s : sqArr)
                s.setPiece(null);
        }
        movePiece(new Piece(2, 4), 0);
        movePiece(new Piece(4, 2), 1);
        movePiece(new Piece(3, 3), 2);
        movePiece(new Piece(1, 4), 3);
        movePiece(new Piece(6, 6), 4);
        movePiece(new Piece(3, 7), 5);
        movePiece(new Piece(4, 4), 6);
        movePiece(new Piece(2, 18), 7);
        movePiece(new Piece(5, 5), 16);
        movePiece(new Piece(5, 5), 17);
        movePiece(new Piece(5, 5), 18);
        movePiece(new Piece(5, 5), 19);
        movePiece(new Piece(5, 5), 20);
        movePiece(new Piece(5, 5), 21);
        movePiece(new Piece(5, 5), 22);
        movePiece(new Piece(5, 5), 23);
        movePiece(new Piece(-2, 4), 112);
        movePiece(new Piece(-4, 2), 113);
        movePiece(new Piece(-3, 3), 114);
        movePiece(new Piece(-1, 4), 115);
        movePiece(new Piece(-6, 6), 116);
        movePiece(new Piece(-3, 7), 117);
        movePiece(new Piece(-4, 4), 118);
        movePiece(new Piece(-2, 18), 119);
        movePiece(new Piece(-5, 5), 96);
        movePiece(new Piece(-5, 5), 97);
        movePiece(new Piece(-5, 5), 98);
        movePiece(new Piece(-5, 5), 99);
        movePiece(new Piece(-5, 5), 100);
        movePiece(new Piece(-5, 5), 101);
        movePiece(new Piece(-5, 5), 102);
        movePiece(new Piece(-5, 5), 103);
    }

    public void movePiece(Piece piece, int location) {
        if((location & 0x88) != 0) {
            System.out.println(location);
            System.out.println("Illegal move");
            return;
        }

        piece.bitPiece.setBitLocation(location);
        for (SquareButton[] sqArr : squareButtons) {
            for (SquareButton s : sqArr)
                if(s.getBitLocation() == location)
                    s.setPiece(piece);
        }
    }

    public static SquareButton findButtonLocation(int location) {
        for (SquareButton[] a : squareButtons)
            for (SquareButton s : a)
                if(s.getBitLocation() == location)
                    return s;
        return null;
    }

    public boolean validMove(Piece piece, int location) {

        return MoveType.INSTANCE.validMove(piece, location);
    }


}
