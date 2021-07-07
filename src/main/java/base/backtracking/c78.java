package base.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class c78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, 0, new Stack<>());
        return result;
    }

    public void dfs(int[] nums, List<List<Integer>> result, int index, Stack<Integer> subset) {
        result.add(new ArrayList<>(subset));
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            subset.push(nums[i]);
            dfs(nums, result, i + 1, subset);
            subset.pop();
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 1; i <= nums.length; i++) {
            backtracking(nums, result, i, 0, new Stack<>());
        }
        return result;
    }

    public void backtracking(int[] nums, List<List<Integer>> result, int len, int index, Stack<Integer> subset) {
        if (subset.size() == len) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            subset.push(nums[i]);
            backtracking(nums, result, len, i + 1, subset);
            subset.pop();
        }
    }

    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> res : result) {
                List<Integer> copy = new ArrayList<>(res);
                copy.add(num);
                temp.add(copy);
            }
            result.addAll(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        c78 instance = new c78();

        {
            int[] nums = {1, 2, 3};
            System.out.println(instance.subsets(nums));
        }

        {
            int[] nums = {0};
            System.out.println(instance.subsets(nums));
        }

        {
            int[] nums = {1, 2, 3};
            System.out.println(instance.subsets2(nums));
        }
    }
}
