
public class BossEnemy extends Enemy {

	public BossEnemy(int x, int y, int width, int height, String type, int damage, int health) {
		super(x, y, width, height, type, damage, health);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return ("Boss Enemy[" + getType() + "] @ (" + getX() + ", " + getY() + ") " + getWidth() + "x"
				+ getHeight() + " DMG=" + getDamage() + " HP=" + getHealth());
	}
	

}
