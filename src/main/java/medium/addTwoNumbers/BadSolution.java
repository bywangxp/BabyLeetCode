package medium.addTwoNumbers;

import java.math.BigInteger;

/**
 * 一个错误的思路，但是还是给算出来了，过程中还是有学习的 ==
 * 计算性能非常差，属于暴力解题吧
 * 有几个知识点：
 * 1、Math.pow() 方法返回的是 double 类型的结果，然而，这有可能导致精度的丢失，尤其是当指数较大的时候。
 * 如果你需要对大的整数进行指数运算并且希望结果能够保持精度，你可能需要使用 BigInteger 类的 pow 方法。这个方法接受一个 int 类型的参数作为指数，并返回该 BigInteger 的指数次方。
 * 2、如果一个 int 变量的值超过了其最大的取值范围（也就是 Integer.MAX_VALUE, 约等于 2^31-1 或者 2147483647），那么你可以考虑使用更大的数据类型，比如 long 或者 BigInteger。
 * 3、在Java中，如果你有一个字符（char）表示的数字（例如 '1'）并且你希望将其转换为对应的整数值（例如 1），你可以通过 -'0'方式计算出来：
 *
 *
 */
public class BadSolution {
    public static ListNode addTwoNumbersMyCase(ListNode l1, ListNode l2) {
        BigInteger l1Num = getNumFromListNode(l1);
        System.out.println("l1Num:" + l1Num);

        BigInteger l2Num = getNumFromListNode(l2);
        System.out.println("l2Num:" + l2Num);

        BigInteger sum = l1Num.add(l2Num);
        System.out.println("sum:" + sum);
        return changeNumToListNode(sum);
    }

    /**
     * 根据链表算出数字
     *
     * @param link
     * @return
     */
    private static BigInteger getNumFromListNode(ListNode link) {
        if (link == null) {
            return BigInteger.valueOf(0);
        }
        BigInteger num = BigInteger.valueOf(0);
        int i = 0;
        while (link != null) {
            BigInteger base = new BigInteger("10");
            num = num.add( BigInteger.valueOf(link.val).multiply(base.pow(i)));
            i += 1;
            link = link.next;
        }
        return num;


    }

    /**
     * char 如何转为数字   -'0'
     * 这种方式是通过利用字符（char）在Java中实际上是整数值（基于Unicode字符集）这一特性实现的。数字字符 '0' 到 '9' 在Unicode中是连续的，因此你可以通过计算字符 '0' 与你的数字字符之间的差值来得到对应的整数值。例如，字符 '7' 减去 '0' 的结果是整数 7。
     * @param num
     * @return
     */
    private static ListNode changeNumToListNode(BigInteger num) {
        String numString = String.valueOf(num);
        char first = numString.charAt(numString.length() - 1);
        ListNode firstNode = new ListNode(first - '0', null);
        ListNode preNode = firstNode;
        for (int i = 1; i < numString.length(); ++i) {
            char data = numString.charAt(numString.length() - 1 - i);
            ListNode nextNode = new ListNode(data - '0');
            preNode.next = nextNode;
            preNode = nextNode;


        }
        return firstNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))))))));
        toStringListNode(listNode1);
        ListNode listNode2 = new ListNode(9);
        toStringListNode(listNode2);
        ListNode listNode = addTwoNumbersMyCase(listNode1, listNode2);
        toStringListNode(listNode);


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


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

