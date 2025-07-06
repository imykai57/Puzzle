package com.github.ui;

import javax.swing.JFrame;

public class LoginJFrame extends JFrame{
	//methods
	public LoginJFrame() {
		this.setSize(488,430);
		this.setTitle("Login");
		this.setAlwaysOnTop(true);
		
		//Centering
		this.setLocationRelativeTo(null);
		
		//close Mode
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);;//3
		
		this.setVisible(true);
	}
}
