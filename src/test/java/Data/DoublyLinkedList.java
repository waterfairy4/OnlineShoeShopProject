package Data;



public class DoublyLinkedList {
 private Node first;
 private Node last;
 
 public DoublyLinkedList(){
	 first=last=null;
 }
 
 public boolean isEmpty() {    
	return first==null;
	
 }
 public Node getFirst() {
	return first;
	 
 }
 
 public void insertAtFront(TreeNode treeNode) {
	 Node newItem = new Node(treeNode);
	 if(isEmpty()) {
		 first=last=newItem;
	 }
	 else {
		 newItem.setNext(first);
		 first.setPrev(newItem);
		 first=newItem;
		 
	 }
 }
 
 

public void insertAtBack(TreeNode treeNode) {
	 Node newItem = new Node(treeNode);
	 if(isEmpty()) {
		 first=last=newItem;
	 }
	 else {
	 newItem.setPrev(last);
	 newItem.setNext(null);
	 last.setNext(newItem);
	 last=newItem;
	 }
	 
 }
 
 public boolean removeFromFront() {
	 if(isEmpty()) {
		return false;
	 }
	 else {
		 if(first==last) {
			 first=last=null;
		 }
		 else {
			 first=first.getNext();
		     first.setPrev(null);
			
		 }
	 }
	 return true;
 }
 
 
 public boolean removeTheShoes(TreeNode treeNode){
	 if(isEmpty()){
		 System.out.println("The list is empty!");
	 return false;
	 }
	 
 
 
 else{
	 Node current = first;
	 Node prev= new Node();
	 while(current!=null) {
		 if(current.getTreeNode().equals(treeNode)) {
			 if(current==first) {
			first=current.getNext();
			 return true;
		 }
		 else {
			 prev.setNext(current.getNext());
			 return true;
		 }
		 
		 
	 }
	 prev=current;
	 current=current.getNext();
	 
	 
 }
	 System.out.println(treeNode.getShoes() + "is not in the list!");
	 return false;
 }
	 
	 
}
	 
			
 
 
 public boolean removeFromBack() {
	 if(isEmpty()) {
			return false;
		 }
	
	 else {
		 if(first==last) {
			 first=last=null;
		 }
		 else {
			 last=last.getPrev();
		     last.setNext(null);
			
		 }
	 }
	
	 return true;
 }
 
 public void outputList() {
	 Node temp=first;
	 while(temp!=null) {
		 System.out.println(temp.getTreeNode().getShoes().toString());
		 temp=temp.getNext();
	 }
 }
 
public void outputListBackward() {
	 Node temp = last;
	 while(temp!=null) {
		 System.out.println(temp.getTreeNode().getShoes().toString());
		 temp=temp.getPrev();
	 }
 }





public void buyShoes(Shoes shoes) {
	DoublyLinkedList list =this;
	Node temp=first;
	while(temp!=null) {
		if(shoes.equals(temp.getTreeNode().getShoes())) {
        temp.getTreeNode().getShoes().buyShoes(temp.getTreeNode().getShoes(),temp.getTreeNode().getShoes().getBuyedquantity() );
		}
		temp=temp.getNext();
	}
}

public void setNull() {
	 first=null;
}

 
 
 
 
}
