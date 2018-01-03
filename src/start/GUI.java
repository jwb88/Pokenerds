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
		// nu van x = 0% naar x = 100% En van y = 50% naar y = 100% 
		int[] loc = locationFromPercent(0, 80, 60, 100); 
		g.fillRoundRect(loc[0], loc[1], loc[2], loc[3], 10, 10);
		
		g.setColor(Color.GRAY);
		g.drawRoundRect(loc[0], loc[1], loc[2], loc[3], 10, 10); // Dit is het randje, die gebruikt de zelfde coordinaten
		
		//tekst
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		drawStringMultiLine(g, turnMessage, loc[0] + (loc[2]/20), loc[1] + (loc[3]/2) - 70);
		
		// ff alvast voor straks: geen int[] loc = ..., want die is er nu al maar gewoon loc = locationFromPercent(... etc.
		
		// knoppen
		loc = locationFromPercent(60, 80, 100, 100);
		
		
		g.setColor(Color.white);
		g.fillRoundRect(loc[0], loc[1], loc[2], loc[3], 10, 10);
		
		g.setColor(Color.GRAY);
		g.drawRoundRect(loc[0], loc[1], loc[2], loc[3], 10, 10); 
		
		//g.drawString("FIGHT", x, y);*/
		
		bs.show();
		g.dispose();
		
	}
	
	private int[] locationFromPercent(int x1, int y1, int x2, int y2) {
		
		int x = Math.round((width / 100f) * x1);  
		int y = Math.round((height / 100f) * y1);
		int w = Math.round((width / 100f) * (x2-x1)); 
		int h = Math.round((height / 100f) * (y2-y1)); // Je begint steeds beter te worden. Echt waar :D Vind ik leuk om te zien n_n
		return new int[] {x,y,w,h};
	}
	
	private void drawStringMultiLine(Graphics g, String text, int x, int y) {
	    for (String line : text.split("\n"))
	        g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}
	
	private void resizeCanvas() {
		int newWidth = getContentPane().getSize().width;
		int newHeight = getContentPane().getSize().height;
		
		if(width != newWidth || height != newHeight){
			
			width = newWidth;		
			height = newHeight;
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
