package java_210628.ysp;

import java.util.ArrayList;

public class Solution2 {

	public int solution(String s) {
		int answer = 0;
		ArrayList<Character> list = new ArrayList<>();
		list.add('0');
		char c = 0;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c != list.get(list.size()-1)) {
				list.add(c);
			}
			else {
				list.remove(list.size()-1);
			}
		}
		if(list.size()==1) answer = 1;
		return answer;
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		String str = "baabaa";
		System.out.println("the answer is : " + s.solution(str));
	}

}
