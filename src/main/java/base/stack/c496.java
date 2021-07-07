package base.stack;

import java.util.*;

/**
 * 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * <p>
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 */
public class c496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先处理 nums2，把对应关系存入哈希表
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // 遍历 nums1 得到结果集
        int len1 = nums1.length;
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return null;
        }

        int[] result = new int[nums1.length];
        int index = 0;

        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            stack.push(num);
        }

        for (int num : nums1) {
            Stack<Integer> temp = new Stack<>();
            boolean isFound = false;
            int max = -1;
            while (!isFound && !stack.isEmpty()) {
                int top = stack.pop();
                if (top > num) {
                    max = top;
                } else if (top == num) {
                    isFound = true;
                }
                temp.push(top);
            }
            result[index++] = max;

            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        c496 instance = new c496();
        {
            int[] num1 = {4, 1, 2};
            int[] num2 = {1, 3, 4, 2};
            System.out.println(Arrays.toString(instance.nextGreaterElement(num1, num2)));
        }

        {
            int[] num1 = {2, 4};
            int[] num2 = {1, 2, 3, 4};
            System.out.println(Arrays.toString(instance.nextGreaterElement(num1, num2)));
        }
    }
}
