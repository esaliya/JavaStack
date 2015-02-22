package edu.indiana.cs;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;


/**
 * This calss will display a image and based on the mouse drags
 * it will calculate a new camera angles and location.
 * Simple mouse drag up and down will move the camera towards and 
 * away from the origin.
 * Mouse drag with the Shift key pressed will present a rolling 
 * ball camera setup.
 * @author chathura
 *
 */
public class RayTraceDisplay extends Panel implements MouseMotionListener,
		MouseListener, KeyListener {

	private static Point mouseDownPoint = null;

	private static boolean shiftPressed;

	private static double locX = 0;
	private static double locY = 0;
	private static double locZ = 10.0;

	private static double dirX = 0;
	private static double dirY = 0;
	private static double dirZ = -1;

//	private BufferedImage image;

//	public BufferedImage getImage() {
//		return image;
//	}

	public RayTraceDisplay() {
//		try {
			
//			File input = new File(imageName);
//			image = ImageIO.read(input);
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
			this.addKeyListener(this);
//		} catch (IOException ie) {
//			System.out.println("Error:" + ie.getMessage());
//		}
	}

//	public void paint(Graphics g) {
//		g.drawImage(image, 0, 0, null);
//	}

	static public void main(String args[]) throws Exception {
		JFrame frame = new JFrame("RayTrace");
		String imageName = "finalresult.jpg";
        ImageIcon icon = new ImageIcon("finalresult.jpg");
		RayTraceDisplay panel = new RayTraceDisplay();
        panel.add(new JLabel(icon));

		frame.getContentPane().add(panel);
		frame.setSize(icon.getIconWidth(), icon.getIconHeight());
		frame.setVisible(true);
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 16) {
			shiftPressed = true;
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 16) {
			shiftPressed = false;
		}
	}

	

	public void mousePressed(MouseEvent e) {
		mouseDownPoint = e.getPoint();

	}

	public void mouseReleased(MouseEvent e) {

		Point mouseDragged = e.getPoint();

		int dx = mouseDragged.x - mouseDownPoint.x;
		int dy = mouseDragged.y - mouseDownPoint.y;

		if (shiftPressed) {
			// Then we are moving towars or away in r direction on polar
			// cordinates
			double r = Math.sqrt(Math.pow(locX, 2) + Math.pow(locY, 2)
					+ Math.pow(locZ, 2));
			double thetaX = Math.acos(locX / r);
			double thetaY = Math.acos(locY / r);
			double thetaZ = Math.acos(locZ / r);

			r = r + ((double) dy) / 50;
			// direction wont change but the location does

			locX = r * Math.cos(thetaX);
			locY = r * Math.cos(thetaY);
			locZ = r * Math.cos(thetaZ);
			System.out.println("Forward backward");

		} else {
			// we do rolling ball around origin this would be sufficient for the
			// ray trace to notice

			double r = Math.sqrt(Math.pow(locX, 2) + Math.pow(locY, 2)
					+ Math.pow(locZ, 2));
			double r2 = Math.sqrt(Math.pow(locX + dx / 50, 2)
					+ Math.pow(locY + dy / 50, 2) + Math.pow(locZ, 2));
			double thetaX = Math.acos((locX + dx / 50) / r2);
			double thetaY = Math.acos((locY + dy / 50) / r2);
			double thetaZ = Math.acos(locZ / r2);

			locX = r * Math.cos(thetaX);
			locY = r * Math.cos(thetaY);
			locZ = r * Math.cos(thetaZ);

			// new normalized r
			r = Math.sqrt(Math.pow(locX, 2) + Math.pow(locY, 2)
					+ Math.pow(locZ, 2));
			dirX = -locX / r;
			dirY = -locY / r;
			dirZ = -locZ / r;
			System.out.println("Rolling ball");

		}

		System.out.println("Location (" + locX + ", " + locY + ", " + locZ
				+ ")");

		System.out.println("Direction (" + dirX + ", " + dirY + ", " + dirZ
				+ ")");
		
		//TODO Invoke your ray trace call here
		//you may want to run it in a new thread
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}