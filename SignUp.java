import java.lang.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsDevice.WindowTranslucency;

public class SignUp extends JFrame implements ActionListener{
    JLabel id,passLabel,phone,address,name;
    JTextField idTF,passTF,phnTF,phoneTF1,addTF,nameTF;
    JButton signUpBtn,genBtn,backBtn;
    ImageIcon icon,back;
    JPanel panel,trans;

    SignUp()
    {
        super("Sign-Up");
        this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon = new ImageIcon("icon.PNG");
		this.setIconImage(icon.getImage());
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        
        trans =new JPanel();
		trans.setBounds(0, 0, 200, 450);
        trans.setBackground(new Color(97,97,97));
		
		back=new ImageIcon("left-arrow.PNG");
        backBtn=new JButton(back);
		backBtn.setBounds(0,0,30,30);
		backBtn.setBackground(null);
		backBtn.setBorder(null);
        backBtn.addActionListener(this);
        trans.add(backBtn);

        this.add(trans);
        panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(200, 0, 700, 450);
        panel.setBackground(new Color(33,33,33));

        id=new JLabel("user id :");
        id.setBounds(250,100,100,30);
        id.setForeground(new Color(46,125,50));
        panel.add(id);

        passLabel=new JLabel("password :");
        passLabel.setBounds(250,150,100,30);
        passLabel.setForeground(new Color(46,125,50));
        panel.add(passLabel);

        phone=new JLabel("phone :");
        phone.setBounds(250,200,100,30);
        phone.setForeground(new Color(46,125,50));
        panel.add(phone);

        address=new JLabel("address :");
        address.setBounds(250,250,100,30);
        address.setForeground(new Color(46,125,50));
        panel.add(address);

        name=new JLabel("Name :");
        name.setBounds(250,300,100,30);
        name.setForeground(new Color(46,125,50));
        panel.add(name);


        idTF=new JTextField();
        idTF.setBounds(360,100,100,30);
        panel.add(idTF);

        passTF=new JTextField();
		passTF.setBounds(360,150,100,30);
		passTF.setEnabled(false);
        panel.add(passTF);
        
        phnTF=new JTextField();
        phnTF.setBounds(400,200,100,30);
        panel.add(phnTF);

        phoneTF1 = new JTextField("+880");
		phoneTF1.setBounds(360, 200, 40, 30);
		phoneTF1.setEnabled(false);
		phoneTF1.setForeground(Color.BLACK);
		panel.add(phoneTF1);

        addTF=new JTextField();
        addTF.setBounds(360,250,100,30);
        panel.add(addTF);

        nameTF=new JTextField();
        nameTF.setBounds(360,300,100,30);
        panel.add(nameTF);

        genBtn=new JButton("generate");
        genBtn.setBounds(500,150,100,30);
        genBtn.addActionListener(this);
        panel.add(genBtn);

        signUpBtn=new JButton("SIGN UP");
		signUpBtn.setBounds(360, 350, 80, 30);
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
		
		if(text.equals(genBtn.getText()))
		{
			passTF.setEnabled(true);
			Random r = new Random();
			passTF.setText(r.nextInt(89999999)+10000000+"");
			genBtn.setEnabled(false);
			passTF.setEnabled(false);
		}
		else if(text.equals(signUpBtn.getText()))
		{
			checkId(idTF.getText());
			Login lg=new Login();
            lg.setVisible(true);
            this.setVisible(false);
		}
		else if(text.equals(backBtn.getText()))
		{
            Login lg=new Login();
            lg.setVisible(true);
            this.setVisible(false);
		}
		else{}
    }
    public void checkId(String userId)
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
                //String password = rs.getString("password");
				if(!flag)
				{
					JOptionPane.showMessageDialog(this,"User Id already taken !"); 
				}
				
			}
			if(!rs.next())
			{
				if(idTF.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "you must have an user id !");
				}
				else if(passTF.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "you must have an generated password !");
				}
				else if(phnTF.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "you must have a phone No !");
				}
				else if(addTF.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "you must have an address !");
				}
				else if(nameTF.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "you must have a name !");
				}
				else{
					insertIntoDB();
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
    public void insertIntoDB()
	{
		String newId = idTF.getText();
		String newPass = passTF.getText();
		String eName = nameTF.getText();
		String phnNo = phoneTF1.getText()+phnTF.getText();
		String address = addTF.getText();
		int status = 1;
		
		
		String query1 = "INSERT INTO Customer VALUES ('"+newId+"','"+eName+"','"+ phnNo+"','"+address+"');";
		String query2 = "INSERT INTO Login VALUES ('"+newId+"','"+newPass+"',"+status+");";
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
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
    }
}