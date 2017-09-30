package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(root == null) return result;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(q.isEmpty() == false){
			List<Integer> list = new LinkedList<Integer>();
			int size = q.size();
			for(int i = 0; i < size; i++){
				TreeNode node = q.poll();
				if(node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
				list.add(node.val);
			}
			result.add(list);
		}
		return result;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
	}
}
