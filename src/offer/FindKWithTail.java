package offer;

/**
 * 剑指Offer面试题15（Java版）：链表中倒数第K个结点
 * 题目： 输入一个链表。输出该链表中倒数第k哥结点。
 * 为了符合大多数人的习惯，本题从1開始计数。即链表的尾结点是倒数第1个结点。
 * 比如一个链表有6个结点。从头结点開始它们的值依次是1。2。3，4，5，6.这个链表的倒数第3个结点是值为4的结点
 * <p>
 * <p>
 * 为了实现仅仅遍历链表一次就能找到倒数第k个结点。我们能够定义两个指针。第一个指针从链表的头指针開始遍历向前走k-1。第二个指针保持不动；从第k步開始，第二个指针也开化寺从链表的头指针開始遍历。
 * <p>
 * 因为两个指针的距离保持在k-1。当第一个（走在前面的）指针到达链表的尾指结点时，第二个指针正好是倒数第k个结点。
 */
public class FindKWithTail {

    public class ListNode {
        public int value;
        public ListNode next;
    }

    public static ListNode findK(ListNode node, int k) {
        if (null == node || k <= 0) {
            return null;
        }

        ListNode sNode = node;

        for (int i = 1; i < k; i++) {
            if (null != sNode.next) {
                sNode = sNode.next;
            } else {
                return null;
            }
        }

        while (null != sNode.next) {
            node = node.next;
            sNode = sNode.next;
        }

        return node;
    }

}
