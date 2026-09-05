package tree;
class MaxPathSum {

    int path = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        findSum(root);

        return path;
    }

    public int findSum(TreeNode root) {

        if (root == null)
            return 0;

        /*
         * Get maximum contribution from left and right subtree.
         *
         * If contribution is negative, don't include it.
         * Hence Math.max(0, contribution).
         */
        int lp = Math.max(0, findSum(root.left));
        int rp = Math.max(0, findSum(root.right));

        /*
         * Complete path through current node:
         *
         *        left
         *          \
         *          root
         *          /
         *       right
         *
         * This path can use BOTH left and right.
         * But this value is only used for the global answer.
         */
        path = Math.max(path, lp + root.val + rp);

        /*
         * Return value to parent:
         *
         * Parent can take only ONE side.
         *
         * We cannot return:
         *     lp + root + rp
         *
         * because then the path would branch.
         */
        return root.val + Math.max(lp, rp);
    }
}

/*/* 
1. `path` = global maximum path anywhere in the tree.

2. `return` = maximum path contribution that can be extended
   to the parent.

3. Global answer can use:
      left + root + right

4. Return to parent can use only:
      root + max(left, right)

5. Negative subtree contribution is ignored:
      Math.max(0, contribution)

6. This is the important Tree DP pattern:
      RETURN → what parent can use
      GLOBAL → what can be the complete answer
*/

