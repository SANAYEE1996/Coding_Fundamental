package java_210623_start.ysp;

//숫자의 표현 프로그래머스 레벨 2
public class Solution {
	public int solution(int n) {
        int answer = 1;
        int sum = 0;
        for(int i = 1; i < n/2+1; i++) {
        	sum = 0;
        	for(int j = i; j<n/2+2; j++) {
        		sum += j;
        		if(sum == n) {
        			answer++;
        			sum = 0;
        			break;
        		}
        		else if (sum > n) {
        			sum = 0;
        			break;
        		}
        	}
        }
        return answer;
    }
	
	public static void main(String args[]) {
		Solution s = new Solution();
		
		System.out.println("the answer is : " +s.solution(9999));
		
		
	}
}
