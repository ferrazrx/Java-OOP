package screensaver;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Square extends Shape{


		private static int x;
		private static int y;
		private static String direction_x = "forward";
		private static String direction_y = "down";
		private Color color = Color.RED;

		
		
		public Square(Graphics g) {
			super(g);

		}

		public void draw(int position_x, int position_y) {
			Graphics g = this.getG();
			g.setColor(color);
			g.fill3DRect(x, y, 15, 15, true);
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
			if(x > panel.getWidth() - 15){
				direction_x = "backwards";
			}
			
			if(direction_y == "down"){
				y+=4;
			}else{
				y--;
			}
			if(y < 0){
				direction_y = "down";
			}
			if(y > panel.getHeight() - 15){
				direction_y = "up";
			}
		}

	}