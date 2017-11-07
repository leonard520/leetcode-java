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
	public TreeNode addOneRow(TreeNode root, int v, int d) {
		Queue<TreeNode> queue = new LinkedList<>();
		if(root == null) return root;
		if(d == 1){
			TreeNode node = new TreeNode(v);
			node.left = root;
			return node;
		}
		queue.offer(root);
		for(int i = 1; i < d - 1; i++){
			int size = queue.size();
            for (int j = 0; j < size; j++) {
            	TreeNode node = queue.poll();
            	if(node.left != null) queue.offer(node.left);
            	if(node.right != null) queue.offer(node.right);
            }
		}
		while(queue.isEmpty() == false){
			TreeNode node = queue.poll();
			TreeNode left = node.left;
			TreeNode right = node.right;
			node.left = new TreeNode(v);
			node.right = new TreeNode(v);
			node.left.left = left;
			node.right.right = right;
		}
		return root;
	}
}