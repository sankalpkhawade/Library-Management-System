package Project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

class LibrarianSuccess extends JFrame implements ActionListener
{
  JLabel l1;
  JButton b1,b2,b3,b4;
  LibrarianSuccess()
  {
    setLayout(null);
    setSize(1950,1500);
    setVisible(true);
    l1= new JLabel("Admin Section");
    l1.setForeground(Color.GRAY);
    b1=new JButton("Add User");
    b2=new JButton("View User");
    b3=new JButton("Delete User");
    b4=new JButton("Logout");
    l1.setFont(new Font("Tahoma", Font.PLAIN, 30));
    b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
    b3.setFont(new Font("Tahoma", Font.PLAIN, 15));
    b4.setFont(new Font("Tahoma", Font.PLAIN, 15));
    add(l1);
    add(b1);
    add(b2);
    add(b3);
    add(b4);
    l1.setBounds(880,300,150,30);
    b1.setBounds(850,400,150,30);
    b2.setBounds(850,490,150,30);
    b3.setBounds(850,580,150,30);
    b4.setBounds(850,670,150,30);
    l1.setSize(250,60);
    b1.setSize(250,80);
    b2.setSize(250,80);
    b3.setSize(250,80);
    b4.setSize(250,80);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
  }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==b1)
    {
    	LibrarianForm f3=new LibrarianForm();
    	 setVisible(false);
    }
  if(ae.getSource()==b2)
  {
	 ViewUsers u=new ViewUsers();
	  setVisible(false);
  }
  if(ae.getSource()==b3)
  {
	  DeleteUser d=new DeleteUser();
	  setVisible(false);
  }
  if(ae.getSource()==b4)
  {
	  LibrarianLogin lf=new LibrarianLogin();
	  setVisible(false);
  }
  }
  public static void main(String args[]){
	  LibrarianSuccess s=new LibrarianSuccess();
  }
  }

