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
        while(queue.isEmpty() != true){
        	int size = queue.size();
        	boolean findStart = false;
    		int start = 0;
    		int end = 0;
        	for(int i = 0; i < size; i++){
        		TreeNode node = queue.poll();
        		if(node == null){
        			queue.offer(null);
        			queue.offer(null);
        		} else {
        			queue.offer(node.left);
        			queue.offer(node.right);
        			if(findStart == false){
        				start = end = i;
        				findStart = true;
        			} else {
        				end = i;
        			}
        		}
        	}
        	max = Math.max(max, end - start + 1);
        	if(findStart == false){
        		break;
        	}
        }
        return max;
    }
}