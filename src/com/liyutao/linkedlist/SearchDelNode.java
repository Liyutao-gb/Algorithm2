package com.liyutao.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author liyutao
 * @Date 2021/9/6 23:59
 * @Description
 * 删除链表节点：
 *      输入: 1->1->2->3->3
 *      输出: 1->2->3
 * 删除链表节点：
 *      输入: 1->1->2->3->3
 *      输出: 2->3
 * 无序单链表中删除重复值
 *
 * 查找链表节点
 *
 *
 */
public class SearchDelNode {

    public static void main(String[] args) {

    }

    //删除链表节点 1->1->2->3->3   1->2->3
    public ListNode removeDumpNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    //删除链表节点  1->1->2->3->3   2->3
    public ListNode removeDupNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    //无序链表删除节点
    public ListNode removeDupInNoOrderList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }


}
