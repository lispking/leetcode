package base.unionfind;

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

        int lands = grid.length;
        int[] root = new int[lands];
        int[] rank = new int[lands];
        for (int i = 0; i < lands; i++) {
            root[i] = i;
            rank[i] = 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                union(root, rank, i, j);
            }
        }

        int result = 0;
        for (int i = 0; i < lands; i++) {
            if (root[i] == i) {
                result++;
            }
        }
        return result;
    }

    public void union(int[] root, int[] rank, int x, int y) {
        int rootX = find(root, x);
        int rootY = find(root, y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = root[rootX];
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = root[rootY];
            } else {
                root[rootY] = root[rootY];
                rank[rootX] += 1;
            }
        }
    }

    public int find(int[] root, int index) {
        if (root[index] != index) {
            root[index] = find(root, root[index]);
        }
        return root[index];
    }

    public static void main(String[] args) {
        base.dfs.c200 instance = new base.dfs.c200();

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
