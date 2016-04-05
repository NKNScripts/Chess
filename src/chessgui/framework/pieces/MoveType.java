package chessgui.framework.pieces;

import chessgui.gui.BoardPanel;
import chessgui.gui.SquareButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Christopher.Shafer on 3/16/2016.
 */
public class MoveType {


    public static final MoveType INSTANCE = new MoveType();

    private MoveType() {}


    public void clearSquares() {
        for (SquareButton[] a : BoardPanel.squareButtons)
            for (SquareButton s : a)
                s.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
    }

    public void showValidMoves(Piece piece) {
        MOVE_TYPE type = piece.getType();
        switch (type) {
            case WHITE_PAWN: {
                if(validMove(piece, piece.getBitPiece().getBitLocation() + 32)) {
                    SquareButton b = BoardPanel.findButtonLocation(piece.getBitPiece().getBitLocation() + 32);
                    if(b != null)
                        b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                }
                for (int i = 15; i <= 17; i++) {
                    if(validMove(piece, piece.getBitPiece().getBitLocation() + i)) {
                        SquareButton b = BoardPanel.findButtonLocation(piece.getBitPiece().getBitLocation() + i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                    }
                }
                break;
            }
            case BLACK_PAWN: {
                if(validMove(piece, piece.getBitPiece().getBitLocation() + -32)) {
                    SquareButton b = BoardPanel.findButtonLocation(piece.getBitPiece().getBitLocation() - 32);
                    if(b != null)
                        b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                }
                for (int i = 15; i <= 17; i++) {
                    if(validMove(piece, piece.getBitPiece().getBitLocation() - i)) {
                        SquareButton b = BoardPanel.findButtonLocation(piece.getBitPiece().getBitLocation() - i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                    }
                }
                break;
            }

            case KING: {
                for (int i : type.getValidMoves()) {
                    if(validMove(piece, piece.getBitPiece().getBitLocation() + i)) {
                        SquareButton b = BoardPanel.findButtonLocation(piece.getBitPiece().getBitLocation() + i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                    }
                    if(validMove(piece, piece.getBitPiece().getBitLocation() - i)) {
                        SquareButton b = BoardPanel.findButtonLocation(piece.getBitPiece().getBitLocation() - i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                    }

                }
                break;
            }

            case QUEEN: {
                for (int i : type.getValidMoves()) {
                    int holder = piece.getBitPiece().getBitLocation();
                    while (validMove(piece, holder + i)) {
                        SquareButton b = BoardPanel.findButtonLocation(holder + i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                        holder = holder + i;
                    }
                    holder = piece.getBitPiece().getBitLocation();
                    while (validMove(piece, holder - i)) {
                        SquareButton b = BoardPanel.findButtonLocation(holder - i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                        holder = holder - i;
                    }
                }
                break;
            }

            case ROOK: {
                for (int i : type.getValidMoves()) {
                    int holder = piece.getBitPiece().getBitLocation();
                    while (validMove(piece, holder + i)) {
                        SquareButton b = BoardPanel.findButtonLocation(holder + i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                        holder = holder + i;
                    }
                    holder = piece.getBitPiece().getBitLocation();
                    while (validMove(piece, holder - i)) {
                        SquareButton b = BoardPanel.findButtonLocation(holder - i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                        holder = holder - i;
                    }
                }
                break;
            }

            case BISHOP: {
                for (int i : type.getValidMoves()) {
                    int holder = piece.getBitPiece().getBitLocation();
                    while (validMove(piece, holder + i)) {
                        SquareButton b = BoardPanel.findButtonLocation(holder + i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                        holder = holder + i;
                    }
                    holder = piece.getBitPiece().getBitLocation();
                    while (validMove(piece, holder - i)) {
                        SquareButton b = BoardPanel.findButtonLocation(holder - i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                        holder = holder - i;
                    }
                }
                break;
            }

            case KNIGHT: {
                for (int i : type.getValidMoves()) {
                    int holder = piece.getBitPiece().getBitLocation();
                    while (validMove(piece, holder + i)) {
                        SquareButton b = BoardPanel.findButtonLocation(holder + i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                        holder = holder + i;
                    }
                    holder = piece.getBitPiece().getBitLocation();
                    while (validMove(piece, holder - i)) {
                        SquareButton b = BoardPanel.findButtonLocation(holder - i);
                        if(b != null)
                            b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 200, 0)));
                        holder = holder - i;
                    }
                }
                break;
            }
        }
    }

    public boolean validMove(Piece piece, int location) {
        if((location & 0x88) != 0) return false;
        MOVE_TYPE type = piece.getType();
        boolean white = piece.bitPiece.getPieceValue() > 0;
        if(white) {
            if(colorPieceAt(location, true)) return false;
        } else if(colorPieceAt(location, false)) return false;
        int pieceLocation = piece.getBitPiece().getBitLocation();
        int difference = location - pieceLocation;
        switch (type) {
            case BLACK_PAWN: {
                if(pieceAt(location) && (difference == -15 || difference == -17))
                    return true;
                for (int i : type.getValidMoves())
                    if(difference == i) {
                        if(i == -32) {
                            if(!piece.firstMove) continue;
                            return !pieceAt(location) && !pieceAt(location + 16);
                        }
                        return !pieceAt(location);
                    }
                return false;
            }
            case WHITE_PAWN: {
                if(pieceAt(location) && (difference == 15 || difference == 17))
                    return true;
                for (int i : type.getValidMoves())
                    if(difference == i) {
                        if(i == 32) {
                            if(!piece.firstMove) continue;
                            return !pieceAt(location) && !pieceAt(location - 16);
                        }
                        return !pieceAt(location);
                    }
                return false;
            }
            case QUEEN: {
                for (int i : type.getValidMoves()) {
                    if(i == 1) {
                        if(Math.abs(location - pieceLocation) > 6) {
                            return false;
                        }
                    }
                    if((location - pieceLocation) % i == 0) {
                        int jump;
                        if(location - pieceLocation > 0)
                            jump = location - i;
                        else
                            jump = location + i;

                        while (jump != pieceLocation) {
                            if(pieceAt(jump)) return false;
                            if(location - pieceLocation > 0)
                                jump -= i;
                            else
                                jump += i;
                        }
                        return true;
                    }
                }
                return false;

            }
            case KING: {
                for (int i : type.getValidMoves()) {
                    System.out.println(i + "  " + difference);
                    if(difference == i || -difference == i) return true;
                }

                return false;

            }
            case KNIGHT: {
                for (int i : type.getValidMoves()) {
                    System.out.println(i + "  " + difference);
                    if(difference == i || -difference == i) return true;
                }

                return false;

            }
            case ROOK: {
                for (int i : type.getValidMoves()) {
                    if(i == 1) {
                        if(Math.abs(location - pieceLocation) > 6) {
                            return false;
                        }
                    }
                    if((location - pieceLocation) % i == 0) {
                        int jump;
                        if(location - pieceLocation > 0)
                            jump = location - i;
                        else
                            jump = location + i;

                        while (jump != pieceLocation) {
                            if(pieceAt(jump)) return false;
                            if(location - pieceLocation > 0)
                                jump -= i;
                            else
                                jump += i;
                        }
                        return true;
                    }
                }

                return false;

            }
            case BISHOP: {
                for (int i : type.getValidMoves()) {
                    if(i == 1) {
                        if(Math.abs(location - pieceLocation) > 6) {
                            return false;
                        }
                    }
                    if((location - pieceLocation) % i == 0) {
                        int jump;
                        if(location - pieceLocation > 0)
                            jump = location - i;
                        else
                            jump = location + i;

                        while (jump != pieceLocation) {
                            if(pieceAt(jump)) return false;
                            if(location - pieceLocation > 0)
                                jump -= i;
                            else
                                jump += i;
                        }
                        return true;
                    }
                }
                return false;

            }

        }

        return false;
    }

    private boolean colorPieceAt(int location, boolean white) {
        for (SquareButton[] sqArr : BoardPanel.squareButtons) {
            for (SquareButton s : sqArr)
                if(s.getBitLocation() == location && s.getPiece() != null) {
                    if(white)
                        return s.getPiece().bitPiece.getPieceValue() > 0;
                    else
                        return s.getPiece().bitPiece.getPieceValue() < 0;
                }


        }
        return false;
    }

    private boolean pieceAt(int location) {
        for (SquareButton[] sqArr : BoardPanel.squareButtons) {
            for (SquareButton s : sqArr)
                if(s.getBitLocation() == location)
                    return s.getPiece() != null;
        }
        return false;
    }

    public enum MOVE_TYPE {
        BLACK_PAWN(new int[]{-16, -32}, true, true),
        WHITE_PAWN(new int[]{16, 32}, true, true),
        KING(new int[]{15, 16, 17, 1}, true),
        QUEEN(new int[]{15, 16, 17, 1}, false),
        BISHOP(new int[]{15, 17}, false),
        ROOK(new int[]{16, 1}, false),
        KNIGHT(new int[]{31, 33, 14, 18}, true);


        private final int[] validMoves;
        private final boolean singleMove;
        private final boolean pawn;


        MOVE_TYPE(int[] validMoves, boolean singleMove) {
            this.validMoves = validMoves;
            this.singleMove = singleMove;
            this.pawn = false;
        }

        MOVE_TYPE(int[] validMoves, boolean singleMove, boolean pawn) {
            this.validMoves = validMoves;
            this.singleMove = singleMove;
            this.pawn = pawn;
        }

        int[] getValidMoves() {
            return validMoves;
        }

        boolean isSingleMove() {
            return singleMove;
        }

        boolean isPawn() {
            return pawn;
        }
    }
}
