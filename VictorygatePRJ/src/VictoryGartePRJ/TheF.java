package VictoryGartePRJ;
import java.awt.*;
import java.awt.event.*;

public class TheF {
	protected int platformlevel = 0;//ระดับของแพลตฟอร์มที่ตัวละครอยู่
	//บอกทิศทางการเคลื่อนที่ 
	protected boolean left = false; 
	protected boolean right = false;
	//บอกว่าFหล่นมั้ย
	protected boolean theF_fall;
	//ตำแหน่งของตัวละครบนแกน X และ Y.
	protected double x, y;
	// ขนาดของตัวละคร.
	protected static int w;
	protected static int h;
	// ความเร็วในการตกลง และ ความเร็วล่าสุดในการตกลง.
	protected double downvelocity = 6; 
	protected double currentfallvel = 0.2; 
	//ใช้ในการตรวจสอบการชน
	Rectangle r1 = new Rectangle((int) x, (int) y, w, h); 
	
    public void draw(Graphics g) {
    	
    g.setColor(Color.magenta);
    Font font = new Font("Arial", Font.BOLD, 40); 
    g.setFont(font);
    g.drawString("F", (int) x + w/4, (int) y + h/2);
    g.setColor(Color.magenta); 
	}

	public TheF(int w, int h) {
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
				platforms[j]))) { 
				theF_fall = false;
				platformlevel = platformlevel +1;
				
				break;

			} else {
				theF_fall = true;
			}
		}
		
		
		if ((platformlevel > 260) && (1240 > platformlevel)) {
			x = x + 2; 
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

		
		if (theF_fall == true) {
			y = y + currentfallvel / 2; 
			if (downvelocity > currentfallvel) {
				currentfallvel = currentfallvel + 0.1;
		}
		}
		if (theF_fall == false) {
			currentfallvel = 0.2;
		}
	}

	public boolean contains(Point playerPoint) {
		return false;
	}

}
