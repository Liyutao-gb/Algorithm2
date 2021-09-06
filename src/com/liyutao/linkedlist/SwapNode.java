package com.liyutao.linkedlist;

/**
 * @Author liyutao
 * @Date 2021/9/6 23:02
 * @Description
 * 两两交换链表节点  K个为一组交换链表节点  反转链表
 */
public class SwapNode {

    public static void main(String[] args) {

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

    //两两交换链表节点 循环
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

    //反转链表节点
    public void reverseListNode(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }

    //K个一组交换链表节点
    public ListNode swapNodeKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        //cur first...second third
        while (cur.next != null) {
            ListNode first = cur.next;
            ListNode second = cur;
            int count = 0, i = 0;
            for (i = 0, count = 0; i < k; i++, count++) {
                if (second.next != null) {
                    second = second.next;
                } else {
                    break;
                }
            }
            if (count != k)
                break;
            ListNode third = second.next;
            second.next = null;
            reverseListNode(first);
            first.next = third;
            cur.next = second;
            cur = first;
        }
        return dummy.next;
    }

}
