import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
public class Balance extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the data
	 */
	static Connection con;
	PreparedStatement pst;
	
	public static void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/atm","root","");
		}
		catch (ClassNotFoundException ex) {
			
		}
		catch (SQLException ex) {
			
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public Balance(String ID) {
		Connect();
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 603);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//	left Panel ************************************************

		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.LIGHT_GRAY);
		leftPanel.setBounds(0, 0, 815, 574);
		contentPane.add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel logoicon = new JLabel("");
		ImageIcon imgLogo = new ImageIcon(this.getClass().getResource("/abanklogo.png"));
		logoicon.setIcon(imgLogo);
		logoicon.setBounds(10, 11, 32, 32);
		leftPanel.add(logoicon);
		
		JLabel logoTitle = new JLabel("Razo Bank");
		logoTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		logoTitle.setBounds(52, 11, 391, 32);
		leftPanel.add(logoTitle);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home(ID);
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(547, 495, 247, 57);
		leftPanel.add(btnNewButton_2);
		
		String query ="SELECT * FROM users where id="+ID.toString();
		Statement st;
		String firstName="null",lastName="null",email="null",phone="null",amount="null",password="null";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				email = rs.getString("email");
				phone = rs.getString("phone");
				amount = rs.getString("amount");
				password = rs.getString("password");

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 68, 355, 364);
		leftPanel.add(panel);
		panel.setLayout(null);
		
		JLabel firstNameText = new JLabel("First Name: ");
		firstNameText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		firstNameText.setBounds(10, 62, 109, 51);
		panel.add(firstNameText);
		
				JLabel firstDynamic = new JLabel();
				firstDynamic.setBackground(Color.WHITE);
				firstDynamic.setBounds(121, 62, 237, 51);
				panel.add(firstDynamic);
				firstDynamic.setText(firstName);
				firstDynamic.setFont(new Font("Tahoma", Font.BOLD, 23));
				
				JLabel lastDynamic = new JLabel();
				lastDynamic.setText(lastName);
				lastDynamic.setFont(new Font("Tahoma", Font.BOLD, 23));
				lastDynamic.setBounds(121, 112, 237, 51);
				panel.add(lastDynamic);
				
				JLabel LastNameText = new JLabel("Last name: ");
				LastNameText.setFont(new Font("Tahoma", Font.PLAIN, 20));
				LastNameText.setBounds(10, 113, 109, 51);
				panel.add(LastNameText);
				
				JLabel phoneDynamic = new JLabel();
				phoneDynamic.setText(phone);
				phoneDynamic.setFont(new Font("Tahoma", Font.BOLD, 23));
				phoneDynamic.setBounds(159, 214, 237, 51);
				panel.add(phoneDynamic);
				
				JLabel phoneText = new JLabel("Phone number:");
				phoneText.setFont(new Font("Tahoma", Font.PLAIN, 20));
				phoneText.setBounds(10, 215, 147, 51);
				panel.add(phoneText);
				 
				JLabel emailText = new JLabel("Email:");
				emailText.setFont(new Font("Tahoma", Font.PLAIN, 20));
				emailText.setBounds(10, 164, 56, 51);
				panel.add(emailText);
				
				JLabel emailDynamic = new JLabel();
				emailDynamic.setText(email);
				emailDynamic.setFont(new Font("Tahoma", Font.BOLD, 23));
				emailDynamic.setBounds(73, 163, 237, 51);
				panel.add(emailDynamic);
				
				JLabel PasswordDynamic = new JLabel();
				PasswordDynamic.setText(password);
				PasswordDynamic.setFont(new Font("Tahoma", Font.BOLD, 23));
				PasswordDynamic.setBounds(110, 315, 237, 51);
				panel.add(PasswordDynamic);
				
				JLabel PasswordText = new JLabel("Password: ");
				PasswordText.setFont(new Font("Tahoma", Font.PLAIN, 20));
				PasswordText.setBounds(10, 316, 101, 51);
				panel.add(PasswordText);
				
				JLabel amountText = new JLabel("Amount:");
				amountText.setFont(new Font("Tahoma", Font.PLAIN, 20));
				amountText.setBounds(10, 266, 84, 51);
				panel.add(amountText);
				
				JLabel amountDynamic = new JLabel();
				amountDynamic.setText(amount);
				amountDynamic.setFont(new Font("Tahoma", Font.BOLD, 23));
				amountDynamic.setBounds(89, 265, 237, 51);
				panel.add(amountDynamic);
				
				JLabel idDynamic = new JLabel();
				idDynamic.setText(ID);
				idDynamic.setFont(new Font("Tahoma", Font.BOLD, 23));
				idDynamic.setBounds(110, 10, 237, 51);
				panel.add(idDynamic);
				
				JLabel idText = new JLabel("Acount ID:");
				idText.setFont(new Font("Tahoma", Font.PLAIN, 20));
				idText.setBounds(10, 11, 101, 51);
				panel.add(idText);

	}
}