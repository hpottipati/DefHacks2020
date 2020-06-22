import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;

public class Virus {
	public static int x, y;
	public static int width, height;
	public static int cellHealth;
	public int count = 0;

	public Virus(int x, int y, int width, int height, int health) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.cellHealth = health;

	}

	public void paint(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);

	}

	public void moveRight() {
		x = x + 10;
		if (getCenterX() > 1000) {
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
		if (getCenterY() < 0) {
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
		if (Math.abs((x + width) - Cell.x) <= 50 && Math.abs((y + height) - Cell.y) <= 50
				|| Math.abs((x) - (Cell.x + Cell.width)) <= 50 && Math.abs((y) - (Cell.y + Cell.height)) <= 50) {
			cellHealth -= 10;
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
			Cell.x = x + width + 20;
			Cell.y = y;
			count++;
		}
	}

	public int getCellHealth() {
		return cellHealth;
	}

	public int getVirusx() {
		return x;
	}

	public int getVirusy() {
		return y;
	}
	
	public int getCenterX()
    {
      return x+width/2;  
    }
    
    public int getCenterY()
    {
      return y+height/2; 
    }

}