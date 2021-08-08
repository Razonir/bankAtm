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
public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField phone;
	private JTextField password;
	private JTextField passwordC;


	/**
	 * Create the data
	 */
	
	static Connection con;
	PreparedStatement pst;
	private JTextField amount;
	
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
	public Register() {
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
		
		firstName = new JTextField("First Name");
		firstName.setBounds(72, 75, 391, 42);
		firstName.setColumns(10);
		firstName.setForeground(Color.GRAY);
		firstName.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (firstName.getText().equals("First Name")) {
		        	firstName.setText("");
		        	firstName.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (firstName.getText().isEmpty()) {
		        	firstName.setForeground(Color.GRAY);
		        	firstName.setText("First Name");
		        }
		    }
		    });
		leftPanel.add(firstName);
		
		lastName = new JTextField("Last Name");
		lastName.setBounds(72, 128, 391, 42);
		lastName.setColumns(10);
		lastName.setForeground(Color.GRAY);
		lastName.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (lastName.getText().equals("Last Name")) {
		        	lastName.setText("");
		        	lastName.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (lastName.getText().isEmpty()) {
		        	lastName.setForeground(Color.GRAY);
		        	lastName.setText("Last Name");
		        }
		    }
		    });
		leftPanel.add(lastName);
		
		email = new JTextField("Email");
		email.setBounds(72, 181, 391, 42);
		email.setColumns(10);
		email.setForeground(Color.GRAY);
		email.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (email.getText().equals("Email")) {
		        	email.setText("");
		        	email.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (email.getText().isEmpty()) {
		        	email.setForeground(Color.GRAY);
		        	email.setText("Email");
		        }
		    }
		    });
		leftPanel.add(email);
		
		phone = new JTextField("Phone Number");
		phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		phone.setBounds(72, 234, 391, 42);
		phone.setColumns(10);
		phone.setForeground(Color.GRAY);
		phone.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (phone.getText().equals("Phone Number")) {
		        	phone.setText("");
		        	phone.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (phone.getText().isEmpty()) {
		        	phone.setForeground(Color.GRAY);
		        	phone.setText("Phone Number");
		        }
		    }
		    });
		leftPanel.add(phone);
		
		password = new JTextField("Password");
		password.setBounds(72, 287, 391, 42);
		password.setColumns(10);
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
		leftPanel.add(password);
		
		
		passwordC = new JTextField("Password again");
		passwordC.setBounds(72, 340, 391, 42);
		passwordC.setColumns(10);
		passwordC.setForeground(Color.GRAY);
		passwordC.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (passwordC.getText().equals("Password again")) {
		        	passwordC.setText("");
		        	passwordC.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (passwordC.getText().isEmpty()) {
		        	passwordC.setForeground(Color.GRAY);
		        	passwordC.setText("Password again");
		        }
		    }
		    });
		leftPanel.add(passwordC);

		Button register = new Button("register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String firstNameText,lastNameText,emailText,phoneText,passwordText,passwordCText,amountText;
				firstNameText = firstName.getText();
				lastNameText = lastName.getText();
				emailText = email.getText();
				phoneText = phone.getText();
				passwordText = password.getText();
				passwordCText = passwordC.getText();
				amountText = amount.getText();
				
				if(!firstName.getText().equals("First Name") &&
						!lastName.getText().equals("Last Name") &&
						!email.getText().equals("Email") &&
						!phone.getText().equals("Phone Number") &&
						!password.getText().equals("Password") &&
						!passwordC.getText().equals("Password again") &&
						!amount.getText().equals("Fake amount")){
					if(passwordText.equals(passwordC.getText())) {
						try {
							pst = con.prepareStatement("insert into users(first_name,last_name,email,phone,password,amount)values(?,?,?,?,?,?)");
							pst.setString(1, firstNameText);
							pst.setString(2, lastNameText);
							pst.setString(3, emailText);
							pst.setString(4, phoneText);
							pst.setString(5, passwordText);
							pst.setString(6, amountText);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Record Addedd !!");
							
							firstName.setText("First Name");
							lastName.setText("Last Name");
							email.setText("Email");
							phone.setText("Phone Number");
							password.setText("Password");
							passwordC.setText("Password again");
							amount.setText("Fake amount");
							
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
						}else { //password not equals
							JOptionPane.showMessageDialog(null, "password not equals!");
							password.setText("Password");
							passwordC.setText("Password again");
		
						}
					}else { // empty 
						JOptionPane.showMessageDialog(null, "fill the empty");

					}
			}
		});
		
		register.setBounds(77, 490, 386, 42);
		leftPanel.add(register);
		
		
		amount = new JTextField("Fake amount");
		amount.setBounds(72, 393, 391, 42);
		amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		amount.setColumns(10);
		amount.setForeground(Color.GRAY);
		amount.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (amount.getText().equals("Fake amount")) {
		        	amount.setText("");
		        	amount.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (amount.getText().isEmpty()) {
		        	amount.setForeground(Color.GRAY);
		        	amount.setText("Fake amount");
		        }
		    }
		    });
		leftPanel.add(amount);
		

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