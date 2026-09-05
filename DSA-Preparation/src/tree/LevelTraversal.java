package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal {
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
		
		
		Queue<TreeNode>queue= new LinkedList<>();
		List<List<Integer>>level=new LinkedList<>();
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			List<Integer>sublist=new LinkedList<>();
			for(int i=1;i<=size;i++) {
				if(queue.peek().left!=null)
					queue.offer(queue.peek().left);
				if(queue.peek().right!=null)
					queue.offer(queue.peek().right);
				sublist.add(queue.poll().val);
				
			}
			level.add(sublist);
			
		}
		System.out.println(level);
	}

}
