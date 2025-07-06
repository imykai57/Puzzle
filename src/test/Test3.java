package test;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(603,680);
		frame.setTitle("Demo");
		frame.setAlwaysOnTop(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(3);
		frame.setLayout(null);
		
		
		JButton jbtButton = new JButton("Click me!");
		jbtButton.setBounds(0,0,100,50);
		jbtButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("button has been clicked");
		    }
		});
		
		frame.getContentPane().add(jbtButton);
		
		
		
		frame.setVisible(true);
	}

}
