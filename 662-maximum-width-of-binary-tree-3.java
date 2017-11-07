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
	public int widthOfBinaryTree(TreeNode root) {
		int max = 0;
        if(root == null) return max;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        while(queue.isEmpty() != true){
        	int size = queue.size();
        	map.put(root, 1);
    		int start = 0;
    		int end = 0;
        	for(int i = 0; i < size; i++){
        		TreeNode node = queue.poll();
        		if(i == 0) start = map.get(node);
        		if(i == size - 1) end = map.get(node);
        		if(node.left != null) {
        			queue.offer(node.left);
        			map.put(node.left, map.get(node) * 2);
        		}
        		if(node.right != null) {
        			queue.offer(node.right);
        			map.put(node.right, map.get(node) * 2 + 1);
        		}
        	}
        	max = Math.max(max, end - start + 1);
        }
        return max;
    }
}