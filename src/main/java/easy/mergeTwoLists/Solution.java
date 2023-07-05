package easy.mergeTwoLists;

import medium.addTwoNumbers.ListNode;


public class Solution {

    public static ListNode mergeTwoListsNew(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <=  list2.val){
            list1.next = mergeTwoListsNew(list1.next,list2);
            return list1;
        }
        list2.next = mergeTwoListsNew(list1,list2.next);
        return list2;





    }
        /**
         * 注意：表示头结点，这里提供一个思路，先建一个假的头结点，这样可以把next的关系下去。否则没法保存关系
         * @param list1
         * @param list2
         * @return
         */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode first = list1;
        ListNode second = list2;
        ListNode result = new ListNode();
        ListNode currentNode = result;


        while (first != null && second != null) {
            if (first.val <= second.val) {
                currentNode.next = first;
                currentNode = currentNode.next;
                first = first.next;
            } else {
                currentNode.next = second;
                currentNode = currentNode.next;
                second = second.next;

            }
        }

        if (first != null) {
            currentNode.next = first;
        }

        if (second != null) {
            currentNode.next = second;

        }


        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode.toStringListNode(listNode1);
        ListNode.toStringListNode(listNode2);
        ListNode.toStringListNode(mergeTwoListsNew(listNode1, listNode2));
    }
}

