
package bankmanagement;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener{

JLabel text;
JTextField amount;
JButton  deposit,back;
String pin;
Deposit(String pin) {
    this.pin = pin;
    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(850,680, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 850, 680);
    add(image);

    text = new JLabel("Enter the amount you want to deposit");
    text.setBounds(180,220,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD,16));
    image.add(text);

     amount = new JTextField();
    amount.setFont(new Font ("Raleway",Font.BOLD,22));
    amount.setBounds (157,270,320,25);
    image.add(amount);

     deposit = new JButton("Deposit");
     deposit.setBounds(340,340,130,30);
     deposit.addActionListener(this);
     image.add(deposit);

     back = new JButton("Back");
     back.setBounds(340,375,130,30);
     back.addActionListener(this);
     image.add(back);


    setSize(900,900);
    setLocation(350,0);
    setVisible(true);
}

public void actionPerformed(ActionEvent ae) {
   try {
       String numbers = amount.getText();

     Date date = new Date();
    if (ae.getSource()==deposit) {

     if (numbers.equals("")){
         JOptionPane.showMessageDialog(null, "Please enter the Amount to be added ");
     } else {
         Conn conn = new Conn();
         String query = "insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+numbers+"')";
         conn.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null, "Rs. "+numbers+" Deposited Successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
     }
   } else if (ae.getSource()==back) {
       new Transactions(pin).setVisible(true);
   }
} catch (Exception e) {
    e.printStackTrace();
}
}
public static void main(String args[]) {
    new Deposit("");
}
}
