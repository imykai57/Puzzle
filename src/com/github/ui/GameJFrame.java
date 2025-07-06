package com.github.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;


//game
public class GameJFrame extends JFrame implements KeyListener,ActionListener{
	private int[][] data = new int[4][4];
	//position of white block
	int x = 0;
	int y = 0;
	//show image path
	String path = "image/animal/animal3/";
	int[][] win = new int[][] {
		{1,2,3,4},
		{5,6,7,8},
		{9,10,11,12},
		{13,14,15,0}
	};
	int step = 0;
	
	JMenuItem replayItem = new JMenuItem("Re-play");
	JMenuItem reLoginItem = new JMenuItem("Re-Login");
	JMenuItem closeItem = new JMenuItem("Close");
	JMenuItem accountItem = new JMenuItem("QR-Code");
	
	public GameJFrame() {	
		initJFrame();
		initMenuBar();
		initData();
		initImage();
		
		
		
		this.setVisible(true);

	}


	private void initJFrame() {
		//Size,Title,Top
		this.setSize(603,680);
		this.setTitle("Puzzle me offline");
		this.setAlwaysOnTop(true);	
		//Centering
		this.setLocationRelativeTo(null);	
		//close Mode
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);;//3
		/*
		 * why EXIT_ON_CLOSE?
		 * three UIs can not show at the same time
		 */
		
		//cancle default position of Hdiding Containers
		this.setLayout(null);//allready newed"ContendPane"
		//add keylistener
		this.addKeyListener(this);

		
	}	
	private void initMenuBar() {
		JMenuBar jMenuBar = new JMenuBar();
		JMenu functionJMenu = new JMenu("Functions");
		JMenu aboutJMenu = new JMenu("About");
		

		
		//add
		functionJMenu.add(replayItem);
		functionJMenu.add(reLoginItem);
		functionJMenu.add(closeItem);
		aboutJMenu.add(accountItem);
		
		replayItem.addActionListener(this);
		reLoginItem.addActionListener(this);
		closeItem.addActionListener(this);
		accountItem.addActionListener(this);
		
		
		
		
		
		
		jMenuBar.add(functionJMenu);
		jMenuBar.add(aboutJMenu);
		
		this.setJMenuBar(jMenuBar);
	}


	private void initImage() {
		//delete origin image
		this.getContentPane().removeAll();
		if(victory()) {
			JLabel vic = new JLabel(new ImageIcon("image\\win.png"));
			vic.setBounds(203,283,197,73);
			this.getContentPane().add(vic);
		}
		
		JLabel stepCount = new JLabel("Step:" + step);
		stepCount.setBounds(50,30,100,20);
		this.getContentPane().add(stepCount);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int num = data[i][j];
				//ImageIcon and JLabel(manager can)
				JLabel jLabel = new JLabel(new ImageIcon(path + num +".jpg"));
				//position
				jLabel.setBounds(105*j+83, 105*i+134, 105, 105);
				//Border
				jLabel.setBorder(new BevelBorder(0));
				this.getContentPane().add(jLabel);
			}	
		}
		//Background
		JLabel bg = new JLabel(new ImageIcon("image/background.png"));
		bg.setBounds(40, 40, 508, 560);
		this.getContentPane().add(bg);
		//refresh
		this.getContentPane().repaint();
	}
	
	//Shuffle
	private void initData() {
		int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Random r = new Random();
		for (int i = 0; i < tempArr.length; i++) {
			int index = r.nextInt(tempArr.length);
			int temp = tempArr[i];
			tempArr[i] = tempArr[index];
			tempArr[index] = temp;
			if(tempArr[i]==0) {
				x = i/4;
				y = i%4;
			}
		}
		for (int i = 0; i < tempArr.length; i++) {
			System.out.print(tempArr[i] + " ");
		}
		

		int index = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = tempArr[index];
				index++;
			}
		}

	}


	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(victory()) {
			return; //end the game
		}
		int code = e.getKeyCode();
		//keep press 'A'
		if(code == 65) {
			this.getContentPane().removeAll();
			JLabel  all = new JLabel(new ImageIcon(path + "all.jpg"));
			all.setBounds(83,134,420,420);
			this.getContentPane().add(all);
			//Background
			JLabel bg = new JLabel(new ImageIcon("image/background.png"));
			bg.setBounds(40, 40, 508, 560);
			this.getContentPane().add(bg);
			//refresh
			this.getContentPane().repaint();
			
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		if(victory()) {
			return; //end the game
		}
		//up 38,down 40,left 37 and right 39
		int code = e.getKeyCode();
		if(code == 37) {
			System.out.println("left");
			data[x][y] = data[x][y+1];
			data[x][y+1] = 0;
			y++;
			step++;
			initImage();
		}else if(code == 38) {
			System.out.println("up");
			data[x][y] = data[x+1][y];
			data[x+1][y] = 0;
			x++;
			step++;
			initImage();
		}else if(code == 39) {
			System.out.println("right");
			data[x][y] = data[x][y-1];
			data[x][y-1] = 0;
			y--;
			step++;
			initImage();
		}else if(code == 40) {
			System.out.println("down");
			data[x][y] = data[x-1][y];
			data[x-1][y] = 0;
			x--;
			step++;
			initImage();
		}else if(code == 65) {
			initImage();
		}else if(code == 87) {
			//cheating 'W'
			data = new int[][] {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,0}
			};
			initImage();
		}
		
	}
	
	//data == win? true/false
	public boolean victory() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i][j] != win[i][j]) {
					return false;
				}
			}
		}
		return true;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == replayItem) {
			System.out.println("replay");
			step =0;
			initData();
			initImage();
			
		}else if(obj == reLoginItem) {
			System.out.println("reLogin");
			this.setVisible(false);
			new LoginJFrame();
		}else if(obj == closeItem) {
			System.out.println("close");
			System.exit(0);
		}else if(obj == accountItem) {
			System.out.println("QR-Code");
			JDialog jDialog = new JDialog();
			JLabel jLabel = new JLabel(new ImageIcon("image/about.jpg"));
			jLabel.setBounds(0,0,600,600);
			jDialog.getContentPane().add(jLabel);
			jDialog.setSize(480,560);
			jDialog.setAlwaysOnTop(true);
			jDialog.setLocationRelativeTo(null);
			jDialog.setModal(true);
			jDialog.setVisible(true);
		}
		
	}
}
