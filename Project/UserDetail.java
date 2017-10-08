package Project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UserDetail extends JFrame implements ActionListener
{	
	JLabel l1,l2,l3,l4,l5,l6,lt1,lt2,lt3,lt4,lt5;
	JButton b1;
	String username,email,contact,name_of_book,di;
	public UserDetail(String aa,String bb,String cc,String dd,String ee) 
	{
		setLayout(null);
		setSize(1950,1500);
		setVisible(true);
		username=aa;
		l1= new JLabel("View Data");
		l1.setForeground(Color.DARK_GRAY);
		l2= new JLabel("Name :");
		l3= new JLabel("Email :");
		l4= new JLabel("Contact No :");
		l5=new JLabel("Name of Book :");
		l6=new JLabel("Date of issue : ");
        lt1=new JLabel(aa);
        lt2=new JLabel(bb);
        lt3=new JLabel(cc);
        lt4=new JLabel(dd);
        lt5=new JLabel(ee);
		b1= new JButton("BACK");
		l1.setFont(new Font("Tahoma", Font.ITALIC, 30));
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lt1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lt2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lt3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lt4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lt5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(b1);
		add(l1);
		add(l2);
	    add(l3);
		add(l4);
		add(l5);
		add(l6);
        add(lt1);
        add(lt2);
        add(lt3);
        add(lt4);
        add(lt5);
		l1.setBounds(900,100,150,30);
	    l2.setBounds(850,250,150,30);
	    l3.setBounds(850,300,150,30);
	    l4.setBounds(850,350,150,30);
	    l5.setBounds(850,400,150,30);
	    l6.setBounds(850,450,150,30);
	    lt1.setBounds(970,250,150,30);
	    lt2.setBounds(970,300,150,30);
	    lt3.setBounds(970,350,150,30);
	    lt4.setBounds(970,400,150,30);
	    lt5.setBounds(970,450,150,30);
	    b1.setBounds(20,50,100,30);
	    b1.addActionListener(this);
	    l1.setSize(200,60);
	    l2.setSize(200,60);
	    l3.setSize(200,60);
	    l4.setSize(200,60);
	    l5.setSize(200,60);
	    l6.setSize(200,60);
	    lt1.setSize(200,60);
	    lt2.setSize(200,60);
	    lt3.setSize(200,60);
	    lt4.setSize(200,60);
	    lt5.setSize(200,60);
	    b1.setSize(200,60);
	}
	public void actionPerformed(ActionEvent ae) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pst;
		String name = null,pass=null,email1="" ,contact="",name_of_book="",di="";
		if(ae.getSource()==b1)
		{
			new UserLogin();
			setVisible(false);
		}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	        conn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/sk","root","123456");
		  Class.forName("com.mysql.jdbc.Driver");// Register JDBC driver
		  
		  stmt=conn.createStatement();
		  
		}	catch(Exception e){
					JOptionPane.showMessageDialog(null,"Username invalid");

   					  }
    		finally{
   						//finally block used to close resources
   								try{
   										if(stmt!=null)
   													stmt.close();
   									}catch(SQLException se2)
   															{// nothing we can do
   								    						}
   								try{
   									if(conn!=null)
   										conn.close();
   								    }
   								catch(Exception e)
   									{
   										
   									}
    		}
	}
	public static void main(String args[]){
		UserDetail v=new UserDetail("","","","","");
	}
}