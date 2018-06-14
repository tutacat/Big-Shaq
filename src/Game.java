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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener {
	Timer t = new Timer(5, this);
	Bullet b;
	Player player;
	Enemy e;
	boolean bulletVisible;
	LinkedList<Bullet> bullets = new LinkedList();
	ArrayList<Enemy> enemies = new ArrayList();
	
	public Game() {
		player = new Player(9, 880, 885);
		e = new Enemy(15, (int)(Math.random()*((1760 - 10) + 1) + 10), (int)(Math.random()*((10 - 1) + 1) + 1));
		enemies.add(e);
		t.start();
		setBackground(Color.DARK_GRAY);
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
	
	public void paintEnemy(Graphics g) {
		for(int i = 0; i < enemies.size(); i++) {
			e = enemies.get(i);
			e.paintEnemy(g);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintPlayer(g);
		paintBullets(g);
		paintEnemy(g);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_UP) {
			player.vely = -7;
			//enemies.add(new Enemy(15, (int)(Math.random()*((1760 - 10) + 1) + 10), (int)(Math.random()*((10 - 1) + 1) + 1)));
		}
		if(c == KeyEvent.VK_DOWN) {
			player.vely = 7;
		}
		if(c == KeyEvent.VK_LEFT) {
			player.velx = -7;
		}
		if(c == KeyEvent.VK_RIGHT) {
			player.velx = 7;
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
		Random r = new Random();
		r.ints(0, 4);
		if(r.nextInt() % 2 == 0) {
			e.yvel = 5;
		} else {
			e.xvel = -5;
			e.yvel = 5;
		}
		if(e.xpos < 10) {
			e.xvel = 0;
			e.xpos = 10;
		}
		if(e.xpos > 1760) {
			e.xvel = 0;
			e.xpos = 1760;
		}
		if(e.ypos < 10) {
			e.yvel = 0;
			e.ypos = 10;
		}
		if(e.ypos > 885) {
			e.yvel = 0;
			e.ypos = 885;
		}
		
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
		if(player.ypos > 885) {
			player.vely = 0;
			player.ypos = 885;
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
		/*
		for(int i = 0; i < enemies.size(); i++) {
			e = enemies.get(i);
			if(e.getHealth() == 0) {
				e.isDead = true;
				enemies.remove(i);
			}
			if(e.isDead) {
				Enemy temp = new Enemy(15, (int)(Math.random()*((1760 - 10) + 1) + 10), (int)(Math.random()*((10 - 1) + 1) + 1));
				enemies.add(temp);
			} else {
				Enemy temp = new Enemy(15, (int)(Math.random()*((1760 - 10) + 1) + 10), (int)(Math.random()*((10 - 1) + 1) + 1));
				enemies.add(temp);
				t.setDelay(10000);
			}
			if(e.ypos < 10) {
				e.ypos = 10;
			}
			if(e.ypos > 885) {
				e.ypos = 885;
			}
			repaint();
		}*/
		e.ypos += e.yvel;
		repaint();
	}
	
}