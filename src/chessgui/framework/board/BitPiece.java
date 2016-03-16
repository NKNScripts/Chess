package chessgui.framework.board;

import chessgui.framework.pieces.MoveType;

/**
 * Created by Christopher.Shafer on 2/10/2016.
 */
public class BitPiece {
    private int bitLocation;
    private int pieceValue = 0;
    private MoveType.MOVE_TYPE moveType;

    public BitPiece(int bitLocation, int pieceValue) {
        this.bitLocation = bitLocation;
        this.pieceValue = pieceValue;
        this.moveType = getType();
    }

    private MoveType.MOVE_TYPE getType() {
        switch (Math.abs(pieceValue)) {
            case 1:
                return MoveType.MOVE_TYPE.KING;
            case 2:
                return MoveType.MOVE_TYPE.QUEEN;
            case 5:
                return pieceValue > 0 ? MoveType.MOVE_TYPE.WHITE_PAWN : MoveType.MOVE_TYPE.BLACK_PAWN;
            default:
                return null;
        }
    }

    public BitPiece(int bitLocation) {
        this.bitLocation = bitLocation;
    }

    public int getBitLocation() {
        return bitLocation;
    }

    public void setBitLocation(int bitLocation) {
        this.bitLocation = bitLocation;
    }

    public int getPieceValue() {
        return pieceValue;
    }

    public void setPieceValue(int pieceValue) {
        this.pieceValue = pieceValue;
    }
}
