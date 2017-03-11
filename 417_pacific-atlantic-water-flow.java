package com.eg;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	int [][]pacific;
	int [][]atlantic;
	pair []dir;
	class pair{
		int x;
		int y;
		public pair(int xx, int yy){
			x = xx;
			y = yy;
		}
		public pair(){
			
		}
	}
	boolean isIn(int m, int n, int x, int y){
		return (x >= 0 && y >= 0 && x < m && y < n);
	}

	public void bfs(int[][] a, boolean pacific, boolean [][]v){
		Queue<pair> queue = new LinkedList<pair>();
		int m = a.length;
		int n = a[0].length;
		int r = 0;
		int l = 0;
		
		if(pacific == false){
			r = m - 1;
			l = n - 1;
		}
		for(int i = 0; i < n; i++){
			queue.offer(new pair(r, i));
			v[r][i] = true;
		}
		for(int i = 0; i < m; i++){
			queue.offer(new pair(i, l));
			v[i][l] = true;
		}
		
		while(queue.isEmpty() == false){
			pair p = queue.poll();
			int x = p.x;
			int y = p.y;
			for(pair pp : dir){
				int xx = x + pp.x;
				int yy = y + pp.y;
				if(isIn(m, n, xx ,yy) && v[xx][yy] == false && a[x][y] <= a[xx][yy]){
					v[xx][yy] = true;
					queue.offer(new pair(xx, yy));
				}
			}
		}
	}
    public List<int[]> pacificAtlantic(int[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
    		return new LinkedList<>();
    	}
    	List<int[]> res = new LinkedList<>();
        dir = new pair[4];
        dir[0] = new pair(1, 0);
        dir[1] = new pair(-1, 0);
        dir[2] = new pair(0, 1);
        dir[3] = new pair(0, -1);
		int m = matrix.length;
		int n = matrix[0].length;
		boolean [][]p = new boolean[m][n];
		boolean [][]a = new boolean[m][n];
        bfs(matrix, true, p);
        bfs(matrix, false, a);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(p[i][j] && a[i][j])
                    res.add(new int[]{i,j});
            }
        }
        return res;
    }
    
    public static void main(String args[]){
    	int[][] matrix = {{1,1}, {1,1},{1,1}};
    	
    	Solution s = new Solution();
    	s.pacificAtlantic(matrix);
    }
}