package medium.addTwoNumbers;


import static medium.addTwoNumbers.ListNode.toStringListNode;

/**
 * 自己的解法  击败了100%的用户，哈哈
 *给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 */
public class SolutionGoodCase {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode currentNode = result;

        while (l1 != null || l2 != null) {
            int value1 = 0;
            int value2 = 0;
            if (l1 != null) {
                value1 = l1.val;
                l1 = l1.next;

            }
            if (l2 != null) {
                value2 = l2.val;
                l2 = l2.next;
            }
            int quotient = (value1 + value2 + currentNode.val) / 10;
            currentNode.val = (value1 + value2 + currentNode.val) % 10;
            if(l1 != null || l2 != null || quotient !=0){
                currentNode.next = new ListNode(quotient);
            }
            currentNode = currentNode.next;
        }
        return result;

    }

    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));

//        ListNode listNode1 = new ListNode(0);
//        ListNode listNode2 = new ListNode(0);

         ListNode listNode1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
         ListNode listNode2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        toStringListNode(listNode1);
        toStringListNode(listNode2);
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        toStringListNode(listNode);


    }
}
