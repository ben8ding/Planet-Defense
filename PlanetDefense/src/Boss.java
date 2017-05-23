import java.util.ArrayList;

<<<<<<< HEAD
public class Boss extends Alien {

=======
public class Boss extends Sprite {
	
	private int speed = 1;
	private int health = 100;
	private int bossMoveTimer;
	public Boss(int x, int y, int health) {
		super(x, y);
		this.health = health;
		vis = true;
		initBoss();
	}
>>>>>>> master

   
	
	public static int speed = 1;
	
	
    
    public Boss(int x, int y, int health) {
        super(x, y, health);

<<<<<<< HEAD
       
        
        initAlien();
    }

    private void initAlien() {

        loadImage("boss1.gif");
        getImageDimensions();
    }
    
   
    

    public void move() {
        x -= speed;
    }
=======
		loadImage("boss.png");
		getImageDimensions();
	}

	public void bossDamage() {
		health--;
	}

	public void move() {
		
		bossMoveTimer++;
		if (bossMoveTimer % 3 == 0)
		x-=speed;
		
	}
	public int getHealth(){
		return health;
	}
	public void setSpeed() {
		speed = 1;
	}
>>>>>>> master
}