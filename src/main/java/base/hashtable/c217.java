package base.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class c217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Map<Integer, Boolean> array2map = new HashMap<>();
        for (int num: nums) {
            if (array2map.containsKey(num)) {
                return true;
            }

            array2map.put(num, true);
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }

    public static void main(String[] args) {
        c217 instance = new c217();
        {
            int[] nums = {1,2,3,1};
            System.out.println(instance.containsDuplicate(nums));
        }

        {
            int[] nums = {1,2,3,4};
            System.out.println(instance.containsDuplicate(nums));
        }

        {
            int[] nums = {1,1,1,3,3,4,3,2,4,2};
            System.out.println(instance.containsDuplicate(nums));
        }

    }
}
