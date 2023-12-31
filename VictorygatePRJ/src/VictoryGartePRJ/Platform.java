package VictoryGartePRJ;
import java.awt.*;

public class Platform extends Rectangle {
	public Platform(int x, int y) {
		setBounds(x, y, 665, 40); // size of platform
	}

	public void tick() {	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height); 
		g.setColor(Color.black);
		for (int i = 0; i < 616; i=i+100) {
		    g.fillRect(x+15+i, y+10, (width/20)+1, height/5); }
		for (int j = 0; j < 616; j=j+50) {
			g.fillRect(x+20+j, y+15, width/28, height/5); } 
		for (int i = 0; i < 626; i=i+100) {
			g.fillRect(x+25+i, y+20, width/50, height/5);  }
		for (int j = 0; j < 576; j=j+100) {
			g.fillRect(x+75+j, y+10, width/50, height/5); }
		for (int i = 0; i < 566; i=i+100) {
		    g.fillRect(x+65+i, y+20, (width/20)+1, height/5); }
	 }
 }