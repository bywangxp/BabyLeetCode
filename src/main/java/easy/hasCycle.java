package easy;

import medium.addTwoNumbers.ListNode;

/**
 * Created by bywangxp on 2023/7/24.
 */
public class hasCycle {


    public static boolean hasCycle(ListNode head) {
        // 快慢指针，从原点出发，快走2步，慢走1步。 如果有环，他们永远不会走到尾节点去

        ListNode slowNode = head;
        ListNode quickNode = head;

        while (quickNode != null && quickNode.next != null && quickNode.next.next != null) {
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if(quickNode == slowNode){
                return true;
            }

        }
        return false;

    }




}
