package GUIDesign;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Data.Gender;
import Data.Node;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class ShoppingCart extends JFrame implements ActionListener {
	Inventory inventory = new Inventory();
	DefaultListModel<String> d = new DefaultListModel<String>();
	JList<String> l = new JList<String>(d);
	JScrollPane sp = new JScrollPane(l);
	
	JButton goBackBtn = new JButton("Go Back");
	JButton deleteBtn = new JButton("Delete Item");
	JButton endBtn = new JButton("End Purchase");
	
	public ShoppingCart() {
		super("Shopping Cart");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel backPnl = new JPanel();
		backPnl.setLayout(new FlowLayout());
		backPnl.add(goBackBtn); add(new JPanel());
		
		add(backPnl, BorderLayout.BEFORE_LINE_BEGINS);
		add(sp, BorderLayout.CENTER);
		
		JPanel btnPnl = new JPanel();
		btnPnl.setLayout(new GridLayout(2,1));
		btnPnl.add(componentPanel(deleteBtn));
		btnPnl.add(componentPanel(endBtn));
		
		add(btnPnl, BorderLayout.SOUTH);
		
		pack();
		
		Node temp=(ShoeDisplayPage.getShoppingList().getFirst());
		while (temp!=null) {
		
			d.addElement(temp.getTreeNode().getShoes().toString());
			temp=temp.getNext();
			
		}
		deleteBtn.addActionListener(this);
		endBtn.addActionListener(this);
		goBackBtn.addActionListener(this);
	}
	
	public JPanel componentPanel(Component comp) {
		JPanel stg = new JPanel();
		stg.setLayout(new BorderLayout());
		stg.add(comp, BorderLayout.LINE_END);
		return stg;
	}
	
	public static void main(String[] args) {
		new ShoppingCart().setVisible(true);
	}
		
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == goBackBtn) {
			OnlineShoeShop account = new OnlineShoeShop();
			account.loginBtn.setName("Profile");
			account.isLoggedIn = true;
			account.setVisible(true);
			setVisible(false);
		}
		if(e.getSource() == deleteBtn && !l.isSelectionEmpty()) {
			
				//String itemsToDel = l.getSelectedValues().length > 1 ? l.getSelectedValues().toString() : l.getSelectedValue();
				String itemToDelete = l.getSelectedValue();
				//d.removeElement(itemToDelete);
				
			          
					                                                                             
				              Node temp=(ShoeDisplayPage.getShoppingList().getFirst());
						while(temp!=null) {
							if(itemToDelete.contains(temp.getTreeNode().getShoes().toString())) {
								ShoeDisplayPage.getShoppingList().removeTheShoes(temp.getTreeNode());
								//inventory.womanStock.insertAtFront(temp.getTreeNode());
							}
							temp=temp.getNext();
						}
					 System.out.println("-----------------------");
					 ShoeDisplayPage.getShoppingList().outputList();
					 //inventory.womanStock.getShoppingList().outputList();
					 
					 d.removeElement(l.getSelectedValue());
					
				}                                                                                
				
			
	


		if(e.getSource() == endBtn) {
			
				//String itemsToDel = l.getSelectedValues().length > 1 ? l.getSelectedValues().toString() : l.getSelectedValue();
				
				//d.removeElement(itemToDelete);
				
				                            //the chosen treeNode will be added to the LinkedList how?
					//inventory.womanStock.delete(shoes);                                        //the chose's some prosperitys will be added to the search button like search(int price)
					//inventory.womanStock.inorder(inventory.womanStock.getRoot());              //we we will search them in the tree and find them after that 
					                                                                               //add them to a link list
					Node temp=(ShoeDisplayPage.getShoppingList().getFirst());
						while(temp!=null) {
							
								ShoeDisplayPage.getShoppingList().buyShoes(temp.getTreeNode().getShoes());
								
							    if(temp.getTreeNode().getShoes().getQuantity()==0) {
							    	if(temp.getTreeNode().getShoes().getGender()==Gender.WOMAN) {
							    		inventory.womanStock.delete(temp.getTreeNode().getShoes());
							    	}
							    	else
							    	{
							    		inventory.manStock.delete(temp.getTreeNode().getShoes());
							    	}
							    }
							    	
								
								//inventory.womanStock.insertAtFront(temp.getTreeNode());
							    temp=temp.getNext();
							
						}
						
						
						 ShoeDisplayPage.getShoppingList().outputList();
						ShoeDisplayPage.getShoppingList().setNull();
						d.removeAllElements();
						
						
					 System.out.println("-----------------------");
					 System.out.println("Shopping List:");
					 ShoeDisplayPage.getShoppingList().outputList();
					 System.out.println("-----------------------");
					 System.out.println("Woman Stock");
					 inventory.womanStock.inorder(Inventory.womanStock.getRoot());
					 System.out.println("Man Stock");
					 inventory.manStock.inorder(Inventory.manStock.getRoot());
					 JOptionPane.showMessageDialog(new JFrame(), "Your purchase is made!\nThanks for choosing to shop with us! :)", "", JOptionPane.INFORMATION_MESSAGE);
					
				}                                                                                
				
				                                                                                  
				
				}
}
				
			
			
			
			
			
		
		
	
	


