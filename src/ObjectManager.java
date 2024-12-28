import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<>();
	ArrayList<Alien> aliens = new ArrayList<>();
	Random rand = new Random();

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
	}

	public void draw(Graphics g) {
		rocket.draw(g);

		for (Alien a : aliens) {
			a.draw(g);
		}
		
		for(Projectile p: projectiles) {
			p.draw(g);
		}
	}
	
	public void purgeObjects() {
		for(int i = 0; i < aliens.size(); i++) {
			if(aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
	}

}
