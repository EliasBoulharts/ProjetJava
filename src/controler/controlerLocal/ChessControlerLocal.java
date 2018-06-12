package controler.controlerLocal;

import javax.swing.*;

import model.business.ChessGameModel;
import tools.data.Coord;
import tools.data.Couleur;
import controler.ChessGameControlerModelVue;
import vue.ChessGridGUI;

import java.awt.*;

public class ChessControlerLocal implements ChessGameControlerModelVue {

    private ChessGameModel chessGame;
    private ChessGridGUI chessBoard;

    public ChessControlerLocal(ChessGameModel chessGame) {
        // TODO Auto-generated constructor stub
        this.chessGame = chessGame;
    }

    @Override
    public void actionsWhenPieceIsSelectedOnGUI(Coord pieceToMoveCoord,
                                                Couleur pieceToMoveCouleur) {
        // TODO Auto-generated method stub
        Component component = this.chessBoard.getComponentAt(pieceToMoveCoord.getX(),pieceToMoveCoord.getY());
        if  (!(component instanceof JPanel)){
            if (this.isPlayerOk(pieceToMoveCouleur)) {

                MouseInfo e;
                Point parentLocation = component.getParent().getLocation();
                xAdjustment = parentLocation.x - e.getX();
                yAdjustment = parentLocation.y - e.getY();
                chessPiece = (JLabel) c;
                chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
                chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
                chessBoard.add(chessPiece, JLayeredPane.DRAG_LAYER);
            }
        }

    }

    @Override
    public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord,
                                             Coord targetCoord) {
        // TODO Auto-generated method stub
        chessGame.move(pieceToMoveCoord.getX(), pieceToMoveCoord.getY(), targetCoord.getX(), targetCoord.getY());

    }

    @Override
    public void setGridPanel(ChessGridGUI panel) {
        // TODO Auto-generated method stub
        chessBoard = panel;

    }

    @Override
    public boolean isPlayerOk(Couleur pieceToMoveCouleur) {
        // TODO Auto-generated method stub
        if (pieceToMoveCouleur.equals(chessGame.getColorCurrentPlayer())) {
            return true;
        }
        return false;
    }

}
