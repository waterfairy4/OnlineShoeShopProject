package GUIDesign;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import Data.*;
import Data.Color;

import java.awt.datatransfer.*;
import java.awt.*;
import GUIDesign.Inventory;


public class ShoeDisplayPage extends JFrame implements ActionListener {
	Inventory inventory=new Inventory();
	private static final DoublyLinkedList shoppingList=new DoublyLinkedList();
	public static DoublyLinkedList getShoppingList() {
		return shoppingList;
	}
    private static String qquantity;
	
    public String getQquantity() {
		return qquantity;
	}



	public void setQquantity(String qquantity) {
		this.qquantity = qquantity;
	}


	JLabel lblTitle = new JLabel("Shoe Display Page");
	
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
	Color.BLUE,Color.ORANGE,Color.BLUE,Color.ORANGE,
	Color.RED,Color.PINK,Color.PURPLE,Color.BROWN,Color.GREY,Color.BLACK};		
	JComboBox<Color> cmbColor = new JComboBox<Color>(color);
	
	JLabel lblPrice = new JLabel("  Enter The Most Price: ");
	JTextField priceTxt = new JTextField(20);
	
	JLabel lblSize = new JLabel("  Select Size: ");
	Integer[] size = {35,36,37,38,39,40,41,42,43,44,45,46};
	JComboBox<Integer> cmbSize = new JComboBox<Integer>(size);
	
	
	
	JButton btnSearch4 = new JButton("Search with all");
	JButton btnSearch3 = new JButton("Search without Brand");
	JButton btnSearch2 = new JButton("Search without Color");
	JButton btnSearch1 = new JButton("Search without Color and Brand");
	
	JButton btnAddToTheShoppingList = new JButton("Add to the shopping list");
	JButton btngoMainPage = new JButton("Go Main Page");
	public ShoeDisplayPage() {
		super("Shoes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//add(new JPanel(true));
	
        setLayout(new BorderLayout());
		
		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(12,2));
		pnl.add(lblItem); pnl.add(cmbItem);
		pnl.add(lblType); pnl.add(cmbType);
		pnl.add(lblBrand); pnl.add(cmbBrand);
		pnl.add(lblColor); pnl.add(cmbColor);
		pnl.add(lblSize); pnl.add(cmbSize);
		pnl.add(lblPrice); pnl.add(priceTxt);
		pnl.add(new JPanel()); pnl.add(btnSearch4);
		pnl.add(new JPanel()); pnl.add(btnSearch2);
		pnl.add(new JPanel()); pnl.add(btnSearch3);
		pnl.add(new JPanel()); pnl.add(btnSearch1);
		pnl.add(btngoMainPage); pnl.add(btnAddToTheShoppingList);
		 
		
		add(lblTitle, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		add(pnl, BorderLayout.SOUTH);
		
		
		pack();
		
		
		btnSearch4.addActionListener(this);
		btnSearch3.addActionListener(this);
		btnSearch2.addActionListener(this);
		btnSearch1.addActionListener(this);
		btnAddToTheShoppingList.addActionListener(this);  
		btngoMainPage.addActionListener(this);
		
	}
	
	
	
	public static void main(String[] args) {
		new ShoeDisplayPage().setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	
		     
		if(e.getSource() == btnSearch1) {
		//	String item = "(" + gender(cmbItem.getSelectedItem()) + ") " + 
		//cmbType.getSelectedItem() + " - Brand: " + cmbBrand.getSelectedItem() + " - '" + cmbColor.getSelectedItem() + "' - size: " + cmbSize.getSelectedItem() +
		//" - price: $" + priceTxt.getText() + " -quantity:"+ quantityTxt.getText();
			
			
		
			if(cmbItem.getSelectedItem().equals(Gender.WOMAN))
			{	
				inventory.womanStock.getFoundShoes().setNull();
				d.removeAllElements();
				Inventory.womanStock.searchy(Inventory.womanStock.getRoot(),Integer.parseInt(priceTxt.getText()) ,
						cmbSize.getItemAt(cmbSize.getSelectedIndex()), cmbType.getItemAt(cmbType.getSelectedIndex()));
				
				
				//womanStock.getFoundShoes().getFirst().getTreeNode().getShoes().toString();
				//inventory.getWomanStock().inorder(inventory.getWomanStock().getRoot());
				//inventory.getWomanStock().getFoundShoes().outputList();
				
				 Node temp=(Inventory.womanStock.getFoundShoes().getFirst());
					while (temp!=null) {
						d.addElement(temp.getTreeNode().getShoes().toString());
						temp=temp.getNext();
						
					}
				
					
				
				if(Inventory.womanStock.getFoundShoes().isEmpty()) {
					System.out.println("There is no maching found");
					JOptionPane.showMessageDialog(new JFrame(), "There is no maching found!", "", JOptionPane.WARNING_MESSAGE);
				}
				else {
				Inventory.womanStock.getFoundShoes().outputList(); 
				}
			}
			else {
				inventory.manStock.getFoundShoes().setNull();
				d.removeAllElements();
				Inventory.manStock.searchy(Inventory.manStock.getRoot(),Integer.parseInt(priceTxt.getText()) ,
						cmbSize.getItemAt(cmbSize.getSelectedIndex()), cmbType.getItemAt(cmbType.getSelectedIndex()));
				
				
				 
				 Node temp=(Inventory.manStock.getFoundShoes().getFirst());
				while( temp!=null) {
					d.addElement(temp.getTreeNode().getShoes().toString());
					
					temp=temp.getNext();
				}
				
				if(Inventory.manStock.getFoundShoes().isEmpty()) {
					System.out.println("There is no maching found");
					JOptionPane.showMessageDialog(new JFrame(), "There is no maching found!", "", JOptionPane.WARNING_MESSAGE);
				}
				else {
				Inventory.manStock.getFoundShoes().outputList();
				}
				
			}
		}
		
		if(e.getSource() == btnSearch4) {
			//	String item = "(" + gender(cmbItem.getSelectedItem()) + ") " + 
			//cmbType.getSelectedItem() + " - Brand: " + cmbBrand.getSelectedItem() + " - '" + cmbColor.getSelectedItem() + "' - size: " + cmbSize.getSelectedItem() +
			//" - price: $" + priceTxt.getText() + " -quantity:"+ quantityTxt.getText();
				
				
			
				if(cmbItem.getSelectedItem().equals(Gender.WOMAN))
				{	
					inventory.womanStock.getFoundShoes().setNull();
					d.removeAllElements();
					Inventory.womanStock.searchy(Inventory.womanStock.getRoot(),Integer.parseInt(priceTxt.getText()) ,
							cmbSize.getItemAt(cmbSize.getSelectedIndex()), cmbType.getItemAt(cmbType.getSelectedIndex()), 
							cmbBrand.getItemAt(cmbBrand.getSelectedIndex()), cmbColor.getItemAt(cmbColor.getSelectedIndex()));
					
					
					//womanStock.getFoundShoes().getFirst().getTreeNode().getShoes().toString();
					//inventory.getWomanStock().inorder(inventory.getWomanStock().getRoot());
					//inventory.getWomanStock().getFoundShoes().outputList();
					
					 Node temp=(Inventory.womanStock.getFoundShoes().getFirst());
						while (temp!=null) {
							d.addElement(temp.getTreeNode().getShoes().toString());
							temp=temp.getNext();
							
						}
					
						
					
					if(Inventory.womanStock.getFoundShoes().isEmpty()) {
						System.out.println("There is no maching found");
						JOptionPane.showMessageDialog(new JFrame(), "There is no maching found!", "", JOptionPane.WARNING_MESSAGE);
					}
					else {
					Inventory.womanStock.getFoundShoes().outputList(); 
					}
				}
				else {
					inventory.manStock.getFoundShoes().setNull();
					d.removeAllElements();
					Inventory.manStock.searchy(Inventory.manStock.getRoot(),Integer.parseInt(priceTxt.getText()) ,
							cmbSize.getItemAt(cmbSize.getSelectedIndex()), cmbType.getItemAt(cmbType.getSelectedIndex()), 
							cmbBrand.getItemAt(cmbBrand.getSelectedIndex()), cmbColor.getItemAt(cmbColor.getSelectedIndex()));
					
					
					 
					 Node temp=(Inventory.manStock.getFoundShoes().getFirst());
					while( temp!=null) {
						d.addElement(temp.getTreeNode().getShoes().toString());
						
						temp=temp.getNext();
					}
					
					if(Inventory.manStock.getFoundShoes().isEmpty()) {
						System.out.println("There is no maching found");
						JOptionPane.showMessageDialog(new JFrame(), "There is no maching found!", "", JOptionPane.WARNING_MESSAGE);
					}
					else {
					Inventory.manStock.getFoundShoes().outputList();
					}
					
				}
			}
		
		if(e.getSource() == btnSearch2) {
			//	String item = "(" + gender(cmbItem.getSelectedItem()) + ") " + 
			//cmbType.getSelectedItem() + " - Brand: " + cmbBrand.getSelectedItem() + " - '" + cmbColor.getSelectedItem() + "' - size: " + cmbSize.getSelectedItem() +
			//" - price: $" + priceTxt.getText() + " -quantity:"+ quantityTxt.getText();
				
				
			
				if(cmbItem.getSelectedItem().equals(Gender.WOMAN))
				{	
					inventory.womanStock.getFoundShoes().setNull();
					d.removeAllElements();
					Inventory.womanStock.searchy(Inventory.womanStock.getRoot(),Integer.parseInt(priceTxt.getText()) ,
							cmbSize.getItemAt(cmbSize.getSelectedIndex()), cmbType.getItemAt(cmbType.getSelectedIndex()), 
							cmbColor.getItemAt(cmbColor.getSelectedIndex()));
					
					
					//womanStock.getFoundShoes().getFirst().getTreeNode().getShoes().toString();
					//inventory.getWomanStock().inorder(inventory.getWomanStock().getRoot());
					//inventory.getWomanStock().getFoundShoes().outputList();
					
					 Node temp=(Inventory.womanStock.getFoundShoes().getFirst());
						while (temp!=null) {
							d.addElement(temp.getTreeNode().getShoes().toString());
							temp=temp.getNext();
							
						}
					
						
					
					if(Inventory.womanStock.getFoundShoes().isEmpty()) {
						System.out.println("There is no maching found");
						JOptionPane.showMessageDialog(new JFrame(), "There is no maching found!", "", JOptionPane.WARNING_MESSAGE);
					}
					else {
					Inventory.womanStock.getFoundShoes().outputList(); 
					}
				}
				else {
					inventory.manStock.getFoundShoes().setNull();
					d.removeAllElements();
					Inventory.manStock.searchy(Inventory.manStock.getRoot(),Integer.parseInt(priceTxt.getText()) ,
							cmbSize.getItemAt(cmbSize.getSelectedIndex()), cmbType.getItemAt(cmbType.getSelectedIndex()), 
							 cmbColor.getItemAt(cmbColor.getSelectedIndex()));
					
					
					 
					 Node temp=(Inventory.manStock.getFoundShoes().getFirst());
					while( temp!=null) {
						d.addElement(temp.getTreeNode().getShoes().toString());
						
						temp=temp.getNext();
					}
					
					if(Inventory.manStock.getFoundShoes().isEmpty()) {
						System.out.println("There is no maching found");
						JOptionPane.showMessageDialog(new JFrame(), "There is no maching found!", "", JOptionPane.WARNING_MESSAGE);
					}
					else {
					Inventory.manStock.getFoundShoes().outputList();
					}
					
				}
			}
		if(e.getSource() == btnSearch3) {
			//	String item = "(" + gender(cmbItem.getSelectedItem()) + ") " + 
			//cmbType.getSelectedItem() + " - Brand: " + cmbBrand.getSelectedItem() + " - '" + cmbColor.getSelectedItem() + "' - size: " + cmbSize.getSelectedItem() +
			//" - price: $" + priceTxt.getText() + " -quantity:"+ quantityTxt.getText();
				
				
			
				if(cmbItem.getSelectedItem().equals(Gender.WOMAN))
				{	
					inventory.womanStock.getFoundShoes().setNull();
					d.removeAllElements();
					Inventory.womanStock.searchy(Inventory.womanStock.getRoot(),Integer.parseInt(priceTxt.getText()) ,
							cmbSize.getItemAt(cmbSize.getSelectedIndex()), cmbType.getItemAt(cmbType.getSelectedIndex()), 
							cmbBrand.getItemAt(cmbBrand.getSelectedIndex()));
					
					
					//womanStock.getFoundShoes().getFirst().getTreeNode().getShoes().toString();
					//inventory.getWomanStock().inorder(inventory.getWomanStock().getRoot());
					//inventory.getWomanStock().getFoundShoes().outputList();
					
					 Node temp=(Inventory.womanStock.getFoundShoes().getFirst());
						while (temp!=null) {
							d.addElement(temp.getTreeNode().getShoes().toString());
							temp=temp.getNext();
							
						}
					
						
					
					if(Inventory.womanStock.getFoundShoes().isEmpty()) {
						System.out.println("There is no maching found");
						JOptionPane.showMessageDialog(new JFrame(), "There is no maching found!", "", JOptionPane.WARNING_MESSAGE);
					}
					else {
					Inventory.womanStock.getFoundShoes().outputList(); 
					}
				}
				else {
					inventory.manStock.getFoundShoes().setNull();
					d.removeAllElements();
					Inventory.manStock.searchy(Inventory.manStock.getRoot(),Integer.parseInt(priceTxt.getText()) ,
							cmbSize.getItemAt(cmbSize.getSelectedIndex()), cmbType.getItemAt(cmbType.getSelectedIndex()), 
							cmbBrand.getItemAt(cmbBrand.getSelectedIndex()));
					
					
					 
					 Node temp=(Inventory.manStock.getFoundShoes().getFirst());
					while( temp!=null) {
						d.addElement(temp.getTreeNode().getShoes().toString());
						
						temp=temp.getNext();
					}
					
					if(Inventory.manStock.getFoundShoes().isEmpty()) {
						System.out.println("There is no maching found");
						JOptionPane.showMessageDialog(new JFrame(), "There is no maching found!", "", JOptionPane.WARNING_MESSAGE);
					}
					else {
					Inventory.manStock.getFoundShoes().outputList();
					}
					
				}
			}
		if(e.getSource() == btnAddToTheShoppingList) {
			//Shoes shoes= new Shoes(Integer.parseInt(priceTxt.getText()),cmbSize.getItemAt(cmbSize.getSelectedIndex()) ,cmbType.getItemAt(cmbType.getSelectedIndex()),
			//		cmbBrand.getItemAt(cmbBrand.getSelectedIndex()),cmbColor.getItemAt(cmbColor.getSelectedIndex()),
			//		cmbItem.getItemAt(cmbItem.getSelectedIndex()));
			
			
//	String item = "(" + gender((Gender) cmbItem.getSelectedItem()) + ") " + 
	//		cmbType.getSelectedItem() + " - Brand: " + cmbBrand.getSelectedItem() + " - '" + cmbColor.getSelectedItem() + "' - size: " + cmbSize.getSelectedItem() +
	//		" - price: $" + priceTxt.getText() + " -quantity:"+ quantityTxt.getText();		
			if(!l.isSelectionEmpty()) {
				//String itemsToDel = l.getSelectedValues().length > 1 ? l.getSelectedValues().toString() : l.getSelectedValue();
				String itemToDelete = l.getSelectedValue();
				//d.removeElement(itemToDelete);
				
				if(cmbItem.getSelectedItem().equals(Gender.WOMAN)) {                             //the chosen treeNode will be added to the LinkedList how?
					//inventory.womanStock.delete(shoes);                                        //the chose's some prosperitys will be added to the search button like search(int price)
					//inventory.womanStock.inorder(inventory.womanStock.getRoot());              //we we will search them in the tree and find them after that 
					                                                                               //add them to a link list
					
					 
					 
					 qquantity = JOptionPane.showInputDialog(new JFrame(), "Enter Quantity", "", JOptionPane.PLAIN_MESSAGE);
						Node temp1=(Inventory.womanStock.getFoundShoes().getFirst());
						while(temp1!=null) {
							if(itemToDelete.contains(temp1.getTreeNode().getShoes().toString())&& temp1.getTreeNode().getShoes().getQuantity()>=Integer.parseInt(qquantity)) {
								temp1.getTreeNode().getShoes().setBuyedquantity(Integer.parseInt(qquantity));
								//inventory.manStock.getShoppingList().insertAtFront(temp.getTreeNode());
							}
							
							else {
								while(itemToDelete.contains(temp1.getTreeNode().getShoes().toString()) && temp1.getTreeNode().getShoes().getQuantity()<Integer.parseInt(qquantity)) {
									JOptionPane.showMessageDialog(new JFrame(), "There is no enough shoes please enter an another quantity!", "", JOptionPane.WARNING_MESSAGE);
								 qquantity = JOptionPane.showInputDialog(new JFrame(), "Enter Quantity", "", JOptionPane.PLAIN_MESSAGE);
								}
							}
							temp1=temp1.getNext();
						
						
						}
						System.out.println(qquantity);
						
						Node temp=(Inventory.womanStock.getFoundShoes().getFirst());
						while(temp!=null) {
							if(itemToDelete.contains(temp.getTreeNode().getShoes().toString())) {
								ShoeDisplayPage.shoppingList.insertAtFront(temp.getTreeNode());
								//inventory.womanStock.insertAtFront(temp.getTreeNode());
							}
							temp=temp.getNext();
						}
					 System.out.println("-----------------------");
					 ShoeDisplayPage.shoppingList.outputList();
					 //inventory.womanStock.getShoppingList().outputList();
				}                                                                                
				
				                                                                                  
				else {
					//manStock.delete(shoes);
					//Inventory.manStock.inorder(Inventory.manStock.getRoot());
					
					
				 
				 qquantity = JOptionPane.showInputDialog(new JFrame(), "Enter Quantity", "", JOptionPane.PLAIN_MESSAGE);
					Node temp2=(Inventory.manStock.getFoundShoes().getFirst());
					while(temp2!=null) {
						if(itemToDelete.contains(temp2.getTreeNode().getShoes().toString()) && temp2.getTreeNode().getShoes().getQuantity()>=Integer.parseInt(qquantity) ) {
							temp2.getTreeNode().getShoes().setBuyedquantity(Integer.parseInt(qquantity));
							//inventory.manStock.getShoppingList().insertAtFront(temp.getTreeNode());
							
						}
						else {
							while(itemToDelete.contains(temp2.getTreeNode().getShoes().toString()) && temp2.getTreeNode().getShoes().getQuantity()<Integer.parseInt(qquantity)) {
								JOptionPane.showMessageDialog(new JFrame(), "There is no enough shoes please enter an another quantity!", "", JOptionPane.WARNING_MESSAGE);
							 qquantity = JOptionPane.showInputDialog(new JFrame(), "Enter Quantity", "", JOptionPane.PLAIN_MESSAGE);
							}
						}
						
						
						temp2=temp2.getNext();
						
					}
					System.out.println(qquantity);
					
					Node temp=(Inventory.manStock.getFoundShoes().getFirst());
					while(temp!=null) {
						if(itemToDelete.contains(temp.getTreeNode().getShoes().toString())) {
							ShoeDisplayPage.shoppingList.insertAtFront(temp.getTreeNode());
							//inventory.manStock.getShoppingList().insertAtFront(temp.getTreeNode());
						}
						temp=temp.getNext();
					}
				 System.out.println("-----------------------");
				 ShoeDisplayPage.shoppingList.outputList();
				 //inventory.manStock.getShoppingList().outputList();
				}
				
				
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(), "Nothing is selected from the inventory!", "", JOptionPane.WARNING_MESSAGE);
			}
			
			
			
		}
		
		if(e.getSource()==btngoMainPage ) {
			new OnlineShoeShop().setVisible(true);
			setVisible(false);                          
		}
		
	}

	

	

}
