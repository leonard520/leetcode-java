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
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new LinkedList<Double>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root == null) return result;
		queue.offer(root);
		while(queue.isEmpty() != true){
			int size = queue.size();
			double average = 0;
			for(int i = 0; i < size; i++){
				TreeNode node = queue.poll();
				average += node.val;
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
			result.add(average / size);
		}
		return result;
    }
}