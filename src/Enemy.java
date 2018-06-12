import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

public class Enemy extends JComponent{
	private int health;
	public int xpos;
	public int ypos;
	public int xvel;
	public int yvel;
	public boolean isDead;
	
	public Enemy(int health, int xpos, int ypos) {
		this.health = health;
		this.xpos = xpos;
		this.ypos = ypos;
		this.xvel = 0;
		this.yvel = 0;
		this.isDead = false;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public int getXvel() {
		return xvel;
	}

	public void setXvel(int xvel) {
		this.xvel = xvel;
	}

	public int getYvel() {
		return yvel;
	}

	public void setYvel(int yvel) {
		this.yvel = yvel;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	public void paintPlayer(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    Image img1 = Toolkit.getDefaultToolkit().getImage("res/darklord.png");
	    g2.drawImage(img1, (int)xpos, (int)ypos, this);
	    g2.finalize();
	}
}
