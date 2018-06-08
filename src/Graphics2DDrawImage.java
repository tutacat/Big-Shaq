import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Graphics2DDrawImage {
	public static void main(String[] a) {
	    JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1000, 1000);
		Player player = new Player(3, "bigshaq");
		window.getContentPane().setBackground(Color.CYAN);
		window.getContentPane().add(player);
		window.setVisible(true);
	}
}
