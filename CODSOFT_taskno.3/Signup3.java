
package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {
    
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
   JRadioButton r1,r2,r3,r4;
   JButton b1,b2;
   JCheckBox c1,c2,c3,c4,c5,c6,c7;
   String formno;
    Signup3(String formno) {
        this.formno = formno;
        setLayout(null);
    l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100, 100, 200, 30);
        add(l2);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 130, 150, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 130, 300, 30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 170, 250, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 170, 250, 30);
        add(r4);

        ButtonGroup new_account = new ButtonGroup();
        new_account.add(r1);
        new_account.add(r2);
        new_account.add(r3);
        new_account.add(r4);

        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 220, 200, 30);
        add(l3);

        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(330, 220, 250, 30);
        add(l4);

        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(100, 250, 200, 20);
        add(l5);

        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        l6.setBounds(330, 250, 500, 20);
        add(l6);

        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100, 290, 200, 30);
        add(l7);

        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(330, 290, 200, 30);
        add(l8);

        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
        l9.setBounds(100, 320, 200, 20);
        add(l9);

        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 350, 200, 30);
        add(l10);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 400, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 400, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 450, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 450, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 500, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 500, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 530, 600, 20);
        add(c7);

        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250, 570, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(420, 570, 100, 30);
        b2.addActionListener(this);
        add(b2);

        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
      if (ae.getSource()==b1) {
          String accountType = null;
          if(r1.isSelected()){ 
            accountType = "Saving Account";
        }
        else if(r2.isSelected()){ 
            accountType = "Fixed Deposit Account";
        }
        else if(r3.isSelected()){ 
            accountType = "Current Account";
        }else if(r4.isSelected()){ 
            accountType = "Recurring Deposit Account";
        
        }  
         
          Random random = new Random ();
          String cardnumber = "" + Math.abs((random.nextLong()% 90000000L) + 5040936000000000L);
         
          String pin = "" + Math.abs((random.nextLong()% 9000L) + 1000L);
          
          String facility ="";
          if(c1.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){ 
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){ 
            facility = facility + " EMAIL Alerts";
        }
        if(c5.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){ 
            facility = facility + " E-Statement";
        }
        
        try {
            if (accountType.equals("")) {
                JOptionPane.showMessageDialog(null,"Account type is Required");
            } else {
                Conn conn = new Conn();
                String query = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pin+"','"+facility+"')";
                String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pin+"')";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card Number " + cardnumber +"\n Pin:" + pin);
                setVisible(false);
                new Deposit(pin).setVisible(false);
                new Signup3(formno).setVisible(true);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        
      }  else if (ae.getSource()==b2) {
          setVisible(false);
          new Login().setVisible(true);
      }
    }
    public static void main(String args[]) {
        new Signup3 ("").setVisible(true);
        // TODO code application logic here
    }
}
