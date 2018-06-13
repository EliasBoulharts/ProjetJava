package model.business;

import java.util.List;

import tools.BoardGameConfig;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

public class ChessModel implements ChessGameModel{
	private Couleur colorCurrentPlayer;
	private ChessImplementor implementor;
	public ChessModel (){
		this.colorCurrentPlayer = BoardGameConfig.getBeginColor();
		this.implementor = new ChessImplementor();
	}

	@Override
	public String toString() {
		return "Color current player : " + colorCurrentPlayer +
				"\nModel :\n" + implementor +
				"\n";
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		// TODO Auto-generated method stub
		return this.colorCurrentPlayer;
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coord> getPieceListMoveOK(int xInit, int yInit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub

		System.out.println(this);
		return null;
	}

	@Override
	public boolean pawnPromotion(int x, int y, String promotionType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

}
