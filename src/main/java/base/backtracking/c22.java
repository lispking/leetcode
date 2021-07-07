package base.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 */
public class c22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, result, 0, 0, "");
        return result;
    }

    public void generateParenthesis(int n, List<String> result, int left, int right, String s) {
        if (right > left) {
            return;
        }

        if (left == right && left == n) {
            result.add(s);
            return;
        }

        if (left < n) {
            generateParenthesis(n, result, left + 1, right, s + "(");
        }

        if (right < left) {
            generateParenthesis(n, result, left, right + 1, s + ")");
        }
    }

    public static void main(String[] args) {
        c22 instance = new c22();

        for (int n = 1; n <= 8; n ++) {
            List<String> result = instance.generateParenthesis(n);
            System.out.println(n + ":" + result.size() + ":" + result);
        }
    }
}
