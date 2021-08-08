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
import javax.swing.JScrollPane;
public class Pulling extends JFrame {

	private JPanel contentPane;
	int i;
	int smallNumber = 0,midNumber = 0,BigNumber = 0;
	int hundred=0,fifty=0,twenty=0,ten=0,five=0,two=0,one=0;


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
	public Pulling(String ID,String pullNumber) {
		Connect();
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 603);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		//check
		int pullNumberInt = Integer.parseInt(pullNumber);
		if(pullNumberInt>=100) {
			int hundred = big(pullNumberInt);
			int smallarr[]=small(pullNumberInt);
			five=smallarr[0];
			two=smallarr[1];
			one=smallarr[2];
			int midarr[]=mid(pullNumberInt);
			fifty=midarr[0];
			twenty=midarr[1];
			ten=midarr[2];
		}
		if(pullNumberInt>=10 && pullNumberInt<100) {
			int smallarr[]=small(pullNumberInt);
			five=smallarr[0];
			two=smallarr[1];
			one=smallarr[2];
			int midarr[]=mid(pullNumberInt);
			fifty=midarr[0];
			twenty=midarr[1];
			ten=midarr[2];
		}
		if(pullNumberInt<10 && pullNumberInt>0) {
			int smallarr[]=small(pullNumberInt);
			five=smallarr[0];
			two=smallarr[1];
			one=smallarr[2];
		}
		int hundredS=hundred,fiftyS=fifty,twentyS=twenty,tenS=ten,fiveS=five,twoS=two,oneS=one;

		//check S
		if(hundredS>3 && hundredS%2==0) { //100
			hundredS= hundred/2;
			fiftyS= fifty+hundred;
		}else if(hundredS>3 && hundredS%2!=0) {
			hundredS= (hundred-1)/2;
			fiftyS= fifty+hundred+1;
		}
		if(fiftyS>3 && fiftyS%2==0) { //50
			fiftyS= fiftyS/2;
			while(i<fiftyS) {
				twentyS+=2;
				tenS+=1;
				i++;
			}
			i=0;
		}else if(fiftyS>3 && fiftyS%2!=0) {
			fiftyS= (fiftyS-1)/2;
			while(i<fiftyS) {
				twentyS+=2;
				tenS+=1;
				i++;
			}
			i=0;
			fiftyS++;
		}
		if(tenS>3 && tenS%2==0) { //10
			fiveS= fiveS+tenS;
			tenS= tenS/2;
		}else if(tenS>3 && tenS%2!=0) {
			fiveS= fiveS+tenS+1;
			tenS= (tenS-1)/2;
		}
		if(fiveS>3 && fiveS%2==0) { //50
			fiveS= fiveS/2;
			while(i<fiveS) {
				twoS+=2;
				oneS+=1;
				i++;
			}
			i=0;
		}else if(fiveS>3 && fiveS%2!=0) {
			fiveS= (fiveS-1)/2;
			while(i<fiveS) {
				twoS+=2;
				oneS+=1;
				i++;
			}
			i=0;
			fiveS++;
		}
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
		
		JLabel lblNewLabel = new JLabel("Pulling");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(283, 41, 123, 64);
		leftPanel.add(lblNewLabel);
		
		JLabel lblNull = new JLabel(pullNumber+" $");
		lblNull.setHorizontalAlignment(SwingConstants.LEFT);
		lblNull.setForeground(Color.RED);
		lblNull.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNull.setBounds(405, 41, 255, 64);
		leftPanel.add(lblNull);
		
		JLabel lblNewLabel_1 = new JLabel("Choose your favorite banknote composition");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 96, 815, 32);
		leftPanel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(405, 133, 255, 350);
		leftPanel.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Select");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PullingFee afterfee = new PullingFee(ID,pullNumber);
				afterfee.show();
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 37));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(0, 269, 255, 83);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mix Bills");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.GRAY);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_2_1.setBounds(0, 0, 255, 40);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel hundredText_1 = new JLabel("100$ bill:");
		hundredText_1.setHorizontalAlignment(SwingConstants.RIGHT);
		hundredText_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hundredText_1.setBounds(0, 51, 133, 25);
		panel_1.add(hundredText_1);
		
		JLabel hundredDynamic_1 = new JLabel(Integer.toString(hundredS));
		hundredDynamic_1.setHorizontalAlignment(SwingConstants.LEFT);
		hundredDynamic_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hundredDynamic_1.setBounds(143, 51, 112, 25);
		panel_1.add(hundredDynamic_1);
		
		JLabel fiftyDynamic_1 = new JLabel(Integer.toString(fiftyS));
		fiftyDynamic_1.setHorizontalAlignment(SwingConstants.LEFT);
		fiftyDynamic_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fiftyDynamic_1.setBounds(143, 75, 112, 25);
		panel_1.add(fiftyDynamic_1);
		
		JLabel fiftyText_1 = new JLabel("50$ bill:");
		fiftyText_1.setHorizontalAlignment(SwingConstants.RIGHT);
		fiftyText_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fiftyText_1.setBounds(0, 75, 133, 25);
		panel_1.add(fiftyText_1);
		
		JLabel twentyDynamic_1 = new JLabel(Integer.toString(twentyS));
		twentyDynamic_1.setHorizontalAlignment(SwingConstants.LEFT);
		twentyDynamic_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		twentyDynamic_1.setBounds(143, 100, 112, 25);
		panel_1.add(twentyDynamic_1);
		
		JLabel twentyText_1 = new JLabel("20$ bill:");
		twentyText_1.setHorizontalAlignment(SwingConstants.RIGHT);
		twentyText_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		twentyText_1.setBounds(0, 100, 133, 25);
		panel_1.add(twentyText_1);
		
		JLabel twoDynamic_1 = new JLabel(Integer.toString(twoS));
		twoDynamic_1.setHorizontalAlignment(SwingConstants.LEFT);
		twoDynamic_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		twoDynamic_1.setBounds(143, 173, 112, 25);
		panel_1.add(twoDynamic_1);
		
		JLabel twoText_1 = new JLabel("2$ bill:");
		twoText_1.setHorizontalAlignment(SwingConstants.RIGHT);
		twoText_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		twoText_1.setBounds(0, 173, 133, 25);
		panel_1.add(twoText_1);
		
		JLabel fiveText_1 = new JLabel("5$ bill:");
		fiveText_1.setHorizontalAlignment(SwingConstants.RIGHT);
		fiveText_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fiveText_1.setBounds(0, 148, 133, 25);
		panel_1.add(fiveText_1);
		
		JLabel fiveDynamic_1 = new JLabel(Integer.toString(fiveS));
		fiveDynamic_1.setHorizontalAlignment(SwingConstants.LEFT);
		fiveDynamic_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fiveDynamic_1.setBounds(143, 148, 112, 25);
		panel_1.add(fiveDynamic_1);
		
		JLabel tenDynamic_1 = new JLabel(Integer.toString(tenS));
		tenDynamic_1.setHorizontalAlignment(SwingConstants.LEFT);
		tenDynamic_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tenDynamic_1.setBounds(143, 124, 112, 25);
		panel_1.add(tenDynamic_1);
		
		JLabel tenText_1 = new JLabel("10$ bill:");
		tenText_1.setHorizontalAlignment(SwingConstants.RIGHT);
		tenText_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tenText_1.setBounds(0, 124, 133, 25);
		panel_1.add(tenText_1);
		
		JLabel oneDynamic_1 = new JLabel(Integer.toString(oneS));
		oneDynamic_1.setHorizontalAlignment(SwingConstants.LEFT);
		oneDynamic_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		oneDynamic_1.setBounds(143, 197, 112, 25);
		panel_1.add(oneDynamic_1);
		
		JLabel oneText_1 = new JLabel("1$ bill:");
		oneText_1.setHorizontalAlignment(SwingConstants.RIGHT);
		oneText_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		oneText_1.setBounds(0, 197, 133, 25);
		panel_1.add(oneText_1);
		
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
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(140, 133, 255, 350);
		leftPanel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("Select");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PullingFee afterfee = new PullingFee(ID,pullNumber);
				afterfee.show();
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(0, 269, 255, 83);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 37));
		btnNewButton_1_1.setBackground(Color.RED);
		panel_1_1.add(btnNewButton_1_1);
		
		JLabel offerCurr = new JLabel("Big offer");
		offerCurr.setForeground(Color.GRAY);
		offerCurr.setFont(new Font("Tahoma", Font.PLAIN, 23));
		offerCurr.setHorizontalAlignment(SwingConstants.CENTER);
		offerCurr.setBounds(0, 0, 255, 40);
		panel_1_1.add(offerCurr);
		
		JLabel hundredText = new JLabel("100$ bill:");
		hundredText.setHorizontalAlignment(SwingConstants.RIGHT);
		hundredText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hundredText.setBounds(0, 53, 133, 25);
		panel_1_1.add(hundredText);
		
		JLabel hundredDynamic = new JLabel(Integer.toString(hundred));
		hundredDynamic.setHorizontalAlignment(SwingConstants.LEFT);
		hundredDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hundredDynamic.setBounds(143, 53, 112, 25);
		panel_1_1.add(hundredDynamic);
		
		JLabel fiftyDynamic = new JLabel(Integer.toString(fifty));
		fiftyDynamic.setHorizontalAlignment(SwingConstants.LEFT);
		fiftyDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fiftyDynamic.setBounds(143, 77, 112, 25);
		panel_1_1.add(fiftyDynamic);
		
		JLabel fiftyText = new JLabel("50$ bill:");
		fiftyText.setHorizontalAlignment(SwingConstants.RIGHT);
		fiftyText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fiftyText.setBounds(0, 77, 133, 25);
		panel_1_1.add(fiftyText);
		
		JLabel twentyDynamic = new JLabel(Integer.toString(twenty));
		twentyDynamic.setHorizontalAlignment(SwingConstants.LEFT);
		twentyDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		twentyDynamic.setBounds(143, 102, 112, 25);
		panel_1_1.add(twentyDynamic);
		
		JLabel twentyText = new JLabel("20$ bill:");
		twentyText.setHorizontalAlignment(SwingConstants.RIGHT);
		twentyText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		twentyText.setBounds(0, 102, 133, 25);
		panel_1_1.add(twentyText);
		
		JLabel twoDynamic = new JLabel(Integer.toString(two));
		twoDynamic.setHorizontalAlignment(SwingConstants.LEFT);
		twoDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		twoDynamic.setBounds(143, 175, 112, 25);
		panel_1_1.add(twoDynamic);
		
		JLabel twoText = new JLabel("2$ bill:");
		twoText.setHorizontalAlignment(SwingConstants.RIGHT);
		twoText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		twoText.setBounds(0, 175, 133, 25);
		panel_1_1.add(twoText);
		
		JLabel fiveText = new JLabel("5$ bill:");
		fiveText.setHorizontalAlignment(SwingConstants.RIGHT);
		fiveText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fiveText.setBounds(0, 150, 133, 25);
		panel_1_1.add(fiveText);
		
		JLabel fiveDynamic = new JLabel(Integer.toString(five));
		fiveDynamic.setHorizontalAlignment(SwingConstants.LEFT);
		fiveDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fiveDynamic.setBounds(143, 150, 112, 25);
		panel_1_1.add(fiveDynamic);
		
		JLabel tenDynamic = new JLabel(Integer.toString(ten));
		tenDynamic.setHorizontalAlignment(SwingConstants.LEFT);
		tenDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tenDynamic.setBounds(143, 126, 112, 25);
		panel_1_1.add(tenDynamic);
		
		JLabel tenText = new JLabel("10$ bill:");
		tenText.setHorizontalAlignment(SwingConstants.RIGHT);
		tenText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tenText.setBounds(0, 126, 133, 25);
		panel_1_1.add(tenText);
		
		JLabel oneDynamic = new JLabel(Integer.toString(one));
		oneDynamic.setHorizontalAlignment(SwingConstants.LEFT);
		oneDynamic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		oneDynamic.setBounds(143, 199, 112, 25);
		panel_1_1.add(oneDynamic);
		
		JLabel oneText = new JLabel("1$ bill:");
		oneText.setHorizontalAlignment(SwingConstants.RIGHT);
		oneText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		oneText.setBounds(0, 199, 133, 25);
		panel_1_1.add(oneText);
		

		
	}
	
	public int[] small(int pullNumberInt) {
	smallNumber = pullNumberInt%10;
	if(smallNumber>=5) {
		smallNumber-=5;
		five++;
	}else {
		if(smallNumber%2==0) {
			while(smallNumber!=0) {
				smallNumber-=2;
				two++;
			}
		}else {
			smallNumber-=1;
			one++;
			while(smallNumber!=0) {
				smallNumber-=2;
				two++;
			}
		}
	}
	if(smallNumber!=0) {
		if(smallNumber%2==0) {
			while(smallNumber!=0) {
				smallNumber-=2;
				two++;
			}
		}else {
			smallNumber-=1;
			one++;
			while(smallNumber!=0) {
				smallNumber-=2;
				two++;
			}
		}
	}
	int[]arr= {five,two,one};
	return arr;
	}
	
	public int[] mid(int pullNumberInt) {
	midNumber = (pullNumberInt/10)%10;
	if(midNumber>=5) {
		midNumber-=5;
		fifty++;
	}else {
		if(midNumber%2==0) {
			while(midNumber!=0) {
				midNumber-=2;
				twenty++;
			}
		}else {
			midNumber-=1;
			ten++;
			while(midNumber!=0) {
				midNumber-=2;
				twenty++;
			}
		}
	}
	if(midNumber!=0) {
		if(midNumber%2==0) {
			while(midNumber!=0) {
				midNumber-=2;
				twenty++;
			}
		}else {
			midNumber-=1;
			ten++;
			while(midNumber!=0) {
				midNumber-=2;
				twenty++;
			}
		}
	}
	int[]arr= {fifty,twenty,ten};
	return arr;
	}
	
	public int big(int pullNumberInt) {
		int bigNumber = (pullNumberInt/100);
		while(bigNumber!=0) {
			bigNumber--;
			hundred++;
		}
		return hundred;
	}
}