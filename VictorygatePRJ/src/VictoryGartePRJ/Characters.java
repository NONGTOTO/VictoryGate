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
						
	
	g.setColor(Color.magenta); 
	g.fillRect(x + 8, y - 78, width + 20, 90); 
	g.fillRect(x + 8, y - 75, width + 20, height * 4); 


	g.setColor(Color.yellow); 
	g.fillRect(x + 13, y - 45, 10, 10); 




		
			
	g.setColor(Color.magenta); // Choose the color you prefer
	g.fillRect((int) x - 310, (int) y - 92, width , height + 80);

	
	g.setColor(Color.magenta); // Choose the color you prefer
	g.fillRect((int) x - 310, (int) y - 52, width + 50, height );

	
	g.setColor(Color.magenta); // Choose the color you prefer
	g.fillRect((int) x - 310, (int) y - 92, width + 50, height );
		
		
		
		
		

		//Door start
		g.setColor(Color.red);
		g.fillRect(x-550, y+550, width*2, height*3);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x-542, y+580, width/2, height/2);
		g.setColor(Color.blue);
		
		
	
		// if (GamePanel.TickCounter > 4390) { //so when barrels hit drum, fire drawn
		
		// g.setColor(Color.red);
		// g.fillRect(x-540, y+534, width-1, height);
		// g.fillRect(x-548, y+540, width, height-10);
		// g.fillRect(x-532, y+540, width, height-10);
		// g.setColor(Color.orange);
		// g.fillRect(x-538, y+540, width-5, height/2);
		// g.fillRect(x-548, y+550, width, height/5);
		// g.fillRect(x-532, y+550, width, height/5);
		// g.setColor(Color.yellow);
		// g.fillRect(x-535, y+545, width/2, height/2);
		// g.setColor(Color.red);
		// g.fillRect(x-532, y+550, width/5, height/4);
		// }

	}

}
