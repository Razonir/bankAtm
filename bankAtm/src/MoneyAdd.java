import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
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
public class MoneyAdd extends JFrame {

	private JPanel contentPane;
	public 	int amountOldNum=0;


	/**
	 * Create the data
	 */
	static Connection con;
	PreparedStatement pst;
	private JTextField textField;
	
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
	public MoneyAdd(String ID) {
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
				Home back = new Home(ID);
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
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"1");
			}
		});
		panel.setBackground(Color.WHITE);
		panel.setBounds(84, 214, 107, 65);
		leftPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel.setBounds(10, 11, 87, 43);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"2");
			}
		});
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(201, 214, 107, 65);
		leftPanel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("2");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_1.setBounds(10, 11, 87, 43);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"3");
			}
		});
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(318, 214, 107, 65);
		leftPanel.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("3");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_2.setBounds(10, 11, 87, 43);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"5");
			}
		});
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(201, 284, 107, 65);
		leftPanel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("5");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_1_1.setBounds(10, 11, 87, 43);
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"6");
			}
		});
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(318, 284, 107, 65);
		leftPanel.add(panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("6");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_2_1.setBounds(10, 11, 87, 43);
		panel_2_1.add(lblNewLabel_2_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"4");
			}
		});
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(84, 284, 107, 65);
		leftPanel.add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("4");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_3.setBounds(10, 11, 87, 43);
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"0");
			}
		});
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(318, 425, 107, 65);
		leftPanel.add(panel_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("0");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_1_1_1.setBounds(10, 11, 87, 43);
		panel_1_1_1.add(lblNewLabel_1_1_1);
		
		char dot='.';
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText().substring(0,textField.getText().length()-1));
			}
		});
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(84, 425, 224, 65);
		leftPanel.add(panel_3_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Del");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_3_1.setBounds(10, 11, 204, 43);
		panel_3_1.add(lblNewLabel_3_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"7");
			}
		});
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(84, 355, 107, 65);
		leftPanel.add(panel_4);
		
		JLabel lblNewLabel_4 = new JLabel("7");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_4.setBounds(10, 11, 87, 43);
		panel_4.add(lblNewLabel_4);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"8");
			}
		});
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(201, 355, 107, 65);
		leftPanel.add(panel_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("8");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_1_2.setBounds(10, 11, 87, 43);
		panel_1_2.add(lblNewLabel_1_2);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textField.setText(textField.getText()+"9");
			}
		});
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(318, 355, 107, 65);
		leftPanel.add(panel_2_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("9");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_2_2.setBounds(10, 11, 87, 43);
		panel_2_2.add(lblNewLabel_2_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		textField.setBounds(172, 125, 253, 57);
		leftPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("sum:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel_5.setBounds(84, 125, 78, 57);
		leftPanel.add(lblNewLabel_5);
		
		
		String query ="SELECT * FROM users where id="+ID.toString();
		Statement st;
		String amountOld="null";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				amountOld = rs.getString("amount");
				amountOldNum = Integer.parseInt(amountOld);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			amountOldNum=0;
			e1.printStackTrace();
		}
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String id = ID;
				String amount = textField.getText();
				int amountNum = Integer.parseInt(amount);
				int sum =amountOldNum+amountNum;
				String sumText = String.valueOf(sum);
				try {
					pst = con.prepareStatement("update users set amount=? where id=?");
					pst.setString(1, sumText);
					pst.setString(2, id);
					pst.executeUpdate();
					
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Fake Deposit successfully");
				Home home = new Home(ID);
				home.show();
				dispose();
			}
		});
		panel_5.setBackground(Color.RED);
		panel_5.setBounds(471, 170, 323, 109);
		leftPanel.add(panel_5);
		panel_5.setLayout(null);
		
		
		JLabel lblNewLabel_5_1 = new JLabel("Deposit");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 47));
		lblNewLabel_5_1.setBounds(10, 11, 303, 87);
		panel_5.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6 = new JLabel("Be gentle it's fake money");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_6.setBounds(481, 286, 306, 42);
		leftPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Not more than 1000000000");
		lblNewLabel_7.setBounds(182, 91, 228, 23);
		leftPanel.add(lblNewLabel_7);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		

		
	}
}