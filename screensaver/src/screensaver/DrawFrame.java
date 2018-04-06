package screensaver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import javax.swing.JPanel;

public class DrawFrame extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Timer timer;


	
	public DrawFrame(){
		timer = new Timer(5, new TimerHandler()); //Create timer
		
		//Start Timer
		timer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g); // Prevent graphic issues
		this.setBackground(Color.BLACK);
		
		Shape circle = (Shape) new Circle(g);
		Shape square = (Shape) new Square(g);
		Shape line = (Shape) new Line(g);
		
		circle.draw(0,0);
		circle.move(this);
		
		square.draw(0,0);
		square.move(this);
		
		line.draw(this.getWidth(),0);
		line.move(this);
		
		Shape star = (Shape) new Star(g);
		star.draw(0,0);
		star.move(this);
		
	}
	
	private class TimerHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
			
		}
		
	}

	
	
}
