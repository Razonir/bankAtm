import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.sql.*;
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField acountNumber;
	private JTextField password;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Main frame = new Main();
		frame.setVisible(true);
			
	}

	/**
	 * Create the frame.
	 */
	public Main() {
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
		leftPanel.setBounds(0, 0, 443, 574);
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
		
		JLabel firstTitle = new JLabel("To log in to the account");
		firstTitle.setFont(new Font("Tahoma", Font.BOLD, 21));
		firstTitle.setBounds(52, 72, 391, 32);
		leftPanel.add(firstTitle);
		
		JLabel secTitle = new JLabel("Enter the account number and password");
		secTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		secTitle.setBounds(52, 115, 391, 32);
		leftPanel.add(secTitle);
		
		acountNumber = new JTextField("Acount number");
		acountNumber.setBounds(52, 209, 335, 40);
		acountNumber.setForeground(Color.GRAY);
		acountNumber.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (acountNumber.getText().equals("Acount number")) {
		        	acountNumber.setText("");
		        	acountNumber.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (acountNumber.getText().isEmpty()) {
		        	acountNumber.setForeground(Color.GRAY);
		        	acountNumber.setText("Acount number");
		        }
		    }
		    });
		leftPanel.add(acountNumber);
		

		password = new JTextField();
		password.setText("Password");
		password.setBounds(52, 278, 335, 40);
		password.setForeground(Color.GRAY);
		password.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (password.getText().equals("Password")) {
		        	password.setText("");
		        	password.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (password.getText().isEmpty()) {
		        	password.setForeground(Color.GRAY);
		        	password.setText("Password");
		        }
		    }
		    });
		leftPanel.add(acountNumber);
		leftPanel.add(password);
		

		JButton enterB = new JButton("ENTER");
		enterB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(password.getText().equals("admin") && acountNumber.getText().equals("admin")) {
					AdminMain adminSwitch = new AdminMain();
					adminSwitch.setVisible(true);
					dispose();
				}
			}
		});
		enterB.setFont(new Font("Tahoma", Font.BOLD, 16));
		enterB.setBounds(108, 364, 232, 46);
		leftPanel.add(enterB);
		
		//	right Panel ************************************************
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.RED);
		rightPanel.setBounds(441, 0, 374, 574);
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);
		
		Button registerB = new Button("register");
		registerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.setVisible(true);
				dispose();
			}
		});
		registerB.setFont(new Font("Dialog", Font.BOLD, 16));
		registerB.setBounds(10, 495, 341, 56);
		rightPanel.add(registerB);
	}
}
