package hot_100;

import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class c2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode current = res;

        int next1 = 0;

        while (l1 != null && l2 != null) {
            int total = l1.val + l2.val + next1;
            current.next = new ListNode(total % 10);
            next1 = total / 10;
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }

        while (l1 != null) {
            int total = l1.val + next1;
            current.next = new ListNode(total % 10);
            next1 = total / 10;
            l1 = l1.next;
            current = current.next;
        }

        while (l2 != null) {
            int total = l2.val + next1;
            current.next = new ListNode(total % 10);
            next1 = total / 10;
            l2 = l2.next;
            current = current.next;
        }

        if (next1 == 1) {
            current.next = new ListNode(1);
        }
        return res.next;
    }

    @Test
    public void test_000() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = addTwoNumbers(l1, l2);
        Assert.assertEquals(7, res.val);
        Assert.assertEquals(0, res.next.val);
        Assert.assertEquals(8, res.next.next.val);
    }

    @Test
    public void test_001() {
        ListNode l1 = new ListNode(9);
        ListNode current = l1;
        for (int i = 0; i < 6; i++) {
            current.next = new ListNode(9);
            current = current.next;
        }

        ListNode l2 = new ListNode(9);
        current = l2;
        for (int i = 0; i < 3; i++) {
            current.next = new ListNode(9);
            current = current.next;
        }

        ListNode res = addTwoNumbers(l1, l2);
        int[] acts = {8, 9, 9, 9, 0, 0, 0, 1};
        for (int a : acts) {
            Assert.assertEquals(a, res.val);
            res = res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}