package java_210628.ysp;

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length-1; i++) {
        	if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println("the answer is : " +s.solution(phone_book));
	}
}
