

public class Boss extends Sprite {


    private int time = 100;
	private int y = 150;
	public static int speed = 1;
	public static int health = 100;
    
    public Boss(int x, int y) {
        super(x, y);

        initBoss();
    }

    private void initBoss() {

        loadImage("alien.png");
        getImageDimensions();
    }

    public void move() {
        x -= speed;
    }
}