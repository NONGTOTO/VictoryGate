package VictoryGartePRJ;
import java.awt.*;
import java.util.*;

//จัดการกับสถานะต่าง ๆ ของเกม
public class Manager {
	public static boolean restarted;
	
	public Stack<AbstractState> stages;
	public Manager() { // constructor
		stages = new Stack<AbstractState>();
		stages.push(new MainMenu(this));
	}
	
	public void keyPressed(int P) {
		stages.peek().keyPressed(P); //return value on top
	}
	public void keyReleased(int R) {
		stages.peek().keyPressed(R);
	}
	public void tick() {
		stages.peek().tick();
	}
	public void draw(Graphics g) {
		stages.peek().draw(g);
	}
}
