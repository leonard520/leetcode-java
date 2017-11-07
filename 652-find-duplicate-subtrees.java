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
	HashMap<String, TreeNode> map = new HashMap<String, TreeNode>();
	public void findDuplicateSubtreesInternal(TreeNode root, Set<TreeNode> result) {
		if(root == null) return;
		String s = path(root);
		if(map.get(s) == null){
			map.put(s, root);
		} else {
			result.add(map.get(s));
		}
		findDuplicateSubtreesInternal(root.left, result);
		findDuplicateSubtreesInternal(root.right, result);
	}
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result = new LinkedList<TreeNode>();
		Set<TreeNode> set = new HashSet<TreeNode>();
        if(root == null) return result;
        findDuplicateSubtreesInternal(root, set);
        result.addAll(set);
        return result;
    }
	private String path(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + path(root.left) + "," + path(root.right);
    }
}