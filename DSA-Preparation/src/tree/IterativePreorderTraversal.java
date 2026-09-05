package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreorderTraversal {
	public static void main(String[] args) {
		TreeNode root= new TreeNode();
		root.val=1;
		TreeNode l1=root.left=new TreeNode();
		TreeNode r1=root.right=new TreeNode();
		
		l1.val=2;
		r1.val=3;
		
		l1.left=new TreeNode();
		l1.left.val=4;
		
		l1.right=new TreeNode();
		l1.right.val=5;
		
		r1.left=new TreeNode();
		r1.left.val=6;
		
		List<Integer>preorder=new ArrayList<>();
		
		Stack<TreeNode>stack= new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node=stack.pop();
			preorder.add(node.val);
			
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
		System.out.println(preorder);
		
	}

}
