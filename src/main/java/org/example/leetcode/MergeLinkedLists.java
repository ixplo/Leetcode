package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

class MergeLinkedLists {

    public static void main(String[] args) {

        System.out.println(mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4)))));
        System.out.println(mergeTwoLists(null, null));
        System.out.println(mergeTwoLists(null, new ListNode(0)));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode cur = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        List<Integer> values1 = values(list1);
        List<Integer> values2 = values(list2);
        values1.addAll(values2);
        values1.sort(null);
        return node(values1);
    }

    public static List<Integer> values(ListNode listNode) {
        List<Integer> values = new ArrayList<>();
        int value = listNode.val;
        values.add(value);
        ListNode next = listNode.next;
        while (true) {
            if (next == null) {
                break;
            }
            value = next.val;
            values.add(value);
            next = next.next;
        }
        return values;
    }

    public static ListNode node(List<Integer> values) {
        ListNode listNode = null;
        for (int i = values.size() - 1; i >= 0; i--) {
            listNode = new ListNode(values.get(i), listNode);
        }
        return listNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
            System.out.println(val);
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}