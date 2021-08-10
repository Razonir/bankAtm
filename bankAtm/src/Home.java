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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
public class Home extends JFrame {

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
	
	Color myWhite = new Color(240, 240, 240);
	Color myred = new Color(255, 35, 35);
	Color red = new Color(255, 0, 0);


	/**
	 * Create the frame.
	 */
	public Home(String ID) {
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
		
		JPanel pullfirst = new JPanel();
		pullfirst.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Pulling pulling = new Pulling(ID,"50");
				pulling.show();
				dispose();
			}
		});
		
		pullfirst.setBackground(Color.RED);
		pullfirst.setBounds(52, 84, 209, 119);
		leftPanel.add(pullfirst);
		pullfirst.setLayout(null);
		
		JLabel dollarfirst = new JLabel("$");
		dollarfirst.setForeground(Color.WHITE);
		dollarfirst.setFont(new Font("Tahoma", Font.BOLD, 29));
		dollarfirst.setBounds(109, 55, 18, 42);
		pullfirst.add(dollarfirst);
		
		JLabel pullTitleF = new JLabel("Pulling");
		pullTitleF.setFont(new Font("Tahoma", Font.BOLD, 18));
		pullTitleF.setForeground(Color.WHITE);
		pullTitleF.setBounds(29, 7, 64, 30);
		pullfirst.add(pullTitleF);
		
		JLabel lblNewLabel_1 = new JLabel("50");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel_1.setBounds(43, 39, 64, 53);
		pullfirst.add(lblNewLabel_1);
		
		JPanel pullsec = new JPanel();
		pullsec.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Pulling pulling = new Pulling(ID,"100");
				pulling.show();
				dispose();
			}
		});
		pullsec.setLayout(null);
		pullsec.setBackground(Color.RED);
		pullsec.setBounds(271, 84, 209, 119);
		leftPanel.add(pullsec);
		
		JLabel lblNewLabel_3 = new JLabel("Pulling");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(29, 7, 147, 30);
		pullsec.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("100");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel_1_1.setBounds(39, 39, 114, 52);
		pullsec.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("$");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_2_1.setBounds(140, 48, 39, 42);
		pullsec.add(lblNewLabel_2_1);
		
		JPanel pullother = new JPanel();
		pullother.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				PullingOther pullingO = new PullingOther(ID);
				pullingO.show();
				dispose();
			}
		});
		pullother.setLayout(null);
		pullother.setBackground(Color.RED);
		pullother.setBounds(271, 214, 209, 119);
		leftPanel.add(pullother);
		
		JLabel PullingText = new JLabel("Pulling");
		PullingText.setForeground(Color.WHITE);
		PullingText.setFont(new Font("Tahoma", Font.BOLD, 18));
		PullingText.setBounds(29, 7, 147, 30);
		pullother.add(PullingText);
		
		JLabel pullingTextOther = new JLabel("Other");
		pullingTextOther.setForeground(Color.WHITE);
		pullingTextOther.setFont(new Font("Tahoma", Font.BOLD, 50));
		pullingTextOther.setBounds(29, 33, 186, 52);
		pullother.add(pullingTextOther);
		
		JPanel pullthr = new JPanel();
		pullthr.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Pulling pulling = new Pulling(ID,"200");
				pulling.show();
				dispose();
			}
		});
		pullthr.setLayout(null);
		pullthr.setBackground(Color.RED);
		pullthr.setBounds(52, 214, 209, 119);
		leftPanel.add(pullthr);
		
		JLabel pullTextThr = new JLabel("Pulling");
		pullTextThr.setForeground(Color.WHITE);
		pullTextThr.setFont(new Font("Tahoma", Font.BOLD, 18));
		pullTextThr.setBounds(29, 7, 147, 30);
		pullthr.add(pullTextThr);
		
		JLabel numberThr = new JLabel("200");
		numberThr.setForeground(Color.WHITE);
		numberThr.setFont(new Font("Tahoma", Font.BOLD, 50));
		numberThr.setBounds(39, 34, 114, 52);
		pullthr.add(numberThr);
		
		JLabel dollar = new JLabel("$");
		dollar.setForeground(Color.WHITE);
		dollar.setFont(new Font("Tahoma", Font.BOLD, 29));
		dollar.setBounds(140, 48, 54, 42);
		pullthr.add(dollar);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.show();
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setBounds(547, 495, 247, 57);
		leftPanel.add(btnNewButton_2);
		
		JPanel viewB = new JPanel();
		viewB.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Balance balance = new Balance(ID);
				balance.show();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				viewB.setBackground(myWhite);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				viewB.setBackground(Color.white);
			}
		});
		viewB.setLayout(null);
		viewB.setBackground(Color.WHITE);
		viewB.setBounds(52, 344, 430, 84);
		leftPanel.add(viewB);
		
		JLabel viewBText = new JLabel("View your balance");
		viewBText.setBackground(Color.WHITE);
		viewBText.setHorizontalAlignment(SwingConstants.CENTER);
		viewBText.setForeground(Color.GRAY);
		viewBText.setFont(new Font("Tahoma", Font.BOLD, 32));
		viewBText.setBounds(72, 0, 293, 84);
		viewB.add(viewBText);
		
		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MoneyAdd add = new MoneyAdd(ID);
				add.show();
				dispose();
			}
		});
		panel_3_1_1_1.setLayout(null);
		panel_3_1_1_1.setBackground(Color.WHITE);
		panel_3_1_1_1.setBounds(516, 171, 278, 84);
		leftPanel.add(panel_3_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Money deposit");
		lblNewLabel_5_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_5_1_1_1.setBounds(20, 0, 234, 84);
		panel_3_1_1_1.add(lblNewLabel_5_1_1_1);
		
		JPanel panel_3_1_1_1_1 = new JPanel();
		panel_3_1_1_1_1.setLayout(null);
		panel_3_1_1_1_1.setBackground(Color.WHITE);
		panel_3_1_1_1_1.setBounds(516, 344, 278, 84);
		leftPanel.add(panel_3_1_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1_1_1 = new JLabel("Details about us");
		lblNewLabel_5_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_5_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5_1_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_5_1_1_1_1_1.setBounds(20, 0, 234, 84);
		panel_3_1_1_1_1.add(lblNewLabel_5_1_1_1_1_1);
		
		JPanel panel_3_1_1_2 = new JPanel();
		panel_3_1_1_2.setLayout(null);
		panel_3_1_1_2.setBackground(Color.WHITE);
		panel_3_1_1_2.setBounds(516, 257, 278, 84);
		leftPanel.add(panel_3_1_1_2);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Additional actions");
		lblNewLabel_5_1_1_1_1.setBounds(21, 0, 234, 84);
		panel_3_1_1_2.add(lblNewLabel_5_1_1_1_1);
		lblNewLabel_5_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_5_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5_1_1_1_1.setBackground(Color.WHITE);
		
		JPanel panel_3_1_1_2_1 = new JPanel();
		panel_3_1_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3_1_1_2_1.setBackground(myWhite);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3_1_1_2_1.setBackground(Color.white);
			}
		});
		panel_3_1_1_2_1.setLayout(null);
		panel_3_1_1_2_1.setBackground(Color.WHITE);
		panel_3_1_1_2_1.setBounds(516, 84, 278, 84);
		leftPanel.add(panel_3_1_1_2_1);
		
		JLabel lblNewLabel_5_1_1_1_1_2 = new JLabel("Send Money");
		lblNewLabel_5_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_1_1_2.setForeground(Color.GRAY);
		lblNewLabel_5_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5_1_1_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_5_1_1_1_1_2.setBounds(21, 0, 234, 84);
		panel_3_1_1_2_1.add(lblNewLabel_5_1_1_1_1_2);
	}
}