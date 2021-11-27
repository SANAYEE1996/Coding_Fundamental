package java_210624.ysp;

//프로그래머스 레벨 2 // 2017 립스타운 // 알고리즘 문제 생각 잘할 것.
public class Solution {
	public int solution(int n, int a, int b) {
        int answer = 0;
        int flag = 0;
        for(int i = 1; i <= 20; i++) {
    		if(Math.pow(2, i) == n) {
    			flag = i;
    			break;
    		}
    	}
        if((a <= n/2 && n/2 < b)||(b <= n/2 && n/2 < a)) {
        	answer = flag;
        }
        else {
        	if(a > n/2 && b > n/2) {
        		a -= n/2;
        		b -= n/2;
        		return solution(n/2,a,b);
        	}
        	else {
        		return solution(n/2,a,b);
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println("the answer is : " +s.solution(8, 2, 3));
	}
}
