package base.heap;

import java.util.*;

/**
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * <p>
 * <p>
 * 扩展练习：
 * <p>
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */
public class c692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCnt = new HashMap<>();
        for (String word : words) {
            wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) ->
                wordCnt.get(s1).equals(wordCnt.get(s2)) ?
                        s2.compareTo(s1) :
                        wordCnt.get(s1) - wordCnt.get(s2));
        for (String s: wordCnt.keySet()) {
            minHeap.offer(s);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> res = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        c692 instance = new c692();

        {
            String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
            int k = 2;
            System.out.println(instance.topKFrequent(words, k));
        }

        {
            String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
            int k = 4;
            System.out.println(instance.topKFrequent(words, k));
        }
    }
}
