package java_210623_start.ysp;

import java.util.Arrays;

//영어 끝말 잇기
public class Solution4 {
	public int[] solution(int n, String[] words) {
    	int[] answer = new int[2];
        for(int i = 1; i < words.length; i++) {
        	char before = words[i-1].charAt(words[i-1].length()-1);
        	char after = words[i].charAt(0);
        	if(( before != after ) || Existed(words,words[i],i)) {
        		answer[0] = (i%n) + 1;
        		answer[1] = (i/n) + 1;
        		break;
        	}
        }
        return answer;
    }
    
    public static boolean Existed(String[] words, String w,int index) {
    	boolean isExisted = false;
    	for(int i = 0; i < index; i++) {
    		if(w.equals(words[i])) {
    			isExisted = true;
    			break;
    		}
    	}
    	return isExisted;
    }
    
    public static void main(String[] args) {
    	Solution4 s = new Solution4();
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int n = 3;
		
		System.out.println("the answer is : " +Arrays.toString(s.solution(n, words)));
	}

}
