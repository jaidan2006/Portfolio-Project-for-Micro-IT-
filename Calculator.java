import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Simple Calculator Project
 * Developed using Java Swing
 * Supports basic arithmetic operations
 */
public class Calculator extends JFrame implements ActionListener {

        private JTextField display;

    
    private double num1 = 0, num2 = 0;
    private char operator;

    
    public Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

     
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 28));
        add(display, BorderLayout.NORTH);

    
        JPanel panel = new JPanel(new GridLayout(4, 4, 10, 10));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String label : buttons) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.BOLD, 24));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

   
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        if (input.matches("[0-9]")) {
            display.setText(display.getText() + input);
        } else if (input.equals("C")) {
            display.setText("");
            num1 = num2 = 0;
        } else if (input.equals("=")) {
            try {
                num2 = Double.parseDouble(display.getText());

                switch (operator) {
                    case '+': display.setText(String.valueOf(num1 + num2)); break;
                    case '-': display.setText(String.valueOf(num1 - num2)); break;
                    case '*': display.setText(String.valueOf(num1 * num2)); break;
                    case '/':
                        if (num2 == 0) {
                            display.setText("Cannot divide by zero");
                        } else {
                            display.setText(String.valueOf(num1 / num2));
                        }
                        break;
                }
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else {
            try {
                num1 = Double.parseDouble(display.getText());
                operator = input.charAt(0);
                display.setText("");
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        }
    }

   
    public static void main(String[] args) {
        new Calculator();
    }
}