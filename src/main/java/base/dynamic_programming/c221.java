package base.dynamic_programming;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * https://assets.leetcode.com/uploads/2020/11/26/max1grid.jpg
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 * https://assets.leetcode.com/uploads/2020/11/26/max2grid.jpg
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 */
public class c221 {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (matrix[x][y] == '1') {
                    if (x == 0 || y == 0) {
                        dp[x][y] = 1;
                    } else {
                        dp[x][y] = Math.min(Math.min(dp[x - 1][y], dp[x][y - 1]), dp[x - 1][y - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[x][y]);
                }
            }
        }
        return maxSide * maxSide;
    }

    @Test
    public void test_000() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        Assert.assertEquals(4, maximalSquare(matrix));
    }

    @Test
    public void test_001() {
        char[][] matrix = {
                {'0', '1'},
                {'1', '0'}
        };
        Assert.assertEquals(1, maximalSquare(matrix));
    }

    @Test
    public void test_002() {
        char[][] matrix = {{'0'}};
        Assert.assertEquals(0, maximalSquare(matrix));
    }
}