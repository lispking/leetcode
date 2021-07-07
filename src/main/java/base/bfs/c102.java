package base.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class c102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        dfs(root, result, 0);
        return result;
    }

    public void dfs(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }

        if (level > result.size() - 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        if (node.left != null) {
            dfs(node.left, result, level + 1);
        }

        if (node.right != null) {
            dfs(node.right, result, level + 1);
        }
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size > 0) {
                TreeNode current = queue.pop();
                temp.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
                size --;
            }
            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        c102 instance = new c102();

        {
            TreeNode root = new TreeNode(3);
            TreeNode left = new TreeNode(9);
            TreeNode right = new TreeNode(20);
            root.left = left;
            root.right = right;
            right.left = new TreeNode(15);
            right.right = new TreeNode(7);

            System.out.println(instance.levelOrder(root));
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

            System.out.println(instance.levelOrder(root));
        }
    }
}
