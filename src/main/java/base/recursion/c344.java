package base.recursion;

/**
 * 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class c344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        for(int low = 0, high = s.length -1; low < high; low ++, high --) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
        }
    }

    public void reverseString2(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        reverseString(s, 0, s.length - 1);
    }

    public void reverseString(char[] s, int low, int high) {
        if (low >= high) {
            return;
        }

        reverseString(s, low + 1, high - 1);
        char temp = s[low];
        s[low] = s[high];
        s[high] = temp;
    }

    public static void main(String[] args) {
        c344 instance = new c344();

        {
            char[] s = {'h', 'e', 'l', 'l', 'o'};
            instance.reverseString(s);
            System.out.println(s);
        }

        {
            char[] s = {'l', 'e', 'e', 't', 'c', 'o', 'd', 'e'};
            instance.reverseString(s);
            System.out.println(s);
        }

        {
            char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
            instance.reverseString(s);
            System.out.println(s);
        }
    }
}
