package pkg;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Calculator extends JFrame {
	String sign;
	double firstNumber;
	double secondNumber;
	double result = 0;

	Calculator() {
		setTitle("계산기");
		setLayout(new BorderLayout());

		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);

		JTextArea t = new JTextArea(10, 33);

		t.setEditable(false);
		t.setBackground(Color.WHITE);
		p.add(t);
		add(p, BorderLayout.NORTH);

		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setLayout(new GridLayout(4, 4, 2, 2));
		add(p1, BorderLayout.CENTER);

		String[] button_names = { "7", "8", "9", "x", "4", "5", "6", "/", "1", "2", "3", "+", "C", "0", "=", "-" };

		for (String name : button_names) {
			JButton b = new JButton(name);
			

			if (name.equals("C") || name.equals("=") || name.equals("x") || name.equals("/") || name.equals("+")
					|| name.equals("-")) {
				b.setBackground(new Color(210, 180, 140));
			} else {
				b.setBackground(Color.LIGHT_GRAY);
			}
			
			b.addActionListener(new ButtonClickListener()); 	

			p1.add(b);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(350, 550);
			setVisible(true);

		}
		private class ButtonClickListener() implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				
				if (command.equals("C")) {
					t.setText("0");
					firstNumber = 0;
					secondNumber = 0;
					
					
					
				}if (sign.equals("+")) {
					result = firstNumber + secondNumber;
				} else if (sign.equals("-")) {
					result = firstNumber - secondNumber;
				} else if (sign.equals("x")) {
					result = firstNumber * secondNumber;
				} else if (sign.equals("/")) {
					result = firstNumber / secondNumber;
					
				}

				
			}
			
		}
		
	
		
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
