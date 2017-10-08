package Project;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import javax.swing.*;

public class LibrarianForm extends JFrame implements ActionListener
{	
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JButton b1,b2;
	public LibrarianForm() 
	{
		setLayout(null);
		setSize(1950,1500);
		setVisible(true);
		l1= new JLabel("User Form");
		l1.setForeground(Color.DARK_GRAY);
		l2= new JLabel("Name:");
		l3= new JLabel("Password:");
		l4= new JLabel("Email:");
		l5= new JLabel("Address:");
		l6= new JLabel("City:");
		l7= new JLabel("Contact No:");
		l8=new JLabel("Name of Book");
		l9=new JLabel("Date of issue");
		b1= new JButton("Add Librarian");
		b2=new JButton("Back");
		t1= new JTextField(30);
		t2= new JTextField(30);
		t3= new JTextField(30);
		t4= new JTextField(30);
		t5= new JTextField(30);
		t6= new JTextField(30);
		t7= new JTextField(30);
		t8= new JTextField(30);
		l1.setFont(new Font("Tahoma", Font.ITALIC, 30));
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(b1);
		add(b2);
		add(l1);
		add(l2);
	    add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(t1);
		add(t2);
	    add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		add(t8);
		l1.setBounds(950,50,150,30);
	    l2.setBounds(850,200,150,30);
	    l3.setBounds(850,250,150,30);
	    l4.setBounds(850,300,150,30);
	    l5.setBounds(850,350,150,30);
	    l6.setBounds(850,400,150,30);
	    l7.setBounds(850,450,150,30);
	    l8.setBounds(850,500,150,30);
	    l9.setBounds(850,550,150,30);
	    t1.setBounds(950,200,150,30);
	    t2.setBounds(950,250,150,30);
	    t3.setBounds(950,300,150,30);
	    t4.setBounds(950,350,150,30);
	    t5.setBounds(950,400,150,30);
	    t6.setBounds(950,450,150,30);
	    t7.setBounds(950,500,150,30);
	    t8.setBounds(950,550,150,30);
	    b1.setBounds(950,600,100,30);
	    b2.setBounds(20,50,100,30);
		t1.addActionListener(this);
	    t2.addActionListener(this);
	    t3.addActionListener(this);
	    t4.addActionListener(this);
	    t5.addActionListener(this);
	    t6.addActionListener(this);
	    t7.addActionListener(this);
	    t8.addActionListener(this);
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    l1.setSize(200,60);
	    l2.setSize(200,60);
	    l3.setSize(200,60);
	    l4.setSize(200,60);
	    l5.setSize(200,60);
	    l6.setSize(200,60);
	    l7.setSize(200,60);
	    l8.setSize(200,60);
	    l9.setSize(200,60);
	    t1.setSize(200,40);
	    t2.setSize(200,40);
	    t3.setSize(200,40);
	    t4.setSize(200,40);
	    t5.setSize(200,40);
	    t6.setSize(200,40);
	    t7.setSize(200,40);
	    t8.setSize(200,40);
	    b1.setSize(200,60);
	    b2.setSize(200,60);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		Connection cn = null;
		Statement st = null;
		PreparedStatement pst;
        
        String name=t1.getText();
        String password=t2.getText();
        String email=t3.getText();
        String address=t4.getText();
        String city=t5.getText();
        String contact=t6.getText();
        String name_of_book=t7.getText();
        String di=t8.getText();
    	if(ae.getSource()==b2)
        {
      	  new LibrarianSuccess();
      	  setVisible(false);
    	        
        }  
		try
		  {
			Class.forName("com.mysql.jdbc.Driver");
	         cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/sk","root","123456");
	         st=cn.createStatement();
	        
			
		      if(ae.getSource()==b1)
	          {
	          
		    	  if(name.equals("") ||password.equals("")||email.equals("")||address.equals("")||city.equals("")||contact.equals("")||name_of_book.equals("")||di.equals(""))
		  		{
		    			JOptionPane.showMessageDialog(null,"Fill Fields !");
		    			return ;
		  		}//check filed are properly entered of not
		        pst=cn.prepareStatement("insert into user(name,pass,email,address,city,contact,name_of_book,di )"+" values(?,?,?,?,?,?,?,?)");
		        
		        pst.setString(1,name);
		        pst.setString(2,password);
		        pst.setString(3,email);
		        pst.setString(4,address);
		        pst.setString(5,city);
		        pst.setString(6,contact);
		        pst.setString(7, name_of_book);
		        pst.setString(8,di);
		        pst.execute();
                JOptionPane.showMessageDialog(null,"Updated");

		        t1.setText("");
		        t2.setText("");
		        t3.setText("");
		        t4.setText("");
		        t5.setText("");
		        t6.setText("");
		        t7.setText("");
		        t8.setText("");
	          }
		    
		  }	catch(Exception e){     
					//Handle errors for Class.forName
					  e.printStackTrace();
				  }
			finally{
					//finally block used to close resources
							try{
									if(st!=null)
												st.close();
								}catch(SQLException se2)
								{// nothing we can do
									}
							try{
								if(cn!=null)
									cn.close();
							    }
							catch(SQLException se)
								{
									se.printStackTrace();
							    }//end finally try
						}//end finally

  	      }
	public static void main(String a[])
	{
		LibrarianForm f3 =new LibrarianForm();
	}
}
