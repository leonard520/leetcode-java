package com.test.solution;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

class Solution {
	private ListNode sortList(ListNode head, int length) {
		if(length == 1) return head;
		int half = length / 2;
		ListNode node = head;
		for(int i = 0; i < half; i++){
			node = node.next;
		}
		
		ListNode left = sortList(head, half);
		ListNode right = sortList(node, length - half);
		
		return Merge(left, right, half, length - half);
	}
	public ListNode sortList(ListNode head) {
        if(head == null) return null;
        int len = 0;
        ListNode node = head;
        while(node != null){
        	len ++;
        	node = node.next;
        }
        return sortList(head, len);
    }
	
	private ListNode Merge(ListNode left, ListNode right, int leftLen, int rightLen) {
		boolean isHead = true;
		ListNode head = null;
		ListNode current = null;
		while(leftLen > 0 && rightLen > 0){
			if(left.val <= right.val){
				if(isHead == true){
					current = head = left;
					isHead = false;
				} else {
					current.next = left;
					current = current.next;
				}
				left = left.next;
				leftLen--;
			} else {
				if(isHead == true){
					current = head = right;
					isHead = false;
				} else {
					current.next = right;
					current = current.next;
				}
				right = right.next;
				rightLen--;
			}
		}
		if(leftLen == 0){
			while(rightLen > 0) {
				current.next = right;
				current = current.next;
				right = right.next;
				rightLen--;
			}
		}
		if(rightLen == 0){
			while(leftLen > 0) {
				current.next = left;
				current = current.next;
				left = left.next;
				leftLen--;
			}
		}
		return head;
	}
	
	public static void main(String args[]){
		Solution s = new Solution();
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		ListNode head = s.sortList(n1);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}