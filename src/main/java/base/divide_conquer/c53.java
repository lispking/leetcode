package base.divide_conquer;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 * <p>
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class c53 {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    public int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int leftMax = maxSubArray(nums, left, mid);
        int rightMax = maxSubArray(nums, mid + 1, right);
        int crossMax = crossMaxSubArray(nums, left, mid, right);
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    public int crossMaxSubArray(int[] nums, int left, int mid, int right) {
        int leftSum = nums[mid];
        int leftMax = leftSum;
        for (int i = mid - 1; i >= left; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightSum = nums[mid + 1];
        int rightMax = rightSum;
        for (int i = mid + 2; i <= right; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }
        return leftMax + rightMax;
    }

    public static void main(String[] args) {
        c53 instance = new c53();

        {
            int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            System.out.println(instance.maxSubArray(nums));
        }

        {
            int[] nums = {5, 4, -1, 7, 8};
            System.out.println(instance.maxSubArray(nums));
        }
    }
}
