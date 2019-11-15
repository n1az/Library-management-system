import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsDevice.WindowTranslucency;

public class EmployeeHome extends JFrame implements ActionListener
{
	JLabel roleLabel,salaryLabel,bookSearchLabel,bookNameLabel,bookIdLabel,authorLabel,pubDateLabel,quantityLabel,cUserIdLabel, cNameLabel, cAddressLabel, cPhonelabel;
	JButton addEmpBtn,updateBtn,mngEmpBtn,changePasswordBtn,refreshBtn, logoutBtn,backBtn,customerBtn,searchBtn,addBtn,minusBtn,plusBtn,removeBtn,updateBook;
	JPanel panel,trans;
	String userId,name,phone,address,role;
	double salary;
	ImageIcon icon,back;
	JTextField bNameTF,bIdTF,authorTF,pubYrTF,quanTF;
	
	public EmployeeHome(String userId,String name,String phone,String role,double salary,int a)
	{
		super("Library Management System - Manager Home Window");
		
		this.userId = userId;
		this.name=name;
		this.phone=phone;
		this.role=role;
		this.salary=salary;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon = new ImageIcon("icon.PNG");
		this.setIconImage(icon.getImage());
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		
		trans =new JPanel();
		trans.setBounds(0, 0, 200, 600);
		trans.setBackground(new Color(38,50,56));
		trans.setLayout(null);
		Font f1=new Font("Monospaced", Font.TRUETYPE_FONT, 20);
		JLabel title=new JLabel("Logged in as :");
		title.setBounds(10,50,200,50);
		title.setForeground(new Color(46,125,50));
		//title.setFont(f1);
		trans.add(title);

		cUserIdLabel=new JLabel(""+userId);
		cUserIdLabel.setBounds(10, 80, 200, 30);
		cUserIdLabel.setForeground(new Color(46,125,50));
		//cUserIdLabel.setFont(f1);
		trans.add(cUserIdLabel);

		cNameLabel=new JLabel(""+name);
		cNameLabel.setBounds(10, 110, 200, 30);
		cNameLabel.setForeground(new Color(46,125,50));
		trans.add(cNameLabel);

		roleLabel=new JLabel(""+role);
		roleLabel.setBounds(10, 150, 200, 30);
		roleLabel.setForeground(new Color(46,125,50));
		trans.add(roleLabel);

		salaryLabel=new JLabel(""+salary);
		salaryLabel.setBounds(10, 200, 200, 30);
		salaryLabel.setForeground(new Color(46,125,50));
		trans.add(salaryLabel);


		cPhonelabel=new JLabel(""+phone);
		cPhonelabel.setBounds(10, 250, 200, 30);
		cPhonelabel.setForeground(new Color(46,125,50));
		trans.add(cPhonelabel);

		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(0, 400, 200, 30);
		changePasswordBtn.addActionListener(this);
		trans.add(changePasswordBtn);

		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(0, 500, 200, 30);
		logoutBtn.addActionListener(this);
		trans.add(logoutBtn);

		updateBtn=new JButton("Update");
		updateBtn.setBounds(0, 350, 200, 30);
		updateBtn.addActionListener(this);
		trans.add(updateBtn);
		
		back=new ImageIcon("left-arrow.PNG");
        backBtn=new JButton(back);
		backBtn.setBounds(10,10,40,40);
		backBtn.setBackground(null);
		backBtn.setBorder(null);
        backBtn.addActionListener(this);
		trans.add(backBtn);

		

		mngEmpBtn=new JButton("Manage Employee");
		mngEmpBtn.setBounds(0,300,200,30);
		mngEmpBtn.addActionListener(this);
		trans.add(mngEmpBtn);
		
		customerBtn=new JButton("View Customer");
		customerBtn.setBounds(0,450,200,30);
		customerBtn.addActionListener(this);
		trans.add(customerBtn);

        this.add(trans);
        panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(200, 0, 700, 600);
		panel.setBackground(new Color(33,33,33));
		
		bookSearchLabel=new JLabel("Books Search");
		bookSearchLabel.setBounds(210, 20, 200, 30);
		bookSearchLabel.setForeground(new Color(46,125,50));
		bookSearchLabel.setFont(f1);
		panel.add(bookSearchLabel);

		addEmpBtn=new JButton("Add Employee");
		addEmpBtn.setBounds(0,530,200,30);
		addEmpBtn.addActionListener(this);
		trans.add(addEmpBtn);

		bookNameLabel=new JLabel("Book name :");
		bookNameLabel.setBounds(210, 100, 100, 30);
		bookNameLabel.setForeground(new Color(46,125,50));
		panel.add(bookNameLabel);

		bookIdLabel=new JLabel("Book id :");
		bookIdLabel.setBounds(210, 150, 100, 30);
		bookIdLabel.setForeground(new Color(46,125,50));
		panel.add(bookIdLabel);

		authorLabel=new JLabel("Book author :");
		authorLabel.setBounds(210, 200, 100, 30);
		authorLabel.setForeground(new Color(46,125,50));
		panel.add(authorLabel);

		pubDateLabel=new JLabel("Publication Year :");
		pubDateLabel.setBounds(210, 250, 150, 30);
		pubDateLabel.setForeground(new Color(46,125,50));
		panel.add(pubDateLabel);

		quantityLabel=new JLabel("Quantity :");
		quantityLabel.setBounds(210, 300, 100, 30);
		quantityLabel.setForeground(new Color(46,125,50));
		panel.add(quantityLabel);

		bNameTF=new JTextField();
		bNameTF.setBounds(400,100,100,30);
		panel.add(bNameTF);

		bIdTF=new JTextField();
		bIdTF.setBounds(400,150,100,30);
		panel.add(bIdTF);

		authorTF=new JTextField();
		authorTF.setBounds(400,200,100,30);
		panel.add(authorTF);

		pubYrTF=new JTextField();
		pubYrTF.setBounds(400,250,100,30);
		panel.add(pubYrTF);

		quanTF=new JTextField();
		quanTF.setBounds(400,300,100,30);
		panel.add(quanTF);

		searchBtn=new JButton("search");
		searchBtn.setBounds(550,100,100,30);
		searchBtn.addActionListener(this);
		panel.add(searchBtn);

		refreshBtn=new JButton("Refresh");
		refreshBtn.setBounds(550,50,100,30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);

		addBtn=new JButton("ADD");
		addBtn.setBounds(550,150,100,30);
		addBtn.addActionListener(this);
		panel.add(addBtn);

		minusBtn=new JButton("-");
		minusBtn.setBounds(400,350,60,30);
		minusBtn.setFont(f1);
		minusBtn.addActionListener(this);
		panel.add(minusBtn);

		plusBtn=new JButton("+");
		plusBtn.setBounds(300,350,60,30);
		plusBtn.setFont(f1);
		plusBtn.addActionListener(this);
		panel.add(plusBtn);

		removeBtn=new JButton("REMOVE");
		removeBtn.setBounds(550,200,100,30);
		removeBtn.addActionListener(this);
		panel.add(removeBtn);
		
		updateBook=new JButton("UPDATE");
		updateBook.setBounds(550,250,100,30);
		updateBook.addActionListener(this);
		panel.add(updateBook);

		this.setResizable(false);
		this.add(panel);
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
	}
	public EmployeeHome(String userId,String name,String phone,String role,double salary)
	{
		super("Library Management System - Employee Home Window");
		
		this.userId = userId;
		this.name=name;
		this.phone=phone;
		this.role=role;
		this.salary=salary;
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon = new ImageIcon("icon.PNG");
		this.setIconImage(icon.getImage());
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		
		trans =new JPanel();
		trans.setBounds(0, 0, 200, 550);
		trans.setBackground(new Color(38,50,56));
		trans.setLayout(null);
		Font f1=new Font("Monospaced", Font.TRUETYPE_FONT, 20);
		JLabel title=new JLabel("Logged in as :");
		title.setBounds(10,50,200,50);
		title.setForeground(new Color(46,125,50));
		//title.setFont(f1);
		trans.add(title);

		cUserIdLabel=new JLabel(""+userId);
		cUserIdLabel.setBounds(10, 80, 200, 30);
		cUserIdLabel.setForeground(new Color(46,125,50));
		//cUserIdLabel.setFont(f1);
		trans.add(cUserIdLabel);

		cNameLabel=new JLabel(""+name);
		cNameLabel.setBounds(10, 110, 200, 30);
		cNameLabel.setForeground(new Color(46,125,50));
		trans.add(cNameLabel);

		roleLabel=new JLabel(""+role);
		roleLabel.setBounds(10, 150, 200, 30);
		roleLabel.setForeground(new Color(46,125,50));
		trans.add(roleLabel);

		salaryLabel=new JLabel(""+salary);
		salaryLabel.setBounds(10, 200, 200, 30);
		salaryLabel.setForeground(new Color(46,125,50));
		trans.add(salaryLabel);

		cPhonelabel=new JLabel(""+phone);
		cPhonelabel.setBounds(10, 250, 200, 30);
		cPhonelabel.setForeground(new Color(46,125,50));
		trans.add(cPhonelabel);

		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(0, 400, 200, 30);
		changePasswordBtn.addActionListener(this);
		trans.add(changePasswordBtn);

		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(0, 500, 200, 30);
		logoutBtn.addActionListener(this);
		trans.add(logoutBtn);

		updateBtn=new JButton("Update");
		updateBtn.setBounds(0, 350, 200, 30);
		updateBtn.addActionListener(this);
		trans.add(updateBtn);
		
		back=new ImageIcon("left-arrow.PNG");
        backBtn=new JButton(back);
		backBtn.setBounds(10,10,40,40);
		backBtn.setBackground(null);
		backBtn.setBorder(null);
        backBtn.addActionListener(this);
		trans.add(backBtn);
		
		customerBtn=new JButton("View Customer");
		customerBtn.setBounds(0,450,200,30);
		customerBtn.addActionListener(this);
		trans.add(customerBtn);

        this.add(trans);
        panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(200, 0, 700, 550);
		panel.setBackground(new Color(33,33,33));
		
		bookSearchLabel=new JLabel("Books Search");
		bookSearchLabel.setBounds(210, 20, 200, 30);
		bookSearchLabel.setForeground(new Color(46,125,50));
		bookSearchLabel.setFont(f1);
		panel.add(bookSearchLabel);

		bookNameLabel=new JLabel("Book name :");
		bookNameLabel.setBounds(210, 100, 100, 30);
		bookNameLabel.setForeground(new Color(46,125,50));
		panel.add(bookNameLabel);

		bookIdLabel=new JLabel("Book id :");
		bookIdLabel.setBounds(210, 150, 100, 30);
		bookIdLabel.setForeground(new Color(46,125,50));
		panel.add(bookIdLabel);

		authorLabel=new JLabel("Book author :");
		authorLabel.setBounds(210, 200, 100, 30);
		authorLabel.setForeground(new Color(46,125,50));
		panel.add(authorLabel);

		pubDateLabel=new JLabel("Publication Year :");
		pubDateLabel.setBounds(210, 250, 150, 30);
		pubDateLabel.setForeground(new Color(46,125,50));
		panel.add(pubDateLabel);

		quantityLabel=new JLabel("Quantity :");
		quantityLabel.setBounds(210, 300, 100, 30);
		quantityLabel.setForeground(new Color(46,125,50));
		panel.add(quantityLabel);

		bNameTF=new JTextField();
		bNameTF.setBounds(400,100,100,30);
		panel.add(bNameTF);

		bIdTF=new JTextField();
		bIdTF.setBounds(400,150,100,30);
		panel.add(bIdTF);

		authorTF=new JTextField();
		authorTF.setBounds(400,200,100,30);
		panel.add(authorTF);

		pubYrTF=new JTextField();
		pubYrTF.setBounds(400,250,100,30);
		panel.add(pubYrTF);

		quanTF=new JTextField();
		quanTF.setBounds(400,300,100,30);
		panel.add(quanTF);

		searchBtn=new JButton("search");
		searchBtn.setBounds(550,100,100,30);
		searchBtn.addActionListener(this);
		panel.add(searchBtn);

		refreshBtn=new JButton("Refresh");
		refreshBtn.setBounds(550,50,100,30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);

		addBtn=new JButton("ADD");
		addBtn.setBounds(550,150,100,30);
		addBtn.addActionListener(this);
		panel.add(addBtn);

		minusBtn=new JButton("-");
		minusBtn.setBounds(400,350,60,30);
		minusBtn.setFont(f1);
		minusBtn.addActionListener(this);
		panel.add(minusBtn);

		plusBtn=new JButton("+");
		plusBtn.setBounds(300,350,60,30);
		plusBtn.setFont(f1);
		plusBtn.addActionListener(this);
		panel.add(plusBtn);

		removeBtn=new JButton("REMOVE");
		removeBtn.setBounds(550,200,100,30);
		removeBtn.addActionListener(this);
		panel.add(removeBtn);
		
		updateBook=new JButton("UPDATE");
		updateBook.setBounds(550,250,100,30);
		updateBook.addActionListener(this);
		panel.add(updateBook);

		this.setResizable(false);
		this.add(panel);
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
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		if(str.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(str.equals(backBtn.getText()))
		{
            Login lg=new Login();
            lg.setVisible(true);
            this.setVisible(false);
		}
		else if(str.equals(updateBtn.getText()))
		{
            ViewEmployee vc=new ViewEmployee(userId,name,phone,role,salary);
            vc.setVisible(true);
            this.setVisible(false);
		}
		else if(str.equals(changePasswordBtn.getText()))
		{
			ChangePassword cp=new ChangePassword(userId);
			cp.setVisible(true);
			this.setVisible(false);
		}
		
		else if(str.equals(addBtn.getText()))
		{
			addBook();
		}
		else if(str.equals(removeBtn.getText()))
		{
			removeBook();
		}
		else if(str.equals(plusBtn.getText()))
		{
			plusBook();
		}
		else if(str.equals(minusBtn.getText()))
		{
			minusBook();
		}
		else if(str.equals(updateBook.getText()))
		{
			updateBook();
		}
		else if(str.equals(refreshBtn.getText()))
		{
			bNameTF.setText("");
			bIdTF.setText("");
			authorTF.setText("");
			pubYrTF.setText("");
			quanTF.setText("");
		}
		else if(str.equals(searchBtn.getText()))
		{
			loadFromDB();
		}
		else if(str.equals(mngEmpBtn.getText()))
		{
			ManageEmployee vm=new ManageEmployee(userId, name, phone, role, salary);
			vm.setVisible(true);
			this.setVisible(false);
		}
		else if(str.equals(addEmpBtn.getText()))
		{
			AddEmployee vm=new AddEmployee(userId, name, phone, role, salary);
			vm.setVisible(true);
			this.setVisible(false);
		}
		else if(str.equals(customerBtn.getText()))
		{
			ViewCustomer b=new ViewCustomer(userId, name, role, phone, salary);
			b.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	public void updateBook()
    {
        String newId=bIdTF.getText();
		String newName=bNameTF.getText();
		String auth=authorTF.getText();
		String pub=pubYrTF.getText();
		String quant=quanTF.getText();
        String query = "UPDATE book SET bookId='"+newId+"',bookTitle='"+newName+"',authorName='"+auth+"',publicationYear='"+pub+"',availableQuantity='"+quant+"' WHERE bookId='"+newId+"';";
        //String query1 = "DELETE from book WHERE bookId='"+bookId+"';";	
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
            //st.execute(query1);
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
	public void addBook()
    {
		String newId=bIdTF.getText();
		String newName=bNameTF.getText();
		String auth=authorTF.getText();
		String pub=pubYrTF.getText();
		String quant=quanTF.getText();
        String query = "INSERT INTO book VALUES ('"+newId+"','"+newName+"','"+auth+"','"+pub+"','"+quant+"');";
        //String query1 = "DELETE from book WHERE bookId='"+bookId+"';";	
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
            //st.execute(query1);
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
	public void removeBook()
    {
        String bookId = bIdTF.getText();
        String query = "DELETE from borrowInfo WHERE bookId='"+bookId+"';";
        String query1 = "DELETE from book WHERE bookId='"+bookId+"';";	
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
	public void minusBook()
    {
        String bookId = bIdTF.getText();
        int avlQuantity = Integer.parseInt(quanTF.getText());
        avlQuantity--;       
                
	           // System.out.println(dateFormat.format(date));
        try
        {
            avlQuantity = Integer.parseInt(quanTF.getText());
            avlQuantity--;
        }
        catch(Exception e){}
        String query = "UPDATE book SET availableQuantity = "+avlQuantity+" WHERE bookId='"+bookId+"'";
        //String query1 = "DELETE from borrowInfo WHERE userId='"+userId+"' && bookId='"+bookId+"';";	
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
            //st.execute(query1);
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
	public void plusBook()
    {
        String bookId = bIdTF.getText();
        int avlQuantity = Integer.parseInt(quanTF.getText());
        avlQuantity++;       
                
	           // System.out.println(dateFormat.format(date));
        try
        {
            avlQuantity = Integer.parseInt(quanTF.getText());
            avlQuantity++;
        }
        catch(Exception e){}
        String query = "UPDATE book SET availableQuantity = "+avlQuantity+" WHERE bookId='"+bookId+"'";
        //String query1 = "DELETE from borrowInfo WHERE userId='"+userId+"' && bookId='"+bookId+"';";	
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
            //st.execute(query1);
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
	public void loadFromDB()
	{
		String loadId = bNameTF.getText();
		String query = "SELECT `bookId`, `authorName`, `publicationYear`, `availableQuantity` FROM `book` WHERE `bookTitle`='"+loadId+"';";     
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
			String bkId = null;
			String auth = null;
			String pubdate = null;
			String quant = null;			
			while(rs.next())
			{
                bkId = rs.getString("bookId");
				auth = rs.getString("authorName");
				pubdate = rs.getString("publicationYear");
				quant = rs.getString("availableQuantity");
				flag=true;
				
				bIdTF.setText(bkId);
				//phoneTF1.setText("+880");
				//phoneTF2.setText(phnNo.substring(4,14));
				authorTF.setText(auth);
				pubYrTF.setText(pubdate);
				quanTF.setText(quant);
				//updateBtn.setEnabled(true);
				//delBtn.setEnabled(true);
			}
			if(!flag)
			{
				bIdTF.setText("");
				authorTF.setText("");
				pubYrTF.setText("");
				quanTF.setText("");
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
}