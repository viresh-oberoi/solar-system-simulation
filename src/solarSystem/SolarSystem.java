/*
 * Author: Viresh Oberoi
 * This class holds the code that manages the entire star system. This is where the planets and the stars 
 * are defined. It holds an array of planets and stars. For this demonstration, our solar system's  details
 * have been used. 
 */



package solarSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class SolarSystem {
	
	protected ArrayList<Planet> planets = new ArrayList<Planet>();
	protected ArrayList<Star> stars = new ArrayList<Star>();
	protected int frameWidth;
	protected int frameHeight;
	protected int centerOfGravityX;
	protected int centerOfGravityY;
	
	//use these values to see a more accurate representation of the solar system (in terms of size of the sun)
	protected static int sunDiam = 200;  
	protected static int AU = (sunDiam + 100); //adding the diameter of sun to make sure planets are placed outside of the sun's dimensions
	
	//use these values to see all planets on the screen
	//protected static int sunDiam = 1; //made it smaller to fit all planets on the screen.
	//protected static int AU = (sunDiam + 100) / 5; 
	
	
	public SolarSystem(int frameW, int frameH) {
		frameWidth = frameW;
		frameHeight = frameH;
		centerOfGravityX = frameW/2;
		centerOfGravityY = frameH/2;
		addStar(new Star(frameW, frameH, sunDiam, 500, this)); 
		//sizes of the planets are set relative to each other but not to the size of the Sun (unless sunDiam = 400) 
		
		//creating all the planets.
		//using AU (Astronomical Units) = 100 pixels
		Color mercury = new Color(128, 128, 128);
		addPlanet(new Planet(1, 0.39, 20, mercury));
		
		Color venus = new Color(187, 161, 79);
		addPlanet(new Planet(3, 0.723, 20, venus));
		
		Color earth = Color.blue;
		addPlanet(new Planet(4, 1, 20, earth));
		
		Color mars = Color.red;
		addPlanet(new Planet(2, 1.524, 20, mars));
		
		Color jupiter = new Color(181, 101, 29);
		addPlanet(new Planet(40, 5.203, 20, jupiter));
		
		Color saturn = new Color(204, 153, 102);
		addPlanet(new Planet(33, 9.539, 20, saturn));
		
		Color uranus = new Color(0, 255, 255);
		addPlanet(new Planet(14, 19.18, 20, uranus));
		
		Color neptune = Color.blue;
		addPlanet(new Planet(15, 30.06, 20, neptune));
		
	}
	

	public void addStar (Star s) {
		stars.add(s);
	}
	
	public void addPlanet (Planet p) {
		planets.add(p);
		p.setSystem(this);
	}
	
	public void paint(Graphics g) {
		for (int i = 0; i < stars.size(); i++) {
			stars.get(i).paint(g);
		}
		for (int i = 0; i < planets.size(); i++) {
			planets.get(i).paint(g);
		}
	}
	
	public void move() {
		for (Star star : stars) {
			star.move();
		}
		for (Planet planet : planets) {
			planet.move();
		}
		
	}
	
	
}