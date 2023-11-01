package VictoryGartePRJ;

import javax.swing.*;

import java.awt.BorderLayout;

public class Main {

	public static void main(String[] args) {
		JFrame gameframe;

		gameframe = new JFrame("The Victory Gate");//name on the game window
		//terminates program on closed
		gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameframe.setLayout(new BorderLayout());
		gameframe.add(new GamePanel(), (BorderLayout.CENTER));
		gameframe.setVisible(true);//makes frame visible
		gameframe.pack();//resizes the frame to the panel size
		gameframe.setLocationRelativeTo(null);
		gameframe.setResizable(true);//cannot resize game
		gameframe.setSize(1000, 830);

	}

}
