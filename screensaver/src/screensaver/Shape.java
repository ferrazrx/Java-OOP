package screensaver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public abstract class Shape {
	private Random random = new Random();
	private Color colorArray[] = {Color.BLUE,Color.CYAN,Color.YELLOW,
            Color.GRAY,Color.GREEN,Color.ORANGE};
	private Graphics g;
	
	public Shape(Graphics g){
		this.g = g;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public int getRandom(int limit) {
		return random.nextInt(limit);
	}
	
	private int getRandom() {
		return random.nextInt(4);
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public Color getRandomColor(){
		return this.colorArray[(0 + this.getRandom())];
		
	}

	public Color[] getColorArray() {
		return colorArray;
	}



	public void setColorArray(Color[] colorArray) {
		this.colorArray = colorArray;
	}



	
	
	
	
	public abstract void draw(int x, int y);
	public abstract void move(JPanel panel);
	
	
}
