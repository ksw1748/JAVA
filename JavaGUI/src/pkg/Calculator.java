package pkg;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator extends JFrame {
	Calculator() {
		setTitle("게산기");
		setLayout(new BorderLayout());
		
		
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		
		JTextArea t = new JTextArea(10, 38);
		t.setBackground(Color.WHITE);
		p.add(t);
		add(p, BorderLayout.NORTH);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,550);
		setVisible(true);
		
		
		
		
		
	}

	public static void main(String[] args) {
		new Calculator();
		
		

	}

}
