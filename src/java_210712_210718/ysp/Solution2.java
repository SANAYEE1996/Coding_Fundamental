package java_210712_210718.ysp;

import java.util.Arrays;

public class Solution2 {
	public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        long a = 0;
        long b = 0;
        int j;
        String s = "";
        for(int i = 0; i < numbers.length; i++) {
        	a = numbers[i];
        	if(a %2 == 0) {
        		j = 1;
            	while(true) {
            		b = a+j;
            		s = Long.toBinaryString(a^b);
            		if(countChar(s,'1') <= 2) {
            			answer[i] = b;
            			break;
            		}
            		j++;
            	}
        	}
        	else {
        		int count = 0;
        		s = Long.toBinaryString(a);
        		for(int k = s.length()-1; k >= 0; k--) {
        			if(s.charAt(k) == '1') {
        				count++;
        			}
        			else {
        				break;
        			}
        		}
        		answer[i] = a + ((long) Math.pow(2,(count-1)));
        	}
        }
        return answer;
    }
	
	public static int countChar(String str, char ch) {
		return str.length() - str.replace(String.valueOf(ch), "").length();
	}
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		long[] a = {2,7};
		long[] b = {1001,337,0,1,333,673,343,221,898,997,121,1015,665,779,891,421,222,256,512,128,100,45193574893512L};
		System.out.println(Arrays.toString(s.solution(a)));
		System.out.println(Arrays.toString(s.solution(b)));
		System.out.println(7^9);
	}
	
}

