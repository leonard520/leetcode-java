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
	public TreeNode buildTreeInternal(int prestart, int instart, int inend, int[] preorder, int[] inorder) {
		if(prestart > preorder.length - 1 || instart > inend) {
	        return null;
	    }
		int r = preorder[prestart];
		TreeNode node = new TreeNode(r);
		int inroot = 0;
		for(int i = instart; i <= inend; i++){
			if(inorder[i] == r){
				inroot = i;
			}
		}
		node.left = buildTreeInternal(prestart + 1, instart, inroot - 1, preorder, inorder);
		node.right = buildTreeInternal(prestart + inroot - instart + 1, inroot + 1, inend, preorder, inorder);
		return node;
    }
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null) return null;
		return buildTreeInternal(0, 0, inorder.length - 1, preorder, inorder);
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
	}
}
