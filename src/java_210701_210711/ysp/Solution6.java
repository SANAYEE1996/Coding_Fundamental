package java_210701_210711.ysp;

import java.util.ArrayList;

public class Solution6 {
	boolean solution(String s) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('!');
        for(int i = 0; i < s.length(); i++) {
        	if(list.get(list.size()-1) =='(' && s.charAt(i) == ')') {
        		list.remove(list.size()-1);
        	}
        	else {
        		list.add(s.charAt(i));
        	}
        }
        if(list.size() == 1) {
        	return true;
        }
        else {
        	return false;
        }
    }
	
	public static void main(String[] args) {
		Solution6 s = new Solution6();
		
		System.out.println("the answer is : " +s.solution("(())()"));
		System.out.println("the answer is : " +s.solution("(())()()(())()(())"));
	}
}
