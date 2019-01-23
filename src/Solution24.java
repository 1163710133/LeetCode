/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
说明:

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode temp2 = new ListNode(0);
        ListNode temp3 = new ListNode(0);
        if (head == null || head.next == null) {
            return head;
        } else {
            temp = head;
            temp2 = head.next.next;
            head = head.next;
            head.next = temp;
            temp.next = temp2;
        }
        while (temp.next != null && temp.next.next != null) {
            temp2 = temp.next;
            temp.next = temp.next.next;
            temp3 = temp.next.next;
            temp.next.next = temp2;
            temp2.next = temp3;
            temp = temp2;
        }
        return head;
    }
}
