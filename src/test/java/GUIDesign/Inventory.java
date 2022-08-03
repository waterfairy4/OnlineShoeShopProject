package GUIDesign;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Data.BinarySearchStockTree;
import Data.Brand;
import Data.Color;
import Data.Gender;
import Data.Node;
import Data.Shoes;
import Data.Typee;


public class Inventory extends JFrame implements ActionListener {
	public  static final BinarySearchStockTree womanStock = new BinarySearchStockTree();
	public  static final BinarySearchStockTree manStock = new BinarySearchStockTree();
	
	public BinarySearchStockTree getWomanStock() {
		return womanStock;
	}

	public BinarySearchStockTree getManStock() {
		return manStock;
	}



	JLabel lblTitle = new JLabel("Shoe Inventory");
	
	DefaultListModel<String> d = new DefaultListModel<String>();
	JList<String> l = new JList<String>(d);
	JScrollPane sp = new JScrollPane(l);
	
	JLabel lblItem = new JLabel("  Select Gender: ");
	Gender[] item = {Gender.MAN,Gender.WOMAN};
	JComboBox<Gender> cmbItem = new JComboBox<Gender>(item);
	
	JLabel lblType = new JLabel("  Select Type: ");
	Typee[] type = {Typee.CASUAL,Typee.CLASSIC,Typee.BOOTS,Typee.HIGHHEELS,Typee.SANDALS,Typee.SLIPPERS,Typee.SNEAKERS};
	JComboBox<Typee> cmbType = new JComboBox<Typee>(type);
	
	JLabel lblBrand = new JLabel("  Select Brand: ");
	Brand[] brand = {Brand.ADIDAS,Brand.CITYLIFE,Brand.CONVERSE,Brand.ECLIPSE,Brand.HAMMERJACK,
			Brand.LUMBERJACK,Brand.NEWBALANCE,Brand.NIKE,Brand.PROVOQ,Brand.PUMA,Brand.SKECHERS,
			Brand.THENORTHFACE,Brand.TWIGY,Brand.USPOLOASSN,Brand.VANS};
	JComboBox<Brand> cmbBrand = new JComboBox<Brand>(brand);
	
	JLabel lblColor = new JLabel("  Select Color: ");
	Color[] color= {Color.WHITE,Color.YELLOW,Color.GREEN,
	Color.BLUE,Color.ORANGE,
	Color.RED,Color.PINK,Color.PURPLE,Color.BROWN,Color.GREY,Color.BLACK};		
	JComboBox<Color> cmbColor = new JComboBox<Color>(color);
	
	JLabel lblPrice = new JLabel("  Enter Price: ");
	JTextField priceTxt = new JTextField(20);
	
	JLabel lblSize = new JLabel("  Select Size: ");
	Integer[] size = {35,36,37,38,39,40,41,42,43,44,45,46};
	JComboBox<Integer> cmbSize = new JComboBox<Integer>(size);
	
	JLabel lblQuantity = new JLabel("  Enter Quantity: ");
	JTextField quantityTxt = new JTextField(20);

	
	
	JButton btnAdd = new JButton("Add Item");
	JButton btnDelete = new JButton("Delete Selected Item");
	JButton btnTurnBackToShoppingSite = new JButton("Save and Exit");
	
	
	public Inventory() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(10, 2));
		pnl.add(lblItem); pnl.add(cmbItem);
		pnl.add(lblType); pnl.add(cmbType);
		pnl.add(lblBrand); pnl.add(cmbBrand);
		pnl.add(lblColor); pnl.add(cmbColor);
		pnl.add(lblSize); pnl.add(cmbSize);
		pnl.add(lblPrice); pnl.add(priceTxt);
		pnl.add(lblQuantity); pnl.add(quantityTxt);
		pnl.add(new JPanel()); pnl.add(btnAdd);
		pnl.add(new JPanel()); pnl.add(btnDelete);
		pnl.add(btnTurnBackToShoppingSite); 
		

	
		
		add(lblTitle, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		add(pnl, BorderLayout.SOUTH);
		pack();
		
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnTurnBackToShoppingSite.addActionListener(this);
		
		
	}
 	
	

	public static void main(String[] args) {
		new Inventory().setVisible(true);
	}
	
	public String gender(Gender gender) {
		if(gender == Gender.WOMAN)
			return "women";
		else
			return "men";
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Shoes shoes= new Shoes(Integer.parseInt(priceTxt.getText()),cmbSize.getItemAt(cmbSize.getSelectedIndex()) ,cmbType.getItemAt(cmbType.getSelectedIndex()),
				cmbBrand.getItemAt(cmbBrand.getSelectedIndex()),cmbColor.getItemAt(cmbColor.getSelectedIndex()),
				cmbItem.getItemAt(cmbItem.getSelectedIndex()),Integer.parseInt(quantityTxt.getText()));
		if(e.getSource() == btnAdd) {
			
			String item = "(" + gender((Gender) cmbItem.getSelectedItem()) + ") " + 
		cmbType.getSelectedItem() + " - Brand: " + cmbBrand.getSelectedItem() + " - '" + cmbColor.getSelectedItem() + "' - size: " + cmbSize.getSelectedItem() +
		" - price: $" + priceTxt.getText() + " -quantity:"+ quantityTxt.getText();
			d.addElement(item);
			
			
			
			    
		
			if(cmbItem.getSelectedItem().equals(Gender.WOMAN)) {
				
				womanStock.insert(shoes);
				System.out.println("-----------------------------------");
				womanStock.inorder(womanStock.getRoot());   
			}
			else {
				
				manStock.insert(shoes);
				System.out.println("-----------------------------------");
				manStock.inorder(manStock.getRoot());
			}
			
			
				
	         
		}
		if(e.getSource() == btnDelete) {
			if(!l.isSelectionEmpty()) {
				//String itemsToDel = l.getSelectedValues().length > 1 ? l.getSelectedValues().toString() : l.getSelectedValue();
				String itemToDelete = l.getSelectedValue();
				d.removeElement(itemToDelete);   //getselectedquantity so remove
				if(cmbItem.getSelectedItem().equals(Gender.WOMAN)) {
					womanStock.delete(shoes);
					womanStock.inorder(womanStock.getRoot());
				}
				
				else {
					manStock.delete(shoes);
					manStock.inorder(manStock.getRoot());
				}
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(), "Nothing is selected from the inventory!", "", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getSource()==btnTurnBackToShoppingSite ) {
		
		
			new OnlineShoeShop().setVisible(true);
			setVisible(false);
	
		}
		//Shoes shoes= new Shoes(Integer.parseInt(priceTxt.getText()),cmbSize.getItemAt(cmbSize.getSelectedIndex()) ,cmbType.getItemAt(cmbType.getSelectedIndex()),
		//		cmbBrand.getItemAt(cmbBrand.getSelectedIndex()),cmbColor.getItemAt(cmbColor.getSelectedIndex()),
		//		cmbItem.getItemAt(cmbItem.getSelectedIndex()),Integer.parseInt(quantityTxt.getText()));
	
	}
	
}

