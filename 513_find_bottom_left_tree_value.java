package com.eg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	
    public int findBottomLeftValue(TreeNode root) {
    	int value = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.size() != 0){
        	int size = queue.size();
        	for(int i = 0; i < size; i++){
        		TreeNode node = queue.poll();
        		if(i == 0) value = node.val;
        		if(node.left != null) queue.offer(node.left);
        		if(node.right != null) queue.offer(node.right);
        	}
        }
        return value;
    }
}