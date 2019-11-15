import java.lang.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsDevice.WindowTranslucency;

class MyDefaultMetalTheme extends DefaultMetalTheme {
	public ColorUIResource getWindowTitleInactiveBackground() {
	  return new ColorUIResource(new Color(46,125,50));
	}
  
	public ColorUIResource getWindowTitleBackground() {
	  return new ColorUIResource(new Color(46,125,50));
	}
  
	public ColorUIResource getPrimaryControlHighlight() {
	  return new ColorUIResource(new Color(46,125,50));
	}
  
	public ColorUIResource getPrimaryControlDarkShadow() {
	  return new ColorUIResource(new Color(46,125,50));
	}
  
	public ColorUIResource getPrimaryControl() {
	  return new ColorUIResource(new Color(46,125,50));
	}
  
	public ColorUIResource getControlHighlight() {
	  return new ColorUIResource(new Color(46,125,50));
	}
  
	public ColorUIResource getControlDarkShadow() {
	  return new ColorUIResource(new Color(46,125,50));
	}
  
	public ColorUIResource getControl() {
	  return new ColorUIResource(new Color(46,125,50));
	}
  }

public class Login extends JFrame implements ActionListener
{
	JLabel title, userLabel, passLabel,signUpLabel,imgLabel,badgLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn,signUpBtn;
	JPanel panel,trans;
	ImageIcon icon,badge;
	String userId,name,phone,address,role;
	double salary;
	
	public Login()
	{
		super("Library Management system - Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon = new ImageIcon("icon.PNG");
		this.setIconImage(icon.getImage());
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

		MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme());
		try{
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		ImageIcon slider =new ImageIcon("slider.JPG");
		imgLabel = new JLabel(slider);
		trans =new JPanel();
		trans.setBounds(0, 0, 200, 450);
		trans.setBackground(new Color(97,97,97));
		this.add(trans);

		trans.add(imgLabel);

		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(200, 0, 700, 450);


		panel.setBackground(new Color(33,33,33));

		Font f1=new Font("Monospaced",Font.BOLD,20);
		Font f2=new Font("Monospaced",Font.ITALIC,15);
		
		title = new JLabel("Welcome to Library");
		title.setBounds(280, 50, 450, 40);
		title.setForeground(new Color(46,125,50));
		title.setFont(f1);
		panel.add(title);

		badge=new ImageIcon("library.PNG");
		badgLabel=new JLabel(badge);
		badgLabel.setBounds(520,80,200,200);
		panel.add(badgLabel);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 60, 30);
		userLabel.setForeground(new Color(46,125,50));
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 70, 30);
		passLabel.setForeground(new Color(46,125,50));
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		panel.add(passPF);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.setBackground(new Color(41,182,246));
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 200, 80, 30);
		exitBtn.setBackground(new Color(244,67,54));
		exitBtn.addActionListener(this);
		panel.add(exitBtn);

		signUpLabel=new JLabel("Have no account ?");
		signUpLabel.setBounds(300, 250, 200, 30);
		signUpLabel.setForeground(new Color(46,125,50));
		signUpLabel.setFont(f2);
		panel.add(signUpLabel);

		signUpBtn=new JButton("SIGN UP");
		signUpBtn.setBounds(350, 300, 80, 30);
		signUpBtn.setBackground(new Color(46,125,50));
		signUpBtn.addActionListener(this);
		panel.add(signUpBtn);
		
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
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(loginBtn.getText()))
		{
			checkLogin();
		}
		else if(text.equals(signUpBtn.getText()))
		{
			SignUp su=new SignUp();
			su.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else{}
	}
	
	public void checkLogin()
	{
		String query = "SELECT `userId`, `password`, `status` FROM `login`;";     
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
			while(rs.next())
			{
                String usrId = rs.getString("userId");
                String password = rs.getString("password");
				int status = rs.getInt("status");
				
				if(usrId.equals(userTF.getText()) && password.equals(passPF.getText()))
				{
					flag=true;
					if(status==0)
					{
							String loadId=usrId;
							String query1 = "SELECT `userId`, `employeeName`, `phoneNumber`,`role`,`salary` FROM `Employee` WHERE `userId`='"+loadId+"';";     
							Connection con1=null;//for connection
							Statement st1 = null;//for query1 execution
							ResultSet rs1 = null;//to get row by row result from DB
							System.out.println(query1);
							try
							{
								Class.forName("com.mysql.jdbc.Driver");//load driver
								System.out.println("driver loaded");
								con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
								System.out.println("connection done");//connection with database established
								st1 = con1.createStatement();//create statement
								System.out.println("statement created");
								rs1 = st1.executeQuery(query1);//getting result
								System.out.println("results received");
								
								boolean flag1 = false;			
								while(rs1.next())
								{
									userId = rs1.getString("userId");
									name = rs1.getString("employeeName");
									phone = rs1.getString("phoneNumber");
									role = rs1.getString("role");
									salary=rs1.getDouble("salary");
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
									if(rs1!=null)
										rs1.close();

									if(st1!=null)
										st1.close();

									if(con1!=null)
										con1.close();
								}
								catch(Exception ex){}
							}
							if(role.equals("Manager"))
							{
								EmployeeHome nh=new EmployeeHome(userId, name, phone, role, salary,1);
								nh.setVisible(true);
								this.setVisible(false);
							}
							else{
							EmployeeHome eh = new EmployeeHome(userId,name,role,phone,salary);
							eh.setVisible(true);
							this.setVisible(false);
							}
					}
					else if(status==1)
					{
						String loadId=usrId;
							String query1 = "SELECT `userId`, `customerNamer`, `phoneNumber`, `address` FROM `Customer` WHERE `userId`='"+loadId+"';";     
							Connection con1=null;//for connection
							Statement st1 = null;//for query1 execution
							ResultSet rs1 = null;//to get row by row result from DB
							System.out.println(query1);
							try
							{
								Class.forName("com.mysql.jdbc.Driver");//load driver
								System.out.println("driver loaded");
								con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
								System.out.println("connection done");//connection with database established
								st1 = con1.createStatement();//create statement
								System.out.println("statement created");
								rs1 = st1.executeQuery(query1);//getting result
								System.out.println("results received");
								
								boolean flag1 = false;			
								while(rs1.next())
								{
									userId = rs1.getString("userId");
									name = rs1.getString("customerNamer");
									phone = rs1.getString("phoneNumber");
									address = rs1.getString("address");
									
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
									if(rs1!=null)
										rs1.close();

									if(st1!=null)
										st1.close();

									if(con1!=null)
										con1.close();
								}
								catch(Exception ex){}
							}
						CustomerHome ch = new CustomerHome(userId,name,phone,address);
						ch.setVisible(true);
						this.setVisible(false);
					}
					else{}
				}
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
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