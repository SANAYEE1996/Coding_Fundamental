package java_210719_210725.ysp;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] str = new String[numbers.length];
        StringBuilder before = new StringBuilder();
        StringBuilder after = new  StringBuilder();
        for(int i=0; i<numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
            	before.setLength(0);
            	after.setLength(0);
            	before.append(a);
            	before.append(b);
            	after.append(b);
            	after.append(a);
                return (after.toString()).compareTo(before.toString());
            }
        });
        
        if(str[0].equals("0")){
            return "0";
        }
        
        for(int i=0; i<numbers.length; i++){
            sb.append(str[i]);
        }        
        
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] a = {6, 10, 2};
		int[] b = {3, 30, 34, 5, 9};
		int[] c = {34,343};
		int[] d = {0,0,0,0};
		int[] e = {10,100,1000};
		System.out.println(s.solution(a));
		System.out.println(s.solution(b));
		System.out.println(s.solution(c));
		System.out.println(s.solution(d));
		System.out.println(s.solution(e));
	}
}
