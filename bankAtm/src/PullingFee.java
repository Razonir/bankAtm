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
public class PullingFee extends JFrame {

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
	public PullingFee(String ID,String pullNumber) {
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
				Pulling back = new Pulling(ID,pullNumber);
				back.show();
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(547, 495, 247, 57);
		leftPanel.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(173, 54, 450, 405);
		leftPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pulling");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(29, 21, 189, 61);
		panel.add(lblNewLabel);
		
		JLabel pullVal = new JLabel("123456789");
		pullVal.setForeground(Color.RED);
		pullVal.setFont(new Font("Tahoma", Font.BOLD, 53));
		pullVal.setBounds(39, 93, 400, 91);
		pullVal.setText(pullNumber);
		panel.add(pullVal);
		
		JLabel lblNewLabel_2 = new JLabel("$");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 46));
		lblNewLabel_2.setBounds(10, 137, 46, 47);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("For this action your account will be charged a 1$ fee");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(20, 195, 419, 33);
		panel.add(lblNewLabel_3);
		
		String query ="SELECT * FROM users where id="+ID.toString();
		Statement st;
		String amount="null";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				amount = rs.getString("amount");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int fixAmount=(Integer.parseInt(amount))-(Integer.parseInt(pullNumber))-1;
		String newAmount=String.valueOf(fixAmount);
		
		JButton btnNewButton = new JButton("Confirmation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pst = con.prepareStatement("update users set amount=? where id=?");
					pst.setString(1, newAmount);
					pst.setString(2, ID);
					pst.executeUpdate();					
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Pulled successfully");
				Home home = new Home(ID);
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(10, 325, 429, 69);
		panel.add(btnNewButton);
		
	}
}