/*
Sai Avula
7/22/2024
Calculator.java
Count the number of times you click a button
*/
import java.awt.*;  import java.awt.event.*;
import javax.swing.*;

public class Calculator{

    JButton[] arrayBtn;
    JTextArea num, operator, num2, ans, equals ;
    boolean bool, fin1, fin2 , add, subtract, multiply, divide;
    String one, two, answer;
    public Calculator()
    {
        num = null;
        operator = null;
        num2 = null;
        ans = null;
        equals = null;
        one = "0";
        two = "0";
        answer = "0";
        bool = false;
        fin1 = false;
        fin2 = false;
        add = false;
        subtract = false;
        multiply = false;
        divide = false;
    }

    public static void main(String[] args)
    {
        Calculator GLS = new Calculator();
        GLS.runIt();
    }

    public void runIt()
    {
        JFrame frame = new JFrame("GridLayoutSample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        GridLayout grid = new GridLayout(5, 5, 3, 3);
        frame.setLayout(grid);

        num = new JTextArea();
        num.setText(one);
        num.setEditable(false);
        frame.add(num);

        operator = new JTextArea();
        operator.setText("*");
        operator.setEditable(false);
        frame.add(operator);
    }

    class ButtonHandler2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           
        }
    }
}