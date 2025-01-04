import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<>();
	ArrayList<Alien> aliens = new ArrayList<>();
	Random rand = new Random();
	int score = 0;

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;

	}

	public void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	public void addAlien() {
		aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

	}

	public void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}

		for (Projectile p : projectiles) {
			p.update();
		}

		if (rocket.isActive) {
			checkCollision();
			purgeObjects();
		}

	}

	public void draw(Graphics g) {
		rocket.draw(g);

		for (Alien a : aliens) {
			a.draw(g);
		}

		for (Projectile p : projectiles) {
			p.draw(g);
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
				i--;
			}
		}

		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
				i--;
			}
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				rocket.isActive = false;
				a.isActive = false;
			}
			for (Projectile p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					p.isActive = false;
					a.isActive = false;
					score++;
				}
			}
		}

	}
	
	public int getScore() {
		return score;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();

	}
}
