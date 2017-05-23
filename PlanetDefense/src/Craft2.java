import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Craft2 extends Craft {

	private int dx;
	private int dy;
	private int dx2;
	private int dy2;
	public final static int tcs = 7;
	public static int cs = 7;
	private static int level = 1;
	public static int i = 0;
	public static int pState = 0;
	private ArrayList<Missile> missiles;

	public Craft2(int x, int y) {
		super(x, y);

		initCraft();
	}

	private void initCraft() {

		missiles = new ArrayList<>();
		loadImage("craft3.gif");
		getImageDimensions();
	}

	public void move() {

		float dxf = (float) dx;

		dxf += 0.3 * ((float) dx2 - 0.012 * (float) dx);

		dx = (int) dxf;

		float dyf = (float) dy;

		dyf += 0.3 * ((float) dy2 - 0.012 * (float) dy);

		dy = (int) dyf;

	
		if(dx>10)
		{
			dx = 10;
		}
		

		if(dy>10)
		{
			dy = 10;
		}
		
		x += dx;
		y += dy;

		if (x < -11) {
			x = -11;
		}

		if (y < -11) {
			y = -11;
		}
		if (y > 589) {
			y = 589;
		}
		if (x > 989) {
			x = 989;
		}
	}


	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_Z && key != KeyEvent.VK_X) {
			if (level == 1 && i <= 95) {
				fire1();
			} else if (level == 2 && i <= 90) {
				fire1();
			} else if (level >= 3 && i <= 85) {
				fire1();
			}

		}

		if (key == KeyEvent.VK_X && key != KeyEvent.VK_Z) {
			if (level >= 2 && i <= 90) {
				fire2();
			} else if (level >= 4 && i <= 80) {
				fire2();
			}

		}

		if (key == KeyEvent.VK_LEFT) {
			// dx2 = -cs;
			dx2 = -cs;

		}

		if (key == KeyEvent.VK_RIGHT) {
			// dx2 = cs;
			dx2 = cs;
		}

		if (key == KeyEvent.VK_UP) {
			dy2 = -cs;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy2 = cs;
		}

		if (key == KeyEvent.VK_U) {
			setLevel(4);
		}

		if (key == KeyEvent.VK_ESCAPE && !Board.isPause) {
			Board.pause();
			pState = 0;

		}

		if (key == KeyEvent.VK_ESCAPE && Board.isPause && pState > 5) {
			Board.unPause();
		}
	}



	

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx2 = 0;
			
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx2 = 0;
		}

		if (key == KeyEvent.VK_UP) {
			dy2 = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy2 = 0;
		}
	}
}
