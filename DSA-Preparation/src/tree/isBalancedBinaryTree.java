//You are given the root of a binary tree.
//
//You need to determine whether the tree is height-balanced.
//
//A binary tree is called balanced if, for every node in the tree:
//
//The difference between the height of its left subtree and the height of its right subtree is at most 1.
package tree;

public class isBalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        return check(root)!=-1;
        
    }
    public int check(TreeNode root){
        if(root==null)
        return 0;
        int lh=check(root.left);
        if(lh==-1)return -1;

        int rh=check(root.right);
        if(rh==-1)return -1;
        if(Math.abs(lh-rh)>1)return -1;

        return Math.max(lh,rh)+1;
    }

}
