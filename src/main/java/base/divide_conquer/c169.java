package base.divide_conquer;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class c169 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int num : nums) {
            if (candidate == num) {
                count++;
            } else if (--count == 0) {
                candidate = num;
                count = 1;
            }
        }
        return candidate;
    }

    public int majorityElement2(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    public int majorityElement(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int leftElement = majorityElement(nums, left, mid);
        int rightElement = majorityElement(nums, mid + 1, right);

        if (leftElement == rightElement) {
            return leftElement;
        }
        int leftCnt = countInRange(nums, left, right, leftElement);
        int rightCnt = countInRange(nums, left, right, rightElement);
        return (leftCnt > rightCnt) ? leftElement : rightElement;
    }

    public int countInRange(int[] nums, int left, int right, int target) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        c169 instance = new c169();

        {
            int[] nums = {3, 2, 3};
            System.out.println(instance.majorityElement(nums));
        }

        {
            int[] nums = {2, 2, 1, 1, 1, 2, 2};
            System.out.println(instance.majorityElement(nums));
        }

        {
            int[] nums = {8, 9, 8, 9, 8};
            System.out.println(instance.majorityElement(nums));
        }
    }
}
