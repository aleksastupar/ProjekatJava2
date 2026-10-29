
public class Player extends GameObject {
	protected String name;
	protected int health;
	
	
	public Player(int x, int y, int width, int height, String name, int health) {
		super(x, y, width, height);
		this.name = name;
		this.health = health;
	}
	
	public void setName() {
		if (name != null) {
            String[] words = name.trim().toLowerCase().split("\\s+");
            String result = "";

            for (String word : words) {
                result += Character.toUpperCase(word.charAt(0))
                        + word.substring(1) + " ";
            }

            this.name = result.trim();
        }
    }
	

	public void getName(String name) {
		this.name = name;
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
        return "Player(" + name + ") @ (" + getX() + "," + getY() + ") " + getWidth() + "x" + getHeight()
                + " HP=" + health;
    }
}
