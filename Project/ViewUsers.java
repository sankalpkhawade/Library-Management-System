package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class ViewUsers extends JFrame implements ActionListener,ItemListener
{

	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/sk";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "123456";
	
	   JButton b,b1;
	   CheckboxGroup cg; 
	   Checkbox cb[]=new Checkbox[30];
	   JLabel l[]=new JLabel[30];

	   int m;
    
	   public ViewUsers()
	   {
		   setLayout(null);
	    	setSize(1950,1500);
	    	setVisible(true);
			Connection conn = null;
			Statement stmt = null;
			b=new JButton("Get Details");
			b1=new JButton("Back");
			b=new JButton("Get Details");
			b.setSize(200,60);
			b1.setSize(200,60);
			b.setFont(new Font("Tahoma", Font.PLAIN, 15));
			b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    add(b);
		    add(b1);
		    b.setBounds(50,100,200,30);
		    b1.setBounds(270,100,100,30);
		    b.addActionListener(this);
		    b1.addActionListener(this);
		    b.setSize(200,60);
		    b1.setSize(200,60);
		    //check filed are properly entered of not
		    try
		    {
		  
			  Class.forName("com.mysql.jdbc.Driver");// Register JDBC driver
			  conn = DriverManager.getConnection(DB_URL,USER,PASS);// Open a connection
	            Statement st=conn.createStatement();
	
			  stmt=conn.createStatement();
			  String Lname,Lpass;
			  int n=0	;
			  m=n;
			  ResultSet check1=stmt.executeQuery("select count(*) from user ;");
			  while(check1.next()){
			  		n =check1.getInt(1);
				  }
			  	  System.out.println("NO of user = "+n);
				    
			  	  int i=1,s=200;
			  	  cg=new CheckboxGroup();
		
			  	  ResultSet check=stmt.executeQuery("select * from user order by name;");
			  	  		while(check.next())
			  	  		{
			  	  			String	nam=(check.getString(1)); 
			  	  			System.out.println("NO of user = "+nam);
		
			  	  			cb[i]=new Checkbox("", cg, true);
			  	  			l[i]  =new JLabel(nam);
			  	  			add(cb[i]);
			  	  			add(l[i]);
				  	  					
				  	  					cb[i].setBounds(50,s,10,30);
				  	  				    l[i].setBounds(70,s,400,30);
				  	  					s=s+30;
				  	  					cb[i].addItemListener(this);
				  	                    i++;
				  	  					}
				}
		  	 	catch(Exception e){
   					  e.printStackTrace();
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
							catch(SQLException se)
							{
								se.printStackTrace();
						    }//end finally try
					}//end finally
	   		}
	   
	   	public void actionPerformed(ActionEvent ae)
	   	{
	    
	       if(ae.getSource()==b)
	       {

	    	   for(int j=1;j<100;j++)
	    	   {
	    		   if(cb[j].getState()==true)
	    		   { 
	    			   String s=l[j].getText();
	    			 
	    			   	new GetDetail("","","","","");
	  	  			 
	  	  			    setVisible(false); 
	    		   }
	    	   }
	    	}
	       	if(ae.getSource()==b1)
	        {
	       		LibrarianSuccess l=new LibrarianSuccess();
	        	setVisible(false);
	        }  
	       	repaint();
	   	}
	   	public static void main(String args[])
	   	{
	   		ViewUsers vu= new ViewUsers();
	   	}

	   	@Override
	   	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	   	}
}
