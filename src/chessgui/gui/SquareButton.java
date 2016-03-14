package chessgui.gui;

import chessgui.framework.board.SquareMouseListener;
import chessgui.framework.pieces.Piece;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Christopher.Shafer on 1/29/2016.
 */
public class SquareButton extends JButton {
    private Piece piece = null;
    private Font font = new Font("Bitstream Cyberbit", Font.PLAIN, 64);
    private int bitLocation;


    public SquareButton(Color color) {
        this.setBackground(color);
        this.setBorder(null);
        this.addMouseListener(SquareMouseListener.createSquareMouseListener());
        this.setPreferredSize(new Dimension(64, 64));
        this.setFont(font);

    }


    public SquareButton(Color color, Piece piece) {
        this.piece = piece;
        this.setBackground(color);
        this.setBorder(null);
        this.addMouseListener(SquareMouseListener.createSquareMouseListener());
        this.setPreferredSize(new Dimension(64, 64));
    }

    public int getBitLocation() {
        return bitLocation;
    }

    public void setBitLocation(int bitLocation) {
        this.bitLocation = bitLocation;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if(piece != null)
            this.setText(piece.getIcon());
        else
            this.setText(null);
    }


    @Override
    public String toString() {
        return "Piece: " + this.piece + ", Color: " + this.getBackground();
    }


}
