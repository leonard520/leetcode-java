package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	private void inorderTraversalInternal(TreeNode root, List<Integer> result) {
		if(root == null) return;
		inorderTraversalInternal(root.left, result);
		result.add(root.val);
		inorderTraversalInternal(root.right, result);
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		if(root == null) return result;
		inorderTraversalInternal(root, result);
		return result;
    }
}
