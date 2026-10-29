
/* Grupa 11
   Clanovi:
   Aleksa Stupar 24/105
   Dalil Hadziahmetovic 24/043
   Luka Vukovic 24/130
 */


import java.util.ArrayList;

public class Game {
	private ArrayList<Enemy> enemy = new ArrayList<>();
	private ArrayList<String> eventLog= new ArrayList<>();
	private Player player;
	
	public Game(Player player) {
	    this.player = player;
	}
		
	public ArrayList<Enemy> getEnemies() {
        return enemy;
    }

    public ArrayList<String> getEventLog() {
        return eventLog;
    }
	
	public void addEnemy(Enemy e) {
	        enemy.add(e);
	        eventLog.add("ADD: " + e.getType());
	    }
	
	public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }
	
    public void decreaseHealth(Player p, Enemy e) {
        int damage = e.getDamage();

        if (e instanceof BossEnemy) {
            damage = damage * 2;
        }

        int oldHealth = p.getHealth();
        int newHealth = oldHealth - damage;

        if (newHealth < 0) {
            newHealth = 0;
        }

        p.setHealth(newHealth);

        eventLog.add("HIT: Player udario " + e.getType()
                + " za " + damage + "dmg -> HP "
                + oldHealth + " -> " + newHealth);
    }
    
    public ArrayList<Enemy> poType(String s) {
        ArrayList<Enemy> result = new ArrayList<>();

        for (Enemy e : enemy) {
            if (e.getType().toLowerCase().contains(s.toLowerCase())) {
                result.add(e);
            }
        }

        return result;
    }
    
    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> result = new ArrayList<>();

        for (Enemy e : enemy) {
            if (checkCollision(player, e)) {
                result.add(e);
            }
        }

        return result;
    }
    
    public void resolveCollisions() {
        for (Enemy e : enemy) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }
    
	public static void main(String[] agrs) {
	
	Player p1 = new Player(1, 5, 6, 6, "Player", 80);

	Enemy e1 = new MeleeEnemy(10, 10, 6, 6, "Goblin", 40, 100);
	Enemy e2 = new MeleeEnemy(4, 4, 2, 2, "Spider", 10, 10);
	Enemy e3 = new BossEnemy(15, 7, 16, 16, "Giant", 100, 100);	
		
	 Game game = new Game(p1);

     game.addEnemy(e1);
     game.addEnemy(e2);
     game.addEnemy(e3);

     System.out.println("=== Svi neprijatelji ===");
     for (Enemy e : game.enemy) {
         System.out.println(e);
     }
     
     System.out.println("");
     
     System.out.println("=== Pretraga za type gobin ===");
     for (Enemy e : game.poType("gob")) {
         System.out.println(e);
     }
     System.out.println("");
     
     System.out.println("=== Kolizije ===");
     for (Enemy e : game.collidingWithPlayer()) {
         System.out.println("Sudara se sa: " + e.getType());
     }
     
     System.out.println("");
     
     System.out.println("=== Igrac prije kolizije ===");
     System.out.println(p1);

     System.out.println("");
     game.resolveCollisions();

     System.out.println("=== Igrac poslije kolizije ===");
     System.out.println(p1);
     
     System.out.println("");
     
     System.out.println("Event log:");
     for (String event : game.getEventLog()) {
         System.out.println(event);
     }	
	
	}
}
