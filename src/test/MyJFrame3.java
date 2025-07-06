package test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;

public class MyJFrame3 extends JFrame implements KeyListener {
	public MyJFrame3() {
		this.setSize(603,680);
		this.setTitle("Puzzle Me Offline");
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setLayout(null);//active XY axis
		
		this.addKeyListener(this);//给整个界面(1.this本类), 增加键盘监听(2.this当事件触发后会执行本类中对应代码)
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("按下");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == 87) {
			System.out.println("W");
		}else if(code == 65) {
			System.out.println("A");
		}else if(code == 83) {
			System.out.println("S");
		}else if(code == 68) {
			System.out.println("D");
		}
		
	}
	
}
