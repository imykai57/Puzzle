package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyJFrame extends JFrame implements ActionListener{
	JButton jbt1 = new JButton("Zoom up");
	JButton jbt2 = new JButton("Random Positon");
	
	public MyJFrame() {
		this.setSize(603,680);
		this.setTitle("Puzzle Me Offline");
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setLayout(null);//active XY axis
		
		this.getContentPane().add(jbt1);
		this.getContentPane().add(jbt2);
		
		jbt1.setBounds(0,0,100,50);
		jbt1.addActionListener(this);
		
		
		jbt2.setBounds(100,0,100,50);
		jbt2.addActionListener(this);
		
		this.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == jbt1) {
			jbt1.setSize(200,200);
		}else if(source == jbt2) {
			Random r = new Random();
			jbt2.setLocation(r.nextInt(500),r.nextInt(500));
		}
	}
}
