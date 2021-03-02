import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame{

    int num1;
    int num2;

    MyFrame() {
       /*
       Three text fields
        */
        JTextField jTextField1 = new JTextField(20);
        JTextField jTextField2= new JTextField(20);
        JTextField jTextField3= new JTextField(20);

       /*
       Four radio buttons
       */
        JRadioButton jRadioButton1 = new JRadioButton("+");
        JRadioButton jRadioButton2 = new JRadioButton("-");
        JRadioButton jRadioButton3 = new JRadioButton("*");
        JRadioButton jRadioButton4 = new JRadioButton("/");

       /*
       Label for equality sign
       */
        JLabel jLabel = new JLabel("=");

       /*
       Adding all the radio buttons in a box to display them in line in vertical alignment
       */
        Box box = Box.createVerticalBox();
        box.add(jRadioButton1);
        box.add(jRadioButton2);
        box.add(jRadioButton3);
        box.add(jRadioButton4);

       /*
       Grouping all radio buttons
        */
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        buttonGroup.add(jRadioButton4);

        this.setVisible(true);
        this.setTitle("Assignment 2");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

       /*
       Adding the same light coloured background as mentioned in the requirements
        */
        this.getContentPane().setBackground(new Color(233, 236, 213));

       /*
       Using Grid Bag Layout
        */
        this.setLayout(new GridBagLayout());

       /*
       Adding window listener for terminating a program when user clicks on 'X' on the frame
        */
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

       /*
       Adding action listener to jRadioButton1
        */
        jRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   /*
                   Parsing of input string values in text field 1 and 2 to integer values
                    */
                    num1 = Integer.parseInt(jTextField1.getText());
                    num2 = Integer.parseInt(jTextField2.getText());
                    String res = String.valueOf(num1 + num2);
                    jTextField3.setText(res);
                }catch(Exception exception){
                  /*
                  Handling the case where radio button is pressed with no input values in either of the two input text fields
                   */
                    if(jTextField1.getText().equals("") || jTextField2.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"No input in one or both text fields.");
                    }
                }
            }});

       /*
       Adding action listener to jRadioButton2
        */
        jRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   /*
                   Parsing of input string values in text field 1 and 2 to integer values
                    */
                    num1 = Integer.parseInt(jTextField1.getText());
                    num2 = Integer.parseInt(jTextField2.getText());
                    String res = String.valueOf(num1 - num2);
                    jTextField3.setText(res);
                }catch(Exception exception){
                   /*
                   Handling the case where radio button is pressed with no input values in either of the two input text fields
                    */
                    if(jTextField1.getText().equals("") || jTextField2.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"No input in one or both text fields.");
                    }
                }
            }
        });

       /*
       Adding action listener to jRadioButton3
        */
        jRadioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   /*
                   Parsing of input string values in text field 1 and 2 to integer values
                    */
                    num1 = Integer.parseInt(jTextField1.getText());
                    num2 = Integer.parseInt(jTextField2.getText());
                    String res = String.valueOf(num1 * num2);
                    jTextField3.setText(res);
                }catch(Exception exception){
                   /*
                   Handling the case where radio button is pressed with no input values in either of the two input text fields
                    */
                    if(jTextField1.getText().equals("") || jTextField2.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"No input in one or both text fields.");
                    }
                }
            }
        });

       /*
       Adding action listener to jRadioButton4
        */
        jRadioButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   /*
                   Parsing of input string values in text field 1 and 2 to integer values
                    */
                    num1 = Integer.parseInt(jTextField1.getText());
                    num2 = Integer.parseInt(jTextField2.getText());
                }catch(Exception exception){
                   /*
                   Handling the case where radio button is pressed with no input values in either of the two input text fields
                    */
                    if(jTextField1.getText().equals("") || jTextField2.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"No input in one or both text fields.");
                    }
                }
                boolean flag = false;
                String res;
                try {
                    int temp = num1 / num2;
                } catch (Exception ex) {
                       /*
                       Handling the case where either of the two input text fields contain 0
                        */
                    flag = true;
                    if(jTextField1.getText().equals("0") || jTextField2.getText().equals("0")){
                        JOptionPane.showMessageDialog(null, "Division by zero.");
                        jTextField3.setText("Not Defined");
                    }

                }
                if(!flag){
                    res = String.valueOf(num1 / (num2 * 1.0));
                    jTextField3.setText(res);
                }
            }
        });

       /*
       Adding Document Listener to the GUI
        */
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                modifySum();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                modifySum();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                modifySum();
            }

            private void modifySum() {
                try {
                   /*
                   Parsing of input string values in text field 1 and 2 to integer values
                    */
                    num1 = Integer.parseInt(jTextField1.getText());
                    num2 = Integer.parseInt(jTextField2.getText());
                }catch(Exception ex){
                   /*
                   Handling the case where either of the text fields contain non-integer values
                    */
                    if(((!jTextField2.getText().matches("[0-9]+") && !jTextField2.getText().equals(""))) || (!jTextField1.getText().matches("[0-9]+") && !jTextField1.getText().equals(""))){
                        JOptionPane.showMessageDialog(null,"Non integer inputs on one or both text fields.");
                    }
                }

               /*
               Perform addition when jRadioButton1 is selected
                */
                if (jRadioButton1.isSelected()) {
                    String res = String.valueOf(num1 + num2);
                    jTextField3.setText(res);
                }

               /*
               Perform subtraction when jRadioButton2 is selected
                */
                if (jRadioButton2.isSelected()) {
                    String res = String.valueOf(num1 - num2);
                    jTextField3.setText(res);
                }

               /*
               Perform multiplication when jRadioButton3 is selected
                */
                if (jRadioButton3.isSelected()) {
                    String res = String.valueOf(num1 * num2);
                    jTextField3.setText(res);
                }

               /*
               Perform division when jRadioButton4 is selected
                */
                if (jRadioButton4.isSelected()) {
                    boolean flag = false;
                    String res;
                    try {
                        int temp = num1 / num2;
                    } catch (Exception ex) {
                       /*
                       Handling the case where either of the two input text fields contain 0
                        */
                        flag = true;
                        if(jTextField1.getText().equals("0") || jTextField2.getText().equals("0")) {
                            JOptionPane.showMessageDialog(null, "Division by zero.");
                            jTextField3.setText("Not Defined");
                        }
                    }
                    if(!flag){
                        res = String.valueOf(num1 / (num2 * 1.0));
                        jTextField3.setText(res);

                    }
                }
            }
        };

        jTextField1.getDocument().addDocumentListener(documentListener);
        jTextField2.getDocument().addDocumentListener(documentListener);
        jTextField3.setEditable(false);

       /*
       Adding all the components to GUI
        */
        this.add(jTextField1);
        this.add(box);
        this.add(jTextField2);
        this.add(jLabel);
        this.add(jTextField3);
    }
}
/*
Driver class - 'Main'
*/
public class Main{
    public static void main(String[] args){
        new MyFrame();
    }
}
