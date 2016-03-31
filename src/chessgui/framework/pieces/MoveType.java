package chessgui.framework.pieces;

import chessgui.gui.BoardPanel;
import chessgui.gui.SquareButton;

/**
 * Created by Christopher.Shafer on 3/16/2016.
 */
public class MoveType {


    public static final MoveType INSTANCE = new MoveType();

    private MoveType() {}

    private boolean pieceAt(int location) {
        for (SquareButton[] sqArr : BoardPanel.squareButtons) {
            for (SquareButton s : sqArr)
                if(s.getBitLocation() == location)
                    return s.getPiece() != null;
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

    public boolean validMove(Piece piece, int location) {
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
                        System.out.println("Here");
                        return true;
                    }
                return false;
            }
            case WHITE_PAWN: {
                if(pieceAt(location) && (difference == 15 || difference == 17))
                    return true;
                for (int i : type.getValidMoves())
                    if(difference == i)
                        return true;
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
                    if(location % i == 0) {
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

    public enum MOVE_TYPE {
        BLACK_PAWN(new int[]{-16}, true, true),
        WHITE_PAWN(new int[]{16}, true, true),
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
