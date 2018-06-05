import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Player {
	//fields for player
	private int lives;
	private String graphic;
	private boolean isAlive;
	//final fields
	private final int VELOCITY_UP = 2;
	private final int VELOCITY_SIDE = 5;
	
	public Player(int lives, String graphic) {
		this.lives = lives;
		this.graphic = graphic;
		isAlive = true;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public String getGraphic() {
		return graphic;
	}

	public void setGraphic(String graphic) {
		this.graphic = graphic;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void draw() {
		
	}
}
