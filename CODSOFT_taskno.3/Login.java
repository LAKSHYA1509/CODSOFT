
package bankmanagement;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener {

    JLabel text , pin , cardno ;
    JButton login,clearup,signup;
    JTextField cardTextField,pinTextField;

     Login() {
     setLayout(null);
     
     

      text = new JLabel("CASHIFY");
     text.setFont(new Font("Osward",Font.BOLD,38));
     text.setBounds(200,40,400,40 );
     add(text);


       cardno = new JLabel("card no.");
     cardno.setFont(new Font("Raleway",Font.BOLD,28));
     cardno.setBounds(120,150,150,30 );
     add(cardno);

     cardTextField = new JTextField();
    cardTextField.setBounds(300, 150, 230, 30);
    add(cardTextField);


       pin = new JLabel("PIN");
     pin.setFont(new Font("Raleway",Font.BOLD,28));
     pin.setBounds(120,220,400,40 );
     add(pin);

      pinTextField = new JPasswordField();
     pinTextField.setBounds(300, 220, 230, 30);
     add(pinTextField);

      login = new JButton("SIGN IN");
     login.setBounds(300,300,100,30);
     login.setBackground(Color.DARK_GRAY);
     login.setForeground(Color.WHITE);
     login.addActionListener(this);
     add(login);


       clearup = new JButton("CLEAR");
     clearup.setBounds(430,300,100,30);
     clearup.setBackground(Color.DARK_GRAY);
     clearup.setForeground(Color.WHITE);
     clearup.addActionListener(this);
     add(clearup);


       signup = new JButton("SIGN UP");
     signup.setBounds(300,350,230,30);
     signup.setBackground(Color.DARK_GRAY);
     signup.setForeground(Color.WHITE);
     signup.addActionListener(this);
     add(signup);
     

     getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
       setVisible(true);
       setTitle("Bank Management");
       setLocation(350,150);
    }
    
    public void actionPerformed (ActionEvent ae) {
       if (ae.getSource() == clearup) {
         cardTextField.setText("");
         pinTextField.setText("");
       }  
       else if (ae.getSource() == login) {
        Conn conn = new Conn();
        String cardnumber = cardTextField.getText();
        String pin = pinTextField.getText();
        String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pin+"'";
          try {
             ResultSet rs = conn.s.executeQuery(query);
             if (rs.next()) {
                 setVisible(false);
                 new Transactions(pin).setVisible(true);
             } else {
                 JOptionPane.showMessageDialog(null,"Incorrect card Number or Pin");
             }
          } catch (Exception e){
              System.out.println(e);
          }
       }
       else if (ae.getSource() == signup)  {
           setVisible(false);
          new SignupOne().setVisible(true);
       }
    }
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}