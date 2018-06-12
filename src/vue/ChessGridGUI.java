package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import tools.BoardGameConfig;
import tools.data.Coord;
import tools.data.Couleur;
import tools.data.ChessPiecePos;
import tools.factory.ChessImageProvider;

public class ChessGridGUI extends JLayeredPane {
	Map<Coord, ChessSquareGUI> map = new HashMap<Coord, ChessSquareGUI>();
	public ChessGridGUI(){
		this.setLayout(new GridLayout(BoardGameConfig.getNbLigne(), BoardGameConfig.getNbColonne()));

		for (int i = 0; i<BoardGameConfig.getNbColonne(); i++){
			for (int j = 0;j<BoardGameConfig.getNbLigne();j++){
				ChessSquareGUI square;
				Coord coord = new Coord (i, j);
				if ((i+j)%2 == 0){
					square = new ChessSquareGUI(BoardGameConfig.getWhiteSquareColor(), coord);
				}				else{
					square = new ChessSquareGUI(BoardGameConfig.getBlackSquareColor(), coord);
				}
				this.add(square);
				map.put((square).getCoord(), square);	
			}
		}
		JPanel square;
		JLabel chessPieceGUI = null;
		int index;	

		for (int i = 0; i < ChessPiecePos.values().length; i++) {
			for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
				// fabrication de l'image de la pièce
				chessPieceGUI = new ChessPieceGUI(
						ChessPiecePos.values()[i].couleur,
						ChessPiecePos.values()[i].nom,
						new ImageIcon(ChessImageProvider.getImageFile(
								ChessPiecePos.values()[i].nom,
								ChessPiecePos.values()[i].couleur)));
				// ajout de l'image de piece sur le carre
				index = ChessPiecePos.values()[i].coords[j].getY() * 8 +
						ChessPiecePos.values()[i].coords[j].getX();
				square = (JPanel) this.getComponent(index);
				square.add(chessPieceGUI);
				this.findComponentAt(0,1);
			}
		}
	}
	public Coord findCoords(int xpos, int ypos){
		Component c = this.findComponentAt(xpos, ypos);
		if (c instanceof ChessPieceGUI) {
			c = c.getParent();
		}
		if (c instanceof ChessSquareGUI) {
			return ((ChessSquareGUI) c).getCoord();
		} else {
			return null;
		}
	}

	public Couleur findColor(Coord coord){
		Component c = map.get(coord).getComponent(0);
		return ((ChessPieceGUI)c).getCouleur();


	}
}
