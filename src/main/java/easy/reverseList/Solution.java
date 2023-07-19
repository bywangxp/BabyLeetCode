package easy.reverseList;

import medium.addTwoNumbers.ListNode;

import java.util.Stack;

import static medium.addTwoNumbers.ListNode.toStringListNode;

public class Solution {
    public static ListNode reverseList(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            if(head.next == null){
                break;
            }
            stack.add(head);
            head= head.next;
        }
        ListNode temp ;
        temp = head;
        // 头结点不放在栈中
        while(stack.size() >0){
            ListNode pop = stack.pop();
            temp.next = pop;
            temp = temp.next;
        }
        if(temp != null){
            temp.next = null;
        }
        return head;

    }
    // 双指针法

    public static ListNode reverseList2(ListNode head) {
        ListNode cur =head;
        ListNode pre =null;
        while(cur != null){
            ListNode tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNode;
        }
        return pre;


    }

    // 递归
    public static ListNode reverseList3(ListNode head) {

        if(head == null || head.next ==null){
            return head;
        }
        ListNode cur = reverseList3(head.next);
        head.next.next = head;
        head.next =null;
        return cur;


    }




        public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

//       toStringListNode(head);
       toStringListNode(reverseList3(head));

    }


}
