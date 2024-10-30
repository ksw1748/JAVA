package pkg;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * 기본 산술 연산을 제공하는 간단한 계산기 프로그램입니다.
 * 이 클래스는 숫자와 연산자, 제어 버튼을 포함하는 GUI를 생성합니다.
 * 
 * @author Kim Seung Woo (ksw1748@gmail.com)
 */
public class Calculator extends JFrame {
    String sign = ""; // 현재 연산자
    double firstNumber; // 첫 번째 숫자
    double secondNumber; // 두 번째 숫자
    JLabel l; // 결과를 표시할 레이블

    /**
     * 계산기 GUI를 초기화하는 생성자입니다.
     * 레이아웃, 버튼 및 이벤트 리스너를 설정합니다.
     */
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

        // 버튼 이름 배열
        String[] button_names = { "7", "8", "9", "x", "4", "5", "6", "/", "1", "2", "3", "+", "C", "0", "=", "-" };

        // 버튼 생성 및 리스너 추가
        for (String name : button_names) {
            JButton b = new JButton(name);
            b.setFont(new Font("Arial", Font.BOLD, 20));

            // 버튼 색상 설정
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

    /**
     * 버튼 클릭 이벤트를 처리하는 내부 클래스입니다.
     */
    private class ButtonClickListener implements ActionListener {
        /**
         * 버튼이 클릭될 때 호출됩니다.
         * 클릭된 버튼에 따라 적절한 작업을 수행합니다.
         *
         * @param e 처리할 이벤트
         */
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("C")) {
                // 초기화
                l.setText("0");
                firstNumber = 0;
                secondNumber = 0;
                sign = "";
            } else if (command.equals("=")) {
                // 계산 실행
                secondNumber = Double.parseDouble(l.getText());
                double result = 0;

                switch (sign) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "x":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = firstNumber / secondNumber;
                        break;
                }

                l.setText(String.valueOf(result));
                sign = "";
                firstNumber = result;
            } else if (command.equals("+") || command.equals("-") || command.equals("x") || command.equals("/")) {
                // 연산자 설정
                if (!sign.isEmpty()) {
                    secondNumber = Double.parseDouble(l.getText());
                    double result = 0;

                    switch (sign) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "x":
                            result = firstNumber * secondNumber;
                            break;
                        case "/":
                            result = firstNumber / secondNumber;
                            break;
                    }

                    firstNumber = result;
                    l.setText(String.valueOf(result));
                } else {
                    firstNumber = Double.parseDouble(l.getText());
                }
                sign = command; // 현재 연산자를 저장
                l.setText(""); // 레이블 초기화
            } else {
                // 숫자 입력 처리
                if (l.getText().equals("0")) {
                    l.setText(command);
                } else {
                    l.setText(l.getText() + command);
                }
            }
        }
    }

    /**
     * 계산기 애플리케이션을 실행하는 메인 메서드입니다.
     *
     * @param args 커맨드 라인 인자 (사용되지 않음)
     */
    public static void main(String[] args) {
        new Calculator();
    }
}