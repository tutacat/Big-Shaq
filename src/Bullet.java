import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.Timer;

public class Bullet extends JComponent {
	public double xpos;
	public double ypos;
	public double yvel = -10;
	
	public Bullet(double d, double ypos2) {
		this.xpos  = d;
		this.ypos = ypos2;
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public Rectangle bounds() {
		return new Rectangle((int)xpos, (int)ypos, 100, 100);
	}
	
	public void paintBullet(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    Image img1 = Toolkit.getDefaultToolkit().getImage("res/flame_shot.png");
	    g2.drawImage(img1, (int)xpos, (int)ypos, this);   
	}
	
/*	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    g2.drawRect(xpos, ypos, 1000, 1000);
	}
	
	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ypos += yvel;
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_SPACE) {
			yvel = 2;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}*/
}
