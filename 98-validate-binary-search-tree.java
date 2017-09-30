package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public int rightMin(TreeNode root) {
		if(root == null) return 0;
		if(root.left != null){
			return rightMin(root.left);
		} else return root.val;
	}
	
	public int leftMax(TreeNode root) {
		if(root == null) return 0;
		if(root.right != null){
			return leftMax(root.right);
		} else return root.val;
	}
	
	public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean flag = true;
        if(root.left != null) {
        	int left = leftMax(root.left);
        	if(root.val <= left) return false;
        	flag &= isValidBST(root.left);
        }
        if(root.right != null){
        	int right = rightMin(root.right);
        	if(root.val >= right) return false;
        	flag &= isValidBST(root.right);
        }
        return flag;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
	}
}
