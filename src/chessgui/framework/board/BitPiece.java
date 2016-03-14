package chessgui.framework.board;

/**
 * Created by Christopher.Shafer on 2/10/2016.
 */
public class BitPiece {
    private int bitLocation;
    private int pieceValue = 0;

    public BitPiece(int bitLocation, int pieceValue) {
        this.bitLocation = bitLocation;
        this.pieceValue = pieceValue;
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
