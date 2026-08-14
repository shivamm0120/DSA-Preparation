package tree;

public class HeightOfBinaryTree {
	public static void main(String[] args) {
		//creating my own tree 
		TreeNode root= new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		
		root.left.left= new TreeNode(4);
		root.left.right=new TreeNode(5);
		
		System.out.println("height of this tree is :" + maxHeight(root));
		
		
	}
	static int maxHeight(TreeNode root) {
		if(root==null)
			return 0;
		int left=maxHeight(root.left);
		int right=maxHeight(root.right);
		
		return 1+ Math.max(left,right);
	}

}
