package VictoryGartePRJ;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu extends AbstractState {
	protected Characters chara; 
	public MainMenu(Manager gamestates) {
		super(gamestates);
	}
	String[] choices = { "Start", " ", "No" }; //the option names
	protected int select = 0;

	public void initial() {
		chara = new Characters(655, 360); 
	}

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
		
		if (kp == KeyEvent.VK_ENTER) { 
			if (select == 0) { 
				gamestates.stages.push(new Stage1(gamestates));
			} else if (select == 2) { // exit choice on menu
				System.exit(0);
			}
		}
	}

	public void keyReleased(int kr) {	}

	protected void draw(Graphics g) {		
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 1900, 800); 
		
		g.setColor(Color.black);
		g.fillRect(610, 250, 100, 200);
		g.setFont(new Font("Helvetica", Font.BOLD, 100));
		g.setColor(Color.magenta);
		g.drawString("The VictoryGate", 10, 200);
		g.drawString("", 40, 250);
		g.setColor(Color.black);
		g.fillRect(0, 800, 2500, 2500); 
		g.fillRect(900, 0, 2500, 2500); 
		
		for (int j = 0; 3 > j; j++) {
			int xpoint[] = {525,545,500,545}; 
		    int ypoint[] = {430,420,430,440};//y co-ords of arrow by "Play"
			int ypoint2[] = {570,560,570,580};//y co-ords of arrow by "Exit"
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
			g.drawString(choices[j], 340, j * 70 + 450);
		}	}
	@Override
	public void tick() { }
}