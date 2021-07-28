package Test.dayone;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgorithmNode {
    //内部类创建链表节点
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
//      创建环形链表
        node5.next = node3;
        System.out.println("ssss");
//        System.out.println(hasCycle(node1));

    }

    /*
     * 1、Set集合判断
     * */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        while (head != null) {
            if (!nodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
