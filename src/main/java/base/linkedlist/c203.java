package base.linkedlist;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [0, 10 * 10000] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class c203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
//        [1,2,6,3,4,5,6]

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(6,
                new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        System.out.println("before:" + listNode);

        c203 instance = new c203();
        ListNode removedListNode = instance.removeElements(listNode, 6);
        System.out.println("after:" + removedListNode);
    }
}
