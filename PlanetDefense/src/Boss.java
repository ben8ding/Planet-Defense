
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

	private void initBoss() {

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
}