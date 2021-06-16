/*
 * Author: Viresh Oberoi
 * This class is responsible for moving the planets in a circular motion around the center of gravity for
 * the solar system. The distance for each planet is based on AU (Astronomical Unit)
 */

package solarSystem;

import java.awt.Color;
import java.awt.Graphics;

public class Planet{
	protected double distance;
	protected double mass;
	protected int diameter;
	protected double orbitalPeriod; //determines how fast the object travels around the star.
	protected SolarSystem system; //a link to its hosting system.
	protected Color planetColor;
	protected int timeCounter;  //allows the planet to visually move around the star. 
	protected int x;
	protected int y;
	
	
	public Planet(int d, double dist, int m, Color c) {
		//creating a planet by defining diameter, distance from host Star, mass, and color.
		diameter = d;
		distance = dist * system.AU;
		mass = m;
		planetColor = c;
		timeCounter = 1;
		orbitalPeriod = Math.PI / 128; //kept constant at this speed to enable easy observation of all planets.
		
	}
	
	
	public void setSystem(SolarSystem ss) {
		system = ss;
		x = (int) (system.centerOfGravityX + distance);
		y = system.centerOfGravityY;
	}
	
	
	public void paint(Graphics g) {
		g.setColor(planetColor);		
		g.drawOval(x, y , diameter, diameter);
	}
	
	public void move() {
		x = (int) (system.centerOfGravityX + distance * Math.cos(timeCounter * orbitalPeriod));
		System.out.println(x);
		y = (int) (system.centerOfGravityY + distance * Math.sin(timeCounter * orbitalPeriod));
		timeCounter += 1;
	}
	
	
}