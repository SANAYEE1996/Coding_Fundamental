package java_210701_210711.ysp;

import java.util.ArrayList;

public class Solution4 {
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String a = "";
        ArrayList<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < skill.length(); i++) {
        	list.add(skill.charAt(i));
        }
        for(int i = 0; i < skill_trees.length; i++) {
        	a = skill_trees[i];
        	for(int j = 0; j < a.length(); j++) {
        		if(list.contains(a.charAt(j))) {
        			sb.append(a.charAt(j));
        		}
        	}
        	if(isRight(skill,sb)) {
        		answer++;
        	}	
        	sb.setLength(0);
        }
        return answer;
    }
	
	public static boolean isRight(String skill, StringBuilder sb) {
		int cnt = 0;
		for(int i = 0; i < sb.length(); i++) {
			if(skill.charAt(i) == sb.charAt(i)) {
				cnt++;
			}
		}
		if(cnt == sb.length()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Solution4 s = new Solution4();
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		String[] skill_trees1 = {"AD", "BA", "DC", "CD"};
		System.out.println("the answer is : " +s.solution("CBD", skill_trees));
		System.out.println("the answer is : " +s.solution("CABD", skill_trees1));
	}
}
