package screensaver;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Square extends Shape{


		private static int x;
		private static int y;
		private static String direction_x = "forward";
		private static String direction_y = "down";
		private Color color = Color.YELLOW;
		private static int size = 15;

		
		
		public Square(Graphics g) {
			super(g);

		}

		public void draw(int position_x, int position_y) {
			Graphics g = this.getG();
			g.setColor(color);
			g.fillRect(x, y, size, size);
		}

		public void move(JPanel panel) {
			if(direction_x == "forward"){
				x+=2;
			}else{
				x--;
			};
			if(x < 0){
				direction_x = "forward";
			};
			if(x > panel.getWidth()){
				direction_x = "backwards";
			};
			
			if(direction_y == "down"){
				y++;
			}else{
				y--;
			};
			if(y < 0){
				direction_y = "down";
			};
			if(y > panel.getHeight()){
				direction_y = "up";
			};			
		}
	}