package java_210701_210711.ysp;

import java.util.Arrays; 

public class Solution {
	public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int sum = 0;
        int index = people.length-1;
        END:
        for(int i = 0; i < people.length;i++) {
        	sum = people[i] + people[index];
        	if(people[i] != 0 && people[index] != 0) {
	        	if(sum <= limit) {
	        		people[i] = 0;
	        		people[index] = 0;
	        		answer++;
	        		index--;
	        	}
	        	else if(sum > limit) {
	        		for(int j = index-1; j >= 0; j--) {
	        			sum = people[i] + people[j];
	        			if(sum <= limit && j != 0) {
	        				people[i] = 0;
	        				people[j] = 0;
	        				index = j-1;
	        				answer++;
	        				break;
	        			}
	        			else if(sum > limit && j == 0) {
	        				break END;
	        			}
	        		}
	        	}
        	}
        	if(i >= index) break;
        }
        for(int i = 0; i < people.length; i++) {
        	if(people[i] != 0) {
        		answer++;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] people = {70, 80, 50};
					// {0 , 0 , 0,  0,  ,0 ,  , 0 , 0, , 0,  }
		System.out.println("the answer is : " +s.solution(people,100));
		
	}
}
