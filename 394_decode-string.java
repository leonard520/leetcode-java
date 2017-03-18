package com.eg;

public class Solution {
	boolean isDigit(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }
	
	public String decodeStringInternal(String s){
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while(i < s.length()){
			if(isDigit(s.charAt(i))){
				int times = s.charAt(i) - '1';
				i++;//[
				int j = i + 1;
				int brace = 1;
				while(j < s.length() && brace != 0){
					if(s.charAt(j) == '[') brace++;
					else if(s.charAt(j) == ']') brace--;
					j++;
				}
				String result = decodeStringInternal(s.substring(i, j));
				for(int k = 0; k < times; k++){
					sb.append(result);
				}
			} else {
				sb.append(s.charAt(i));
				i++;
			}
		}
		return sb.toString();
	}
	
    public String decodeString(String s) {
        return decodeStringInternal(s);
    }
    
    public static void main(String args[]){
    	String s = "3[a]2[bc]";
    	Solution solution = new Solution();
    	System.out.println(solution.decodeString(s));
    }
}