package VictoryGartePRJ;
import java.awt.*;

public class Collide {
    // ตรวจสอบว่าพื้นที่บนผู้เล่นอยู่ภายในแพลตฟอร์มหรือไม่		
	public static boolean playerPlatformCollide(Point playerPoint, Platform pl1) 																		
	{	return pl1.contains(playerPoint);  } // if inside returns true
    // เช็คว่พื้นที่บนผู้เล่นอยู่ในบันได
	public static boolean playerLadderCollide(Point playerPoint, Ladder l1) 
	{	return l1.contains(playerPoint); 	}
	// เช็คว่าถึงประตูจบหรือยัง
	public static boolean playerDoorCollide(Point playerPoint, Characters c1) 
	{	return c1.contains(playerPoint); 	}
	//เช็คว่าชนFมั้ย
	public static boolean playerFCollide(Point playerPoint, TheF b1) 
	{	return b1.contains(playerPoint); 	}
}
