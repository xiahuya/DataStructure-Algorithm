package algorithm.leetcode.linkedlist;

import algorithm.domain.ListNode;

/**
 * @author Xiahu
 * @create 2023/3/16 0016
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class JZ_24_LinkedListReverse {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode next = null;

        // 创建新链表的头节点
        ListNode reverseHeadNode  = new ListNode(0);

        while (true) {
            if (current == null) {
                break;
            }

            // 使用一个临时变量
            next = current.next;

            current.next = reverseHeadNode.next;
            reverseHeadNode.next = current;
            current = next;
        }

        reverseHeadNode = reverseHeadNode.next;
        return reverseHeadNode;
    }
}
