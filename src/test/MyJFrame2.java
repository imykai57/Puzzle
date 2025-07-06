package test;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JButton;
import javax.swing.JFrame;

public class MyJFrame2 extends JFrame implements MouseListener{
	JButton jbt1 = new JButton("Click Me");
	
	
	public MyJFrame2() {
		this.setSize(603,680);
		this.setTitle("Puzzle Me Offline");
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setLayout(null);//active XY axis
		
		this.getContentPane().add(jbt1);
		
		jbt1.setBounds(0,0,100,50);
		
		//Binding MouseListener	
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

}