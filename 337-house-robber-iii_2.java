package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	private int[] robInternal(TreeNode root){
		if(root == null) return new int[2];
		int[] left = robInternal(root.left);
		int[] right = robInternal(root.right);
		int[] res = new int[2];
		res[0] = root.val + left[1] + right[1];
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return res;
	}
	public int rob(TreeNode root) {
        if(root == null) return 0;
        return Math.max(robInternal(root)[0], robInternal(root)[1]);
    }

	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
	}
}
