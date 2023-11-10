package VictoryGartePRJ;
import java.awt.*;
import java.awt.event.*;

public class Player {
	// ตัวแปรสำหรับการควบคุมการกระโดดและตก
	public static boolean jump; 
	public static boolean fall; 
	// ทิศทางการเคลื่อนที่
	protected int direction = 1;
	// ตัวแปรสำหรับการวาดภาพ
	protected int leftspriteint = 0;
	// บอกว่าตัวละครอยู่บนบันไดมั้ย
	public boolean onLadder; 
	// ตำแหน่งปัจจุบันของตัวละคร
	protected static double x;
	protected static double y;
	 // ขนาดของตัวละคร
	protected static int w;
	protected int h;
	 // ความเร็วในการเคลื่อนที่และกระโดด
	protected double ms = 5; // movement speed
	protected double xvel = ms;
	protected double js = 6; // jumping speed
	protected double yvel = js; // current jumping speed
	// ความเร็วในการตก
	protected double downvelocity = 5; // variable controlling falling
	protected double currentfallvel = 1; // current downvelocity 
	
	//การควบคุมตัวละคร
	public void keyPressed(int k) { 
		if (k == KeyEvent.VK_LEFT || k ==KeyEvent.VK_A) {
			if (jump) {
				x = x - 30;
			}
			x = x - 6;
			direction = -1;
			leftspriteint = 1;
		}
		
		if (k == KeyEvent.VK_RIGHT || k ==KeyEvent.VK_D) {
			if (jump) {
				x = x + 30;
			}
			x = x + 6; // speed of right movement
			direction = 1; 
			leftspriteint = 0;
		}

		if (k == KeyEvent.VK_UP|| k ==KeyEvent.VK_SPACE|| k ==KeyEvent.VK_W) {
			jump = true;
		}
	}
	// ทำงานเมื่อปุ่มถูกปล่อย
	public void keyReleased(int k) {	}

	//ตำแหน่งเริ่มต้นของผู้เล่น
	public Player(int w, int h) {  
		x = 100; 
		y = 700; 
		this.w = w;
		this.h = h;
	}
	
	public void draw(Graphics g) { 
		g.setColor(Color.green);
		g.fillRect((int) x+2-(leftspriteint*2), (int) y+13, w/3, h/2); 
		g.fillRect((int) x+20-(leftspriteint*2), (int) y+13, w/3, h/2); 
		g.setColor(Color.red);
	
	
		g.fillRect((int) x+2, (int) y, w-2, h-10); 
		g.setColor(Color.pink);
		g.fillOval((int) x+6-(leftspriteint*2), (int) y-15, w-10, h-10);
		
		g.setColor(Color.pink);
		g.fillRect((int) x+(6*direction)+(leftspriteint*22), (int) y+8, w/4, h/4);
		g.fillRect((int) x+(4*direction)+(leftspriteint*22), (int) y+6, w/4, h/4);
		g.fillRect((int) x+(2*direction)+(leftspriteint*22), (int) y+4, w/4, h/4);
		g.fillRect((int) x, (int) y, w, h/4);

		g.setColor(Color.pink);
		g.fillRect((int) x+(12*direction)+(leftspriteint*24), (int) y+12, w/4, h/4);
		
		g.setColor(Color.black);
		g.fillRect((int) x+(12*direction)+(leftspriteint*29), (int) y-10, w/10, h/10);
		g.fillRect((int) x+(20*direction)+(leftspriteint*29), (int) y-10, w/10, h/10);

	}
	// ตรวจสอบการชนกับแพลตฟอร์ม
	public void tick(Platform[] platforms) {
		int intx = (int) x; // changes x to an int
		int inty = (int) y; // changes y to an int
		for (int j = 0; platforms.length > j; j++) {
			// ตรวจสอบการชนด้านล่าง, ด้านซ้าย, และด้านขวาของตัวละครกับแพลตฟอร์ม
			if ((Collide.playerPlatformCollide(
					new Point(intx + (int) AbstractState.yOffset, inty + h + (int) AbstractState.yOffset), platforms[j])
					|| Collide.playerPlatformCollide(
							new Point(intx + w + (int) AbstractState.yOffset, inty + (int) AbstractState.yOffset),
							platforms[j])
					|| Collide.playerPlatformCollide(
							new Point(intx + w + (int) AbstractState.yOffset, inty + h + (int) AbstractState.yOffset),
							platforms[j]))) { 
				fall = false;
				onLadder = false;
				break;
			} else {
				fall = true;	
			}
		}

		if (jump) {
			y = y - yvel / 1.3; // jump height
			yvel = yvel - 0.15;
			if (0 >= yvel) { // if the current jumping speed is 0 or less than 0 , jumping no longer occurs
				jump = false;
				fall = true;
				yvel = js;
			}
		}
				
		if (fall == true) {
			y = y + currentfallvel / 2; // fall speed
			if (downvelocity > currentfallvel) {
				currentfallvel = currentfallvel + 0.1; // the longer the player falls the faster their speed becomes									
			}
		}
		if (fall == false) {
			currentfallvel = 0.2;
		}
	}
	
	
	public void tick(Characters[] Doorend) {
		int inty2 = (int) y; 
		int intx2 = (int) x; 
		for (int i = 0; Doorend.length > i; i++) {
			// เช็คว่าตัวละครชนกับประตูมั้ย
			if ( Collide.playerDoorCollide(new Point(intx2 + (int) AbstractState.yOffset + w, 
						inty2 + h + (int) AbstractState.yOffset),
							Doorend[i])) {
				Stage1.win = 1;
				break;
			} else {
			}
		}
	}
	
	public void tick(Ladder[] ladders) {
		int inty2 = (int) y; 
		int intx2 = (int) x; 
		for (int i = 0; ladders.length > i; i++) {
			// เช็คว่าอยู่ตรงบันไดมั้ย
			if ((Collide.playerLadderCollide(
					new Point(intx2 + (int) AbstractState.yOffset, inty2 + (int) AbstractState.yOffset), ladders[i])
					|| Collide.playerLadderCollide(
							new Point(intx2 + (int) AbstractState.yOffset + w, inty2 + h + (int) AbstractState.yOffset),
							ladders[i]))) { 
											
				y -= 1; // ให้ผู้เล่นปีนขึ้นบันได
				onLadder = true;
				break;

			} else {
				fall = true;
				AbstractState.yOffset = 0; 
			}
		}
	}
	
	Rectangle playerRect = new Rectangle((int)Player.x, (int)Player.y, 30, 30);
	Rectangle r2 = new Rectangle(700, 700, 30, 30);
	
	public void tick(TheF[] F) {
		for (int f = 0; F.length > f; f++) {
			//เมื่อชนกับF
			if ((Collide.playerFCollide(new Point(  ((int)Player.x+30), ((int)Player.y+30) ), F[f])
					|| (Collide.playerFCollide(new Point(  ((int)Player.x+30), ((int)Player.y) ), F[f]))))	
					{
				Stage1.lives = Stage1.lives - 1;				
				break;
			} else {
			}
		}
	}
}
