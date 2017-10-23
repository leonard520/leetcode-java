package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

//1->2->3->4->null
//1->2->3->null
//1->2->null
class Solution {
	public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode evenHead = head.next;
        ListNode evenCurrent = evenHead;
        ListNode oddCurrent = head;
        ListNode current = evenHead.next;
        evenHead.next = null;
        boolean odd = true;
        while(current != null){
        	if(odd){
        		oddCurrent.next = current;
        		current = current.next;
        		oddCurrent = oddCurrent.next;
        		oddCurrent.next = null;
        	} else {
        		evenCurrent.next = current;
        		current = current.next;
        		evenCurrent = evenCurrent.next; 
        		evenCurrent.next = null;
        	}
        	odd = !odd;
        }
        oddCurrent.next = evenHead;
        return head;
    }
}
