
package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Transactions extends JFrame implements ActionListener{

    String pin;
    JButton deposit , withdrawl , fastcash , pinchange , ministatement , balanceenquiry , exit;
    JLabel text;       
           
   Transactions(String pin) {
       this.pin = pin;
       setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 680);
        add(image);
        
        text = new JLabel("Please select your Transaction");
        text.setBounds(200,220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
         deposit = new JButton("Deposit");
        deposit.setBounds(170,260,140,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(340,260,140,30);
         withdrawl.addActionListener(this);
        image.add(withdrawl);

        
         fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,300,140,30);
                fastcash.addActionListener(this);
        image.add(fastcash);
        
          pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,340,140,30);
                pinchange.addActionListener(this);
        image.add(pinchange);
        
        
          ministatement = new JButton("Mini statement");
        ministatement.setBounds(340,300,140,30);
                ministatement.addActionListener(this);
        image.add(ministatement);
        
           balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(340,340,140,30);
                balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        
          exit = new JButton("Exit");
        exit.setBounds(340,380,140,30);
                exit.addActionListener(this);
        image.add(exit);

        
       setSize(850,850);
       setLocation(300,0);
       setVisible(true);
   }
   public void actionPerformed(ActionEvent ae) {
       if (ae.getSource()==exit) { 
           System.exit(0);
       } else if (ae.getSource()==deposit) {
           setVisible(false);
           new Deposit(pin).setVisible(true);
       }  else if (ae.getSource()==withdrawl) {
           setVisible(false);
           new Withdrawl(pin).setVisible(true);
       } else if (ae.getSource()==fastcash) {
           setVisible(false);
           new FastCash(pin).setVisible(true);
       }  else if (ae.getSource()==pinchange) {
           setVisible(false);
           new PinChange(pin).setVisible(true);
       }  else if (ae.getSource()==balanceenquiry) {
           setVisible(false);
           new BalanceEnquiry(pin).setVisible(true);
       }  else if (ae.getSource()==ministatement) {
           setVisible(false);
           new MiniStatement(pin).setVisible(true);
       }  
       }
   
           
           
   public static void main(String args[]) {
       new Transactions("").setVisible(true);
   }
}
