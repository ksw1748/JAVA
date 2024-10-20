package pkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Calculator extends JFrame {
	Calculator() {
		setTitle("계산기");
		setLayout(new BorderLayout());

		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);

		JTextArea t = new JTextArea(10,40);
		t.setBackground(Color.WHITE);
		p.add(t);
		add(p, BorderLayout.NORTH);

		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setLayout(new GridLayout(4, 4, 2, 2));
		add(p1, BorderLayout.CENTER);

		String[] button_names = { "7", "8", "9", "x", "4", "5", "6", "/", "1", "2", "3", "+", "C", "0", "=", "-" };

		for (int i = 0; i < button_names.length; i++) {
			JButton b = new JButton(button_names[i]);
			b.setBackground(Color.LIGHT_GRAY);

			p1.add(b);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(350, 550);
			setVisible(true);

		}

	}

	public static void main(String[] args) {
		new Calculator();

	}

}
