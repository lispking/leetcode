package base.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class c77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n, k, 1, result, new Stack<>());
        return result;
    }

    public void combine(int n, int k, int start, List<List<Integer>> result, Stack<Integer> subset) {
        if (k == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            subset.push(i);
            combine(n, k - 1, i + 1, result, subset);
            subset.pop();
        }
    }

    public static void main(String[] args) {
        c77 instance = new c77();
        System.out.println(instance.combine(4, 2));
    }
}
