package java_210712_210718.ysp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] numb = new int[columns*rows];
        int a,b,c,d;
        for(int i = 0; i < numb.length; i++) {
        	numb[i] = i+1;
        }
        for(int i = 0; i < queries.length; i++) {
        	a = queries[i][0];
        	b = queries[i][1];
        	c = queries[i][2];
        	d = queries[i][3];
        	line(a,b,c,d,numb,rows,columns,answer,i);
        }
        return answer;
    }
	
	public static void line(int a,int b,int c,int d,int[] numb,int rows, int columns,int[] answer, int index) {
		ArrayList<Integer> list = new ArrayList<>();
		int start = (a-1)*columns + b;
		int end = (c-1)*columns + d;
		for(int i = start-1; i <= start + d-b-1; i++) {
			list.add(numb[i]);
		}
		for(int i = start+d-b-1+columns; i <= end-1; i+= columns) {
			list.add(numb[i]);
		}
		for(int i = end -2; i >= end-d+b-1; i--) {
			list.add(numb[i]);
		}
		for(int i = end-d+b-1 -columns; i > start; i -= columns) {
			list.add(numb[i]);
		}
		
		answer[index] = Collections.min(list);
		
		
		for(int i = start; i <= start + d-b-1; i++) {
			numb[i] = list.get(0);
			list.remove(0);
		}
		for(int i = start+d-b-1+columns; i <= end-1; i+= columns) {
			numb[i] = list.get(0);
			list.remove(0);
		}
		for(int i = end -2; i >= end-d+b-1; i--) {
			numb[i] = list.get(0);
			list.remove(0);
		}
		for(int i = end-d+b-1 -columns; i > start; i -= columns) {
			numb[i] = list.get(0);
			list.remove(0);
		}
		numb[start-1] = list.get(0);
		
		
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] a = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[][] b = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		int[][] c = {{1,1,100,97}};
		System.out.println("the answer is : " +Arrays.toString(s.solution(6, 6, a)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(3, 3, b)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(100, 97, c)));
	}
}
