import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	Rectangle maxbounds = env.getMaximumWindowBounds();
	static Game sound = new Game();
	public Main() {
		setTitle("Big Shaq's Adventure");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new Game());
		setBounds(maxbounds);
		setVisible(true);
		System.out.println(getHeight() + " " + getWidth());
	}
	public static void main(String[] a) {
		new Main();
		sound.playSound("res/Final Boss.wav");
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1000, 1000);
	}
}


