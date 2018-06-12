package model.piece;

import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public class Fou extends AbstractPiece{
    public Fou(Couleur couleur, Coord coord) {
        super.setCouleur(couleur);
        super.setName("Fou");
        super.setCoord(coord);
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        return false;
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        return null;
    }
}
