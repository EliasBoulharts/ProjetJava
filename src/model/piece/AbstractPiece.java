package model.piece;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public abstract class AbstractPiece implements Pieces{
    private Coord coord;
    private Couleur couleur;
    private String name;
    @Override
    public String toString() {
        return "Piece " + getName() + "[x : " + getX() + " ; y : " + getY() + "]";
    }

    @Override
    public int getX() {
        return this.coord.getX();
    }

    @Override
    public int getY() {
        return this.coord.getY();
    }

    @Override
    public Couleur getCouleur() {
        return this.couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ActionType doMove(int xFinal, int yFinal) {
        return null;
    }

    @Override
    public boolean catchPiece() {
        return false;
    }

    public abstract boolean isAlgoMoveOk(int xFinal, int yFinal);

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
        return false;
    }

    public abstract List<Coord> getMoveItinerary(int xFinal, int yFinal);

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public boolean undoLastCatch() {
        return false;
    }
}
