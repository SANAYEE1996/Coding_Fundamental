package java_210726_210801.ysp;

import java.util.ArrayList;

public class Solution4 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] map = new String[m][n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		map[i][j] = board[i].substring(j,j+1);
        	}
        }
        
        while(isGo(map)) {
        	ArrayList<ArrayList<Integer>> datas = new ArrayList<ArrayList<Integer>>();
        	ArrayList<Integer> ex;
        	
	        for(int i = 0; i < map.length-1; i++) {
	        	for(int j = 0; j < map[i].length-1; j++) {
	        		if(!map[i][j].equals("0") && map[i][j].equals(map[i][j+1]) && 
	        			map[i][j].equals(map[i+1][j]) && map[i][j].equals(map[i+1][j+1])) {
	        			ex = new ArrayList<>(2);
	        			ex.add(i);
	        			ex.add(j);
	        			if(!datas.contains(ex)) {
	        				datas.add(ex);
	        			}
	        			 
	        			ex = new ArrayList<>(2);
	        			ex.add(i+1);
	        			ex.add(j);
	        			if(!datas.contains(ex)) {
	        				datas.add(ex);
	        			}
	        			
	        			ex = new ArrayList<>(2);
	        			ex.add(i);
	        			ex.add(j+1);
	        			if(!datas.contains(ex)) {
	        				datas.add(ex);
	        			}
	        			
	        			ex = new ArrayList<>(2);
	        			ex.add(i+1);
	        			ex.add(j+1);
	        			if(!datas.contains(ex)) {
	        				datas.add(ex);
	        			}
	        		}
	        	}
	        }
	        
	        for(int i = 0; i < datas.size(); i++) {
	        	map[datas.get(i).get(0)][datas.get(i).get(1)] = "0";
	        }
	        
	        
	        answer += datas.size();
	        String temp = "";
	        for(int j = 0; j < map[0].length; j++) {
		        for(int i = map.length-2; i >= 0; i--) {
		        	int c = i;
	        		for(int k = 0; k < map.length; k++) {
	        			if(c < map.length-1 && !map[c][j].equals("0") && map[c+1][j].equals("0")) {
	        				temp = map[c][j];
	        				map[c][j] = "0";
	        				map[c+1][j] = temp;
	        				c++;
	        			}
	        		}
		        }
		    }
	        
        }
        
        return answer;
    }
    
    public static boolean isGo(String[][] map) {
    	boolean is = false;
    	for(int i = 0; i < map.length-1; i++) {
        	for(int j = 0; j < map[i].length-1; j++) {
        		if(!map[i][j].equals("0") && map[i][j].equals(map[i][j+1]) && 
        			map[i][j].equals(map[i+1][j]) && map[i][j].equals(map[i+1][j+1])) {
        			is = true;
        			break;
        		}
        	}
        }
    	return is;
    }
	
	public static void main(String[] args) {
		Solution4 s = new Solution4();
		String[] a = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		String[] b = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(s.solution(4, 5, a));
		System.out.println(s.solution(6, 6, b));
		
	}
}