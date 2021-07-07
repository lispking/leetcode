package base.dfs;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * https://assets.leetcode.com/uploads/2020/11/05/bst1.jpg
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 * https://assets.leetcode.com/uploads/2020/11/05/bst2.jpg
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 */

import java.util.LinkedList;

/**
 * Definition for a binary base.tree node.D
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class c938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
//        return base.bfs(root, low, high);
        return dfs(root, low, high);
    }

    public int dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int leftSum = dfs(root.left, low, high);
        int rightSum = dfs(root.right, low, high);
        int result = leftSum + rightSum;
        if (root.val >= low && root.val <= high) {
            result += root.val;
        }
        return result;
    }

    public int bfs(TreeNode root, int low, int high) {
        int result = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode curr = queue.pop();
                if (curr.val >= low && curr.val <= high) {
                    result += curr.val;
                }

                if (curr.left != null) {
                    queue.push(curr.left);
                }

                if (curr.right != null) {
                    queue.push(curr.right);
                }
                size --;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        c938 instance = new c938();
        {
            TreeNode root = new TreeNode(10);
            TreeNode left = new TreeNode(5);
            TreeNode right = new TreeNode(15);
            root.left = left;
            root.right = right;
            left.left = new TreeNode(3);
            left.right = new TreeNode(7);
            right.right = new TreeNode(18);
            int low = 7, high = 15;
            System.out.println(instance.rangeSumBST(root, low, high));
        }
    }
}
