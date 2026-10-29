
public class Enemy extends GameObject {
	protected String type;
    protected int damage;
    protected int health;
    
    
	public Enemy(int x, int y, int width, int height, String type, int damage, int health) {
		super(x, y, width, height);
		this.type = type;
		this.damage = damage;
		this.health = health;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
        if (type != null) {
            this.type = type.trim();
        }
    }
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
        if (damage >= 0 && damage <= 100) {
            this.damage = damage;
        }
    }
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
        if (health >= 0 && health <= 100) {
            this.health = health;
        }
    }
	
	@Override
    public String toString() {
        return "Enemy[" + type + "] @ (" + getX() + "," + getY() + ") " + getWidth() + "x" + getHeight()
                + " DMG=" + damage + " HP=" + health;
    }
    
	
    
}