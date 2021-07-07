package base.dynamic_programming;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 */
public class c62 {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int y = 0; y < n; y++) {
            dp[0][y] = 1;
        }

        for (int x = 0; x < m; x++) {
            dp[x][0] = 1;
        }

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
//                System.out.println("dp[" + x + "][" + y + "]=" + dp[x][y]);
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test_000() {
        Assert.assertEquals(28, uniquePaths(7, 3));
        Assert.assertEquals(6, uniquePaths(3, 3));
    }
}
