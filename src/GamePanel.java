import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;	
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font gameFont;
	Timer frameDraw;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager objectManager = new ObjectManager(rocket);
	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		gameFont = new Font("Arial", Font.PLAIN, 24);
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		rocket.update();
		objectManager.update();

	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 	
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("LEAGUE INVADERS", 50, 100);
		
		g.setFont(gameFont);
		g.drawString("Press ENTER to start", 120, 300);
		g.drawString("Press ENTER to start", 120, 500);
		
		
		
		
		
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		objectManager.draw(g);
	}
	
	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 100, 100);
		
		g.setFont(gameFont);
		g.drawString("You killed enemies", 120, 300);
		g.drawString("Press ENTER to start", 120, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
		    updateMenuState();
		} else if(currentState == GAME){
		    updateGameState();
		} else if(currentState == END){
		    updateEndState();
		}
		
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    rocket.up = true;
		}
		
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    rocket.down = true;
		}
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    rocket.right = true;
		}
		
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    rocket.left = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    rocket.up = false;
		}
		
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    rocket.down = false;
		}
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    rocket.right = false;
		}
		
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    rocket.left = false;
		}
		
	}

}
