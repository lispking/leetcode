package base.trie;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * 720. 词典中最长的单词
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * <p>
 * 若无答案，则返回空字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释：
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * 示例 2：
 * <p>
 * 输入：
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释：
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 */
public class c720 {
    public String longestWord(String[] words) {
        Dict dict = new Dict();
        int index = 0;
        for (String word : words) {
            dict.insert(word, ++index); //indexed by 1
        }
        dict.words = words;
        return dict.dfs();
    }

    @Test
    public void test_000() {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        Assert.assertEquals("world", longestWord(words));
    }

    @Test
    public void test_001() {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Assert.assertEquals("apple", longestWord(words));
    }
}

class Node {
    char c;
    HashMap<Character, Node> children = new HashMap<>();
    int end;

    public Node(char c) {
        this.c = c;
    }
}

class Dict {
    Node root;
    String[] words;

    public Dict() {
        root = new Node('0');
    }

    public void insert(String word, int index) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node(c));
            cur = cur.children.get(c);
        }
        cur.end = index;
    }

    public String dfs() {
        String ans = "";
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node.end > 0 || node == root) {
                if (node != root) {
                    String word = words[node.end - 1];
                    if (word.length() > ans.length() ||
                            word.length() == ans.length() && word.compareTo(ans) < 0) {
                        ans = word;
                    }
                }

                for (Node nei : node.children.values()) {
                    stack.push(nei);
                }
            }
        }
        return ans;
    }
}
