package com.eg;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	boolean []used;
	Map<Integer, Boolean> map;
	
	public Solution(){
		map = new HashMap<Integer, Boolean>();
	}
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    	if(desiredTotal <= 1){
    		return true;
    	}
    	if((1 + maxChoosableInteger) * maxChoosableInteger < 2 * desiredTotal){
    		return false;
    	}
    	used = new boolean[maxChoosableInteger];

		return helper(desiredTotal);
    }
    
    private boolean helper(int desiredTotal){
    	if(desiredTotal <= 0){
    		return false;
    	}
    	int n = 1;
    	Integer status = new Integer(0);
    	for(Boolean b:used){
    		status |= (b.equals(Boolean.TRUE) ? 1:0) * n;
    		n <<= 1;
    	}
    	System.out.println("current status: " + status);
    	
    	if(map.containsKey(status) == false){
    		for(int i = 0; i < used.length; i++){
    			if(used[i] == Boolean.FALSE){
    				used[i] = Boolean.TRUE;
    				if(helper(desiredTotal - i - 1) == false){
    					map.put(status, Boolean.TRUE);
    					used[i] = Boolean.FALSE;
    					return true;
    				}
    				used[i] = Boolean.FALSE;
    			}
    		}
    		map.put(status, Boolean.FALSE);
    	}
    	return map.get(status);
    }
    
    public static void main(String args[]){
    	Solution s = new Solution();
    	System.out.println(s.canIWin(8, 10));
    }
 }
