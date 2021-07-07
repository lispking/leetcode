package base.greedy;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class c322 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }

        if (rem == 0) {
            return 0;
        }

        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public void assertEqual(int[] coins, int amount, int actual) {
        int min = coinChange(coins, amount);
        if (actual == min) {
            System.out.println(Arrays.toString(coins) + " " + amount + " is ok.");
        } else {
            System.out.println(Arrays.toString(coins) + " " + amount + " is NOT ok." + min);
        }
    }

    public static void main(String[] args) {
        c322 instance = new c322();

        {
            int[] coins = {1, 2, 5};
            int amount = 11;
            instance.assertEqual(coins, amount, 3);
        }

        {
            int[] coins = {2};
            int amount = 3;
            instance.assertEqual(coins, amount, -1);
        }

        {
            int[] coins = {1};
            int amount = 0;
            instance.assertEqual(coins, amount, 0);
        }

        {
            int[] coins = {1};
            int amount = 1;
            instance.assertEqual(coins, amount, 1);
        }

        {
            int[] coins = {1};
            int amount = 2;
            instance.assertEqual(coins, amount, 2);
        }
    }
}
