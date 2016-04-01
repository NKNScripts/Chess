package chessgui.framework.board;

import chessgui.framework.pieces.Piece;
import chessgui.gui.BoardPanel;
import chessgui.gui.SquareButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Christopher.Shafer on 2/3/2016.
 */
public class SquareMouseListener implements MouseListener {
    public static boolean colorTurn = false, selected = false;
    public static Piece selectedPiece = null;
    public static SquareButton startSquareButton;

    private SquareMouseListener() {
    }

    public static SquareMouseListener createSquareMouseListener() {
        return new SquareMouseListener();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        selectedPiece = ((SquareButton) e.getSource()).getPiece();
        if(selectedPiece != null && selectedPiece.getBitPiece().getPieceValue() < 0 == colorTurn) {
            selected = true;
            startSquareButton = (SquareButton) e.getSource();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(selected) {
            Container container = ((JComponent) e.getSource()).getParent();
            Point mousePosition = container.getMousePosition();
            if(mousePosition == null) {
                selected = false;
                return;
            }
            SquareButton destination = (SquareButton) container.getComponentAt(mousePosition);
            if(destination != startSquareButton) {
                BoardPanel panel = (BoardPanel) ((JComponent) e.getSource()).getParent().getParent();
                if(panel.validMove(selectedPiece, destination.getBitLocation())) {
                    panel.movePiece(selectedPiece, destination.getBitLocation());
                    selectedPiece.firstMove = false;
                    startSquareButton.setPiece(null);
                    startSquareButton = null;
                    colorTurn = !colorTurn;
                }


            }


        }
        selected = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
