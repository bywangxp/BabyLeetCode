package medium.partition;

import medium.addTwoNumbers.ListNode;

import static medium.addTwoNumbers.ListNode.toStringListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * https://leetcode.cn/problems/partition-list/description/
 */
public class Solution {

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode smallList = new ListNode();
        ListNode smallListTemp = smallList;
        ListNode largerEqualList = new ListNode();
        ListNode largerEqualListTemp = largerEqualList;

        while (head != null) {
            if (head.val < x) {
                smallListTemp.next = head;
                smallListTemp = head;
            } else {
                largerEqualListTemp.next = head;
                largerEqualListTemp = head;
            }
            head = head.next;

        }
        largerEqualListTemp.next = null;


        if (largerEqualList.next != null) {
            smallListTemp.next = largerEqualList.next;
        }else{
            smallListTemp.next = null;

        }


        return smallList.next;

    }

    public static void main(String[] args) {
        toStringListNode(partition(new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2)))))),3));
        toStringListNode(partition(new ListNode(2,new ListNode(1)),2));
    }
}
