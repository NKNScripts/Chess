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
    public MoveType.MOVE_TYPE type;
    public boolean firstMove = true;


    public Piece(int pieceType, int location) {
        this.bitPiece = new BitPiece(location, pieceType);
        this.icon = getIconString(this.bitPiece);

    }

    public String getIconString(BitPiece bitPiece) {
        switch (bitPiece.getPieceValue()) {
            case 1: {
                type = MoveType.MOVE_TYPE.QUEEN;
                return "\u2655";
            }
            case 2: {
                type = MoveType.MOVE_TYPE.ROOK;
                return "\u2656";
            }
            case 3: {
                type = MoveType.MOVE_TYPE.BISHOP;
                return "\u2657";
            }
            case 4: {
                type = MoveType.MOVE_TYPE.KNIGHT;
                return "\u2658";
            }
            case 5: {
                type = MoveType.MOVE_TYPE.WHITE_PAWN;
                return "\u2659";
            }
            case 6: {
                type = MoveType.MOVE_TYPE.KING;
                return "\u2654";
            }
            case -1: {
                type = MoveType.MOVE_TYPE.QUEEN;
                return "\u265B";
            }
            case -2: {
                type = MoveType.MOVE_TYPE.ROOK;
                return "\u265C";
            }
            case -3: {
                type = MoveType.MOVE_TYPE.BISHOP;
                return "\u265D";
            }
            case -4: {
                type = MoveType.MOVE_TYPE.KNIGHT;
                return "\u265E";
            }
            case -5: {
                type = MoveType.MOVE_TYPE.BLACK_PAWN;
                return "\u265F";
            }
            case -6: {
                type = MoveType.MOVE_TYPE.KING;
                return "\u265A";
            }

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

    public MoveType.MOVE_TYPE getType() {
        return type;
    }
}
