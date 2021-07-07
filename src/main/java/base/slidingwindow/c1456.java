package base.slidingwindow;

/**
 * 1456. 定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 * <p>
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * <p>
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 * <p>
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 * <p>
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 * <p>
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 * <p>
 * 输入：s = "tryhard", k = 4
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 */
public class c1456 {
    public int maxVowels(String s, int k) {
        if (s == null || s.isEmpty() || s.length() < k) {
            return 0;
        }

        int vowelCnt = 0;
        for (int i = 0; i < k; i++) {
            vowelCnt += isVowel(s.charAt(i));
        }

        int window = vowelCnt;
        for (int i = k; i < s.length(); i++) {
            vowelCnt += isVowel(s.charAt(i)) - isVowel(s.charAt(i - k));
            window = Math.max(window, vowelCnt);
        }
        return window;
    }

    public int isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ? 1 : 0;
    }

    public static void main(String[] args) {
        c1456 instance = new c1456();

        {
            String s = "abciiidef";
            int k = 3;
            System.out.println(instance.maxVowels(s, k));
        }

        {
            String s = "aeiou";
            int k = 2;
            System.out.println(instance.maxVowels(s, k));
        }

        {
            String s = "leetcode";
            int k = 3;
            System.out.println(instance.maxVowels(s, k));
        }

        {
            String s = "rhythms";
            int k = 4;
            System.out.println(instance.maxVowels(s, k));
        }

        {
            String s = "tryhard";
            int k = 4;
            System.out.println(instance.maxVowels(s, k));
        }
    }
}
