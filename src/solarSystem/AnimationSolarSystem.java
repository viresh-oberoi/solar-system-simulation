/*
 * Author: Viresh Oberoi
 * This class initiates the animation/simulation using JFrame (execute this file!). This class also initiates an instance of
 * the SolarSystem. This class acts as the View for this project as it renders the models (Star and Planets)
 * and sends requests to the main controller class SolarSystem.
 */


package solarSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class AnimationSolarSystem extends JPanel implements ActionListener {
	
	private static final int delay = 20;
	private Timer timer = new Timer(delay, this);
	private static int frameWidth = 1500;
	private static int frameHeight = 800;
	private SolarSystem sunSystem = new SolarSystem(frameWidth, frameHeight);
	
	public AnimationSolarSystem() {
		timer.start();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new AnimationSolarSystem());
		
		// Set window properties.
		frame.setSize(frameWidth, frameHeight);
		//does not match the fillRect in paint. How to repaint background?
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //makes sure the frame is the size of screen. 
		frame.setBackground(Color.darkGray);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, frameWidth, frameHeight);   //repaints background so there is no trail left behind
		g.setColor(Color.yellow);
		sunSystem.paint(g);
		sunSystem.move();
		g.dispose();
		
	}
	
	
	public int getFrameWidth() {
		return frameWidth;
	}
	public int getFrameHeight() {
		return frameHeight;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
	
	
}