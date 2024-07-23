/*
Sai Avula
3.20.24
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


        arrayBtn[0] = new JButton("0");
        arrayBtn[0].setBackground(Color.white);
        frame.add(arrayBtn[0]);
        arrayBtn[0].addActionListener(bhandler);

        JTextArea ans2 = new JTextArea();
        ans2.setText("");
        ans2.setEditable(false);
        frame.add(ans2);

        JTextArea ans1 = new JTextArea();
        ans1.setText("");
        ans1.setEditable(false);
        frame.add(ans1);

        JTextArea ans3 = new JTextArea();
        ans3.setText("");
        ans3.setEditable(false);
        frame.add(ans3);

        JButton JButtonEqual = new JButton("=");
        JButtonEqual.setBackground(Color.white);
        JButtonEqual.addActionListener(bhandler);
        frame.add(JButtonEqual);
        frame.setVisible(true);

    }

    class ButtonHandler2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if(command.equals("CLR"))
            {
                bool = false;
                fin1 = false;
                fin2 = false;
                add = false;
                subtract = false;
                multiply = false;
                divide = false;
                num.setText("0");
                operator.setText("*");
                num2.setText("0");
                ans.setText("0");

            }
            else if(command.equals("*") || command.equals("-")|| command.equals("/")|| command.equals("+"))
            {
                System.out.println("hi");
                bool = true;
                operator.setText(command);
                if (command.equals("/")) 
                {
                    divide = true;
                }

                if (command.equals("*")) 
                {
                    multiply = true;
                }

                if (command.equals("-")) 
                {
                    subtract = true;
                }

                if (command.equals("+")) 
                {
                    add = true;
                }
            }
            else if(command.equals("RNDM"))
            {
                int temp = (int)(Math.random() * 101) + 100;
                one = temp + "";
                num.setText(one);
            }
            else if(!bool)
            {
                if(!fin1 && (command.equals("0") ||command.equals("1")|| command.equals("2")|| command.equals("3")|| command.equals("4")|| command.equals("5")|| command.equals("6")|| command.equals("7")|| command.equals("8")|| command.equals("9")))
                {
                    one = command;
                    num.setText(one);
                    fin1 = true;
                }
                else if(fin1)
                {
                    one += command;
                    num.setText(one);
                }
            }
            else if(bool && !command.equals("="))
            {
                System.out.println("hi1");
                if(!fin2 && (command.equals("0") ||command.equals("1")|| command.equals("2")|| command.equals("3")|| command.equals("4")|| command.equals("5")|| command.equals("6")|| command.equals("7")|| command.equals("8")|| command.equals("9")))
                {
                    two = command;
                    num2.setText(two);
                    fin2 = true;
                }
                else if(fin2)
                {
                    two += command;
                    num2.setText(two);
                }
            }
            else if(command.equals("="))
            {
                int first = Integer.parseInt(one);
                int second = Integer.parseInt(two);
                int ans1 = 0;
                if(add) ans1 = first + second;
                if(subtract) ans1 = first - second;
                if(multiply) ans1 = first * second;
                if(divide) ans1 = first/second;
                ans.setText(ans1 + "");
            }

        }
    }
}