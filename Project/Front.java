package Project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Front extends JFrame implements ActionListener
{
  JButton b1,b2;
  JLabel l1,l;
  Front()
  { 
	setLayout(null);
    setSize(1950,1500);
    setVisible(true);
    setLayout(new BorderLayout());
    ImageIcon aa=new ImageIcon("marketing-books.jpg");
    l=new JLabel(aa);
    l1= new JLabel("Front Page");
    l1.setFont(new Font("Arial", Font.ITALIC, 40));
	l1.setForeground(Color.ORANGE);
    b1=new JButton("Librarianogin");
    b2=new JButton("User Login");
    add(l);
    l.add(l1);
    l.add(b1);
    l.add(b2);
    b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
    b1.addActionListener(this);
    b2.addActionListener(this);
    l1.setBounds(900,300,100,50);
    b1.setBounds(900,400,150,30);
    b2.setBounds(900,500,150,30);
    l1.setSize(200,60);
    b1.setSize(200,60);
    b2.setSize(200,60);
  }
  public void actionPerformed(ActionEvent ae)
  {
      if(ae.getSource()==b1)
      {
        LibrarianLogin b=new LibrarianLogin();
        setVisible(false);
      }
  if(ae.getSource()==b2)
  {
      UserLogin u=new UserLogin();
      setVisible(false);
  }
    
  }
  public static void main(String args[])
  {
    Front f=new Front();
  }
  }
