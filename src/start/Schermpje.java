package start;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Schermpje extends JPanel{
	
	private BufferedImage canvas;
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 400);
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);		
		g.drawImage(canvas, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
	}
	
	public void draw(){
		Dimension size = getSize();
		canvas = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
		
        Graphics g = canvas.getGraphics();
        
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, size.width/2, 100);
		
		repaint();
	}

}
