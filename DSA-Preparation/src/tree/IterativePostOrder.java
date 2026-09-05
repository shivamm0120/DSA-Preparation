package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {
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
		
		List<Integer>postOrder=new ArrayList<>();
		
		Stack<TreeNode>stack= new Stack<>();
		TreeNode node=root,lastVisited=null;
		
		while(true) {
			if(node!=null) {
				stack.push(node);
				node=node.left;
				
			}
			else {
				if(stack.isEmpty())break;
				node=stack.peek();
				
				//if in right there is node and not processed yet
				if(node.right!=null && lastVisited!=node.right) {
					node=node.right;
				}
				//process current node
				else {
					lastVisited=node;//mark current node as last visited node
					System.out.println(stack.pop().val);
					node=null;
					
				}
			}
		}
	}

}

/*using 2 stack
 * ============
 *  Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();

    stack1.push(root);

    while (!stack1.isEmpty()) {

        TreeNode node = stack1.pop();
        stack2.push(node);

        if (node.left != null)
            stack1.push(node.left);

        if (node.right != null)
            stack1.push(node.right);
    }

    while (!stack2.isEmpty()) {

        TreeNode node = stack2.pop();
        result.add(node.val);
    }
 * 
 * 
 */
