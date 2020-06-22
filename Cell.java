import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;

public class Cell {
	public int count = 0;
	public static int x, y;
	public static int width, height;
	public static int virusHealth;

	public Cell(int x, int y, int width, int height, int health) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.virusHealth = health;

	}

	public void paint(Graphics g) {

		g.setColor(Color.RED);
		g.fillOval(x, y, width, height);

	}

	public void moveRight() {
		x = x + 10;
		if (getCenterX() < 0) {
			x-= 10;
		}
	}

	public void moveLeft() {
		x = x - 10;
		if (getCenterX() < 0) {
			x+= 10;
		}
	}

	public void moveUp() {
		y = y - 10;
		if (getCenterY() < 0)  {
			y+= 10;
		}
		
	}

	public void moveDown() {
		y = y + 10;
		if(getCenterY() > 1000)
        {
			y -= 10;
        }
	}

	public void attack() {
		if (Math.abs((x + width) - Virus.x) <= 50 && Math.abs((y + height) - Virus.y) <= 50
				|| Math.abs((x) - (Virus.x + Virus.width)) <= 50 && Math.abs((y) - (Virus.y + Virus.height)) <= 50) {

			virusHealth -= 10;
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			JFrame gameover = new JFrame();
			if (Virus.cellHealth == 0) {
				JOptionPane.showMessageDialog(gameover, "GAME OVER\n Virus Wins!");
				System.exit(1);
			}
			if (Cell.virusHealth == 0) {
				JOptionPane.showMessageDialog(gameover, "GAME OVER!\n Cell Wins!");
				System.exit(1);
			}
			
		}

		}

	public void pull() {

		if (count <= 0) {
			Virus.x = x + width + 20;
			Virus.y = y;
			count++;
		}
	}

	public int getVirusHealth() {
		return virusHealth;
	}

	public int getCellx() {
		return x;
	}

	public int getCelly() {
		return y;

	}

	public static int getCenterX() {
		return x + width / 2;
	}

	public static int getCenterY() {
		return y + height / 2;
	}
}
