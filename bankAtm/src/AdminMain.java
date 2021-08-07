import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
public class AdminMain extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Connect();
		AdminMain frame = new AdminMain();
		frame.setVisible(true);
	}

	

	/**
	 * connect the data
	 */
	
	static Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
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
	
	public void table_load() {
		try {
			pst = con.prepareStatement("select * from users");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public AdminMain() {
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
		leftPanel.setBounds(0, 0, 539, 574);
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
		
		JScrollPane usersData = new JScrollPane();
		usersData.setBounds(20, 54, 491, 351);
		leftPanel.add(usersData);
		table = new JTable();
		table_load();
		usersData.setViewportView(table);
		

		//	right Panel ************************************************
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.RED);
		rightPanel.setBounds(537, 0, 278, 574);
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);
		
		Button backB = new Button("back");
		backB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main backSwitch = new Main();
				backSwitch.setVisible(true);
				dispose();
			}
		});
		backB.setFont(new Font("Dialog", Font.BOLD, 16));
		backB.setBounds(10, 495, 247, 57);
		rightPanel.add(backB);
	}
}
