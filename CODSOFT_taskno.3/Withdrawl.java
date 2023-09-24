
package bankmanagement;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Withdrawl extends JFrame implements ActionListener{

JLabel text;
JTextField amount;
JButton  withdraw,back;
String pin;
Withdrawl(String pin) {
    this.pin = pin;
    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(850,680, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 850, 680);
    add(image);

    text = new JLabel("Enter the amount you want to withdraw");
    text.setBounds(180,220,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD,16));
    image.add(text);

     amount = new JTextField();
    amount.setFont(new Font ("Raleway",Font.BOLD,22));
    amount.setBounds (157,270,320,25);
    image.add(amount);

     withdraw = new JButton("Withdraw");
     withdraw.setBounds(340,340,130,30);
     withdraw.addActionListener(this);
     image.add(withdraw);

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
    if (ae.getSource()==withdraw) {

     if (numbers.equals("")){
         JOptionPane.showMessageDialog(null, "Please enter the Amount to be Withdrawn ");
     } else {
         Conn conn = new Conn();
         String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+numbers+"')";
         conn.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null, "Rs. "+numbers+" Withdraw Successfully");
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
    new Withdrawl("");
}
}
