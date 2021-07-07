package base.hashtable;

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 */
public class c389 {
    public char findTheDifference(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret ^= s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }

    public char findTheDifference2(String s, String t) {
        int[] hashtable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            hashtable[index]--;
        }

        for (int j = 0; j < t.length(); j++) {
            int index = t.charAt(j) - 'a';
            hashtable[index]++;
        }

        for (int k = 0; k < hashtable.length; k++) {
            if (hashtable[k] == 1) {
                return (char) (k + 'a');
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        c389 instance = new c389();

        {
            String s = "abcd", t = "abcde";
            System.out.println(instance.findTheDifference(s, t));
        }

        {
            String s = "", t = "y";
            System.out.println(instance.findTheDifference(s, t));
        }

        {
            String s = "a", t = "aa";
            System.out.println(instance.findTheDifference(s, t));
        }

        {
            String s = "ae", t = "aea";
            System.out.println(instance.findTheDifference(s, t));
        }
    }
}
