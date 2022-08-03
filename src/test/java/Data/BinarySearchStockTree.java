package Data;

public class BinarySearchStockTree {
private TreeNode root;
private int size;
private  static final DoublyLinkedList foundShoes = new DoublyLinkedList();

//public static DoublyLinkedList getShoppingList() {
//	return shoppingList;
//}





//private static final DoublyLinkedList shoppingList=new DoublyLinkedList();
public  DoublyLinkedList getFoundShoes() {
	return foundShoes;
}


public BinarySearchStockTree(){
	root=null;
	size=0;
}

private TreeNode createNewNode(Shoes shoes ) {
	return new TreeNode(shoes);
}

public TreeNode getRoot() {
	return root;
}

public void setRoot(TreeNode root) {
	this.root = root;
}

public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}


public boolean insert(Shoes shoes) {
	
	
	if(root==null)
		root=createNewNode(shoes); //create a new root 
	else {
		TreeNode parent = null;
		TreeNode current=root;

		while(current!=null) {
		      
			if(shoes.getPrice()<current.getShoes().getPrice()) {
				parent=current;
				current=current.getLeft();
			}
			else if(shoes.getPrice()==current.getShoes().getPrice()) {
				if(shoes.getSize()<current.getShoes().getSize()) {
					parent=current;
					current=current.getLeft();
				}
				else if(shoes.getSize()==current.getShoes().getSize()) {
					if(shoes.getType().compareTo(current.getShoes().getType())<0){
						parent=current;
						current=current.getLeft();
					}
					else if(shoes.getType().compareTo(current.getShoes().getType())==0){
						if(shoes.getBrand().compareTo(current.getShoes().getBrand())<0){
							parent=current;
							current=current.getLeft();
						}
						else if(shoes.getBrand().compareTo(current.getShoes().getBrand())==0){
							if(shoes.getColor().compareTo(current.getShoes().getColor())<0){
								parent=current;
								current=current.getLeft();
							}
							else if (shoes.getColor().compareTo(current.getShoes().getColor())==0){
								System.out.println("These shoes are already in the stock");
								return false;
							}
							else if(shoes.getColor().compareTo(current.getShoes().getColor())>0) {
								parent=current;
								current=current.getRight();
							}
						}
						
						else if(shoes.getBrand().compareTo(current.getShoes().getBrand())>0) {
							parent=current;
							current=current.getRight();
						}
					}
					else if(shoes.getType().compareTo(current.getShoes().getType())>0) {
						parent=current;
						current=current.getRight();
					}
				}
				else if(shoes.getSize()>current.getShoes().getSize()) {
					parent=current;
					current=current.getRight();
				}
			}
			else if(shoes.getPrice()>current.getShoes().getPrice()) {
				parent=current;
				current=current.getRight();
			}
			
			
		
		}
			
		if(shoes.getPrice()<parent.getShoes().getPrice())
			parent.setLeft(createNewNode(shoes));
		else if(shoes.getPrice()==parent.getShoes().getPrice()) {
			if(shoes.getSize()<parent.getShoes().getSize())
				parent.setLeft(createNewNode(shoes));
			else if (shoes.getSize()==parent.getShoes().getSize()) {
				if(shoes.getType().compareTo(parent.getShoes().getType())<0)
					parent.setLeft(createNewNode(shoes));
				else if (shoes.getType().compareTo(parent.getShoes().getType())==0) {
					if(shoes.getBrand().compareTo(parent.getShoes().getBrand())<0)
						parent.setLeft(createNewNode(shoes));
					else if(shoes.getBrand().compareTo(parent.getShoes().getBrand())==0) {
						if(shoes.getColor().compareTo(parent.getShoes().getColor())<0)
							parent.setLeft(createNewNode(shoes));
						else if(shoes.getColor().compareTo(parent.getShoes().getColor())==0)
						     return false;
						else 
							parent.setRight(createNewNode(shoes));
					}
					else 
						parent.setRight(createNewNode(shoes));
				}
				else 
					parent.setRight(createNewNode(shoes));
			}
			else 
				parent.setRight(createNewNode(shoes));
		}
		else 
			parent.setRight(createNewNode(shoes));
		}
			
		
			

	
	
	size++;
	return true;
  	
}




public void searchy(TreeNode root,int price,int size,Typee type) {   
	if (root==null) 
		return;
	searchy(root.getLeft(),price,size,type);
	if(root.getShoes().searchShoes(price,size,type)==true) {
		foundShoes.insertAtFront(root);
		}
	searchy(root.getRight(),price,size,type);
	
}

public void searchy(TreeNode root,int price,int size, Typee type, Brand brand  ,Color color) {   
	if (root==null) 
		return;
	searchy(root.getLeft(),price,size,type,brand,color);
	if(root.getShoes().searchShoes(price,size,type,brand,color)==true) {
		foundShoes.insertAtFront(root);
		}
	searchy(root.getRight(),price,size,type,brand,color);
	
}

public void searchy(TreeNode root,int price,int size,Typee type,Color color) {   
	if (root==null) 
		return;
	searchy(root.getLeft(),price,size,type,color);
	if(root.getShoes().searchShoes(price,size,type,color)==true) {
		foundShoes.insertAtFront(root);
		}
	searchy(root.getRight(),price,size,type,color);
	
}

public void searchy(TreeNode root,int price,int size,Typee type,Brand brand) {   
	if (root==null) 
		return;
	searchy(root.getLeft(),price,size,type,brand);
	if(root.getShoes().searchShoes(price,size,type,brand)==true) {
		foundShoes.insertAtFront(root);
		}
	searchy(root.getRight(),price,size,type,brand);
	
}

public void inorder(TreeNode root ) {
	if (root==null) 
		return;
	postorder(root.getLeft());
	System.out.println(root.getShoes() + " ");
	postorder(root.getRight());
	
}
public void postorder(TreeNode root ) {
	if (root==null) 
		return;
	postorder(root.getLeft());
	postorder(root.getRight());
	System.out.println(root.getShoes() + " ");
}

public void preorder(TreeNode root ) {
	if (root==null) 
		return;
	System.out.println(root.getShoes() + " ");
	preorder(root.getLeft());
	preorder(root.getRight());

}



public Shoes search (int price,int size, Typee type, Brand brand  ,Color color) {
	TreeNode current = root; //start from the root
	while(current!=null) {
		if(price<current.getShoes().getPrice()) {
			current=current.getLeft();
		}
		else if(price==current.getShoes().getPrice()) {
			if(size<current.getShoes().getSize()) {
				
				current=current.getLeft();
			}
			else if(size==current.getShoes().getSize()) {
				if(type.compareTo(current.getShoes().getType())<0){
					
					current=current.getLeft();
				}
				else if(type.compareTo(current.getShoes().getType())==0){
					if(brand.compareTo(current.getShoes().getBrand())<0){
				
						current=current.getLeft();
					}
					else if(brand.compareTo(current.getShoes().getBrand())==0){
						if(color.compareTo(current.getShoes().getColor())<0){
						
							current=current.getLeft();
						}
						else if (color.compareTo(current.getShoes().getColor())==0){
							return current.getShoes();
							
						}
						else if(color.compareTo(current.getShoes().getColor())>0) {
						
							current=current.getRight();
						}
					}
					
					else if(brand.compareTo(current.getShoes().getBrand())>0) {
					
						current=current.getRight();
					}
				}
				else if(type.compareTo(current.getShoes().getType())>0) {
				
					current=current.getRight();
				}
			}
			else if(size>current.getShoes().getSize()) {
			
				current=current.getRight();
			}
		}
		else if(price>current.getShoes().getPrice()) {
		
			current=current.getRight();
		}
		
			
		
	}
	return null;
	
}


public boolean delete(Shoes shoes) {
	//Locate the node to be deleted and also locate its parent node
	TreeNode parent = null;
	TreeNode current = root;
	
	while(current!=null) {
		if(shoes.getPrice()<current.getShoes().getPrice()) {
			parent=current;
			current=current.getLeft();
		}
		else if(shoes.getPrice()==current.getShoes().getPrice()) {
			if(shoes.getSize()<current.getShoes().getSize()) {
				parent=current;
				current=current.getLeft();
			}
			else if(shoes.getSize()==current.getShoes().getSize()) {
				if(shoes.getType().compareTo(current.getShoes().getType())<0){
					parent=current;
					current=current.getLeft();
				}
				else if(shoes.getType().compareTo(current.getShoes().getType())==0){
					if(shoes.getBrand().compareTo(current.getShoes().getBrand())<0){
						parent=current;
						current=current.getLeft();
					}
					else if(shoes.getBrand().compareTo(current.getShoes().getBrand())==0){
						if(shoes.getColor().compareTo(current.getShoes().getColor())<0){
							parent=current;
							current=current.getLeft();
						}
						
						else if(shoes.getColor().compareTo(current.getShoes().getColor())>0) {
							parent=current;
							current=current.getRight();
						}
						else
							break;
					}
					
					else if(shoes.getBrand().compareTo(current.getShoes().getBrand())>0) {
						parent=current;
						current=current.getRight();
					}
					else 
						break;
				}
				else if(shoes.getType().compareTo(current.getShoes().getType())>0) {
					parent=current;
					current=current.getRight();
				}
				else 
					break;
			}
			
			
			
			else if(shoes.getSize()>current.getShoes().getSize()) {
				parent=current;
				current=current.getRight();
			}
			else 
			 break;
		}
		else if(shoes.getPrice()>current.getShoes().getPrice()) {
			parent=current;
			current=current.getRight();
		}
	     
		else
			break;
		//element is in the tree pointed at by current
		
	}
	if(current==null)
	return false; //Element is not in the tree
	
	//Case 1 : current has no left children
	if(current.getLeft()==null) {
		//connect the parent with the right child of the current node
		if(parent==null)
			root=current.getRight();
		else {
			if(shoes.getPrice()<parent.getShoes().getPrice())
				parent.setLeft(current.getRight());
			else if(shoes.getPrice()==parent.getShoes().getPrice()) {
				if(shoes.getSize()<parent.getShoes().getSize())
					parent.setLeft(current.getRight());
				else if (shoes.getSize()==parent.getShoes().getSize()) {
					if(shoes.getType().compareTo(parent.getShoes().getType())<0)
						parent.setLeft(current.getRight());
					else if (shoes.getType().compareTo(parent.getShoes().getType())==0) {
						if(shoes.getBrand().compareTo(parent.getShoes().getBrand())<0)
							parent.setLeft(current.getRight());
						else if(shoes.getBrand().compareTo(parent.getShoes().getBrand())==0) {
							if(shoes.getColor().compareTo(parent.getShoes().getColor())<0)
								parent.setLeft(current.getRight());
							
							else 
								parent.setRight(current.getRight());
						}
						else 
							parent.setRight(current.getRight());
					}
					else 
						parent.setRight(current.getRight());
				}
				else 
					parent.setRight(current.getRight());
			}
			else 
				parent.setRight(current.getRight());
		}
	}
	
	else{
		//Case 2 : The current node has a left child 
				//Locate the rightMost node in the left subtree of the current node and also its parent
				TreeNode parentOfRightMost =current;
				TreeNode rightMost= current.getLeft();
				while(rightMost.getRight()!=null)
				{
					parentOfRightMost =rightMost;
					rightMost= rightMost.getRight(); //Keep going to the right
					
				}
				//replace the element in current by the element in the rightmost
				current.setShoes(rightMost.getShoes());
				//Eliminate rightmost node 
				if(parentOfRightMost.getRight()==rightMost)
					parentOfRightMost.setRight(rightMost.getLeft());
				else //special case : parentOfRightMost = current
					parentOfRightMost.setLeft(rightMost.getLeft());
	}


	size--;
	return true; 
}






}
