import javax.swing.JFrame;

public class LeagueInvaders {
	GamePanel gamePanel;
	JFrame frame;
	public static int WIDTH = 600;
	public static int HEIGHT = 800;

	

	public LeagueInvaders() {
		gamePanel = new GamePanel();
		frame = new JFrame();
	}

	public void setup() {
		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
	}
}
