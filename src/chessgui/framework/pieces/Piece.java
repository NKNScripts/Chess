/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgui.framework.pieces;

import chessgui.framework.board.BitPiece;

/**
 * @author Christopher.Shafer
 */
public class Piece {
    public String icon;
    public BitPiece bitPiece;


    public Piece(int pieceType, int location) {
        this.bitPiece = new BitPiece(location, pieceType);
        this.icon = getIconString(this.bitPiece);
    }

    public String getIconString(BitPiece bitPiece) {
        switch (bitPiece.getPieceValue()) {
            case 1:
                return "\u2655";
            case 2:
                return "\u2656";
            case 3:
                return "\u2657";
            case 4:
                return "\u2658";
            case 5:
                return "\u2659";
            case 6:
                return "\u2654";
            case -1:
                return "\u265B";
            case -2:
                return "\u265C";
            case -3:
                return "\u265D";
            case -4:
                return "\u265E";
            case -5:
                return "\u265F";
            case -6:
                return "\u265A";

        }

        return null;
    }

    public Piece(BitPiece bitPiece) {
        this.bitPiece = bitPiece;
        this.icon = getIconString(bitPiece);
    }

    public Piece copyOf() {
        return new Piece(this.bitPiece);
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public BitPiece getBitPiece() {
        return bitPiece;
    }

    public void setBitPiece(BitPiece bitPiece) {
        this.bitPiece = bitPiece;
    }
}
