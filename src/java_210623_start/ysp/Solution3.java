package java_210623_start.ysp;

import java.util.Arrays;

//프로그래머스 레벨 2 주식가격
public class Solution3 {
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int cnt;
        for(int i = 0; i < prices.length; i++) {
        	cnt = 0;
        	for(int j = i+1; j < prices.length; j++) {
        		cnt++;
        		if(prices[i] > prices[j]) {
        			break;
        		}
        	}
        	answer[i] = cnt;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[] prices = {1, 2, 3, 2, 3};
		
		System.out.println("the answer is : " +Arrays.toString(s.solution(prices)));
		
	}
}
