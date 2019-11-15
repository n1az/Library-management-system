import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsDevice.WindowTranslucency;


public class Return extends JFrame implements ActionListener
{
    JLabel empLabel,welcomeLabel,cUserIdLabel, cNameLabel, cAddressLabel, cPhonelabel, bookIdLabel,nameLabel; 
    JButton logoutButton, searchButton, returnBtn, backBtn;
    JTextField bookIdTF, nameTF,quantity;
    JPanel panel,trans;
    ImageIcon icon,back,emp;
    String userId,name,phone,address;
    
    public Return(String userId,String name,String phone,String address){
        super("Sample Management System - Borrow Window");
            
        this.setSize(800,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        icon = new ImageIcon("icon.PNG");
		this.setIconImage(icon.getImage());
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        this.userId = userId;
		this.name=name;
		this.phone=phone;
        this.address=address;
        
        trans =new JPanel();
		trans.setBounds(0, 0, 200, 450);
        trans.setBackground(new Color(38,50,56));
        trans.setLayout(null);
		
		back=new ImageIcon("left-arrow.PNG");
        backBtn=new JButton(back);
		backBtn.setBounds(10,10,40,40);
		backBtn.setBackground(null);
		backBtn.setBorder(null);
        backBtn.addActionListener(this);
        trans.add(backBtn);
        Font f1=new Font("Monospaced", Font.TRUETYPE_FONT, 20);

        JLabel title=new JLabel("Logged in as :");
		title.setBounds(10,50,200,30);
        title.setForeground(new Color(46,125,50));
        title.setFont(f1);
		trans.add(title);

		cUserIdLabel=new JLabel(""+userId);
		cUserIdLabel.setBounds(10, 100, 200, 30);
        cUserIdLabel.setForeground(new Color(46,125,50));
        cUserIdLabel.setFont(f1);
		trans.add(cUserIdLabel);

		cNameLabel=new JLabel(""+name);
		cNameLabel.setBounds(10, 150, 200, 30);
		cNameLabel.setForeground(new Color(46,125,50));
		trans.add(cNameLabel);

		cAddressLabel=new JLabel(""+phone);
		cAddressLabel.setBounds(10, 200, 200, 30);
		cAddressLabel.setForeground(new Color(46,125,50));
		trans.add(cAddressLabel);

		cPhonelabel=new JLabel(""+address);
		cPhonelabel.setBounds(10, 250, 200, 30);
		cPhonelabel.setForeground(new Color(46,125,50));
		trans.add(cPhonelabel);

        this.add(trans);
            
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(200, 0, 700, 450);
        panel.setBackground(new Color(33,33,33));
        
        emp=new ImageIcon("writer.PNG");
        empLabel=new JLabel(emp);
        empLabel.setBounds(250, 30, 50, 50);
        panel.add(empLabel);

        welcomeLabel=new JLabel("Please provide the Book Id to Borrow !");
        welcomeLabel.setBounds(310, 40, 300, 40);
        welcomeLabel.setForeground(new Color(46,125,50));
        panel.add(welcomeLabel);

        
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(0, 380, 200, 30);
        logoutButton.addActionListener(this);
        trans.add(logoutButton);
        

        bookIdLabel = new JLabel("Book Id : ");
        bookIdLabel.setBounds(300, 100, 120, 30);
        bookIdLabel.setForeground(new Color(46,125,50));
        panel.add(bookIdLabel);

        nameLabel = new JLabel("Name : ");
        nameLabel.setBounds(300, 200, 120, 30);
        nameLabel.setForeground(new Color(46,125,50));
        panel.add(nameLabel);


        bookIdTF = new JTextField();
        bookIdTF.setBounds(425, 100, 120, 30);
        panel.add(bookIdTF);

        quantity=new JTextField();
        

        searchButton = new JButton("Search");
        searchButton.setBounds(555, 100, 120, 30);
        searchButton.addActionListener(this);
        panel.add(searchButton);


        nameTF = new JTextField();
        nameTF.setBounds(425, 200, 120, 30);
        panel.add(nameTF);

        returnBtn = new JButton("Return");
        returnBtn.setBounds(300, 350, 120, 30);
        returnBtn.addActionListener(this);
        panel.add(returnBtn);
        

        this.add(panel);
        this.setResizable(false);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();

		if(!gd.isWindowTranslucencySupported(WindowTranslucency.TRANSLUCENT))
		{
			System.err.println(
			"Translucency is not supported on your Device");
			System.exit(0);
		}
		JFrame.setDefaultLookAndFeelDecorated(true);

		SwingUtilities.invokeLater(new Runnable(){
		
			@Override
			public void run() {
				//Login lg=new Login();
				setOpacity(0.85f);
				//lg.setVisible(true);
			}
		});



       // public void checkLogin(){
        
    }


    
    

    public void actionPerformed(ActionEvent ae)
	{
        String text = ae.getActionCommand();
        //String usrId = cUserIdLabel.getText();
		
		if(text.equals(backBtn.getText()))
		{
			CustomerHome eh = new CustomerHome(userId,name,phone,address);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutButton.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
        }
        
		else if(text.equals(searchButton.getText()))
		{
			loadFromDB();
		}
		else if(text.equals(returnBtn.getText()))
		{
			updateInDB();
		}
		else{}
    }
    public void loadFromDB()
	{
		String loadId = bookIdTF.getText();
		String query = "SELECT `bookTitle`,`availableQuantity` FROM `book` WHERE `bookId`='"+loadId+"';";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			boolean flag = false;
			String bkName = null;
			//String auth = null;
			//String pubdate = null;
			String quant = null;			
			while(rs.next())
			{
                bkName = rs.getString("bookTitle");
				//auth = rs.getString("authorName");
				//pubdate = rs.getString("publicationYear");
				quant = rs.getString("availableQuantity");
				flag=true;
				
				nameTF.setText(bkName);
				//phoneTF1.setText("+880");
				//phoneTF2.setText(phnNo.substring(4,14));
				//authorTF.setText(auth);
				//pubYrTF.setText(pubdate);
				quantity.setText(quant);
				//updateBtn.setEnabled(true);
				//delBtn.setEnabled(true);
			}
			if(!flag)
			{
				bookIdTF.setText("");
				//authorTF.setText("");
				nameTF.setText("");
				//availabeTF.setText("");
				//salaryTF.setText("");
				JOptionPane.showMessageDialog(this,"Sorry this book is not availabe !"); 
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
    public void updateInDB()
    {
        String bookId = bookIdTF.getText();
        int avlQuantity = Integer.parseInt(quantity.getText());
        avlQuantity++;       
                
	           // System.out.println(dateFormat.format(date));
        try
        {
            avlQuantity = Integer.parseInt(quantity.getText());
            avlQuantity++;
        }
        catch(Exception e){}
        String query = "UPDATE book SET availableQuantity = "+avlQuantity+" WHERE bookId='"+bookId+"'";
        String query1 = "DELETE from borrowInfo WHERE userId='"+userId+"' && bookId='"+bookId+"';";	
        //availabeTF.setText(Integer.toString(avlQuantity));
        //panel.add(availabeTF);
        //this.add(panel);



        Connection con=null;//for connection
        Statement st = null;//for query execution
        System.out.println(query);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");//load driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            st = con.createStatement();//create statement
            st.executeUpdate(query);
            st.execute(query1);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(this, "Success !!!");
                
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Oops !!!");
        }
    }
    

    
    

            
	
}

