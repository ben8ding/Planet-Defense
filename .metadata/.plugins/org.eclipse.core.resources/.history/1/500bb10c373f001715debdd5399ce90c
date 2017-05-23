import java.util.ArrayList;

public class Alien extends Sprite {


    private int time = 100;
	private int y = 150;
	public static int speed = 2;
	
	private ArrayList<Missile> aliens;
    
    public Alien(int x, int y) {
        super(x, y);

        initAlien();
    }

    private void initAlien() {

        loadImage("alien.png");
        getImageDimensions();
    }

    public void move() {
        x -= speed;
    }
}