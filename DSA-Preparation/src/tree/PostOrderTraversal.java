package tree;

public class PostOrderTraversal {
	public static void main(String[] args) {
		//creating my own tree 
		TreeNode root= new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
				
		root.left.left= new TreeNode(4);
		root.left.right=new TreeNode(5);
		
		postorder(root);
				
		
	}
	static void postorder(TreeNode root) {
		if(root==null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.val);
		
	}

}
