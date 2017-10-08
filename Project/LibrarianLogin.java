package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LibrarianLogin extends JFrame implements ActionListener
{
  JTextField t1;
  JLabel l1,l2,l3;
  String aa,bb,msg;
  JButton b1,b2,b3;
  JPasswordField t2;
  LibrarianLogin()
  {
    setLayout(null);
    setSize(1950,1500);
    setVisible(true);
    l3= new JLabel("Librarian Login");
    l3.setForeground(Color.GRAY);
    l1=new JLabel("Username");
    l2=new JLabel("Password");
    t1=new JTextField(30);
    t2=new JPasswordField(30);
    b1=new JButton("LOGIN");
    b2=new JButton("RESET");
    b3=new JButton("BACK");
    l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
    l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
    l3.setFont(new Font("Tahoma", Font.PLAIN, 30));
    b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
    b3.setFont(new Font("Tahoma", Font.PLAIN, 15));
    t1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    t2.setFont(new Font("Tahoma", Font.PLAIN, 15));
    add(l1);
    add(t1);
    add(l2);
    add(t2);
    add(b1);
    add(b2);
    add(b3);
    add(l3);
    t1.addActionListener(this);
    t2.addActionListener(this);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    l3.setBounds(900,250,200,40);
    l1.setBounds(840,350,150,30);
    t1.setBounds(1000,360,250,30);
    l2.setBounds(840,400,150,30);
    t2.setBounds(1000,410,250,30);
    b1.setBounds(800,500,150,30);
    b2.setBounds(1050,500,150,30);
    b3.setBounds(20,50,150,30);
    l1.setSize(200,60);
    l2.setSize(200,60);
    t1.setSize(200,40);
    t2.setSize(200,40);
    b1.setSize(200,60);
    b2.setSize(200,60);
    b3.setSize(200,60);
  }
  public void actionPerformed(ActionEvent ae)
  {
    aa=t1.getText();
    bb=t2.getText();
    if(ae.getSource()==b1)
    {
    if(aa.equals("librarian") && bb.equals("12345"))
    {
      new LibrarianSuccess();
      setVisible(false);
    }
    else
    {
      JOptionPane.showMessageDialog(null,"login Failed");
    }
  }
  if(ae.getSource()==b2)
  {
    t1.setText("");
    t2.setText("");
    setBackground(null);
  }
   if(ae.getSource()==b3)
   {
	   new Front();
	   setVisible(false);
   }
  }
  public static void main(String args[]){
	  LibrarianLogin b=new LibrarianLogin();
  }
  }
