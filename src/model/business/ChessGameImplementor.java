package model.business;

import model.piece.Pieces;

import java.util.List;

public interface ChessGameImplementor{

    public List<Pieces> getBlackPieces();
    public List<Pieces> getWhitePieces();

    public void initChessBoard();
}
