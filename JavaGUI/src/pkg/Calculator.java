package pkg;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Calculator extends JFrame {
	String sign = "";
	double firstNumber;
	double secondNumber;
	JLabel l;

	Calculator() {
		setTitle("계산기");
		setLayout(new BorderLayout());

		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);

		l = new JLabel("0", SwingConstants.RIGHT);
		l.setFont(new Font("Arial", Font.BOLD, 30));
		l.setOpaque(true);
		l.setBackground(Color.WHITE);
		l.setPreferredSize(new Dimension(300, 100));

		p.add(l);
		add(p, BorderLayout.NORTH);

		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setLayout(new GridLayout(4, 4, 2, 2));
		add(p1, BorderLayout.CENTER);

		String[] button_names = { "7", "8", "9", "x", "4", "5", "6", "/", "1", "2", "3", "+", "C", "0", "=", "-" };

		for (String name : button_names) {
			JButton b = new JButton(name);
			b.setFont(new Font("Arial", Font.BOLD, 20));

			if (name.equals("C") || name.equals("=") || name.equals("x") || name.equals("/") || name.equals("+")
					|| name.equals("-")) {
				b.setBackground(new Color(210, 180, 140));
			} else {
				b.setBackground(Color.LIGHT_GRAY);
			}

			b.addActionListener(new ButtonClickListener());
			p1.add(b);

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 550);
		setVisible(true);
	}

	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			if (command.equals("C")) {
				l.setText("0");
				firstNumber = 0;
				secondNumber = 0;
				sign = "";
			} else if (command.equals("=")) {
				secondNumber = Double.parseDouble(l.getText());
				double result = 0;

				if (sign.equals("+")) {
					result = firstNumber + secondNumber;
				} else if (sign.equals("-")) {
					result = firstNumber - secondNumber;
				} else if (sign.equals("x")) {
					result = firstNumber * secondNumber;
				} else if (sign.equals("/")) {
					result = firstNumber / secondNumber;
				}

				l.setText(String.valueOf(result));
				sign = "";
				firstNumber = result;
			} else if (command.equals("+") || command.equals("-") || command.equals("x") || command.equals("/")) {
				if (!sign.isEmpty()) {
					secondNumber = Double.parseDouble(l.getText());
					double result = 0;

					if (sign.equals("+")) {
						result = firstNumber + secondNumber;
					} else if (sign.equals("-")) {
						result = firstNumber - secondNumber;
					} else if (sign.equals("x")) {
						result = firstNumber * secondNumber;
					} else if (sign.equals("/")) {
						result = firstNumber / secondNumber;
					}

					firstNumber = result;
					l.setText(String.valueOf(result));

				} else {
					firstNumber = Double.parseDouble(l.getText());
				}
				sign = command;
				l.setText("");

			} else {

				if (l.getText().equals("0")) {

					l.setText(command);
				} else {
					l.setText(l.getText() + command);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
