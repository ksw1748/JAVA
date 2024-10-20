package pkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	Calculator() {
		setTitle("계산기");
		setLayout(new BorderLayout());

		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);

		JTextField t = new JTextField(50);
		t.setBackground(Color.WHITE);
		p.add(t);
		add(p, BorderLayout.NORTH);

		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setLayout(new GridLayout(4, 4));
		add(p1, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 550);
		setVisible(true);

		String[] button_names = { "7", "8", "9", "x", "4", "5", "6", "/", "1", "2", "3", "+", "C", "0", "=", "-" };

		for (int i = 0; i < button_names.length; i++) {
			JButton b = new JButton(button_names[i]);
			b.setBackground(Color.GRAY);

			p1.add(b);

			
		}

	}

	public static void main(String[] args) {
		new Calculator();

	}

}
