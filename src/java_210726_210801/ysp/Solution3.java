package java_210726_210801.ysp;

public class Solution3 {
	public long solution(int n) {
        long a = 0;
        long b = 0;
        long c = 1;
    	for(int i = 0; i < n; i++) {
    		a = b%1234567;
    		b = c%1234567;
    		c = (a+b)%1234567;
    	}
        return c%1234567;
    }
	
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		System.out.println(s.solution(3));
		System.out.println(s.solution(4));
		System.out.println(s.solution(2000));
	}
}
