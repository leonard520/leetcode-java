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
	private int robInternal(TreeNode root, boolean canUse){
		if(root == null) return 0;
		if(canUse == true){
			return Math.max(root.val + robInternal(root.left, false) + robInternal(root.right, false), robInternal(root.left, true) + robInternal(root.right, true));
		} else {
			return robInternal(root.left, true) + robInternal(root.right, true);
		}
	}
	public int rob(TreeNode root) {
        if(root == null) return 0;
        return robInternal(root, true);
    }

	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
	}
}
