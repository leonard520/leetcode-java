package com.eg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
    	if(root == null){
    		return;
    	}
    	Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    	queue.offer(root);
    	while(queue.size() != 0){
    		int n = queue.size();
    		TreeLinkNode node = queue.poll();
    		for(int i = 0; i < n - 1; i++){
    			if(node.left != null) queue.offer(node.left);
    			if(node.right != null) queue.offer(node.right);
    			TreeLinkNode node2 = queue.poll();
    			node.next = node2;
    			node = node2;
    		}
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
    		node.next = null;
    	}
    }
}