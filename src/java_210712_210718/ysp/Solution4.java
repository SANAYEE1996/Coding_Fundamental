package java_210712_210718.ysp;

public class Solution4 {
	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		int i = 0;
		while(true) {
			sb.append(conversion(i,n));
			for(int j = 0; j < sb.length(); j++) {
				if((j+1)%m == 0) {
					answer.append(sb.charAt(j-(m-p)));
				}
			}
			if(answer.length() == t) {
				break;
			}
			answer.setLength(0);
			i++;
		}
        return answer.toString();
    }
	
	public static StringBuilder conversion(int number, int N){
        StringBuilder sb = new StringBuilder();
	    int current = number;
        while(current > 0){
            if(current % N < 10){
                sb.append(current % N);
            } else {
                sb.append((char)(current % N - 10 + 'A'));
            }
            current /= N;
        }
        if(number == 0) {
        	sb.setLength(0);
        	sb.append("0");
        	return sb;
        }
        return sb.reverse();
    }
	
	public static void main(String[] args) {
		Solution4 s = new Solution4();
		System.out.println(s.solution(2, 4, 2, 1));
		System.out.println(s.solution(16, 16, 2, 1));
		System.out.println(s.solution(16, 16, 2, 2));
		
		System.out.println(conversion(100,15));
	}
}
