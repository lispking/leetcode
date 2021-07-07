package base.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class c215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, (a, b) -> b - a);
        for (int num : nums) {
            maxHeap.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i ++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i ++) {
            Integer topElement = minHeap.peek();
            if (nums[i] > topElement) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        c215 instance = new c215();

        {
            int[] nums = {3,2,1,5,6,4};
            int k = 2;
            System.out.println(instance.findKthLargest(nums, k));
        }

        {
            int[] nums = {3,2,3,1,2,4,5,5,6};
            int k = 4;
            System.out.println(instance.findKthLargest(nums, k));
        }
    }
}
