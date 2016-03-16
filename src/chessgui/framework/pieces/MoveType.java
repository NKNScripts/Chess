package chessgui.framework.pieces;

/**
 * Created by Christopher.Shafer on 3/16/2016.
 */
public class MoveType {


    public static final MoveType INSTANCE = new MoveType();

    private MoveType() {}

    public boolean validMove(int location, MOVE_TYPE type) {


        return false;
    }

    public enum MOVE_TYPE {
        BLACK_PAWN(new int[]{-16}, true, true, true),
        WHITE_PAWN(new int[]{16}, true, true, true),
        KING(new int[]{15, 16, 17, 1}, true),
        QUEEN(new int[]{15, 16, 17, 1}, false);

        private final int[] validMoves;
        private final boolean singleMove;
        private final boolean pawn;
        private final boolean black;


        MOVE_TYPE(int[] validMoves, boolean singleMove) {
            this.validMoves = validMoves;
            this.singleMove = singleMove;
            this.pawn = false;
            this.black = false;
        }

        MOVE_TYPE(int[] validMoves, boolean singleMove, boolean pawn, boolean black) {
            this.validMoves = validMoves;
            this.singleMove = singleMove;
            this.pawn = pawn;
            this.black = black;
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
