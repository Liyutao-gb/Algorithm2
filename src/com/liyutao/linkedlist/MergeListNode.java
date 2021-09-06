package com.liyutao.linkedlist;

/**
 * @Author liyutao
 * @Date 2021/9/6 7:54
 * @Description
 * 合并两个链表   合并K个链表
 * 两两交换链表节点  K个为一组交换链表节点
 */
public class MergeListNode {

    public static void main(String[] args) {

    }

    //合并两个链表递归
    public ListNode mergeTwoListNodeRec(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoListNodeRec(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListNodeRec(l1, l2.next);
            return l2;
        }
    }

    //合并两个链表
    public ListNode mergeTwoListNode(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    //合并K个链表
    public ListNode mergeKListNode(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode res = mergeKListNode(lists, 0, lists.length - 1);
        return res;
    }

    public ListNode mergeKListNode(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];

        int mid = (left + right) / 2;
        ListNode l1 = mergeKListNode(lists, left, mid);
        ListNode l2 = mergeKListNode(lists, mid + 1, right);
        return mergeTwoListNode(l1, l2);
    }

    //两两交换链表节点 递归
    public ListNode swapPairsRec(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // head -> next -> swapPairs(next.next)
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        // cur   first second third
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = first;
        }
        return dummy.next;
    }


    //K个一组交换链表节点
    public ListNode swapNodeKGroup(ListNode head) {


    }



}
