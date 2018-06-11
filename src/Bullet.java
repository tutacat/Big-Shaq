import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.Timer;

public class Bullet extends JComponent implements ActionListener, KeyListener {
	public int xpos;
	public int ypos;
	public int yvel = -2;
	
	Timer t = new Timer(5, this);
	
	public Bullet(int x, int y) {
		this.xpos  = x;
		this.ypos = y;
		t.start();
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    g2.drawRect(xpos, ypos, 1000, 1000);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paint(g);
	}

	@Override
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
		
	}
}
