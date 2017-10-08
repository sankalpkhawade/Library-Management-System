package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

class DeleteUser extends JFrame implements ActionListener {
	
	JLabel l1,l2,x;
	JTextField t1;
	JButton b1,b2;
	
	DeleteUser()
	{
		setLayout(null);
	    setSize(1950,1500);
	    setVisible(true);
	    setTitle("Delete User");
	    l1= new JLabel("DeleteUser");
	    l1.setFont(new Font("Arial", Font.ITALIC, 30));
		l1.setForeground(Color.GRAY);
		l2= new JLabel("UserName");
	    l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l2.setForeground(Color.GRAY);
		t1=new JTextField(40);
	    b1=new JButton("Delete");
	    b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    b2=new JButton("Back");
	    b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    add(l1);
	    add(l2);
	    add(t1);
	    add(b1);
	    add(b2);
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    l1.setBounds(900,100,100,50);
	    b1.setBounds(900,400,150,30);
	    b2.setBounds(50,50,150,30);
	    l2.setBounds(800,300,200,40);
	    t1.setBounds(900,300,200,40);
	    l1.setSize(200,60);
	    b1.setSize(200,60);
	    b2.setSize(200,60);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		String t=t1.getText();
		Connection cn = null;
		Statement st = null;
		PreparedStatement pst;
		if(ae.getSource()==b1)
	    {
			try
			  {
				Class.forName("com.mysql.jdbc.Driver");
		         cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/sk","root","123456");
		         st=cn.createStatement();
		        
				
			      if(ae.getSource()==b1)
		          {
		          
			        pst=cn.prepareStatement("delete from user where name='"+t+"';");
			        
			        pst.execute();
	                JOptionPane.showMessageDialog(null,"User Deleted");
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
	    
	  if(ae.getSource()==b2)
	  {
		  new LibrarianSuccess();
		  setVisible(false);
	  }
	}
	public static void main(String args[]){
		DeleteUser d=new DeleteUser();
	}
}