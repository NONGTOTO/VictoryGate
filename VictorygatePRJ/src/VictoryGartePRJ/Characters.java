package VictoryGartePRJ;
//this class draws how the character will look onto the level 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Characters extends Rectangle {
	public Characters(int x4, int y4) {
		setBounds(x4, y4, 20, 20); // size of rectangles
	}

	public void tick() {
	}
	// draws characters onto stage
	public void draw(Graphics g) {
						
	//door end
	g.setColor(Color.magenta); 
	g.fillRect(x -4, y - 78, width + 20, 90); 
	g.fillRect(x -4, y - 75, width + 20, height * 4); 


	g.setColor(Color.yellow); 
	g.fillRect(x + 3, y - 35, 10, 10); 

	//Big F	
	g.setColor(Color.magenta); 
	g.fillRect((int) x - 310, (int) y - 92, width , height + 80);
	g.setColor(Color.magenta); 
	g.fillRect((int) x - 310, (int) y - 52, width + 50, height );
	g.setColor(Color.magenta); 
	g.fillRect((int) x - 310, (int) y - 92, width + 50, height );
		
	
		//Door start
		g.setColor(Color.red);
		g.fillRect(x-550, y+550, width*2, height*3);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x-542, y+580, width/2, height/2);
		g.setColor(Color.blue);
		
		
	
		
	}

}
