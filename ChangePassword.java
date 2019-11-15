import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsDevice.WindowTranslucency;

public class ChangePassword extends JFrame implements ActionListener
{
	JLabel oldPassLabel, newPassLabel,cUserIdLabel;
	JTextField oldPassTF, newPassTF;
	JButton changeBtn, logoutBtn;
	JPanel panel,trans;
	String userId;
	ImageIcon icon;
	
	public ChangePassword(String userId)
	{
		super("Library Management System - Change Password Window");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon = new ImageIcon("icon.PNG");
		this.setIconImage(icon.getImage());
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		Font f1=new Font("Monospaced", Font.TRUETYPE_FONT, 20);
		trans =new JPanel();
		trans.setBounds(0, 0, 200, 500);
		trans.setBackground(new Color(38,50,56));
		trans.setLayout(null);

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

		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(0, 380, 200, 30);
		logoutBtn.addActionListener(this);
		trans.add(logoutBtn);

		this.add(trans);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(200, 0, 700, 500);

		panel.setBackground(new Color(33,33,33));

		oldPassLabel=new JLabel("Old Password");
		oldPassLabel.setBounds(300, 100, 150, 30);
		oldPassLabel.setForeground(new Color(46,125,50));
		//oldPassLabel.addActionListener();
		panel.add(oldPassLabel);

		oldPassTF=new JTextField();
		oldPassTF.setBounds(450, 100, 200, 30);
		//oldPassTF.addActionListener();
		panel.add(oldPassTF);

		newPassLabel=new JLabel("new Password");
		newPassLabel.setBounds(300, 150, 150, 30);
		newPassLabel.setForeground(new Color(46,125,50));
		//newPassLabel.addActionListener();
		panel.add(newPassLabel);

		newPassTF=new JTextField();
		newPassTF.setBounds(450, 150, 200, 30);
		//newPassTF.addActionListener();
		panel.add(newPassTF);

		changeBtn=new JButton("Change");
		changeBtn.setBounds(350, 200, 150, 30);
		changeBtn.addActionListener(this);
		panel.add(changeBtn);
		
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
	public void checkLogin(String userId)
	{
		String loadId=userId;
		String query = "SELECT `password` FROM `login` WHERE `userId`='"+loadId+"';";     
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
                String password = rs.getString("password");
				if(password.equals(oldPassTF.getText()))
				{
					changePassword(userId);
				}
				else if(!flag)
				{
					JOptionPane.showMessageDialog(this,"Invalid Password"); 
				}
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
	public void changePassword(String userId)
	{
		String oldPass= oldPassTF.getText();
		String newPass=newPassTF.getText();
		String query = "UPDATE login SET password='"+newPass+"' WHERE userId='"+userId+"'";	
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
			
			oldPassTF.setEnabled(true);
			oldPassTF.setText("");
			newPassTF.setText("");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
		}
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
		else if(str.equals(changeBtn.getText()))
		{
			checkLogin(userId);
		}
		else{}
	}
}