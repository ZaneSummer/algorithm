package offer;


public class ReverseHead {
    public static Node reverse(Node head) {
        if (null == head) {
            return null;
        }
        Node pre = head;
        Node current = head.next;
        Node next = null;

        while (null != current) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        head.next = null;
        head.next = pre;//current is null  the last is pre
        return head;

    }


    /**
     * 递归实现2
     */

    public static Node reverseNode(Node current) {
        if (null == current || null == current.next) {
            return current;
        }
        Node nextNode = current.next;
        current.next = null;
        Node reverNode = reverseNode(nextNode);
        nextNode.next = null;
        return reverNode;

    }
}
