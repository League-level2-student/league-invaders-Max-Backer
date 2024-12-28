import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
			
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		
		if (needImage) {
		    loadImage ("rocket.png");
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	
	public void update() {
		if(up) {
			y-=speed;
		}
		
		if(left) {
			x-=speed;
		}
		
		if(right) {
			x+=speed;
		}
		
		if(down) {
			y+=speed;
		}
		
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
