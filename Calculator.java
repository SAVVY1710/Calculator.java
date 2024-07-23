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
        num2 = new JTextArea();
        num2.setText(two);
        num2.setEditable(false);
        frame.add(num2);

        equals = new JTextArea();
        equals.setText("=");
        equals.setEditable(false);
        frame.add(equals);

        ans = new JTextArea();
        ans.setText(answer);
        ans.setEditable(false);
        frame.add(ans);



        JButton times = new JButton("*");
        JButton minus = new JButton("-");
        JButton divide = new JButton("/");
        JButton add = new JButton("+");
        JButton clear = new JButton("CLR");
        JButton Random = new JButton("RNDM");
        times.setBackground(Color.white);
        minus.setBackground(Color.white);
        divide.setBackground(Color.white);
        add.setBackground(Color.white);
        clear.setBackground(Color.white);
        Random.setBackground(Color.white);


        ButtonHandler2 bhandler = new ButtonHandler2();


        arrayBtn = new JButton[10];
        for(int i=1; i < arrayBtn.length; i++) {
            arrayBtn[i] = new JButton(Integer.toString(i));
            frame.add(arrayBtn[i]);
            arrayBtn[i].addActionListener(bhandler);
            arrayBtn[i].setBackground(Color.white);
            if(i == 3)
            {
                frame.add(times);
                frame.add(minus);
                times.addActionListener(bhandler);
                minus.addActionListener(bhandler);
            }
            if(i == 6)
            {
                frame.add(divide);
                frame.add(add);
                divide.addActionListener(bhandler);
                add.addActionListener(bhandler);
            }
            if(i == 9)
            {
                frame.add(Random);
                frame.add(clear);
                Random.addActionListener(bhandler);
                clear.addActionListener(bhandler);
            }
        }
    }

    class ButtonHandler2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           
        }
    }
}