package screensaver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.Random;

import javax.swing.JPanel;

public class Star extends Shape{

	    int xPoints[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43};        
	    int yPoints[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36};
	    private Random random = new Random();
		private static String direction_x = "forward";
		private static String direction_y = "down";
		private static int x = 1;
		private static int y = 1;
		
		
		public Star(Graphics g) {
			 super(g);
		}

		public void draw(int position_x, int position_y) {
			Graphics2D g2d = (Graphics2D) this.getG();
			GeneralPath star = new GeneralPath();        
			star.moveTo( xPoints[0], yPoints[0] );//create the star--this does not draw the start        
			
			for (int count = 1; count < xPoints.length; count++)            
				star.lineTo(xPoints[count], yPoints[count]);        
				star.closePath();        
				g2d.translate(0, 0); 
				
				for(int count = 1; count <= 20; count++){            
					g2d.rotate( Math.PI / 10);            
					g2d.setColor(new Color (random.nextInt(256), random.nextInt(256), random.nextInt(256)));
	            g2d.fill(star);
	            }//end for
			}

		@Override
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