package java_210701_210711.ysp;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {
	public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
        	list.add(i);
        }
        merge(answer,n,k,0,list);
        return answer;
    }
	
	public static long fact(int n) {
		long ans = 1;
		for(int i = 2; i <= n; i++) {
			ans *= i;
		}
		return ans;
	}
	
	public static void merge(int[] answer,int n,long k,int index,ArrayList<Integer> list) {
		long last = fact(n-1);
		for(int i = 1; i <= n; i++) {
			if((last*i - last + 1)<=k && k <= last*i) {
				n--;
				k -= (last*i - last);
				answer[index] = list.get(i-1);
				list.remove(i-1);
				index++;
				merge(answer,n,k,index,list);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		System.out.println("the answer is : " +Arrays.toString(s.solution(3,5)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(4,17)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(20,fact(20))));
		System.out.println("the answer is : " +Arrays.toString(s.solution(1,1)));
		
		System.out.println(fact(20));
	}
}
