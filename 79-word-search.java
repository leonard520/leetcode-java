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
	public void reset(boolean [][]visit, int row, int col){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				visit[i][j] = false;
			}
		}
	}
	public boolean search(int i, int j, char[][] board, String word, int k, boolean[][] visit){
		if(k == word.length()){
			return true;
		}
		int row = board.length;
		int col = board[0].length;
		boolean flag = false;
		if(i - 1 >= 0 && board[i - 1][j] == word.charAt(k + 1)){
			visit[i - 1][j] = true;
			flag |= search(i - 1, j , board, word, k + 1, visit);
			visit[i - 1][j] = false;
		}
		if(i + 1 < row && board[i - 1][j] == word.charAt(k + 1)){
			visit[i + 1][j] = true;
			flag |= search(i + 1, j , board, word, k + 1, visit);
			visit[i + 1][j] = false;
		}
		if(j - 1 >= 0 && board[i][j - 1] == word.charAt(k + 1)){
			visit[i][j - 1] = true;
			flag |= search(i, j - 1, board, word, k + 1, visit);
			visit[i][j - 1] = false;
		}
		if(j + 1 < col && board[i][j + 1] == word.charAt(k + 1)){
			visit[i][j + 1] = true;
			flag |= search(i, j + 1 , board, word, k + 1, visit);
			visit[i][j + 1] = false;
		}
		return flag;
	}
	public boolean exist(char[][] board, String word) {
        boolean [][]visit = new boolean[board.length][board[0].length];
        for(int j = 0; j < board.length; j++){
        	for(int k = 0; k < board[0].length; k++){
        		reset(visit, board.length, board[0].length);
        		if(board[j][k] == word.charAt(0)){
            		reset(visit, board.length, board[0].length);
        			visit[j][k] = true;
        			if(search(j, k, board, word, 1, visit) == true){
        				return true;
        			}
       			}
       		}
       	}
        return false;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int []nums = {1, 2, 3};
	}
}
