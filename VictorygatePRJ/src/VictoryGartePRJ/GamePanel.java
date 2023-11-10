package VictoryGartePRJ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class GamePanel extends JPanel implements KeyListener, Runnable { //Panel objects drawn onto
	protected long tTime = 1000000 / 60;//60fps
	protected Thread t;             // เป็นส่วนของการทำงานของ Thread สำหรับเกม
	protected boolean running = false;//บอกว่า Thread ของเกมยังทำงานหรือไม่.
	protected static int TickCounter;// นับจำนวนการทำการตั้งแต่เริ่มต้น.
	protected Manager gamestates; //เป็นส่วนของการจัดการกับสถานะของเกม.

	public GamePanel() {
		setPreferredSize(new Dimension(1200, 1200)); 
		addKeyListener(this);
		setFocusable(true);
		start();    }        //calls start

	private void start() { // method that will start the game
		running = true;
		t = new Thread(this);
		t.start(); }            //calls the run method

	public void run() { 
		gamestates = new Manager(); 
		long begin, wait;
		while (running = true) { 
			begin = System.nanoTime(); 
			TickCounter = TickCounter + 1;
			tick();
			repaint(); 
			wait = tTime - begin / 1000000;
			if (wait <= 0) {
				wait = 5;
			}
			try {
				Thread.sleep(wait);
			} catch (Exception excep) {
				System.out.println("Exception Caught");
			} } }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);  //draws the graphics
		g.clearRect(0, 0, 780, 680); // clears screen before next is drawn
		gamestates.draw(g);     }     //draws level
	
	public void tick() { 
		gamestates.tick(); } 

	public void keyPressed(KeyEvent k) {
		gamestates.keyPressed(k.getKeyCode()); }

	public void keyReleased(KeyEvent k) {
		gamestates.keyReleased(k.getKeyCode()); }

	@Override
	public void keyTyped(KeyEvent e) {	}
}
