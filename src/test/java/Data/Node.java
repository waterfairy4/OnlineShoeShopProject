package Data;

public class Node {
 private TreeNode treeNode;
 private Node prev;
 private Node next;
 
 public TreeNode getTreeNode() {
	return treeNode;
}

public void setTreeNode(TreeNode treeNode) {
	this.treeNode = treeNode;
}

public Node getPrev() {
	return prev;
}

public void setPrev(Node prev) {
	this.prev = prev;
}

public Node getNext() {
	return next;
}

public void setNext(Node next) {
	this.next = next;
}

Node(){
	 treeNode=null;
	 next=null;
	 prev=null;
 }
 
 Node(TreeNode treeNode){
	 this.treeNode=treeNode;
	 next=null;
	 prev=null;
 }
 Node(TreeNode treeNode,Node next){
	 this.treeNode=treeNode;
	 this.next=next;
	 prev=null;
 }
 Node(TreeNode treeNode,Node next,Node prev){
	 this.treeNode=treeNode;
	 this.next=next;
	 this.prev=prev;
 }
}
