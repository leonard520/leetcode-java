package com.test.solution;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

class Solution {
	private int nodeCount(TreeNode root){
		if(root == null) return 0;
		return 1 + nodeCount(root.left) + nodeCount(root.right);
	}
	public int kthSmallest(TreeNode root, int k) {
		if(root.left != null){
			int leftCount = nodeCount(root.left);
			if(leftCount + 1 == k) return root.val;
			else if(leftCount + 1 < k) return kthSmallest(root.right, k - leftCount - 1);
			else if(leftCount + 1 > k) return kthSmallest(root.left, k);
		} else {
			if(k == 1) return root.val;
			else return kthSmallest(root.right, k - 1);
		}
		return -1;
    }
}