package start;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.EventListener;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI extends JFrame implements MouseListener {
	
	private int width;
	private int height;
	private Canvas canvas;
	BufferedImage charmander;
	BufferedImage bulbasaur;
	private Game game;
	
	public GUI(String title, int width, int height, Game game){
		
		this.width = width;
		this.height = height;
		this.game = game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		
		canvas = new Canvas();
		canvas.addMouseListener(this);
		add(canvas);
		
		resizeCanvas();
		
		setVisible(true);
	}
	
	public void update(String turnMessage) {
		
		resizeCanvas();
		BufferStrategy bs = canvas.getBufferStrategy();
		
		if(bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		//g.setColor(Color.cyan);
		//g.fillRect(0, 0, width/2, height/2);
		
		// Pokemon stuff
		//Image charmander = new ImageIcon("C://Users/sanne/images/pokemans_004.gif").getImage();
		g.drawImage(charmander, 300,0, 350,350 ,null);
		g.drawImage(bulbasaur, 0, 100, 400, 400,null);
		
		// Message stuff
		
		
		g.setColor(Color.WHITE);
		int x = 0;
		int y = height - (int)(height * 0.28);
		int w = width;
		int h = height - y;
		//int[] loc = locationFromPercent(0, 50, 0, 100);
		g.fillRoundRect(x, y, w, h, 10, 10);
		
		g.setColor(Color.GRAY);
		g.drawRoundRect(x, y, w, h, 10, 10);
		g.drawRoundRect(350, y, w, h, 10, 10);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		drawStringMultiLine(g, turnMessage, x + (w/20), y + (h/2) - 70);
		
		//buttons
		
		g.drawString("FIGHT", x, y);
		
		bs.show();
		g.dispose();
		
	}
	
	/*private int[] locationFromPercent(int x1, int y1, int x2, int y2) {
		int x = (width * x1)/100;
		int y = (width * y1)/100;
		int w = ((width * x2)/100) - x;
		int h = ((height * y2)/100) - y;
		return new int[] {x,y,w,h};
	}*/
	
	private void drawStringMultiLine(Graphics g, String text, int x, int y) {
	    for (String line : text.split("\n"))
	        g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}
	
	private void resizeCanvas() {
		
		if(width != getWidth() || height != getHeight()){
			
			width = getWidth();
			height = getHeight();
			canvas.setPreferredSize(new Dimension(width, height));
		}
	}
	
	public void loadContent() {
		
		try {
			charmander = ImageIO.read(getClass().getResourceAsStream("/pokemans_004.gif"));
			bulbasaur = ImageIO.read(getClass().getResourceAsStream("/bulbasaur.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		game.optellen();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	
}
