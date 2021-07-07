package base.dfs;

import java.util.LinkedList;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class c200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        LinkedList<Grid> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    queue.offer(new Grid(i, j));
                    grid[i][j] = '0';

                    bfs(grid, queue, row, col);
                }
            }
        }
        return result;
    }

    public void bfs(char[][] grid, LinkedList<Grid> queue, int row, int col) {
        while (queue.size() > 0) {
            Grid curr = queue.pop();
            if (curr.x - 1 >= 0 && grid[curr.x - 1][curr.y] == '1') {
                queue.offer(new Grid(curr.x - 1, curr.y));
                grid[curr.x - 1][curr.y] = '0';
            }
            if (curr.x + 1 < row && grid[curr.x + 1][curr.y] == '1') {
                queue.offer(new Grid(curr.x + 1, curr.y));
                grid[curr.x + 1][curr.y] = '0';
            }
            if (curr.y - 1 >= 0 && grid[curr.x][curr.y - 1] == '1') {
                queue.offer(new Grid(curr.x, curr.y - 1));
                grid[curr.x][curr.y - 1] = '0';
            }
            if (curr.y + 1 < col && grid[curr.x][curr.y + 1] == '1') {
                queue.offer(new Grid(curr.x, curr.y + 1));
                grid[curr.x][curr.y + 1] = '0';
            }
        }
    }

    static class Grid {
        public int x;
        public int y;

        Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int x, int y, int row, int col) {
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x - 1, y, row, col);
        dfs(grid, x + 1, y, row, col);
        dfs(grid, x, y - 1, row, col);
        dfs(grid, x, y + 1, row, col);
    }

    public static void main(String[] args) {
        c200 instance = new c200();

        {
            char[][] grid = {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
            };
            System.out.println(instance.numIslands(grid));
        }

        {
            char[][] grid = {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}
            };
            System.out.println(instance.numIslands(grid));
        }
    }
}
