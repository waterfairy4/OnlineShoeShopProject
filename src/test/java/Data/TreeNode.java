package Data;

public class TreeNode {
  private Shoes shoes;
  private TreeNode left;
  private TreeNode right;
  
  public TreeNode(Shoes shoes) {
	  this.shoes = shoes;
	  left = null;
	  right=null;
  }

public Shoes getShoes() {
	return shoes;
}

public void setShoes(Shoes shoes) {
	this.shoes = shoes;
}

public TreeNode getLeft() {
	return left;
}

public void setLeft(TreeNode left) {
	this.left = left;
}

public TreeNode getRight() {
	return right;
}

public void setRight(TreeNode right) {
	this.right = right;
}
}
