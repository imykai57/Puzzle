package com.github.ui;

import javax.swing.JFrame;

public class RegisterJFrame extends JFrame{
	public RegisterJFrame() {
		this.setSize(488,500);
		this.setTitle("Sign up");
		this.setAlwaysOnTop(true);
		//Centering
		this.setLocationRelativeTo(null);		
		//close Mode
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);;//3
		
		this.setVisible(true);
	}
}
