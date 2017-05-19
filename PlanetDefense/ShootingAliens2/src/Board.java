import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

	public Timer timer;
	private Craft craft;
	private ArrayList<Alien> aliens;
	private static boolean ingame;
	private final int ICRAFT_X = 40;
	private final int ICRAFT_Y = 60;
	private final static int B_WIDTH = 1000;
	private final static int B_HEIGHT = 600;
	private final int DELAY = 15;
	private int time;
	private int score = -1;
	private static int lives = 5;
	public static boolean isPause = false;

	public void spawn() {

		if (time % 50 == 0) {
			aliens.add(new Alien(1000, (int) (Math.random() * 550 + 20)));
		}
		if ((time - 33) % 50 == 0 && time >= 2500) {
			aliens.add(new Alien(1000, (int) (Math.random() * 550 + 20)));
		}
		if (time % 38 == 0 && time >= 5000) {
			aliens.add(new Alien(1000, (int) (Math.random() * 550 + 20)));
		}
		if (time % 25 == 0 && time >= 7500) {
			aliens.add(new Alien(1000, (int) (Math.random() * 550 + 20)));
		}
		if (time == 6000) {

		}
	}

	public Board() {

		initBoard();
	}

	void initBoard() {

		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		ingame = true;

		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

		craft = new Craft(ICRAFT_X, ICRAFT_Y);

		initAliens();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void initAliens() {
		aliens = new ArrayList<>();

		spawn();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (ingame) {

			drawObjects(g);

		} else {

			drawGameOver(g);
		}
		if (isPause) {
			drawPause(g);
		}

		Toolkit.getDefaultToolkit().sync();
	}

	private void drawObjects(Graphics g) {

		if (craft.isVisible()) {
			g.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
		}

		ArrayList<Missile> ms = craft.getMissiles();

		for (Missile m : ms) {
			if (m.isVisible()) {
				g.drawImage(m.getImage(), m.getX(), m.getY(), this);
			}
		}

		for (Alien a : aliens) {
			if (a.isVisible()) {
				g.drawImage(a.getImage(), a.getX(), a.getY(), this);
			}
		}
		String lives = "Lives left: " + this.lives;
		g.setColor(Color.WHITE);
		g.drawString("Aliens Killed: " + (score + 1), 5, 15);
		g.drawString("Overheat Percent: " + Craft.getOverheat() + '%', 5, 30);
		g.drawString(lives, 5, 45);
	}

	private void drawGameOver(Graphics g) {

		String msg = "Game Over";
		String endScore = "Score: " + (score + 1) + "";

		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2, B_HEIGHT / 2);

		g.drawString(endScore, (B_WIDTH - fm.stringWidth(endScore)) / 2, B_HEIGHT / 2 - 20);

	}

	private void drawPause(Graphics g) {
		Font small = new Font("Arial", Font.PLAIN, 26);
		FontMetrics fm = getFontMetrics(small);
		g.setFont(small);

		g.drawString("Game Paused", (B_WIDTH - fm.stringWidth("Game Paused")) / 2, B_HEIGHT / 2 - 20);
		g.drawString("Press ESC to unpause", (B_WIDTH - fm.stringWidth("Press ESC to unpause")) / 2, B_HEIGHT / 2 + 15);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		inGame();

		updateCraft();
		updateMissiles();
		updateAliens();

		checkCollisions();

		time++;
		if (score + 1 == 25) {
			Craft.setLevel(2);
		}
		if (score + 1 == 50) {
			Craft.setLevel(3);
		}
		if (score + 1 == 100) {
			Craft.setLevel(4);
		}

		if (score + 1 >= 300) {
			time = 0;
		}

		if (isPause) {
			Craft.pState++;
		}

		spawn();
		repaint();
		Craft.i--;
		while (Craft.i < 0) {
			Craft.i = 0;
		}
		if (lives == 0) {
			ingame = false;
		}
	}

	private void inGame() {

		if (!ingame) {
			timer.stop();
		}
		// if (isPause) {
		// timer.stop();
		// }
	}

	private void updateCraft() {

		if (craft.isVisible()) {
			craft.move();
		}
	}

	private void updateMissiles() {

		ArrayList<Missile> ms = craft.getMissiles();

		for (int i = 0; i < ms.size(); i++) {

			Missile m = ms.get(i);

			if (m.isVisible()) {
				m.move();
			} else {
				ms.remove(i);
			}
		}
	}

	private void updateAliens() {

		for (int i = 0; i < aliens.size(); i++) {

			Alien a = aliens.get(i);
			if (a.isVisible()) {
				a.move();
			} else {
				aliens.remove(i);
				score++;
			}
			if (a.getX() <= 0) {
				aliens.remove(i);
				lives--;
			}

		}
	}

	public void checkCollisions() {

		Rectangle r3 = craft.getBounds();

		for (Alien alien : aliens) {
			Rectangle r2 = alien.getBounds();

			if (r3.intersects(r2)) {
				alien.setVisible(false);
				lives--;

			}
		}

		ArrayList<Missile> ms = craft.getMissiles();

		for (Missile m : ms) {

			Rectangle r1 = m.getBounds();

			for (Alien alien : aliens) {

				Rectangle r2 = alien.getBounds();

				if (r1.intersects(r2)) {
					m.setVisible(false);
					alien.setVisible(false);
				}
			}
		}

	}

	public static void setIngame(boolean set) {
		ingame = set;
	}

	public static void reduceLives() {
		lives--;
	}

	public static void pause() {

		Alien.speed = 0;
		Missile.MISSILE_SPEED = 0;
		Craft.cs = 0;
		isPause = true;

	}

	public static void unPause() {

		Alien.speed = 2;
		Missile.MISSILE_SPEED = 10;
		Craft.cs = 5;
		isPause = false;

	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			craft.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			craft.keyPressed(e);
		}
	}
}