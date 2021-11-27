package java_210726_210801.ysp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int[] solution(String msg) {
		ArrayList<String> list = new ArrayList<>();
		Queue<String> que = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 65; i <= 90; i++) {
			list.add(String.valueOf((char)i));
		}
		String before = "";
		String after = "";
		StringBuilder isDic = new StringBuilder();
		
		for(int i = 0; i < msg.length(); i++) {
			que.add(msg.substring(i, i+1));
		}
		while(true) {
			isDic.setLength(0);
			before = que.peek();
			que.poll();
			after = que.peek();
			isDic.append(before);
			isDic.append(after);
			if(list.contains(isDic.toString())) {
				while(true) {
					before = isDic.toString();
					que.poll();
					after = que.peek();
					isDic.setLength(0);
					isDic.append(before);
					isDic.append(after);
					if(!list.contains(isDic.toString())) break;
					if(que.size() == 0) break;
				}
				list.add(isDic.toString());
				result.add(list.indexOf(before)+1);
			}
			else {
				list.add(isDic.toString());
				result.add(list.indexOf(before)+1);
			}
			if(que.size() == 0) break;
		}
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
        	answer[i] = result.get(i);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution("KAKAO")));
		System.out.println(Arrays.toString(s.solution("TOBEORNOTTOBEORTOBEORNOT")));
		System.out.println(Arrays.toString(s.solution("ABABABABABABABAB")));
	}
}
