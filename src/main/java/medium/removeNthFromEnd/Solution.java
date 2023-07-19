package medium.removeNthFromEnd;

import medium.addTwoNumbers.ListNode;

import static medium.addTwoNumbers.ListNode.toStringListNode;

/**
 * 19.给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢双指针
        ListNode slowNode = head;
        ListNode quickNode = head;
        for (int i = 0; i < n; ++i) {
            if (quickNode != null) {
                quickNode = quickNode.next;
            }
        }
        if (quickNode == null) {
            return head.next; // 此处不能直接返回null
        }

        while (quickNode.next != null) {
            slowNode = slowNode.next;
            quickNode = quickNode.next;
        }

        slowNode.next = slowNode.next.next;

        return head;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode head = new ListNode(1, new ListNode(2));
//        ListNode head = new ListNode(1, null);
        toStringListNode(head);
        toStringListNode(removeNthFromEnd(head, 4));
    }
}
