package vue;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controler.ChessGameControlerModelVue;

public class ChessGridGUIListener implements MouseListener,MouseMotionListener {
	private JLabel chessPiece;
	private int xAdjustment;
	private int yAdjustment;
	private ChessGridGUI chessGrid;
	private ChessGameControlerModelVue chessGameControler;

	public ChessGridGUIListener(ChessGridGUI chessGridGUI,
			ChessGameControlerModelVue chessGameControler) {
		// TODO Auto-generated constructor stub
		this.chessGrid = chessGridGUI;
		this.chessGameControler = chessGameControler;
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO Auto-generated method stub
		if (chessPiece == null)  
			return;

		chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	}

	//Drop the chess piece back onto the chess board



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		chessPiece = null;
		Component c =  chessGrid.findComponentAt(e.getX(), e.getY());

		if (c instanceof JPanel) 
			return;

		if (chessGameControler.isPlayerOk(chessGrid.findColor(chessGrid.findCoords(e.getX(), e.getY())))) 
		{

			Point parentLocation = c.getParent().getLocation();
			xAdjustment = parentLocation.x - e.getX();
			yAdjustment = parentLocation.y - e.getY();
			chessPiece = (JLabel)c;
			chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
			chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
			chessGrid.add(chessPiece, JLayeredPane.DRAG_LAYER);
		}
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(chessPiece == null) return;

		chessPiece.setVisible(false);
		Component c =  chessGrid.findComponentAt(e.getX(), e.getY());

		if (c instanceof JLabel){
			Container parent = c.getParent();
			parent.remove(0);
			parent.add( chessPiece );
		}
		else {
			Container parent = (Container)c;
			parent.add( chessPiece );
		}

		chessPiece.setVisible(true);
	}
}

