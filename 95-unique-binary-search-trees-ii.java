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
	public List<TreeNode> generateTreesInternal(int low, int high) {
		if(low > high) return null;
		List<TreeNode> root = new LinkedList<TreeNode>();
		List<TreeNode> left;
		List<TreeNode> right;
		for(int i = low; i <= high; i++){
			left = generateTreesInternal(low, i - 1);
			right = generateTreesInternal(i + 1, high);
			if(left == null && right == null){
				TreeNode node = new TreeNode(i + 1);
				root.add(node);
			} else if(left == null){
				for(int j = 0; j < right.size(); j++){
					TreeNode node = new TreeNode(i + 1);
					node.left = null;
					node.right = right.get(j);
					root.add(node);
				}
			} else if(right == null){
				for(int j = 0; j < left.size(); j++){
					TreeNode node = new TreeNode(i + 1);
					node.left = left.get(j);
					node.right = null;
					root.add(node);
				}
				
			} else {
				for(int j = 0; j < left.size(); j++){
					for(int k = 0; k< right.size(); k++){
						TreeNode node = new TreeNode(i + 1);
						node.left = left.get(j);
						node.right = right.get(k);
						root.add(node);
					}
				}
			}
		}
		return root;
    }
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> result = new LinkedList<TreeNode>();
        if(n == 0) return result;
        result = generateTreesInternal(0, n - 1);
        return result;
    }
	
	public static void main(String args[]){
		Solution solution = new Solution();
		solution.generateTrees(1);
	}
}