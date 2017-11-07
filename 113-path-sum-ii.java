package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public void pathSumInternal(int sum, List<TreeNode> queue, List<Integer> list, List<List<Integer>> result)  {
		int size = queue.size();
		for(int i = 0; i < size; i++){
			TreeNode node = queue.get(i);
			if(sum == node.val && node.left == null && node.right == null){
				list.add(node.val);
				result.add(new LinkedList<Integer>(list));
				list.remove(list.size() - 1);
			}
			if(sum > node.val){
				List<TreeNode> child = new LinkedList<TreeNode>();
				if(node.left != null) child.add(node.left);
				if(node.right != null) child.add(node.right);
				list.add(node.val);
				pathSumInternal(sum - node.val, child, list, result);
				list.remove(list.size() - 1);
			}
		}
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(root == null) return result;
		List<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		pathSumInternal(sum, queue, new LinkedList<Integer>(), result);
		return result;
	}
	
	public static void main(String args[]){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		numbers.forEach((Integer value) -> System.out.println(value));
	}
}