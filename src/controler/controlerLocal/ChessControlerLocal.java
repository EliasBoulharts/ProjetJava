package controler.controlerLocal;

import javax.swing.*;

import model.business.ChessGameModel;
import tools.data.Coord;
import tools.data.Couleur;
import controler.ChessGameControlerModelVue;
import vue.ChessGridGUI;

import java.awt.*;
import java.awt.event.MouseEvent;

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
