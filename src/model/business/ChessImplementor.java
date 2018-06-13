package model.business;

import model.piece.AbstractPiece;
import model.piece.Pieces;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;
import tools.factory.ChessPiecesFactory;

import java.util.List;

public class ChessImplementor implements ChessGameImplementor {
    private List<Pieces> blackList;
    private List<Pieces> whiteList;
    private Pieces selectedPiece;

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

    public boolean findSelectedPiece(Couleur currentColor, int x, int y){
        List<Pieces> pieces;
        this.selectedPiece = null;
        boolean find = false;
        //choix de la liste à parcourir
        if (currentColor.equals(Couleur.BLANC))pieces = whiteList;
        else pieces = blackList;
        for(Pieces piece : pieces){
            if(piece.getX()==x && piece.getY()==y){
                this.selectedPiece = piece;
                find = true;
                break;
            }
        }
        return find;
    }

    public Pieces checkFinalPos(int x, int y){
        Pieces square = null;
        List<Pieces> pieces = null;
        pieces.addAll(whiteList);
        pieces.addAll(blackList);
        for(Pieces piece : pieces) {
            if(piece.getX() == x && piece.getY() == y){
                square = piece;
            }
        }
        return square;

    }

    public void movePiece(Couleur colorCurrentPlayer, int xInit, int yInit, int xFinal, int yFinal){
        if(this.findSelectedPiece(colorCurrentPlayer,xInit,yInit)){
            Pieces target = this.checkFinalPos(xFinal,yFinal);
            if(target != null){
                if(target.getCouleur().equals(colorCurrentPlayer)){
                    return;
                }
                else{
                    if (colorCurrentPlayer.equals(Couleur.BLANC))whiteList.remove(target);
                    else blackList.remove(target);
                }
            }
            ((AbstractPiece) selectedPiece).setCoord(new Coord(xFinal,yFinal));
            //move à x y final

        }
        for(Pieces piece : whiteList) {
            if(piece.getX() == xFinal && piece.getY() == yFinal && !(colorCurrentPlayer.equals(piece.getCouleur()))){
                //Manger la piece présente  && placer piece de l'autre couleur à sa nouvelle position

            }
        }

         //placer piece de currentcolor à sa nouvelle position
    }


}

