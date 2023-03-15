package algorithm.leetcode.linkedlist;

/**
 * @author Xiahu
 * @create 2023/3/8 0008
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class A01_LinkedListDemo {
    public static void main(String[] args) {
        A01_LinkedListDemo demo = new A01_LinkedListDemo();
        ListNode headNode = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        headNode.next = node2;
        node2.next = node3;
        /*int[] ints = demo.reversePrint(headNode);
        for (int anInt : ints) {
            System.out.println(anInt);
        }*/

        System.out.println("反转前的链表");
        demo.list(headNode);
        ListNode listNode = demo.reverseList(headNode);
        System.out.println("反转后的链表");
        demo.list(listNode);
    }

    public int[] reversePrint(ListNode head) {
        ListNode current = head;
        int length = 0;
        // 统计链表长度
        while (true) {
            if (current == null) {
                break;
            }
            length++;
            current = current.next;
        }

        int[] result = new int[length];
        ListNode node = head;
        for (int i = 1; i <= length; i++) {
            result[length - i] = node.val;
            node = node.next;
        }

        return result;
    }


    // 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            throw new RuntimeException("链表没有数据");
        }

        ListNode current = head;

        // 创建新链表的头节点
        ListNode newHead = new ListNode(0);
        ListNode newCurrent = null;
        while (true) {
            if (current == null) {
                break;
            }

            newCurrent = current;
            if (newHead.next == null) {
                newHead.next = newCurrent;
            } else {
                newCurrent.next = newHead.next;
                newHead.next = newCurrent;
            }

            current = current.next;
        }

        newHead = newHead.next;
        return newHead;
    }


    public void list(ListNode head) {
        ListNode currentNode = head;

        while (true) {
            if (currentNode == null) {
                break;
            }
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }

    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
