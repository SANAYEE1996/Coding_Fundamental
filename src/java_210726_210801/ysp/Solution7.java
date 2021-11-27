package java_210726_210801.ysp;

import java.util.ArrayList;

public class Solution7 {
	
	public String solution(String p) {
        StringBuilder sb = new StringBuilder();;
        if(isRight(p)) {
        	return p;
        }
        else if(p.equals("")) {
        	return "";
        }
        return sb.toString();
    }
	
	boolean isRight(String s) {
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
		Solution7 s = new Solution7();
		System.out.println(s.solution("(()())()"));
		System.out.println(s.solution(")("));
		System.out.println(s.solution("()))((()"));
		System.out.println(s.solution("))))()(((("));
	}

}
