package java_210712_210718.ysp;

public class Solution3 {
	public String solution(int n) {
		StringBuilder sb = new StringBuilder();
	    int a = 0;
        while(n > 0){
        	a = n%3;

            if(a == 0) {
            	n = n/3 -1;
                a = 4;
            }
            else {
            	n /= 3;
            }
            sb.append(a);
        }
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		for(int i = 1; i <= 39; i++) {
			System.out.println("the answer is : " +s.solution(i));
		}
		
	}
}
