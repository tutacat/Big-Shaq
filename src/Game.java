import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener {
	Timer t = new Timer(5, this);
	Bullet b;
	Player player;
	boolean bulletVisible;
	LinkedList<Bullet> bullets = new LinkedList();
	
	public Game() {
		player = new Player(9, 880, 910);
		t.start();
		setBackground(Color.CYAN);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	
	public void paintBullets(Graphics g) {
		for(int i = 0; i < bullets.size(); i++) {
			b = bullets.get(i);
			b.paintBullet(g);
		}
	}
	
	public void paintPlayer(Graphics g) {
	    player.paintPlayer(g);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintPlayer(g);
		paintBullets(g);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_UP) {
			player.vely = -5;
		}
		if(c == KeyEvent.VK_DOWN) {
			player.vely = 5;
		}
		if(c == KeyEvent.VK_LEFT) {
			player.velx = -5;
		}
		if(c == KeyEvent.VK_RIGHT) {
			player.velx = 5;
		}
		if(c == KeyEvent.VK_SPACE) {
			bullets.add(new Bullet(player.xpos + 40, player.ypos));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_UP) {
			player.vely = 0;
		}
		if(c == KeyEvent.VK_DOWN) {
			player.vely = 0;
		}
		if(c == KeyEvent.VK_LEFT) {
			player.velx = 0;
		}
		if(c == KeyEvent.VK_RIGHT) {
			player.velx = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(player.xpos < 10) {
			player.velx = 0;
			player.xpos = 10;
		}
		if(player.xpos > 1760) {
			player.velx = 0;
			player.xpos = 1760;
		}
		if(player.ypos < 10) {
			player.vely = 0;
			player.ypos = 10;
		}
		if(player.ypos > 910) {
			player.vely = 0;
			player.ypos = 910;
		}
		player.xpos += player.velx;
		player.ypos += player.vely;
		for(int i = 0; i < bullets.size(); i++) {
			b = bullets.get(i);
			if(b.ypos < 0) {
				bullets.remove(b);
			}
			b.ypos += b.yvel;
			repaint();
		}
		repaint();
	}
	
}