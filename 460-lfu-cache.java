package com.test.solution;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
	static final class Node{
		int val;
		Node next;
		Node prev;
		Node(int x) { val = x; }
	}
	
	static final class DList{
		Node head;
		Node tail;
		public void print(){
			System.out.print(head == null ? "null" : head.val);
			System.out.println(tail == null ? "null" : tail.val);
		}
		public void update(int i){
			Node node = find(i);
			if(node == null ||  node != tail){
				remove(node);
				appendTail(i);
			}
		}
		public Node find(int i){
			Node current = head;
			while(current != null){
				if(current.val == i) return current;
				current = current.next;
			}
			return null;
		}
		public void remove(Node node){
			if(node != null){
				if(node == head){
					removeHead();
				} else {
					node.prev.next = node.next;
					node.next.prev = node.prev;
				}
			}
		}
		public void appendTail(int i){
			if(head == null) {
				head = tail = new Node(i);
			} else {
				Node node = new Node(i);
				tail.next = node;
				node.prev = tail;
				node.next = null;
				tail = node;
			}
		}
		public int removeHead(){
			if(head == null){ 
				return -1;
			} else if(head == tail){
				int v = head.val;
				head = tail = null;
				return v;
			} else {
				int v = head.val;
				head = head.next;
				return v;
			}
		}
		public Node getTail(){
			return tail;
		}
	}
	int cap;
	int size = 0;
	Map<Integer, Integer> val;
	DList frequency;
	public LFUCache(int capacity) {
        cap = capacity;
        val = new HashMap<Integer, Integer>();
        frequency = new DList();
    }
    
    public int get(int key) {
    	Integer result = val.get(key);
    	
        if(result != null) {
        	frequency.update(key);
        	frequency.print();
        	return result;
        }
        else{frequency.print();
        	return -1;
        	
        }
    }
    
    public void put(int key, int value) {
        if(size == cap){
        	if(val.get(key) == null) {
        		int toRemove = frequency.removeHead();
	        	val.remove(toRemove);
        	} else {
        		val.put(key, value);
        	}
        } else {
        	val.put(key, value);
        	size++;
        }

        frequency.update(key);
        frequency.print();
    }
    public static void main(String args[]){
    	LFUCache lfu = new LFUCache(3);
    	
    	lfu.put(2, 2);
    	lfu.put(1, 1);
    	lfu.get(2);
    	lfu.get(1);
    	lfu.get(2);
    	lfu.put(3, 3);
    	lfu.put(4, 4);
    	lfu.get(3);
    }
}
