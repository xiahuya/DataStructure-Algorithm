package algorithm.leetcode.linkedlist;

import algorithm.domain.ListNode;

/**
 * @author Xiahu
 * @create 2023/3/16 0016
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class JZ_06_LinkedListPrint {
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
}
