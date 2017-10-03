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
	private boolean fill(int a, int b, int [][]result, int n){
		result[a][b] = 1;
		result[b][a] = -1;
		for(int i = 0; i < n; i++){
			if(result[b][i] == 1){
				if(result[a][i] == -1 || result[i][a] == 1){
					return false;
				} else {
					result[a][i] = 1;
					result[i][a] = -1;
				}
			}
		}
		for(int i = 0; i < n; i++){
			if(result[i][a] == 1){
				if(result[b][i] == 1 || result[i][b] == -1){
					return false;
				} else {
					result[b][i] = -1;
					result[i][b] = 1;
				}
			}
		}
		return true;
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int [][]result = new int[numCourses][numCourses];
		for(int i = 0; i < prerequisites.length; i++){
			for(int j = 0; j < prerequisites[i].length - 1; j++){
				int a = prerequisites[i][j];
				int b = prerequisites[i][j + 1];
				if(result[a][b] == -1 || result[b][a] == 1){
					return false;
				} else {
					if(fill(a, b, result, numCourses) == false){
						return false;
					}
				}
			}
		}
		return true;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
	}
}
