package tree;

public class PreOrderTraversal {
	public static void main(String[] args) {
		//creating my own tree 
		TreeNode root= new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
				
		root.left.left= new TreeNode(4);
		root.left.right=new TreeNode(5);
		
		preorder(root);
				
		
	}
	static void preorder(TreeNode root) {
		if(root==null)
			return;
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
		
	}
	

}
