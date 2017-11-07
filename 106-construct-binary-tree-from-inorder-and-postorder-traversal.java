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
	public TreeNode buildTreeInternal(int[] inorder,  int[] postorder, int i, int j, int ii, int jj) {
		if(j < i && jj < ii) return null;
		TreeNode root = new TreeNode(postorder[jj]);
		int k = 0;
		for(k = i; k <= j; k++){
			if(inorder[k] == postorder[jj])
				break;
		}
		root.left = buildTreeInternal(inorder, postorder, i, k - 1, ii, ii + j - k);
		root.right = buildTreeInternal(inorder, postorder, k + 1, j, ii + j - k + 1, jj);
		return root;
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0){
        	return null;
        }
        return buildTreeInternal(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}