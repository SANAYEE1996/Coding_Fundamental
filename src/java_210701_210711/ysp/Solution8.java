package java_210701_210711.ysp;

import java.util.ArrayList;

public class Solution8 {
	public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
        	sb.append(s.substring(1));
        	sb.append(s.charAt(0));
        	if(isRight(sb,list)) answer++;
        	s = sb.toString();
        	sb.setLength(0);
        }
        return answer;
    }
	
	public static boolean isRight(StringBuilder sb,ArrayList<Character> list) {
		list.add('!');
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == ')') {
				if(list.get(list.size()-1) == '(') {
					list.remove(list.size()-1);
				}
				else {
					list.add(')');
				}
			}
			else if(sb.charAt(i) == '}') {
				if(list.get(list.size()-1) == '{') {
					list.remove(list.size()-1);
				}
				else {
					list.add('}');
				}		
			}
			else if(sb.charAt(i) == ']') {
				if(list.get(list.size()-1) == '[') {
					list.remove(list.size()-1);
				}
				else {
					list.add(']');
				}
			}
			else {
				list.add(sb.charAt(i));
			}
		}
		if(list.size() == 1) {
			list.clear();
			return true;
		}
		else {
			list.clear();
			return false;
		}
	}
	
	public static void main(String[] args) {
		Solution8 s = new Solution8();
		System.out.println("the answer is : " +s.solution("[](){}"));
		System.out.println("the answer is : " +s.solution("}]()[{"));
		System.out.println("the answer is : " +s.solution("[)(]"));
		System.out.println("the answer is : " +s.solution("}}}"));
	}
}
