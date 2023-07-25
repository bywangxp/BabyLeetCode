package medium.addTwoNumbers;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;

    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void toStringListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            if (listNode.next != null) {
                System.out.print("->");
            }
            listNode = listNode.next;

        }

        System.out.println("");

    }

}
