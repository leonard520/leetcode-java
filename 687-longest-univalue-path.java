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
	int max;
	public int longestUnivaluePathInternal(TreeNode root, int val) {
        if(root == null) return 0;
        if(val == root.val){
        	return Math.max(longestUnivaluePathInternal(root.left, val) + 1, longestUnivaluePathInternal(root.right, val) + 1);
        }
        return 0;
    }
	public void traversal(TreeNode root){
		if(root == null){
			return;
		}
		int length = longestUnivaluePathInternal(root.left, root.val) + longestUnivaluePathInternal(root.right, root.val) + 1;
		max = Math.max(length, max);
		traversal(root.left);
		traversal(root.right);
	}
	public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        max = 0;
        traversal(root);
        return max;
    }
}