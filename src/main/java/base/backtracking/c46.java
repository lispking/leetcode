package base.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class c46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num: nums) {
            output.add(num);
        }
        permute(nums.length, output, result, 0);
        return result;
    }

    public void permute(int n, List<Integer> output, List<List<Integer>> result, int index) {
        if (index == n) {
            result.add(new ArrayList<>(output));
            return;
        }

        for (int i = index; i < n; i++) {
            Collections.swap(output, index, i);
            permute(n, output, result, index + 1);
            Collections.swap(output, index, i);
        }
    }

    public static void main(String[] args) {
        c46 instance = new c46();

        {
            int[] nums = {1, 2, 3};
            System.out.println(instance.permute(nums));
        }

        {
            int[] nums = {0, 1};
            System.out.println(instance.permute(nums));
        }

        {
            int[] nums = {1};
            System.out.println(instance.permute(nums));
        }
    }
}
