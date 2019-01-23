/*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
 */

import java.lang.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode answer = new ListNode(0);
        Set<Integer> empty = new HashSet<>();
        int i;
        if (lists == null || lists.length < 1) return null;
        if (lists.length == 1) return lists[0];
        for (i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                empty.add(i);
            }
        }
        if (empty.isEmpty()) return null;

        ListNode temp = answer;
        ListNode min = new ListNode(Integer.MAX_VALUE);
        int minIndex = 0;
        while (!empty.isEmpty()) {
            for (i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min.val) {
                        minIndex = i;
                        min.val = lists[i].val;
                    }
                }
            }
            temp.next = lists[minIndex];
            temp = temp.next;
            if (lists[minIndex].next != null) {
                lists[minIndex] = lists[minIndex].next;
            } else {
                empty.remove(minIndex);
                lists[minIndex] = null;
            }
            min.val = Integer.MAX_VALUE;
        }
        return answer.next;
    }
}
