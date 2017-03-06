package com.eg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Map<Integer, Integer> map;
	private int max;
	
    public int[] findFrequentTreeSum(TreeNode root) {
    	map = new HashMap<Integer, Integer>();
    	max = 0;
    	List<Integer> result = new ArrayList<>();
        postOrder(root);
        for(Integer key : map.keySet()){
        	if(map.get(key).equals(max)){
        		result.add(key);
        	}
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }
    
    public int postOrder(TreeNode root){
    	if(root == null) return 0;
    	int left = postOrder(root.left);
    	int right = postOrder(root.right);
    	int sum = left + right + root.val;
    	int count = map.getOrDefault(sum, 0) + 1;
    	map.put(sum, count);
    	max = Math.max(count, max);
    	return sum;
    }
}