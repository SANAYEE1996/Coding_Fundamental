package java_210701_210711.ysp;

import java.util.ArrayList;
import java.util.Collections;

public class Solution9 {
	public int solution(int[] priorities, int location) {
        int answer = 1;
        ArrayList<Integer> prior = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < priorities.length; i++) {
        	list.add(i);
        	prior.add(priorities[i]);
        }
        int max = 0;
        while(true) {
        	max = Collections.max(prior);
        	if(prior.get(0) == max) {
        		if(list.get(0) == location) {
        			break;
        		}
        		else {
	        		prior.remove(0);
	        		list.remove(0);
	        		answer++;
        		}
        	}
        	else {
        		prior.add(prior.get(0));
        		list.add(list.get(0));
        		prior.remove(0);
        		list.remove(0);
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution9 s = new Solution9();
		int[] priorities = {2, 1, 3, 2}; 
		int[] pr = {1, 1, 9, 1, 1, 1};
		int[] prr = {1 ,2, 3, 5, 9, 8, 7, 6};
		int[] prrr = {5,2,6,1,8,5};
		System.out.println("the answer is : " +s.solution(priorities, 2)+"\n");
		System.out.println("the answer is : " +s.solution(pr, 0)+"\n");
		System.out.println("the answer is : " +s.solution(prr, 0)+"\n");
		System.out.println("the answer is : " +s.solution(prrr, 4)+"\n");
	}
}
