import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxMenuItem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Paint;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.PrintJob;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.RenderingHints.Key;
import java.awt.datatransfer.Clipboard;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.InvalidDnDOperationException;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.im.InputMethodHighlight;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.awt.peer.ButtonPeer;
import java.awt.peer.CanvasPeer;
import java.awt.peer.CheckboxMenuItemPeer;
import java.awt.peer.CheckboxPeer;
import java.awt.peer.ChoicePeer;
import java.awt.peer.DesktopPeer;
import java.awt.peer.DialogPeer;
import java.awt.peer.FileDialogPeer;
import java.awt.peer.FontPeer;
import java.awt.peer.FramePeer;
import java.awt.peer.LabelPeer;
import java.awt.peer.ListPeer;
import java.awt.peer.MenuBarPeer;
import java.awt.peer.MenuItemPeer;
import java.awt.peer.MenuPeer;
import java.awt.peer.PanelPeer;
import java.awt.peer.PopupMenuPeer;
import java.awt.peer.ScrollPanePeer;
import java.awt.peer.ScrollbarPeer;
import java.awt.peer.TextAreaPeer;
import java.awt.peer.TextFieldPeer;
import java.awt.peer.WindowPeer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Player extends JComponent implements ActionListener, KeyListener{
	//fields for player
	private int lives;
	private String graphic;
	private boolean isAlive;
	public int xpos = 10;
	public int ypos = 10;
	private int vely = 0;
	private int velx = 0;
	public int key;
	
	
	Timer t = new Timer(5, this);
	
	
	public Player(int lives, String graphic) {
		//user generated
		this.lives = lives;
		this.graphic = graphic;

		//auto generated
		isAlive = true;
		xpos = 0;
		ypos = 0;
		
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public String getGraphic() {
		return graphic;
	}

	public void setGraphic(String graphic) {
		this.graphic = graphic;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    Image img1 = Toolkit.getDefaultToolkit().getImage("res/BigShaq Still (4).png");
	    g2.drawImage(img1, xpos, ypos, this);
	    g2.finalize();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paint(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_UP) {
			vely = -2;
			velx = 0;
		}
		if(c == KeyEvent.VK_DOWN) {
			vely = 2;
			velx = 0;
		}
		if(c == KeyEvent.VK_LEFT) {
			vely = 0;
			velx = -5;
		}
		if(c == KeyEvent.VK_RIGHT) {
			vely = 0;
			velx = 5;
		}
		if(c == KeyEvent.VK_SPACE) {
			key = c;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		velx = 0;
		vely = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(xpos < 0) {
			velx = 0;
			xpos = 0;
		}
		if(xpos > 1000) {
			velx = 0;
			xpos = 1000;
		}
		if(ypos < 0) {
			vely = 0;
			ypos = 0;
		}
		if(ypos > 1000) {
			vely = 0;
			ypos = 1000;
		}
		xpos += velx;
		ypos += vely;
		//System.out.println("(" + xpos + ", " + ypos + ")");
		repaint();
	}
	
}
