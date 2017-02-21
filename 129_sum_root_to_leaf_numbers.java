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
	public int total;
    public int sumNumbers(TreeNode root) {
    	total = 0;
    	helper(root, 0);
    	return total;
    }
    
    private void helper(TreeNode t, int sum){
    	if(t == null) return;
    	sum = sum * 10 + t.val;
    	if(t.left == null && t.right == null){
    		total += sum;
    		return;
    	}
    	helper(t.left, sum);
    	helper(t.right, sum);
    }
}