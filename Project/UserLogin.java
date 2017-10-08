package Project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class UserLogin extends JFrame implements ActionListener
{
  JTextField t1;
  JLabel l1,l2,l3;
  JPasswordField t2;
  String aa,bb,msg;
  JButton b1,b2,b3;
  UserLogin()
  {
    setLayout(null);
    setSize(1950,1500);
    setVisible(true);
    l3= new JLabel("User Login");
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
	  
		Connection cn = null;
		Statement st = null;
		PreparedStatement pst;
		
		aa=t1.getText();
		bb=t2.getText();
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
		if(ae.getSource()==b1)
		{
			try
		     {
				Class.forName("com.mysql.jdbc.Driver");
				cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/sk","root","123456");
				st=cn.createStatement();
				String Lname,Lpass,name,email1="",contact="",name_of_book="",di="";
				
				ResultSet rs=st.executeQuery("select * from user where name='"+aa+"'");
				while(rs.next())
				{
					Lname=(rs.getString(1));
					Lpass=(rs.getString(2));
					
						name=(rs.getString(1));
	  					email1=(rs.getString(3));
	  					contact=(rs.getString(6));
	  					name_of_book=(rs.getString(7));
	  					di=(rs.getString(8));
					
					if(Lname.equals(aa) && Lpass.equals(bb))
					{
						JOptionPane.showMessageDialog(null,"Login sucessful !");
						new UserDetail(name,email1,contact,name_of_book,di);
					    setVisible(false);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Login Failed");
					}
				}
				
 
		     }
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Invalid User");
			}
 
  }
  }
  public static void main(String args[]){
	  UserLogin b=new UserLogin();
  }
  }
