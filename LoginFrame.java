import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.event.JOptionPane;


import java.awt.Color;

// sql connection
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


//
import java.util.Random;

public class LoginFrame implements ActionListener
{
	
	
	// static block
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
			
			if(conn != null)
			{
				System.out.println("Connection Established....");
				
			}
			else
			{
				System.out.println("Connection Not Established....");
				
			}
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println(cnfe);
			cnfe.printStackTrace();
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle);
			sqle.printStackTrace();
		}
		
	}
	
	// data base connection reference variable
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	static Random r = null;
	
	
	

	public static JFrame frame = null;
	private JTextField text_username = null;
	private JTextField text_password = null;
	private JButton button_login = null;
	private JButton button_cancel= null;
	private JLabel label_bottom = null;
	
	// second frame welcome frame menu reference variable
		JButton  button_create_new_customer = null;
		JButton button_deposit = null;
		JButton  button_withdraw = null;
		JButton  button_display_details = null;
		JButton button_about = null;
		JButton button_loan = null;
		JFrame frame1 = null;
	
	
	// Second frame reference variables
	JFrame frame2 = null;
	JLabel label_customer_details = null;
	JLabel label_customer_bottom_info = null;
	
	// buttons
	JButton button_customer_save = null;
	JButton button_customer_cancel = null;
	
	
	// label left side
	JLabel label_customer_name = null;
	JLabel label_customer_email_id = null;
	JLabel label_customer_dob = null;
	JLabel label_customer_pan_number = null;
	JLabel label_customer_adhar_number = null;
	JLabel label_customer_age = null;
	
	// text left side
	JTextField text_customer_name = null;
	JTextField text_customer_email_id = null;
	JTextField text_customer_dob = null;
	JTextField text_customer_pan_number = null;
	JTextField text_customer_adhar_number = null;
	JTextField text_customer_age = null;
	
	
	// label right side
	JLabel label_customer_mobile_no = null;
	JLabel label_customer_gender = null;
	JLabel label_customer_temporary_address = null;
	JLabel label_customer_permanent_address = null;
	
	// text right side
	JTextField text_customer_mobile_no = null;
	JTextField text_customer_gender = null;
	JTextArea text_customer_temporary_address = null;
	JTextArea text_customer_permanent_address = null;
	
	
	// 3 rd frame
	JFrame frame3 = null;
	
	// labels
	JLabel label_basic_details = null;
	JLabel label_account_open_date = null;
	JLabel label_initial_ammount = null;
	
	// text
	JTextField text_account_open_date = null;
	JTextField text_initial_ammount= null;
	
	// buttons
	JButton button_save = null;
	
	
	// Login Frame Constructor
	LoginFrame()
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(20, 20);
		frame.setTitle("Bank DeskTop Application");
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLayout(null);
		
		initializeComponent();  // user define function to intialize frame component
	}
	
	void initializeComponent()
	{
		EmptyBorder border = new EmptyBorder(5, 20, 10, 10);
		
		
		JLabel label_admin = new JLabel(" ADMIN LOGIN ");
		label_admin.setBounds(750, 9, 300, 300);
		label_admin.setSize(600, 600);
		label_admin.setFont(new java.awt.Font("Times New Roman", 1, 55));
		label_admin.setBorder(border);
		frame.add(label_admin);
		
		JLabel label_title = new JLabel(" Bank Desktop Application ");
		label_title.setBounds(700, 110, 300, 300);
		label_title.setSize(570, 570);
		label_title.setFont(new java.awt.Font("Times New Roman", 1, 45));
		label_title.setBorder(border);
		frame.add(label_title);
	
		
		
		
		JLabel label_username = new JLabel("UserName  ");
		label_username.setBounds(780, 400, 190, 150);
		label_username.setFont(new java.awt.Font("Times New Roman", 1, 34));
		frame.add(label_username);
		
		JLabel label_password = new JLabel("Password   ");
		label_password.setBounds(780, 454, 188, 150);
		label_password.setFont(new java.awt.Font("Times New Roman", 1, 34));
		frame.add(label_password);
		
		/*
		ImageIcon img = new ImageIcon("D:/project/bank_management_system/img/banking3.jpg");
		JLabel background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(2, 0, 1500, 700);
		frame.add(background);
		*/
		
		text_username = new JTextField();
		text_username.setBounds(978, 468, 150, 25);
		frame.add(text_username);
		
		text_password = new JTextField();
		text_password.setBounds(978, 518, 150, 25);
		frame.add(text_password);
		
		button_login = new JButton(" LOGIN ");
		button_login.setBounds(830, 600, 100, 40);
		button_login.setFont(new java.awt.Font("Times New Roman", 0, 15));
		button_login.addActionListener(this);
		frame.add(button_login);
		
		
		button_cancel = new JButton(" CANCEL ");
		button_cancel.setBounds(1000, 600, 110, 40);
		button_cancel.setFont(new java.awt.Font("Times New Roman", 0, 15));
		button_cancel.addActionListener(this);
		frame.add(button_cancel);
		
		
		//© State Bank of India [ APM ID: L&A_Info_344 ]. All Right Reserved
		
		JLabel label_bottom = new JLabel(" © Bank of India [ APM ID: L&A_Info_344 ]. All Right Reserved ");
		label_bottom.setBounds(690, 730, 300, 300);
		label_bottom.setSize(570, 570);
		label_bottom.setFont(new java.awt.Font("Times New Roman", 1, 20));
		frame.add(label_bottom);
	}
	
	// Login page actions
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == button_login)
		{
			String username = text_username.getText();
			String password = text_password.getText();
			System.out.println(username +"  "+password);
			
			try
			{
				verifyLoginIdAndPassword(username, password);
			}
			catch(Exception e)
			{
				System.out.println("Exception on Login Id and Password");
			}
		}
		
		else if(ae.getSource() == button_create_new_customer)
		{
			createNewCustomer();
		}
		
		else if(ae.getSource() == button_cancel)
		{
			text_username.setText("");
			text_password.setText("");
		}
		
		else if(ae.getSource() == button_customer_save)
		{
			insert_new_customer_data();
			
		}
		else if(ae.getSource() == button_customer_cancel)
		{
			
			text_customer_name.setText("");
			text_customer_email_id.setText("");
			text_customer_dob.setText("");
			text_customer_pan_number.setText("");
			text_customer_adhar_number.setText("");
			text_customer_age.setText("");
			text_customer_mobile_no.setText("");
			text_customer_gender.setText("");
			text_customer_temporary_address.setText("");
			text_customer_permanent_address.setText("");
			
			JOptionPane.showMessageDialog(frame2, "Data Cleared ...!!");	
			
		}
		else if(ae.getSource() == button_save)
		{
			insertBankDetails();
		}
		else
		{
			System.out.println("failed.....Failed.........");

		}
	}
	
	void verifyLoginIdAndPassword(String username, String password)
	{
		
		String query1 = "select count(*) from bank.login where username = ? and password = ?";
	
		try
		{
			pst = conn.prepareStatement(query1);
			
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			int row = rs.getInt(1);
			
			if(row > 0)
			{
				System.out.println("Login Successfully.....");
				
				JOptionPane.showMessageDialog(frame, "Login SuccessFully...");	
				newFrame();
				
			}
			else
			{
				System.out.println("Login Failed Invalid Details.....");
	
				JOptionPane.showMessageDialog(frame, "Login Failed...");
			}
		}
		catch(Exception e)
		{
			System.out.println("Login Block Exception " + e);
		}
	
		//finally block
		finally
		{	
			try
			{
				pst.close();
			}
			catch(SQLException npe)
			{
				System.out.println("NULL POinter : " + npe);
				npe.printStackTrace();
			}
			/*
			try
			{
				conn.close();
			}
			catch(SQLException npe)
			{
				System.out.println("NULL POinter : " + npe);
				npe.printStackTrace();
			}
			*/
		}
	}
	
	void newFrame()
	{
		
			frame1 = new JFrame();
			frame1.setVisible(true);
			frame1.setSize(550, 550);
		//	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setLocation(20, 20);
			frame1.setTitle("MENU FRAME");
			frame1.getContentPane().setBackground(Color.PINK);
			frame1.setLayout(null);
			

			
			JLabel label_customer = new JLabel(" .. WELCOME TO BANK .. ");
			label_customer.setBounds(800, 0, 200, 200);
			label_customer.setSize(500, 400);
			label_customer.setFont(new java.awt.Font("Times New Roman", 1, 35));
			frame1.add(label_customer);
			
			button_create_new_customer = new JButton(" CREATE NEW CUTOMER ");
			button_create_new_customer.setBounds(600, 300, 230, 75);
			button_create_new_customer.addActionListener(this);
			button_create_new_customer.setFont(new java.awt.Font("Times New Roman", 0, 16));
			frame1.add(button_create_new_customer);
			
			
			button_deposit = new JButton(" DEPOSIT ");
			button_deposit.setBounds(900, 300, 230, 75);
			//button_login.addActionListener(this);
			button_deposit.setFont(new java.awt.Font("Times New Roman", 0, 16));
			frame1.add(button_deposit);
			
			button_withdraw = new JButton(" WITHDRAW ");
			button_withdraw.setBounds(1200, 300, 230, 76);
			//button_login.addActionListener(this);
			button_withdraw.setFont(new java.awt.Font("Times New Roman", 0, 16));
			frame1.add(button_withdraw);
			
			
			button_display_details = new JButton(" DISPLAY DETAIL ");
			button_display_details.setBounds(600, 430, 230, 75);
			//button_login.addActionListener(this);
			button_display_details.setFont(new java.awt.Font("Times New Roman", 0, 16));
			frame1.add(button_display_details);
			
			button_loan = new JButton(" LOAN ");
			button_loan.setBounds(900, 430, 230, 75);
			//button_login.addActionListener(this);
			button_loan.setFont(new java.awt.Font("Times New Roman", 0, 16));
			frame1.add(button_loan);
			
			button_about = new JButton(" ABOUT ");
			button_about.setBounds(1200, 430, 230, 75);
			//button_login.addActionListener(this);
			button_about.setFont(new java.awt.Font("Times New Roman", 0, 16));
			frame1.add(button_about);
	
		JLabel label_bottom = new JLabel(" © Bank of India [ APM ID: L&A_Info_344 ]. All Right Reserved ");
		label_bottom.setBounds(690, 730, 300, 300);
		label_bottom.setSize(570, 570);
		label_bottom.setFont(new java.awt.Font("Times New Roman", 1, 20));
		frame1.add(label_bottom);
	}
	
	void createNewCustomer()
	{
		frame2 = new JFrame();
		
		
			frame2.setVisible(true);
			frame2.setSize(1000, 1000);
			//frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setLocation(10, 10);
			frame2.setTitle("CUSTOMER Frame");
			frame2.getContentPane().setBackground(Color.ORANGE);
			frame2.setLayout(null);
			
			label_customer_details = new JLabel(" FILL CUSTOMER DETAILS ");
			label_customer_details.setBounds(100, 1, 750, 140);
			//label_customer.setSize(100, 100);
			label_customer_details.setFont(new java.awt.Font("Times New Roman", 1, 55));
			frame2.add(label_customer_details);
			
			// left side
			label_customer_name = new JLabel(" NAME : ");
			label_customer_name.setBounds(400, 220, 200, 40);
			label_customer_name.setFont(new java.awt.Font("Times New Roman", 1, 26));
			frame2.add(label_customer_name);
			
			text_customer_name = new JTextField();
			text_customer_name.setBounds(550, 225, 260, 33);
			frame2.add(text_customer_name);
			
		
			label_customer_email_id = new JLabel(" EMAIL-ID : ");
			label_customer_email_id.setBounds(352, 275, 200, 40);
			label_customer_email_id.setFont(new java.awt.Font("Times New Roman", 1, 26));
			frame2.add(label_customer_email_id);
			
			text_customer_email_id = new JTextField();
			text_customer_email_id.setBounds(550, 279, 260, 33);
			frame2.add(text_customer_email_id);
		
			
			label_customer_dob = new JLabel(" DATE OF BIRTH : ");
			label_customer_dob.setBounds(271, 335, 240, 40);
			label_customer_dob.setFont(new java.awt.Font("Times New Roman", 1, 26));
			frame2.add(label_customer_dob);
			
			text_customer_dob = new JTextField();
			text_customer_dob.setBounds(550, 340, 260, 33);
			frame2.add(text_customer_dob);
			
			label_customer_pan_number = new JLabel(" PAN CARD NUMBER : ");
			label_customer_pan_number.setBounds(213, 395, 300, 40);
			label_customer_pan_number.setFont(new java.awt.Font("Times New Roman", 1, 26));
			frame2.add(label_customer_pan_number);
			
			text_customer_pan_number = new JTextField();
			text_customer_pan_number.setBounds(550, 399, 260, 33);
			frame2.add(text_customer_pan_number);
			
			label_customer_adhar_number = new JLabel(" AADHAR CARD NUMBER : ");
			label_customer_adhar_number.setBounds(151, 450, 360, 40);
			label_customer_adhar_number.setFont(new java.awt.Font("Times New Roman", 1, 26));
			frame2.add(label_customer_adhar_number);
			
			text_customer_adhar_number = new JTextField();
			text_customer_adhar_number.setBounds(550, 453, 260, 33);
			frame2.add(text_customer_adhar_number);
		
			label_customer_age = new JLabel(" AGE : ");
			label_customer_age.setBounds(413, 505, 360, 40);
			label_customer_age.setFont(new java.awt.Font("Times New Roman", 1, 26));
			frame2.add(label_customer_age);
			
			text_customer_age = new JTextField();
			text_customer_age.setBounds(550, 509, 260, 33);
			frame2.add(text_customer_age);
		
		
		
		
		
		
		
			// right side
			label_customer_mobile_no = new JLabel(" MOBILE NUMBER : ");
			label_customer_mobile_no.setBounds(1000, 220, 600, 40);
			label_customer_mobile_no.setFont(new java.awt.Font("Times New Roman", 1, 26));
			frame2.add(label_customer_mobile_no);
			
			text_customer_mobile_no = new JTextField();
			text_customer_mobile_no.setBounds(1300, 225, 260, 33);
			frame2.add(text_customer_mobile_no);
		
		
		    label_customer_gender = new JLabel(" GENDER : ");
			label_customer_gender.setBounds(1120, 280, 600, 40);
			label_customer_gender.setFont(new java.awt.Font("Times New Roman", 1, 26));
			frame2.add(label_customer_gender);
			
			text_customer_gender = new JTextField();
			text_customer_gender.setBounds(1300, 284, 260, 33);
			frame2.add(text_customer_gender);
			
			label_customer_temporary_address = new JLabel(" TEMPORARY ADDRESS : ");
			label_customer_temporary_address.setBounds(933, 364, 600, 40);
			label_customer_temporary_address.setFont(new java.awt.Font("Times New Roman", 1, 26));
			frame2.add(label_customer_temporary_address);
			
			text_customer_temporary_address = new JTextArea();
			text_customer_temporary_address.setBounds(1300, 368, 260, 80);
			frame2.add(text_customer_temporary_address);
			
			label_customer_permanent_address = new JLabel(" PERMANENT ADDRESS : ");
			label_customer_permanent_address.setBounds(933, 474, 600, 40);
			label_customer_permanent_address.setFont(new java.awt.Font("Times New Roman", 1, 26));
			frame2.add(label_customer_permanent_address);
			
			text_customer_permanent_address = new JTextArea();
			text_customer_permanent_address.setBounds(1300, 478, 260, 80);
			frame2.add(text_customer_permanent_address);
	
			
			// buttons
			
		button_customer_save = new JButton(" SAVE ");
		button_customer_save.setBounds(780, 700, 120, 50);
		button_customer_save.setFont(new java.awt.Font("Times New Roman", 1, 18));
		button_customer_save.addActionListener(this);
		frame2.add(button_customer_save);
		
		
		button_customer_cancel = new JButton(" CANCEL ");
		button_customer_cancel.setBounds(1010, 700, 120, 50);
		button_customer_cancel.setFont(new java.awt.Font("Times New Roman", 1, 18));
		button_customer_cancel.addActionListener(this);
		frame2.add(button_customer_cancel);
		
		
		
		
			label_customer_bottom_info = new JLabel(" I hereby declare that the information provided is true and correct.");
			label_customer_bottom_info.setBounds(1400, 950, 750, 140);
			label_customer_bottom_info.setFont(new java.awt.Font("Times New Roman", 0, 19));
			frame2.add(label_customer_bottom_info);
			
	}
	
	void insert_new_customer_data()
	{
		NewCustomer newcustdata = new NewCustomer();	
		
		newcustdata.setcustomer_name(text_customer_name.getText());
		newcustdata.setcustomer_email_id(text_customer_email_id.getText());
		newcustdata.setcustomer_date_of_birth(text_customer_dob.getText());
		newcustdata.setcustomer_pan_card_number(text_customer_pan_number.getText());
		newcustdata.setcustomer_aadhar_card_number(text_customer_adhar_number.getText());
		newcustdata.setcustomer_age(text_customer_age.getText());
		newcustdata.setcustomer_mobile_number(text_customer_mobile_no.getText());
		newcustdata.setcustomer_gender(text_customer_gender.getText());
		newcustdata.setcustomer_temporary_address(text_customer_temporary_address.getText());
		newcustdata.setcustomer_permanent_address(text_customer_permanent_address.getText());
		
		// customer data insert into database
		
		String query =  "insert into bank.new_customer(cust_name, cust_email_id, cust_dob, cust_pan_card_number, cust_aadhar_card_number, cust_age, cust_mobile_number, cust_gender, cust_temp_address, cust_permanent_address) values(?,?,?,?,?,?,?,?,?,?)";

		try
		{
			pst = conn.prepareStatement(query);
			
			pst.setString(1, newcustdata.getcustomer_name());
			pst.setString(2, newcustdata.getcustomer_email_id());
			pst.setString(4, newcustdata.getcustomer_pan_card_number());
			pst.setString(5, newcustdata.getcustomer_aadhar_card_number());
			pst.setString(6, newcustdata.getcustomer_age());
			pst.setString(7, newcustdata.getcustomer_mobile_number());
			pst.setString(8, newcustdata.getcustomer_gender());
			pst.setString(9, newcustdata.getcustomer_temporary_address());
			pst.setString(10, newcustdata.getcustomer_permanent_address());
			
			// date
			
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
			
			java.util.Date ud = sdf.parse(newcustdata.getcustomer_date_of_birth());
			
			long l = ud.getTime();
			
			java.sql.Date sd = new java.sql.Date(l);
			
			pst.setDate(3, sd);
			
			
			int row1 = pst.executeUpdate();
		
			if(row1 > 0)
			{
					JOptionPane.showMessageDialog(frame2, "Data Save INTO DATABASE....");
					basicDetailform();
			}
			else
			{
				JOptionPane.showMessageDialog(frame2, "Data NOT Save INTO DATABASE....");
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("New Customer Insert the Data but generate Exception " + e);
		}
		
		
		finally
		{
			try
			{
				pst.close();
			}
			catch(SQLException npe)
			{
				System.out.println("Null Pointer of pst" + npe);
				npe.printStackTrace();
				
			}
			
		}
		
		
		// Execute After Store Data into database
		text_customer_name.setText("");
		text_customer_email_id.setText("");
		text_customer_dob.setText("");
		text_customer_pan_number.setText("");
		text_customer_adhar_number.setText("");
		text_customer_age.setText("");
		text_customer_mobile_no.setText("");
		text_customer_gender.setText("");
		text_customer_temporary_address.setText("");
		text_customer_permanent_address.setText("");
		
		
			/*
				System.out.println(newcustdata.getcustomer_name());
				System.out.println(newcustdata.getcustomer_email_id());
				System.out.println(newcustdata.getcustomer_date_of_birth());
				System.out.println(newcustdata.getcustomer_pan_card_number());
				System.out.println(newcustdata.getcustomer_aadhar_card_number());
				System.out.println(newcustdata.getcustomer_age());
				System.out.println(newcustdata.getcustomer_mobile_number());
				System.out.println(newcustdata.getcustomer_gender());
				System.out.println(newcustdata.getcustomer_temporary_address());
				System.out.println(newcustdata.getcustomer_permanent_address());
			*/
		
		
	}
	
	void insertBankDetails()
	{
		System.out.println("Number of Records :");
		String query2 = "select count(*) from new_customer";
		String query3 = "insert into bank.customer_bank(cust_number, cif_number, account_number, account_open_date, ifsc_code, balance_amt) values (?,?,?,?,?,?)";
		
		try
		{
			
			pst = conn.prepareStatement(query2);
			rs = pst.executeQuery();
			rs.next();
			
			int count_cust_number = rs.getInt(1);
			count_cust_number = count_cust_number + 1;
			
			//System.out.println("TOTAL : " + count_cust_number);
		
			Random r = new Random();
			int cif_number = r.nextInt();
			
			int account_number = r.nextInt();
		
		
		
		
			pst = conn.prepareStatement(query3);
			
			pst.setInt(1, count_cust_number);
			pst.setInt(2, cif_number);
			pst.setInt(3, account_number);
			pst.setString(5, "BOINO9022");
			
			// calling method
			
			
			//pst.setDate(4,"2018-09-01");
			//pst.setInt(6, 500);
			/*
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
			
			java.util.Date ud = sdf.parse("11-11-2001");
			
			long l = ud.getTime();
			
			java.sql.Date sd = new java.sql.Date(l);
			
			pst.setDate(4, sd);
			
			
			int row2 = pst.executeUpdate();
			
			if(row2 > 0)
			{
				System.out.println("DATA Stored....");
			}
			*/
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		finally
		{
			try
			{
				rs.close();
			}
			catch(SQLException npe)
			{
				System.out.println("Null Pointer of pst" + npe);
				npe.printStackTrace();
				
			}
			
			try
			{
				pst.close();
			}
			catch(SQLException npe)
			{
				System.out.println("Null Pointer of pst" + npe);
				npe.printStackTrace();
				
			}
			
		}
		
		JOptionPane.showMessageDialog(frame3, "ACCOUNt Created succesfully....");
		
	}
	
	void basicDetailform()
	{
			frame3 = new JFrame();
					frame3.setVisible(true);
					frame3.setSize(550, 550);
					//frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame3.setLocation(20, 20);
					frame3.setTitle("BASIC DETAILS");
					frame3.getContentPane().setBackground(Color.RED);
					frame3.setLayout(null);
					
					
					label_basic_details = new JLabel(" FILL BASIC DETAILS ");
					label_basic_details.setBounds(100, 1, 750, 140);
					//label_customer.setSize(100, 100);
					label_basic_details.setFont(new java.awt.Font("Times New Roman", 1, 55));
					frame3.add(label_basic_details);
					
					// left side
					label_account_open_date = new JLabel(" A/C Opening Date : ");
					label_account_open_date.setBounds(715, 220, 500, 45);
					label_account_open_date.setFont(new java.awt.Font("Times New Roman", 1, 26));
					frame3.add(label_account_open_date);
					
					text_account_open_date = new JTextField();
					text_account_open_date.setBounds(705, 270, 260, 33);
					frame3.add(text_account_open_date);
					
				
					label_initial_ammount = new JLabel(" Initial Amount : ");
					label_initial_ammount.setBounds(1100, 220, 200, 40);
					label_initial_ammount.setFont(new java.awt.Font("Times New Roman", 1, 26));
					frame3.add(label_initial_ammount);
					
					text_initial_ammount = new JTextField();
					text_initial_ammount.setBounds(1080, 270, 260, 33);
					frame3.add(text_initial_ammount);
					
			button_save = new JButton(" SAVE ");
			button_save.setBounds(900, 380, 230, 75);
			button_save.addActionListener(this);
			button_save.setFont(new java.awt.Font("Times New Roman", 0, 16));
			frame3.add(button_save);
	}
	
}// end of class