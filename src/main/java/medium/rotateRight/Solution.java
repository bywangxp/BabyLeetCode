package medium.rotateRight;

import medium.addTwoNumbers.ListNode;

import static medium.addTwoNumbers.ListNode.toStringListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 采用快慢指针找到第K个要处理的位置
 */
public class Solution {

    public static ListNode rotateRight(ListNode head, int k) {

        ListNode quickNode = head;
        ListNode slowNode = head;
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if(length == 0){
            return head;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        for (int i = 0; i < k; ++i) {
            quickNode = quickNode.next;
        }

        while (quickNode.next != null) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        // 头结点
        temp = slowNode.next;
        // 处理尾节点
        slowNode.next = quickNode.next;
        // 链接之前的头
        quickNode.next = head;
        head = temp;
        return head;
    }

    public static void main(String[] args) {
        // ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2)));
        toStringListNode(head);
        toStringListNode(rotateRight(head, 3));
    }

}

