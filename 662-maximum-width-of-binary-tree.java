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
		List<List<String>> result = new LinkedList<List<String>>();
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.isEmpty() != true){
        	int size = queue.size();
        	List<String> level = new LinkedList<String>();
        	boolean flag = false;
        	for(int i = 0; i < size; i++){
        		TreeNode node = queue.poll();
        		if(node == null){
        			queue.offer(null);
        			queue.offer(null);
        			level.add("");
        		} else {
        			flag = true;
        			queue.offer(node.left);
        			queue.offer(node.right);
        			level.add(node.val + "");
        		}
        	}
        	result.add(level);
        	if(flag == false){
        		result.remove(result.size() - 1);
        		break;
        	}
        }
        int max = 0;
        for(int i = 0; i < result.size(); i++){
        	List<String> temp = result.get(i);
        	int start = 0;
        	int end = 0;
        	for(int j = 0; j < temp.size(); j++){
        		if(temp.get(j).equals("") == false){
        			start = j;
        			break;
        		}
        	}
        	for(int j = temp.size() - 1; j >= 0; j--){
        		if(temp.get(j).equals("") == false){
        			end = j;
        			break;
        		}
        	}
        	max = Math.max(max, end - start + 1);
        }
        return max;
    }
}