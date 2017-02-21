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
    public List<Integer> largestValues(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() != 0){
        	int size = queue.size();
        	int max = Integer.MIN_VALUE;
        	for(int i = 0; i < size; i++){
            	TreeNode node = queue.poll();
            	max = Math.max(node.val, max);
            	if(node.left != null) queue.offer(node.left);
            	if(node.right != null) queue.offer(node.right);
        	}
        	result.add(max);
        }
        return result;
    }
}