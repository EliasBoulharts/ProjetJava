package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import tools.data.Coord;

public class ChessSquareGUI extends JPanel{
	private final Color color;
	private final Coord coord;

	public ChessSquareGUI(Color color, Coord coord) {
		this.color = color;
		this.coord = coord;
		this.setLayout(new BorderLayout());
		
		setOpaque(false);
		setBackground(this.color);
		setForeground(new Color(100, 100, 100));
		
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(this.color);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public Coord getCoord() {
		// TODO Auto-generated method stub
		return this.coord;
	}
	
	
}

