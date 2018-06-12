package vue;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tools.data.Couleur;

public class ChessPieceGUI extends JLabel{
	private Couleur color;
	private Icon icon;
	private String name;

	public ChessPieceGUI (Icon icon, Couleur color){
		super(icon);
		this.color = color;

	}

	public ChessPieceGUI(Couleur couleur, String nom, ImageIcon imageIcon) {
		// TODO Auto-generated constructor stub
		super(imageIcon);
		this.color = couleur;
		this.icon = imageIcon;
		this.name = nom;
	}
	
	public Couleur getCouleur(){
		return this.color;
	}





}
