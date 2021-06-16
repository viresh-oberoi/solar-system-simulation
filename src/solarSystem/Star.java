/*
 * Author: Viresh Oberoi
 * This class creates a Star object given certain constraints. It uses the frame dimensions of the JFrame
 * and sets its position to the center of the frame.
 */

package solarSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Star{
	protected int mass;
	protected int diameter;
	protected int frameWidth;
	protected int frameHeight;
	protected SolarSystem system;
	
	public Star(int fw, int fh, int d, int m, SolarSystem s) {
		frameWidth = fw;
		frameHeight = fh;
		diameter = d;
		mass = m;
		system = s;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.drawRect(0, 0, frameWidth, frameHeight);
		g.setColor(Color.yellow);
		g.drawOval(system.centerOfGravityX - (diameter/2), system.centerOfGravityY - (diameter/2), diameter, diameter); 	
	}
	
	public void move() {
		
	}
	
}