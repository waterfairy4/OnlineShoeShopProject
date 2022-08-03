package GUIDesign;


	import java.awt.event.*;
	import java.awt.*;
	import javax.swing.*;

	public class EmployeeLoginPage extends JFrame implements ActionListener{
		
		JLabel empIdLbl = new JLabel("Employee Id:");
		JLabel passLbl = new JLabel("Password:");
		JTextField empIdTxt = new JTextField(20);
		JPasswordField passTxt = new JPasswordField(20);
		JButton loginBtn = new JButton("Login");
		
		public EmployeeLoginPage() {
			super("Login");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			
			JPanel pnl = new JPanel();
			pnl.setLayout(new GridLayout(2, 2));
			pnl.add(empIdLbl); pnl.add(empIdTxt);
			pnl.add(passLbl); pnl.add(passTxt);
			
			add(pnl, BorderLayout.CENTER);
			add(loginBtn, BorderLayout.SOUTH);
			
			pack();
			
			loginBtn.addActionListener(this);
			
		}
		
		public static void main(String[] args) {
			new EmployeeLoginPage().setVisible(true);
		}
		
	
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == loginBtn && empIdTxt.getText().matches("[0-9]{9}") ) {   
				new Inventory().setVisible(true);
				setVisible(false);
			}
		}

	}


