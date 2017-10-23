package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	private void spiralOrderInternal(int[][] matrix, int ii, int jj, int kk, int ll, int dir, List<Integer> result) {
		if(ii > kk || jj > ll){
			return;
		}
		if(dir == 0){
			for(int j = jj; j <= ll; j++){
				System.out.println(matrix[ii][j]);
				result.add(matrix[ii][j]);
			}
			spiralOrderInternal(matrix, ii + 1, jj, kk, ll, 1, result);
		} else if(dir == 1){
			for(int i = ii; i <= kk; i++){
				System.out.println(matrix[i][ll]);
				result.add(matrix[i][ll]);
			}
			spiralOrderInternal(matrix, ii, jj, kk, ll - 1, 2, result);
		} else if(dir == 2){
			for(int j = ll; j >= jj; j--){
				System.out.println(matrix[kk][j]);
				result.add(matrix[kk][j]);
			}
			spiralOrderInternal(matrix, ii, jj, kk - 1, ll, 3, result);
		} else if(dir == 3){
			for(int i = kk; i >= ii; i--){
				System.out.println(matrix[i][jj]);
				result.add(matrix[i][jj]);
			}
			spiralOrderInternal(matrix, ii, jj + 1, kk, ll, 0, result);
		}
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new LinkedList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        spiralOrderInternal(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, 0, result);
        return result;
    }
}
