package java_210719_210725.ysp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
	public int[] solution(String s) {
		
		HashMap<Integer,Integer> map = new HashMap<>();
		int key = 0;
		int val = 0;
		for(int i = 1; i < s.length()-1; i++) {
			if(s.charAt(i)=='{') {
				key = i;
			}
			if(s.charAt(i)=='}') {
				val = i-key;
				map.put(key, val);
				key = 0;
				val = 0;
			}
		}
		List<Integer> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
		ArrayList<Integer> list = new ArrayList<>();
		for(Integer i : keySetList) {
			String[] str = s.substring(i+1,i+map.get(i)).split(",");
			for(int j = 0; j < str.length; j++) {
				if(!list.contains(Integer.parseInt(str[j]))) {
					list.add(Integer.parseInt(str[j]));
				}
			}
		}
		
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(Arrays.toString(s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
		System.out.println(Arrays.toString(s.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
		System.out.println(Arrays.toString(s.solution("{{20,111},{111}}")));
		System.out.println(Arrays.toString(s.solution("{{123}}")));
		System.out.println(Arrays.toString(s.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
	}
}
