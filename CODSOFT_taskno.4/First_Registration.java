import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class First_Registration extends JFrame implements ActionListener
{
  JLabel text , text2 , text3;
  JButton next;

  First_Registration() {
    setLayout(null);
    
     text = new JLabel("CASHAVA");
     text.setFont(new Font("Osward",Font.BOLD,46));
     text.setBounds(270,40,600,40);
     add(text);

    text2 = new JLabel("The Best Currency Converter with real time updates");
     text2.setFont(new Font("Raleway",Font.BOLD,20));
     text2.setBounds(140,40,600,200);
     add(text2);

      text3 = new JLabel("Let's Get Started !! ==>");
     text3.setFont(new Font("Raleway",Font.BOLD,26));
     text3.setBounds(100,40,700,400);
     add(text3);

     next = new JButton("Next");
     next.setBounds(430, 225, 120, 30);
     next.setBackground(Color.DARK_GRAY);
     next.setForeground(Color.WHITE);
     next.addActionListener(this);
     add(next);


    getContentPane().setBackground(Color.LIGHT_GRAY);

    setSize(750,350);
   setVisible(true);
   setTitle("The Best Currency Converter");
   setLocation(350,150);
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == next) {
        setVisible(false); // Hide the current frame (First_Registration)
        new Converter().setVisible(true); // Show the Converter frame
    }
}
  public static void main(String[] args) 
  {
    new First_Registration().setVisible(true);
  }
}
