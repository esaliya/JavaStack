package edu.indiana.cs;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame implements MouseListener {
	  JLabel a = new Mylabel();
	
	public void trial() {
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Action");
		MenuItem select = new MenuItem("select");
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		menu.add(select);
		
		MenuItem rotate = new MenuItem("rotate");
		rotate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		menu.add(rotate);
		
		menuBar.add( menu);
		setMenuBar(menuBar);
		
		this.addMouseListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        a.setIcon(new javax.swing.ImageIcon("E:\\Teaching\\Project2\\splits\\finalresult.jpg"));
        add(a);
        pack();
    }
    
    public static void main(String args[]){
    	Frame f = new Frame();
    	f.trial();
    	f.setVisible(true);
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

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    


}
