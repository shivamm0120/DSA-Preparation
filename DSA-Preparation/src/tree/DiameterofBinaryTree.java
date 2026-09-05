package tree;

public class DiameterofBinaryTree {
	 int maxDiam=0;
	    public int diameterOfBinaryTree(TreeNode root) {
	        height(root);
	        return maxDiam;
	    }
	    public int height(TreeNode root){
	        
	        if(root==null)return 0;
	        int left=height(root.left);
	        int right=height(root.right);
	        if(left+right>maxDiam)maxDiam=left+right;

	        return Math.max(left,right)+1;
	    }

}
