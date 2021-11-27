package java_210701_210711.ysp;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution5 {
	
	public int solution(String numbers) {
		int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> orgin = new ArrayList<>();
        for(int i = 0; i < numbers.length(); i++) {
        	orgin.add(numbers.substring(i,i+1));
        	list.add(numbers.substring(i,i+1));
        }
        primed(orgin,numbers.length(),list);
        HashSet<Integer> hashSet = new HashSet<>();
        for(String item : list){
            hashSet.add(Integer.parseInt(item));
        }
        for(int i : hashSet) {
        	if(isPrimed(i)) {
        		answer++;
        	}
        }
        return answer;
    }
	
	public static void primed(ArrayList<String> orgin,int index,ArrayList<String> list) {
		StringBuilder sb = new StringBuilder();
		int length = list.size();
		for(int i = 0; i < length; i++) {
			ArrayList<String> copyOrgin = new ArrayList<String>();
			copyOrgin.addAll(orgin);
			copyOrgin = copyOrgin(copyOrgin, list.get(i));
			for(int j = 0; j < copyOrgin.size(); j++) {
				sb.append(list.get(i));
				sb.append(copyOrgin.get(j));
				if(list.contains(sb.toString()) == false) {
					list.add(sb.toString());
				}
				sb.setLength(0);
			}
		}
		
		if(index > 0) {
			primed(orgin,--index,list);
		}
	}
	
	public static ArrayList<String> copyOrgin(ArrayList<String> copy ,String a){
		for(int i = 0; i < a.length(); i++) {
			for(int j = 0; j < copy.size(); j++) {
				if(a.substring(i, i+1).equals(copy.get(j))) {
					copy.remove(j);
					break;
				}
			}
		}
		return copy;
	}
	
	
	
	public static boolean isPrimed(int c) {
		boolean isP = true;
		for(int i = 2; i <= Math.sqrt(c); i++) {
			if(c % i == 0){
				isP = false;
				break;
			}
		}
		if(c <= 1) {
			isP = false;
		}
		return isP;
	}
	
	public static void main(String[] args) {
		Solution5 s = new Solution5();
		System.out.println("the answer is : " +s.solution("1234567"));
	}
	
}
