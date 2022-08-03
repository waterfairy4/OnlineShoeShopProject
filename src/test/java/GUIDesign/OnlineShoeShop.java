package GUIDesign;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OnlineShoeShop extends JFrame implements ActionListener {
	
	ImageIcon cartIcon = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\shopping.png");
	ImageIcon shoe1 = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\sports.png");
	ImageIcon shoe2 = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\converse.jpg");
	ImageIcon shoe3 = new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\highheels.png");
	
	JLabel lbl1 = new JLabel(resizeImage(shoe1, 60, 60));
	JLabel lbl2 = new JLabel(resizeImage(shoe2, 60, 60));
	JLabel lbl3 = new JLabel(resizeImage(shoe3, 60, 60));
	
	JButton loginBtn = new JButton("Login/Sign In");
	JButton cartBtn = new JButton(resizeImage(cartIcon, 20, 20));
	JButton startShopBtn = new JButton("Start Shopping");
	boolean isLoggedIn = false;
	
	public ImageIcon resizeImage(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		return icon;
	}
	
	public OnlineShoeShop() {
		
		super("Ecila Shoes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 3));
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(loginBtn); buttons.add(cartBtn);
		
		
		add(new JPanel()); add(new JPanel()); add(buttons);
		add(lbl1); add(lbl2); add(lbl3);
		add(new JPanel()); add(startShopBtn); add(new JPanel());
		
		
		pack();
		
		loginBtn.addActionListener(this);
		cartBtn.addActionListener(this);
		startShopBtn.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		
		new OnlineShoeShop().setVisible(true);
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBtn) {
			if(isLoggedIn == true)
				JOptionPane.showMessageDialog(new JFrame(), "You are logged in.", "Login Successfull", JOptionPane.INFORMATION_MESSAGE);
			else {
				new LoginPage().setVisible(true);
				setVisible(false);
			}
		}
		
		if(e.getSource() == cartBtn) {
			new ShoppingCart().setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource() == startShopBtn) {
			if(isLoggedIn == false) {
				JOptionPane.showMessageDialog(new JFrame(), "You should log in to start shopping!", "", JOptionPane.WARNING_MESSAGE);
				new LoginPage().setVisible(true);
				setVisible(false);
			}
			else {
				new ShoeDisplayPage().setVisible(true);
				setVisible(false);
			}
		}
		
	}

}

