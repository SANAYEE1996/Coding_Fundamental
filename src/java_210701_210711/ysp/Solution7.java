package java_210701_210711.ysp;

import java.util.ArrayList;

public class Solution7 {
	public int solution(String s) {
		
        char a = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder eng = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        for(int i = 0; i < s.length(); i++) {
        	a = s.charAt(i);
        	if(Character.isDigit(a)) {
        		sb.append(a);
        	}
        	else {
        		eng.append(a);
        		if(list.contains(eng.toString())) {
        			sb.append(engNum(list,eng));
        			eng.setLength(0);
        		}
        	}
        }
        
        return Integer.parseInt(sb.toString());
    }
	
	public static String engNum(ArrayList<String> list,StringBuilder eng) {
		String a = "";
		for(int i = 0; i < list.size(); i++) {
			if(eng.toString().equals(list.get(i))) {
				a = String.valueOf(i);
				break;
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		Solution7 s = new Solution7();
		System.out.println("the answer is : " +s.solution("one4seveneight"));
		System.out.println("the answer is : " +s.solution("23four5six7"));
		System.out.println("the answer is : " +s.solution("2three45sixseven"));
		System.out.println("the answer is : " +s.solution("123"));
	}
}
