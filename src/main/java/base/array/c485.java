package base.array;

/**
 * 485. 最大连续 1 的个数
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 *
 * 提示：
 *
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class c485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int result = 0;

        for (int num: nums) {
            if (num == 1) {
                count ++;
            } else {
                result = Math.max(count, result);
                count = 0;
            }
        }
        return Math.max(count, result);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        c485 instance = new c485();
        int maxCount = instance.findMaxConsecutiveOnes(nums);
        System.out.println(maxCount);
    }
}
