package medium.LRUCache;

import java.util.HashMap;

/**
 * LRU 状况百出。。。  错误的示范，需要将链路 搞一个虚拟节点重做这道题
 * Created by bywangxp on 2023/7/24.
 */
public class LRUCache {

    HashMap map;
    // 头结点
    Node head;
    // 尾节点
    Node tailNode;

    int maxSize;


    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        maxSize = capacity;

    }

    public int get(int key) {

        Node data = (Node) map.getOrDefault(key, null);
        if (data == null) {
            return -1;
        }

        if (map.size() == 1 || head.key == key) {
            return data.value;
        }

        // 如果尾节点命中，则尾节点变动
        if (tailNode.key == key) {
            tailNode = tailNode.before;

        }

        data.before.next = data.next;

        if (data.next != null) {
            data.next.before = data.before;
        }


        head.before = data;
        data.next = head;
        head = data;


        return data.value;

    }

    /**
     * 在满的情况put的时候，不需要删除结点
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.size() == maxSize) {
            if (tailNode == null) {
                throw new RuntimeException("tailNode 不应该为空");
            }
            if (head == null) {
                throw new RuntimeException("headNode 不应该为空");
            }

            if (!map.containsKey(key)) {
                if (tailNode.before != null) {
                    tailNode.before.next = null;

                }
                // key 不是map里面的就要删除结点了
                map.remove(tailNode.key);
                Node willDelete = tailNode;
                tailNode = willDelete.before;
                willDelete.before = null;
                // 头结点要指向-- bugfix:后来补充的
                Node temp = new Node(null, head, key, value);
                head.before = temp;
                head = temp;
                map.put(key, head);

            } else {
                // 包含这个key
                get(key);

                Node node = (Node) map.get(key);
                node.value = value;


            }


        } else {

            Node temp = new Node(null, head, key, value);
            if (head != null) {
                head.before = temp;

            }
            head = temp;
            map.put(key, head);
            if (map.size() == 1) {
                tailNode = head;
            }

        }


    }


    public static void main(String[] args) {


//        LRUCache obj = new LRUCache(2);
//        obj.put(1, 1);
//        printMap(obj);
//        obj.put(2, 2);
//        printMap(obj);
//        System.out.println("输入1获取:" + obj.get(1));
//        obj.put(3, 3);
//        printMap(obj);
//        System.out.println("输入2获取:" + obj.get(2));
//        obj.put(4, 4);
//        printMap(obj);
//        System.out.println("输入1获取:" + obj.get(1));
//        System.out.println("输入3获取:" + obj.get(3));
//        System.out.println("输入4获取:" + obj.get(4));

//        LRUCache obj = new LRUCache(2);
//        System.out.println("输入2获取:" + obj.get(2));
//
//        obj.put(2, 6);
//        printMap(obj);
//
//        System.out.println("输入1获取:" + obj.get(1));
//
//        obj.put(1, 5);
//        printMap(obj);
//
//        obj.put(1, 2);
//        printMap(obj);
//        System.out.println("输入1获取:" + obj.get(1));
//        System.out.println("输入2获取:" + obj.get(2));

        LRUCache obj = new LRUCache(2);
        obj.put(2, 1);
        printMap(obj);
        obj.put(1, 1);
        printMap(obj);
        obj.put(2, 3);
        printMap(obj);
        obj.put(4, 1);
        printMap(obj);
        System.out.println("输入1获取:" + obj.get(1));
        System.out.println("输入2获取:" + obj.get(2));


    }

    private static void printMap(LRUCache obj) {
        Node temp = obj.head;
        while (temp != null) {
            System.out.print(temp.key + "->");
            temp = temp.next;
        }
        System.out.print("over,head:" + obj.head.key + ",head before:" + obj.head.before + ",head next:" + obj.head.next);
        System.out.print(",tail:" + obj.tailNode.key + ",tail before:" + obj.tailNode.before + ",tail next:" + obj.tailNode.next);
        System.out.print(",map集合:");
        obj.map.forEach((key, value) -> {
            System.out.print(key + ":" + ((Node) value).value + "   |    ");
        });
        System.out.println();
    }
}


class Node {
    Node before;
    Node next;
    int value;
    int key;

    /**
     * 如果toString 方法输出Node对象会导致递归
     *
     * @return
     */
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", key=" + key +
                '}';
    }

    public Node(Node before, Node next, int key, int value) {
        this.before = before;
        this.next = next;
        this.value = value;
        this.key = key;
    }
}
