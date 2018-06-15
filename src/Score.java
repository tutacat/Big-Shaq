import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

public class Score extends JComponent{
	int score;
	public Score() {
		score = 0;
	}
	
	public void addScore(int s) {
		score += s;
	}
	
	public void paintScore(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawString("Score: " + score, 15, 15);
		g2.setColor(Color.WHITE);
	    g2.finalize();
	}
}
