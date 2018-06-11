import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Graphics2DDrawImage {
	public static Player currentPlayer = new Player(3, "bigshaq");
	public static JFrame window = new JFrame();
	static KeyEvent e;
	public static void main(String[] a) {
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(new Dimension(1000, 1000));
		window.getContentPane().setBackground(Color.CYAN);
		window.getContentPane().add(currentPlayer);
		window.pack();
		window.setVisible(true);
		System.out.println(window.getHeight());
		System.out.println(window.getWidth());
	}
}
