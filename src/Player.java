import java.awt.*;
import java.io.*;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Player extends JComponent {
	//fields for player
	private int lives;
	public boolean isAlive;
	public double xpos = 500;
	public double ypos = 1000;
	public double vely = 0;
	public double velx = 0;

	public Player(int lives, int xpos, int ypos) {
		//user generated
		this.lives = lives;
		this.xpos = xpos;
		this.ypos = ypos;
		//auto generated
		isAlive = true;
		xpos = 0;
		ypos = 0;
		/*addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);*/
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public Rectangle bounds() {
		return new Rectangle((int)xpos, (int)ypos, 96, 96);
	}
	
	public void paintPlayer(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    Image img1 = Toolkit.getDefaultToolkit().getImage("res/BigShaq Still (4).png");
	    g2.drawImage(img1, (int)xpos, (int)ypos, this);
	    g2.finalize();
	}
	
	/*public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    Image img1 = Toolkit.getDefaultToolkit().getImage("res/BigShaq Still (4).png");
	    g2.drawImage(img1, xpos, ypos, this);
	    g2.finalize();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paint(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_UP) {
			vely = -2;
			velx = 0;
		}
		if(c == KeyEvent.VK_DOWN) {
			vely = 2;
			velx = 0;
		}
		if(c == KeyEvent.VK_LEFT) {
			vely = 0;
			velx = -5;
		}
		if(c == KeyEvent.VK_RIGHT) {
			vely = 0;
			velx = 5;
		}
		if(c == KeyEvent.VK_SPACE) {
			key = c;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		velx = 0;
		vely = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(xpos < 0) {
			velx = 0;
			xpos = 0;
		}
		if(xpos > 1000) {
			velx = 0;
			xpos = 1000;
		}
		if(ypos < 0) {
			vely = 0;
			ypos = 0;
		}
		if(ypos > 1000) {
			vely = 0;
			ypos = 1000;
		}
		xpos += velx;
		ypos += vely;
		//System.out.println("(" + xpos + ", " + ypos + ")");
		repaint();
	}*/
	
}
