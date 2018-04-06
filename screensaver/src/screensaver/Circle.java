package screensaver;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Circle extends Shape {
	private static int x = 0;
	private static int y = 0;
	private static String direction_x = "forward";
	private static String direction_y = "down";
	private int size = 100;

	
	
	
	public Circle(Graphics g) {
		super(g);

	}

	@Override
	public void draw(int position_x, int position_y) {
		Graphics g = this.getG();
		g.setColor(this.getRandomColor());
		g.fillArc(x, y, size, size, 360, 360);
	}

	public void move(JPanel panel) {
		if(direction_x == "forward"){
			x++;
		}else{
			x--;
		}
		if(x < 0){
			direction_x = "forward";
		}
		if(x > panel.getWidth() - 100){
			direction_x = "backwards";
		}
		
		if(direction_y == "down"){
			y++;
		}else{
			y--;
		}
		if(y < 0){
			direction_y = "down";
		}
		if(y > panel.getHeight() - 100){
			direction_y = "up";
		}
	}

}
