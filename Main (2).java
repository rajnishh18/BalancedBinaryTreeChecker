class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode node) {
        if (node == null) {
            return 0; // Height of an empty tree is 0
        }

       
        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) {
            return -1; 
        }

        
        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; 
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
       
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        boolean result1 = solution.isBalanced(root1);
        System.out.println(result1); 

        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        boolean result2 = solution.isBalanced(root2);
        System.out.println(result2);

        
        TreeNode root3 = null;
        boolean result3 = solution.isBalanced(root3);
        System.out.println(result3); 
    }
}
