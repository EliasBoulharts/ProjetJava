package model.business;

import model.piece.Pieces;
import tools.data.Couleur;
import tools.factory.ChessPiecesFactory;

import java.util.List;

public class ChessImplementor implements ChessGameImplementor {
    private List<Pieces> blackList;
    private List<Pieces> whiteList;

    @Override
    public String toString() {
        return "blackList : " + blackList +
                "\nwhiteList : " + whiteList +
                "\n";
    }

    public ChessImplementor() {
        initChessBoard();
    }

    @Override
    public List<Pieces> getBlackPieces() {
        return blackList;
    }

    @Override
    public List<Pieces> getWhitePieces() {
        return whiteList;
    }

    @Override
    public void initChessBoard() {
        blackList = ChessPiecesFactory.newPieces(Couleur.NOIR);
        whiteList = ChessPiecesFactory.newPieces(Couleur.BLANC);

    }
}
