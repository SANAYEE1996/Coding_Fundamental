package java_210701_210711.ysp;

import java.util.ArrayList;
 
public class Solution2 {
	public int solution(String dirs) {
        int answer = 0;
        int[] flag = new int[121];
        flag[60] = 1;
        int[] locate = {5,5};
        char a = 0;
        int index = 0;
        int nowIndex = 0;
        String check = "";
        String min = "";
        String max = "";
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < dirs.length(); i++) {
        	a = dirs.charAt(i);
        	index = locate[0]*11 + locate[1];
        	if(a == 'U' && locate[0] > 0) {
    			locate[0]--;
    			nowIndex = locate[0]*11 + locate[1];
    			min = String.valueOf(Math.min(index, nowIndex));
    			max = String.valueOf(Math.max(index, nowIndex));
    			check = min+max;
    			if(list.contains(check) != true) {
					list.add(check);
					if(flag[index] == 1 && flag[nowIndex] == 1) {
						flag[nowIndex] = 1;
	    				answer++;
	    			}
				}
    			if(flag[index] == 0 || flag[nowIndex] == 0) {
    				flag[nowIndex] = 1;
    				answer++;
    			}
        	}
        	else if(a == 'D' && locate[0] < 10) {
    			locate[0]++;
    			nowIndex = locate[0]*11 + locate[1];
    			min = String.valueOf(Math.min(index, nowIndex));
    			max = String.valueOf(Math.max(index, nowIndex));
    			check = min+max;
    			if(list.contains(check) != true) {
					list.add(check);
					if(flag[index] == 1 && flag[nowIndex] == 1) {
						flag[nowIndex] = 1;
	    				answer++;
	    			}
				}
    			if(flag[index] == 0 || flag[nowIndex] == 0) {
    				flag[nowIndex] = 1;
    				answer++;
    			}
        	}
			else if(a == 'L' && locate[1] > 0) {
				locate[1]--;
				nowIndex = locate[0]*11 + locate[1];
				min = String.valueOf(Math.min(index, nowIndex));
    			max = String.valueOf(Math.max(index, nowIndex));
    			check = min+max;
				if(list.contains(check) != true) {
					list.add(check);
					if(flag[index] == 1 && flag[nowIndex] == 1) {
						flag[nowIndex] = 1;
	    				answer++;
	    			}
				}
				if(flag[index] == 0 || flag[nowIndex] == 0) {
    				flag[nowIndex] = 1;
    				answer++;
    			}
			}
			else if(a == 'R' && locate[1] < 10){
				locate[1]++;
				nowIndex = locate[0]*11 + locate[1];
				min = String.valueOf(Math.min(index, nowIndex));
    			max = String.valueOf(Math.max(index, nowIndex));
    			check = min+max;
				if(list.contains(check) != true) {
					list.add(check);
					if(flag[index] == 1 && flag[nowIndex] == 1) {
						flag[nowIndex] = 1;
	    				answer++;
	    			}
				}
				if(flag[index] == 0 || flag[nowIndex] == 0) {
    				flag[nowIndex] = 1;
    				answer++;
    			}
			}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println("the answer is : " +s.solution("ULURRDLLU"));
		System.out.println("the answer is : " +s.solution("LULLLLLLU"));
		System.out.println("the answer is : " +s.solution("LRLRL"));
		System.out.println("the answer is : " +s.solution("UDU"));
	}
}
