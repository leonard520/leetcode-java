package com.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	private boolean isValid(int x, int y, int row, int col){
		return x >= 0 && x < row && y >= 0 && y < col;
	}
	
	private int moveRight(int[][] M, int v, int x, int y, int row, int col){
		if(isValid(x, y - 1, row, col)) {
			v -= M[x][y - 1];
		}
		if(isValid(x - 1, y - 1, row, col)) {
			v -= M[x - 1][y - 1];
		}
		if(isValid(x + 1, y - 1, row, col)) {
			v -= M[x + 1][y - 1];
		}
		if(isValid(x, y + 2, row, col)) {
			v += M[x][y + 2];
		}
		if(isValid(x - 1, y + 2, row, col)) {
			v += M[x - 1][y + 2];
		}
		if(isValid(x + 1, y + 2, row, col)) {
			v += M[x + 1][y + 2];
		}
		return v;
	}
	
	private int moveDown(int[][] M, int v, int x, int y, int row, int col){
		if(isValid(x - 1, y, row, col)) {
			v -= M[x - 1][y];
		}
		if(isValid(x - 1, y - 1, row, col)) {
			v -= M[x - 1][y - 1];
		}
		if(isValid(x - 1, y + 1, row, col)) {
			v -= M[x - 1][y + 1];
		}
		if(isValid(x + 2, y, row, col)) {
			v += M[x + 2][y];
		}
		if(isValid(x + 2, y - 1, row, col)) {
			v += M[x + 2][y - 1];
		}
		if(isValid(x + 2, y + 1, row, col)) {
			v += M[x + 2][y + 1];
		}
		return v;
	}
	
	private int calculate(int[][] M, int x, int y,int row, int col){
		int v = 0;
		for (int incR : new int[]{-1, 0, 1}) {
            for (int incC : new int[]{-1, 0, 1}) {
                if (isValid(x + incR, y + incC, row, col)) {
                    v += M[x + incR][y + incC];
                }
            }
        }
		return v;
	}
	
	public int[][] imageSmoother(int[][] M) {
        if(M == null) return null;
        int rows = M.length;
        if (rows == 0) return new int[0][];
        int cols = M[0].length;
        int result[][] = new int[rows][cols];
        result[0][0] = calculate(M, 0, 0, rows, cols);
        for(int i = 0; i < rows; i++){
        	for(int j = 0; j < cols - 1; j++){
        		result[i][j + 1] = moveRight(M, result[i][j], i, j, rows, cols);
        	}
        	if(i != rows - 1) {
        		result[i + 1][0] = moveDown(M, result[i][0], i, 0, rows, cols);
        	}
        }
        
        for(int i = 0; i < rows; i++){
        	for(int j = 0; j < cols; j++){
        		System.out.print(result[i][j] + " ");
        		if((i == 0 && j == 0) || (j == 0 && i == rows - 1) || (i == 0 && j == cols - 1) || (i == rows - 1 && j == cols - 1)){
        			if(rows - 1 != 0 && 0 != cols - 1){
        				result[i][j] = (int) Math.floor((double)result[i][j] / 4);
        			} else if(rows - 1 == 0 && 0 == cols - 1){ 
        				result[i][j] = result[i][j];
        			} else if(rows - 1 == 0 && (j == 0 || j == cols - 1)) {
        				result[i][j] = (int) Math.floor((double)result[i][j] / 2);
        			} else if(cols - 1 == 0 && (i == 0 || i == rows - 1)) {
        				result[i][j] = (int) Math.floor((double)result[i][j] / 2);
        			}
        		} else if(i == 0 || j == 0 || i == rows - 1 || j == cols - 1){
        			if(rows - 1 != 0 && cols - 1 != 0){
        				result[i][j] = (int) Math.floor((double)result[i][j] / 6);
        			} else {
        				result[i][j] = (int) Math.floor((double)result[i][j] / 3);
        			}
        		} else {
        			result[i][j] = (int) Math.floor((double)result[i][j] / 9);
        		}
        		System.out.print(result[i][j] + " ");
        	}
        	System.out.println("");
        }
        return result;

    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		int [][]nums = {{1}};
		s.imageSmoother(nums);
		
	}
}
