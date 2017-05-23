import java.util.ArrayList;

public class Alien extends Sprite {


    private int time = 100;
	private int y = 150;
	private int health;
	public static int speed = 2;
	
	private ArrayList<Missile> aliens;
    
    public Alien(int x, int y, int health) {
        super(x, y);

        this.health = health;
        
        initAlien();
    }

    private void initAlien() {

        loadImage("alien.png");
        getImageDimensions();
    }
    
    public int getHealth(){
    	return health;
    }
    
    public void damage(){
    	health--;
    }
    

    public void move() {
        x -= speed;
    }
}