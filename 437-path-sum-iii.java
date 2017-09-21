package com.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	private int pathSumInternal(TreeNode root, int sum) {
		if(root == null) return 0;
		int left = sum - root.val;
        if(left == 0) {
        	return 1 + pathSumInternal(root.left, left) + pathSumInternal(root.right, left);
        }
        else return pathSumInternal(root.left, left) + pathSumInternal(root.right, left) ;
	}
	public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return pathSumInternal(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		
		
	}
}
