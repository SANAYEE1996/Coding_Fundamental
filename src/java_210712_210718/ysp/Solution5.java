package java_210712_210718.ysp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution5 {
	public int solution(String[][] clothes) {
        int answer = 1;
        String temp = "";
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < clothes.length; i++) {
        	temp = clothes[i][0];
        	clothes[i][0] = clothes[i][1];
        	clothes[i][1] = temp;
        }
        Arrays.sort(clothes, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }			
        });
        int sum = 1;
        for(int i = 0; i < clothes.length-1; i++) {
        	if(clothes[i][0].equals(clothes[i+1][0])) {
        		sum++;
        	}
        	else {
        		list.add(sum);
        		sum = 1;
        	}
        	if(i == clothes.length-2) list.add(sum);
        }
        for(int i = 0; i < list.size(); i++) {
        	answer *= (list.get(i)+1);
        }
        if(clothes.length == 1) return 1;
        return answer-1;
    }
	
	public static void main(String[] args) {
		Solution5 s = new Solution5();
		String[][] clothes = {{"yellowhat", "headgear"}
		, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes1 = {{"crowmask", "face"}
		, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		String[][] clothes2 = {{"crowmask", "face"}};
		System.out.println(s.solution(clothes));
		System.out.println(s.solution(clothes1));
		System.out.println(s.solution(clothes2));
	}
}
