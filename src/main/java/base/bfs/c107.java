package base.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层序遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class c107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.pop();
                temp.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.addFirst(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        c107 instance = new c107();

        {
            TreeNode root = new TreeNode(3);
            TreeNode left = new TreeNode(9);
            TreeNode right = new TreeNode(20);
            root.left = left;
            root.right = right;
            right.left = new TreeNode(15);
            right.right = new TreeNode(7);

            System.out.println(instance.levelOrderBottom(root));
        }

        {
            TreeNode root = new TreeNode(3);
            TreeNode left = new TreeNode(9);
            TreeNode right = new TreeNode(20);
            root.left = left;
            root.right = right;
            left.left = new TreeNode(10);
            right.left = new TreeNode(15);
            right.right = new TreeNode(7);

            System.out.println(instance.levelOrderBottom(root));
        }
    }
}
