import java.awt.Graphics;

import javax.swing.JFrame;

public class Main extends JFrame {
	Graphics g;
	public Main() {
		Player x = new Player(2, "./bigshaq");
		setSize(1000, 1000);
		setVisible(true);
		x.paintComponent(g);
	}
	
	public static void main(String [] args) {
		Main k = new Main();
	}
}
