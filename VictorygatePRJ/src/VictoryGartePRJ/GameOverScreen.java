package VictoryGartePRJ;

import java.awt.*;
import java.awt.event.KeyEvent;
//also add you win
public class GameOverScreen extends AbstractState {
	boolean showscore = false;
	public GameOverScreen(Manager gamestates) {
		super(gamestates);
	}
	// ตัวเลือกในเมนู
	String[] choices2 = { "Restart", " ", "Exit Game" }; 
	protected int select = 0;
	
	
	public void initial() {
		
	}
	// Method ที่รับ Input จากผู้เล่น
	public void keyPressed(int kp) {
		if (kp == KeyEvent.VK_DOWN) { 
			select = select + 1; 
			
			if (select >= 3) {
				select = 2;
			}
		} else if (kp == KeyEvent.VK_UP) { 
			select = select - 1;  
			
			if (2 > select) {
				select = 0;
			}
		}
		// หากผู้เล่นเลือก Restart จะเริ่มเกมใหม่
		if (kp == KeyEvent.VK_ENTER) { 
			if (select == 0) {
				gamestates.stages.push(new Stage1(gamestates));
				Stage1.lives = 3; 
				Stage1.win = 0; 
				Stage1.score = 0; 
			}
			 // หากผู้เล่นเลือก Exit Game จะออกจากโปรแกรม
			 else if (select == 2) { 
				System.exit(0);
			}
		}
	}

	public void keyReleased(int kr) {	}

	protected void draw(Graphics g) {
		// background
		g.setColor(Color.black);
		g.fillRect(0, 0, 1900, 800); //size of black background
		
		 // แสดงคะแนน
	    g.setFont(new Font("Helvetica", Font.BOLD, 55));
		g.setColor(Color.blue);
		g.drawString("FINAL SCORE:", 85, 220);
		g.setColor(Color.white);
		g.drawString("" + Stage1.score, 505, 220);
		
		
		if (Stage1.win == 1) {
			g.setFont(new Font("Helvetica", Font.BOLD, 120));
			g.setColor(Color.yellow);
		    g.drawString("  YOU WIN!", 85, 150);
		   
			
		    g.setFont(new Font("Helvetica", Font.BOLD, 30));
		    g.drawString("  Thank you for play", 230, 700);
		    g.setColor(Color.black);
		  
		}
		if (Stage1.lives == 0) {
			g.setFont(new Font("Helvetica", Font.BOLD, 120));
			g.setColor(Color.yellow);
			g.drawString("GAME OVER", 80, 150);
			
				
		}
		// menu choices 
		for (int j = 0; 3 > j; j++) {
			int xpoint[] = {605, 625, 580, 625}; // ตำแหน่ง x ของลูกศร
		    int ypoint[] = {300, 290, 300, 310};// ตำแหน่ง y ของลูกศรใน "Restart"
			int ypoint2[] = {470, 460, 470, 480};// ตำแหน่ง y ของลูกศรใน "Exit Game"
					
			if (select == j) {
				g.setColor(Color.white); 
                g.fillPolygon(xpoint, ypoint2, 4);
				g.setColor(Color.black); 
			    g.fillPolygon(xpoint, ypoint, 4);
				g.setColor(Color.cyan);
				
			} else {
				g.setColor(Color.white); 
			    g.fillPolygon(xpoint, ypoint, 4);
				g.setColor(Color.black); 
                g.fillPolygon(xpoint, ypoint2, 4);
				g.setColor(Color.red);
			}
			g.setFont(new Font("Helvetica", Font.BOLD, 60));

			g.drawString(choices2[j], 768 / 3, j * 80 + 320);
			
		}
		
	}
	
	@Override
	public void tick() {	}

}
