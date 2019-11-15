import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.io.IOException;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsDevice.WindowTranslucency;


public class ViewCustomer extends JFrame implements ActionListener,MouseListener
{
	JLabel userLabel,cUserIdLabel, eNameLabel, phoneLabel, addressLabel;
	JTextField userTF, phoneTF1, phoneTF2, eNameTF, addressTF;
	JButton refreshBtn,searchBtn, loadBtn, updateBtn, delBtn, backBtn,prevBtn, logoutBtn;
    JPanel panel,trans;
    ImageIcon icon,back;
	double salary;
	String userId,name,phone,address,role;
	
	public ViewCustomer(String userId,String name,String role,String phone,double salary)
	{
		super("Library Management System - View Customer");
		
		this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        icon = new ImageIcon("icon.PNG");
		this.setIconImage(icon.getImage());
		this.userId = userId;
		this.name=name;
		this.role=role;
		this.phone=phone;
		this.salary=salary;
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

		
		
		panel = new JPanel();
		panel.setLayout(null);

		panel.setBackground(new Color(33,33,33));
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(250, 100, 275, 30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(250, 150, 120, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(400, 150, 120, 30);
		panel.add(userTF);
		
		searchBtn = new JButton("Load");
		searchBtn.setBounds(550, 150, 150, 30);
		searchBtn.addActionListener(this);
		panel.add(searchBtn);
		
		eNameLabel = new JLabel("Customer Name : ");
		eNameLabel.setBounds(250, 200, 120, 30);
		panel.add(eNameLabel);
		
		eNameTF = new JTextField();
		eNameTF.setBounds(400, 200, 120, 30);
		panel.add(eNameTF);
		
		phoneLabel = new JLabel("Phone No. : ");
		phoneLabel.setBounds(250, 250, 120, 30);
		panel.add(phoneLabel);
		
		phoneTF1 = new JTextField();
		phoneTF1.setBounds(400, 250, 35, 30);
		phoneTF1.setEnabled(false);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField();
		phoneTF2.setBounds(435, 250, 85, 30);
		panel.add(phoneTF2);
		
		addressLabel = new JLabel("address : ");
		addressLabel.setBounds(250, 300, 120, 30);
		panel.add(addressLabel);
		
		addressTF = new JTextField();
		addressTF.setBounds(400, 300, 120, 30);
		panel.add(addressTF);
		
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(200, 400, 120, 30);
		updateBtn.setEnabled(false);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		delBtn = new JButton("Delete");
		delBtn.setBounds(350, 400, 120, 30);
		delBtn.setEnabled(false);
		delBtn.addActionListener(this);
		panel.add(delBtn);
		
		back=new ImageIcon("left-arrow.PNG");
		prevBtn = new JButton(back);
		prevBtn.setBounds(0, 400, 200, 30);
		prevBtn.addActionListener(this);
		trans.add(prevBtn);
		
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
	}

	public ViewCustomer(String userId,String name,String phone,String address)
	{
		super("Library Management System - View Employee");
		
		this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        icon = new ImageIcon("icon.PNG");
		this.setIconImage(icon.getImage());
		this.userId = userId;
		this.name=name;
		this.phone=phone;
		this.address=address;
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		trans =new JPanel();
		trans.setBounds(0, 0, 200, 500);
		trans.setBackground(new Color(38,50,56));
		trans.setLayout(null);
		Font f1=new Font("Monospaced", Font.TRUETYPE_FONT, 20);
		JLabel title=new JLabel("Logged in as :");
		title.setBounds(10,50,200,50);
		title.setForeground(new Color(46,125,50));
		title.setFont(f1);
		trans.add(title);

		cUserIdLabel=new JLabel(""+userId);
		cUserIdLabel.setBounds(10, 100, 200, 50);
		cUserIdLabel.setForeground(new Color(46,125,50));
		cUserIdLabel.setFont(f1);
		trans.add(cUserIdLabel);

		
		back=new ImageIcon("left-arrow.PNG");
        backBtn=new JButton(back);
		backBtn.setBounds(10,10,40,40);
		backBtn.setBackground(null);
		backBtn.setBorder(null);
        backBtn.addActionListener(this);
		trans.add(backBtn);

		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(0, 380, 200, 30);
		logoutBtn.addActionListener(this);
		trans.add(logoutBtn);

		this.add(trans);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(200, 0, 700, 500);

		panel.setBackground(new Color(33,33,33));
		
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(250, 150, 120, 30);
		userLabel.setForeground(new Color(46,125,50));
		panel.add(userLabel);
		
		userTF = new JTextField(userId);
		userTF.setBounds(400, 150, 120, 30);
		panel.add(userTF);

		loadFromDB();
		
		eNameLabel = new JLabel("Employee Name : ");
		eNameLabel.setBounds(250, 200, 120, 30);
		eNameLabel.setForeground(new Color(46,125,50));
		panel.add(eNameLabel);
		
		eNameTF = new JTextField();
		eNameTF.setBounds(400, 200, 120, 30);
		panel.add(eNameTF);
		
		phoneLabel = new JLabel("Phone No. : ");
		phoneLabel.setBounds(250, 250, 120, 30);
		phoneLabel.setForeground(new Color(46,125,50));
		panel.add(phoneLabel);
		
		phoneTF1 = new JTextField();
		phoneTF1.setBounds(400, 250, 35, 30);
		phoneTF1.setEnabled(false);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField();
		phoneTF2.setBounds(435, 250, 85, 30);
		panel.add(phoneTF2);
		
		addressLabel = new JLabel("address : ");
		addressLabel.setBounds(250, 300, 120, 30);
		addressLabel.setForeground(new Color(46,125,50));
		panel.add(addressLabel);
		
		addressTF = new JTextField();
		addressTF.setBounds(400, 300, 120, 30);
		panel.add(addressTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(550, 150, 150, 30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);

		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(250, 100, 275, 30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(250, 400, 120, 30);
		updateBtn.setEnabled(false);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		delBtn = new JButton("Delete");
		delBtn.setBounds(400, 400, 120, 30);
		delBtn.setEnabled(false);
		delBtn.addActionListener(this);
		panel.add(delBtn);
		
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
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(loadBtn))
		{
			loadFromDB();			
		}
		else if(e.getSource().equals(backBtn))
		{
			CustomerHome me = new CustomerHome(userId,name,phone,address);
			me.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource().equals(searchBtn))
		{
			loadFromDB0();			
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(prevBtn))
		{
			EmployeeHome eh=new EmployeeHome(userId, name, phone, role, salary);
			eh.setVisible(true);
			this.setVisible(false);
		}
	}
	public void mouseReleased(MouseEvent e) {}
	public void actionPerformed(ActionEvent ae) throws NullPointerException
	{
		String text = ae.getActionCommand();
		
		if(text.equals(refreshBtn.getText()))
		{
			updateBtn.setEnabled(false);
			delBtn.setEnabled(false);
			userTF.setEnabled(true);
			userTF.setText("");
			eNameTF.setText("");
			phoneTF1.setText("");
			phoneTF2.setText("");
			addressTF.setText("");
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		
		
		else if(text.equals(updateBtn.getText()))
		{
			updateInDB();
		}
		else if(text.equals(delBtn.getText()))
		{
			deleteFromDB();
		}
		
		else{}
	}
	
	public void loadFromDB()
	{
		String loadId = userId;
		String query = "SELECT `customerNamer`, `phoneNumber`, `address` FROM `customer` WHERE `userId`='"+loadId+"';";     
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
			String eName = null;
			String phnNo = null;
			String address = null;
			double salary = 0.0;			
			while(rs.next())
			{
                eName = rs.getString("customerNamer");
				phnNo = rs.getString("phoneNumber");
				address = rs.getString("address");
				flag=true;
				
				eNameTF.setText(eName);
				phoneTF1.setText("+880");
				phoneTF2.setText(phnNo.substring(4,14));
				addressTF.setText(address);
				userTF.setEnabled(false);
				updateBtn.setEnabled(true);
				delBtn.setEnabled(true);
			}
			if(!flag)
			{
				eNameTF.setText("");
				phoneTF1.setText("");
				phoneTF2.setText("");
				addressTF.setText("");
				JOptionPane.showMessageDialog(this,"Invalid ID"); 
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

	public void loadFromDB0()
	{
		String loadId = userTF.getText();
		String query = "SELECT `customerNamer`, `phoneNumber`, `address` FROM `customer` WHERE `userId`='"+loadId+"';";     
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
			String eName = null;
			String phnNo = null;
			String address = null;
			double salary = 0.0;			
			while(rs.next())
			{
                eName = rs.getString("customerNamer");
				phnNo = rs.getString("phoneNumber");
				address = rs.getString("address");
				flag=true;
				
				eNameTF.setText(eName);
				phoneTF1.setText("+880");
				phoneTF2.setText(phnNo.substring(4,14));
				addressTF.setText(address);
				userTF.setEnabled(false);
				updateBtn.setEnabled(true);
				delBtn.setEnabled(true);
			}
			if(!flag)
			{
				eNameTF.setText("");
				phoneTF1.setText("");
				phoneTF2.setText("");
				addressTF.setText("");
				JOptionPane.showMessageDialog(this,"Invalid ID"); 
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
		String newId = userTF.getText();
		String eName = eNameTF.getText();
		String phnNo = phoneTF1.getText()+phoneTF2.getText();
		String address = addressTF.getText();
		
		String query = "UPDATE customer SET customerNamer='"+eName+"', phoneNumber = '"+phnNo+"', address = '"+address+"' WHERE userId='"+newId+"'";	
        Connection con=null;//for connection
        Statement st = null;//for query execution
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			st = con.createStatement();//create statement
			st.executeUpdate(query);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			
			updateBtn.setEnabled(false);
			delBtn.setEnabled(false);
			userTF.setEnabled(true);
			userTF.setText("");
			eNameTF.setText("");
			phoneTF1.setText("");
			phoneTF2.setText("");
			addressTF.setText("");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
		}
	}
	
	public void deleteFromDB()
	{
		String newId = userTF.getText();
		String query1 = "DELETE from customer WHERE userId='"+newId+"';";
		String query2 = "DELETE from login WHERE userId='"+newId+"';";
		System.out.println(query1);
		System.out.println(query2);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.execute(query2);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			
			updateBtn.setEnabled(false);
			delBtn.setEnabled(false);
			userTF.setEnabled(true);
			userTF.setText("");
			eNameTF.setText("");
			phoneTF1.setText("");
			phoneTF2.setText("");
			addressTF.setText("");
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}
	
}