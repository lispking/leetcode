package hot_100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
public class c1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = hashTable.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }

    @Test
    public void test_000() {
        int[] nums = {2, 7, 11, 15};
        Assert.assertEquals(new int[]{0, 1}, twoSum(nums, 9));
    }

    @Test
    public void test_001() {
        int[] nums = {3, 2, 4};
        Assert.assertEquals(new int[]{1, 2}, twoSum(nums, 6));
    }

    @Test
    public void test_002() {
        int[] nums = {3, 3};
        Assert.assertEquals(new int[]{0, 1}, twoSum(nums, 6));
    }

    @Test
    public void test_003() {
        int[] nums = {-3, 4, 3, 9};
        Assert.assertEquals(new int[]{0, 2}, twoSum(nums, 0));
    }
}
