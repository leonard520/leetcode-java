package com.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public void mergeTreesInternal(TreeNode t1, TreeNode t2, TreeNode node, boolean left) {
		if(t1 == null && t2 == null){
			return;
		}
		if(t1 != null && t2 == null){
			TreeNode r = new TreeNode(t1.val);
			if(left) node.left = r;
			else node.right = r;
			mergeTreesInternal(t1.left, null, r, true);
			mergeTreesInternal(t1.right, null, r, false);
		} else if(t1 == null && t2 != null){
			TreeNode r = new TreeNode(t2.val);
			if(left) node.left = r;
			else node.right = r;
			mergeTreesInternal(null, t2.left, r, true);
			mergeTreesInternal(null, t2.right, r, false);
		} else {
			TreeNode r = new TreeNode(t1.val + t2.val);
			if(left) node.left = r;
			else node.right = r;
			mergeTreesInternal(t1.left, t2.left, r, true);
			mergeTreesInternal(t1.right, t2.right, r, false);
		}
	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
        	return null;
        }
        TreeNode r = new TreeNode(0);
        if(t1 == null && t2 != null){
        	r.val = t2.val;
        	return t2;
        } else if(t1 != null && t2 == null){
        	r.val = t1.val;
        	return t1;
        } else {
        	r.val = t1.val + t2.val;
        }
        
        mergeTreesInternal(t1.left, t2.left, r, true);
        mergeTreesInternal(t1.right, t2.right, r, false);
        return r;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		
		
	}
}
