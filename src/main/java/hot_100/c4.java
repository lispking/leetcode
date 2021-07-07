package hot_100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class c4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 1 && len2 == 0) {
            return nums1[0];
        }

        if (len1 == 0 && len2 == 1) {
            return nums2[0];
        }

        int[] ans = new int[len1 + len2];
        System.arraycopy(nums1, 0, ans, 0, len1);
        System.arraycopy(nums2, 0, ans, len1, len2);
        Arrays.sort(ans);
        if (ans.length % 2 == 0) {
            return (ans[ans.length / 2 - 1] + ans[ans.length / 2]) / 2.0;
        }
        return ans[ans.length / 2];
    }

    @Test
    public void test_000() {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        Assert.assertEquals(2.5, findMedianSortedArrays(num1, num2));
    }

    @Test
    public void test_001() {
        int[] num1 = {1, 3};
        int[] num2 = {2};
        Assert.assertEquals(2, findMedianSortedArrays(num1, num2));
    }

    @Test
    public void test_002() {
        int[] num1 = {1, 4};
        int[] num2 = {2, 3};
        Assert.assertEquals(2.5, findMedianSortedArrays(num1, num2));
    }
}
