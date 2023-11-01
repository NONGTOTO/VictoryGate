package VictoryGartePRJ;
import java.awt.*;
import java.awt.event.*;

public class EnemyBarrel {
	protected int platformlevel = 0;
	protected boolean left = false; 
	protected boolean right = false;
	protected boolean barrelfall;
	protected double x, y;
	protected static int w;
	protected static int h;
	protected double downvelocity = 6; 
	protected double currentfallvel = 0.2; 
	Rectangle r1 = new Rectangle((int) x, (int) y, w, h); 
	
    public void draw(Graphics g) {
    	
    g.setColor(Color.magenta);
    Font font = new Font("Arial", Font.BOLD, 40); 
    g.setFont(font);
    g.drawString("F", (int) x + w/4, (int) y + h/2);
    g.setColor(Color.magenta); 
    
   

    

    
	}

	public EnemyBarrel(int w, int h) {
		x = 240;
		y = 120; 
		this.w = w;
		this.h = h;
	}

	public void tick(Platform[] platforms) {
		Rectangle r1 = new Rectangle((int) x, (int) y, w, h); 
		int intx = (int) x; // change x to an int
		int inty = (int) y; // change y to an int
		
		for (int j = 0; platforms.length > j; j++) {
      
			if ((Collide.playerPlatformCollide(
				new Point(intx + (int) AbstractState.yOffset, inty + h + (int) AbstractState.yOffset),platforms[j])
				|| Collide.playerPlatformCollide(new Point(intx + w + (int) AbstractState.yOffset, inty + (int) AbstractState.yOffset),platforms[j])
				|| Collide.playerPlatformCollide(new Point(intx + w + (int) AbstractState.yOffset, inty + h + (int) AbstractState.yOffset),
				platforms[j]))) { // right = true;//use for conveyer belt levels
				barrelfall = false;
				//System.out.println("Pl = " + platformlevel);
				platformlevel = platformlevel +1;
				//System.out.println("Pl = " + platformlevel);
				break;

			} else {
				barrelfall = true;
			}
		}
		
		
		if ((platformlevel > 260) && (1240 > platformlevel)) {
			x = x + 2; //speed of barrel (right)
		}		
		if ((2238 < platformlevel) && (3185 > platformlevel)) {
			x = x + 2;
		}
		if (platformlevel == 4050) { 
			x = 240;
			y = 90;
			platformlevel = 0;
		}
		
		
		if ((Player.jump == true) || (Player.fall == true)) {
			x = x - 1; 
		}

		
		if (barrelfall == true) {
			y = y + currentfallvel / 2; 
			if (downvelocity > currentfallvel) {
				currentfallvel = currentfallvel + 0.1;
		}
		}
		if (barrelfall == false) {
			currentfallvel = 0.2;
		}
	}

	public boolean contains(Point playerPoint) {
		return false;
	}

}
