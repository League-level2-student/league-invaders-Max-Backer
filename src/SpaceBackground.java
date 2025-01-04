import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SpaceBackground extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public SpaceBackground(String imageFile) {
		// Initialize the background position and size
		super(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		if (needImage) {
			loadImage("space.png");
		}
	}

	public void draw(Graphics g) {
		if (gotImage) {
		
			g.drawImage(image, x, y, width, height, null);
		} else {
			
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
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
