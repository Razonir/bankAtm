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
public class Welcome extends JFrame {

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
	public Welcome(String ID) {
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
		
		JButton ContinueB = new JButton("Continue");
		ContinueB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home(ID);
				home.setVisible(true);
				dispose();
			}
		});
		ContinueB.setBackground(Color.RED);
		ContinueB.setForeground(Color.WHITE);
		ContinueB.setFont(new Font("Tahoma", Font.PLAIN, 60));
		ContinueB.setBounds(0, 363, 815, 211);
		leftPanel.add(ContinueB);
		
		JLabel welcomeText = new JLabel("Welcome");
		welcomeText.setFont(new Font("Tahoma", Font.BOLD, 45));
		welcomeText.setBounds(134, 98, 518, 52);
		leftPanel.add(welcomeText);
		
		String query ="SELECT * FROM users where id="+ID.toString();
		Statement st;
		String firstName="null",lastName="null";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel userNameText = new JLabel();
		userNameText.setText(firstName+" "+lastName);
		userNameText.setFont(new Font("Tahoma", Font.BOLD, 54));
		userNameText.setBounds(182, 163, 518, 52);
		leftPanel.add(userNameText);
	}
}