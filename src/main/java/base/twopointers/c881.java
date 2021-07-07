package base.twopointers;

import java.util.Arrays;

/**
 * 881. 救生艇
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 * <p>
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 * <p>
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * 提示：
 * <p>
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 */
public class c881 {
    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }

        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;
        int res = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        c881 instance = new c881();

        {
            int[] people = {1, 2};
            int limit = 3;
            System.out.println(instance.numRescueBoats(people, limit));
        }

        {
            int[] people = {3, 2, 2, 1};
            int limit = 3;
            System.out.println(instance.numRescueBoats(people, limit));
        }

        {
            int[] people = {3, 5, 3, 4};
            int limit = 5;
            System.out.println(instance.numRescueBoats(people, limit));
        }
    }
}
