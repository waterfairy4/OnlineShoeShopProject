package GUIDesign;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {
	
	JLabel login = new JLabel("Login");
	JLabel areNew = new JLabel("Are you new?");
	JLabel signup = new JLabel("Sign-Up");
	JButton logBtn = new JButton("Login");
	JButton signBtn = new JButton("Finish Sign-Up and Login");
	
	JLabel usernameLbl = new JLabel("Username:");
	JLabel passLbl = new JLabel("Password:");
	JTextField usernameTxt = new JTextField(20);
	JPasswordField passTxt = new JPasswordField(20);
	
	JLabel nameLbl = new JLabel("Name:");
	JLabel surnameLbl = new JLabel("Surname:");
	JLabel mailLbl = new JLabel("Mail:");
	JLabel userLbl = new JLabel("Username:");
	JLabel passSignLbl = new JLabel("Password:");
	JLabel passAgainLbl = new JLabel("Password Again:");
	JTextField nameTxt = new JTextField(20);
	JTextField surnameTxt = new JTextField(20);
	JTextField mailTxt = new JTextField(20);
	JTextField userTxt = new JTextField(20);
	JPasswordField passSign = new JPasswordField(20);
	JPasswordField passAgain = new JPasswordField(20);
	
	public LoginPage() {
		super("Login Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel logPan = new JPanel();
		logPan.setLayout(new BorderLayout());
		logPan.add(login, BorderLayout.NORTH);
		JPanel userPass = new JPanel();
		userPass.setLayout(new GridLayout(2, 2));
		userPass.add(usernameLbl); userPass.add(usernameTxt);
		userPass.add(passLbl); userPass.add(passTxt);
		logPan.add(userPass, BorderLayout.CENTER);
		logPan.add(componentPanel(logBtn), BorderLayout.SOUTH);
		
		JPanel signPan = new JPanel();
		signPan.setLayout(new BorderLayout());
		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(2,1));
		labels.add(componentPanel(areNew)); labels.add(signup);
		signPan.add(labels, BorderLayout.NORTH);
		JPanel lblTxtPnl = new JPanel();
		lblTxtPnl.setLayout(new GridLayout(6,2));
		lblTxtPnl.add(nameLbl); lblTxtPnl.add(nameTxt);
		lblTxtPnl.add(surnameLbl); lblTxtPnl.add(surnameTxt);
		lblTxtPnl.add(mailLbl); lblTxtPnl.add(mailTxt);
		lblTxtPnl.add(userLbl); lblTxtPnl.add(userTxt);
		lblTxtPnl.add(passSignLbl); lblTxtPnl.add(passSign);
		lblTxtPnl.add(passAgainLbl); lblTxtPnl.add(passAgain);
		signPan.add(lblTxtPnl, BorderLayout.CENTER);
		signPan.add(componentPanel(signBtn), BorderLayout.SOUTH);
		
		add(logPan, BorderLayout.NORTH);
		add(signPan, BorderLayout.SOUTH);
		
		pack();
		
		logBtn.addActionListener(this);
		signBtn.addActionListener(this);
	}
	
	public JPanel componentPanel(Component comp) {
		JPanel stg = new JPanel();
		stg.add(new JPanel()); stg.add(comp);
		return stg;
	}
	
	//DON'T FORGET TO COMMENT MAIN
	public static void main(String[] args) {
		//new LoginPage().setVisible(true);
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logBtn || e.getSource() == signBtn) {
			JOptionPane.showMessageDialog(new JFrame(), "You are successfully logged in to your account", "", JOptionPane.INFORMATION_MESSAGE);
			OnlineShoeShop account = new OnlineShoeShop();
			account.loginBtn.setName("Profile");
			account.isLoggedIn = true;
			account.setVisible(true);
			setVisible(false);
		}
		
	}
	
	
	/*
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logBtn) {
			if(usernameTxt.getText().matches("[a-z]{1}[a-z0-9]{0,10}[._]{0,1}[a-z0-9]{0,10}[._]{0,1}[a-z0-9]{0,10}")) {
				JOptionPane.showMessageDialog(new JFrame(), "You are successfully logged in to your account", "", JOptionPane.PLAIN_MESSAGE);
				OnlineShoeShop account = new OnlineShoeShop();
				account.loginBtn.setName("Profile");
				account.isLoggedIn = true;
				account.setVisible(true);
				setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(), "Wrong username or password!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		if(e.getSource() == signBtn) {
			if(!nameTxt.getText().matches("[A-Z]{1}[a-z]*") || !nameTxt.getText().matches("[A-Z]{1}[a-z]*[ ]{1}[A-Z]{1}[a-z]*"))
				JOptionPane.showMessageDialog(new JFrame(), "Invalid Name", "Error", JOptionPane.ERROR_MESSAGE);
			if(!surnameTxt.getText().matches("[A-Z]{1}[a-z]*"))
				JOptionPane.showMessageDialog(new JFrame(), "Invalid Surname", "Error", JOptionPane.ERROR_MESSAGE);
	
			
			if(userTxt.getText().matches("[a-z]{1}[a-z0-9]{0,10}[._]{0,1}[a-z0-9]{0,10}[._]{0,1}[a-z0-9]{0,10}"))
				JOptionPane.showMessageDialog(new JFrame(), "Passwords don't match!", "Error", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(new JFrame(), "You are successfully signed and logged in to your account", "", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
 */
}
