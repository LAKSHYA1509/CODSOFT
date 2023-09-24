
package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    String pin;
    JButton deposit , withdrawl , fastcash , pinchange , ministatement , balanceenquiry , exit;
    JLabel text;       
           
   FastCash(String pin) {
       this.pin = pin;
       setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 680);
        add(image);
        
        text = new JLabel("Select Withdrawl Amount");
        text.setBounds(200,220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
         deposit = new JButton("Rs 100");
        deposit.setBounds(170,260,140,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(340,260,140,30);
         withdrawl.addActionListener(this);
        image.add(withdrawl);

        
         fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,300,140,30);
                fastcash.addActionListener(this);
        image.add(fastcash);
        
          pinchange = new JButton("Rs 2000");
        pinchange.setBounds(170,340,140,30);
                pinchange.addActionListener(this);
        image.add(pinchange);
        
        
          ministatement = new JButton("Rs 5000");
        ministatement.setBounds(340,300,140,30);
                ministatement.addActionListener(this);
        image.add(ministatement);
        
           balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(340,340,140,30);
                balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        
          exit = new JButton("Back");
        exit.setBounds(340,380,140,30);
                exit.addActionListener(this);
        image.add(exit);

        
       setSize(850,850);
       setLocation(300,0);
       setVisible(true);
   }
   public void actionPerformed(ActionEvent ae) {
       if (ae.getSource()==exit) { 
       setVisible (false);
       new Transactions(pin).setVisible(true);
        } else { 
           String amount =((JButton) ae.getSource()).getText().substring(3);
           Conn c = new Conn();
           try {
               ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
               int balance = 0;
               while (rs.next()){
                   if (rs.getString("type").equals("Deposit")) {
                       balance = balance + Integer.parseInt(rs.getString("amount"));
                   } else {
                       balance = balance - Integer.parseInt(rs.getString("amount"));
                   }
               }
               
               if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                   JOptionPane.showMessageDialog(null, "Insuffient Balance");
               }
               
              Date date = new Date();
               String query = ("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs " + amount + "Debited Successfully");
               setVisible(false);
                 new Transactions(pin).setVisible(true);
           } catch (Exception e) {
               
           }
       }
   }
           
           
   public static void main(String args[]) {
       new FastCash("").setVisible(true);
   }
}
