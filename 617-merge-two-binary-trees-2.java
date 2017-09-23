package com.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public TreeNode mergeTreesInternal(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null){
			return null;
		}
		TreeNode r = new TreeNode(0);
		if(t1 != null && t2 == null){
			r.val = t1.val;
			r.left = mergeTreesInternal(t1.left, null);
			r.right = mergeTreesInternal(t1.right, null);
		} else if(t1 == null && t2 != null){
			r.val = t2.val;
			r.left = mergeTreesInternal(null, t2.left);
			r.right = mergeTreesInternal(null, t2.right);
		} else {
			r.val = t1.val + t2.val;
			r.left = mergeTreesInternal(t1.left, t2.left);
			r.right = mergeTreesInternal(t1.right, t2.right);
		}
		return r;
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
        
        r.left = mergeTreesInternal(t1.left, t2.left);
        r.right = mergeTreesInternal(t1.right, t2.right);
        return r;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		
		
	}
}
