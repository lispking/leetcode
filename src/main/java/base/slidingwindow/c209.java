package base.slidingwindow;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */
public class c209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = nums.length + 1, window = 0, low = 0, high = 0;
        while (high < nums.length) {
            window += nums[high++];
            while (window >= target) {
                min = Math.min(min, high - low);
                window -= nums[low++];
            }
        }
        return (min == nums.length + 1) ? 0 : min;
    }

    public static void main(String[] args) {
        c209 instance = new c209();

        {
            int target = 7;
            int[] nums = {2, 3, 1, 2, 4, 3};
            System.out.println(instance.minSubArrayLen(target, nums));
        }

        {
            int target = 4;
            int[] nums = {1, 4, 4};
            System.out.println(instance.minSubArrayLen(target, nums));
        }

        {
            int target = 11;
            int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
            System.out.println(instance.minSubArrayLen(target, nums));
        }
    }
}
