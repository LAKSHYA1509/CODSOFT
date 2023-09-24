
package bankmanagement;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pin;
    
    BalanceEnquiry(String pin) {
        
    this.pin = pin;

     setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 680);
        add(image);
        
      back = new JButton("Back");
     back.setBounds(340,375,130,30);
     back.addActionListener(this);
     image.add(back);

     int balance =0;
           try {
                        Conn c = new Conn();
               ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
               while (rs.next()){
                   if (rs.getString("type").equals("Deposit")) {
                       balance = balance + Integer.parseInt(rs.getString("amount"));
                   } else {
                       balance = balance - Integer.parseInt(rs.getString("amount"));
                   }
               }
           }
                catch (Exception e)
                       {
                       }
           
           JLabel text = new JLabel ("Your Current balance is Rs." +balance );
           text.setForeground(Color.WHITE);
           text.setBounds(170,300,400,30);
           image.add(text);
               
     
          setSize(850,850);
       setLocation(300,0);
       setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
        
    
    public static void main(String args[]) {
        
        new BalanceEnquiry("").setVisible(true);
        
      
}
}
