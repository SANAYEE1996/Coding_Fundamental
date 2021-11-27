package java_210630_start.ysp;

public class Solution {
	public int solution(String dartResult) {
        char a = 0;
        int index = -1;
        int score = 0;
        int[] board = new int[3];
        for(int i = 0; i < dartResult.length(); i++) {
        	a = dartResult.charAt(i);
        	if(Character.isDigit(a)) {
        		index++;
        		score = Character.getNumericValue(a);
        		if(a == '1' && dartResult.charAt(i+1) == '0') {
        			score = 10;
        			i++;
        		}
        	}
        	else {
        		board(board,score,index,a);
        	}
        }
        return board[0]+board[1]+board[2];
    }
	
	public static void board(int[] board,int score,int index,char a) {
		if(a == 'S') {
			board[index] = score;
		}
		else if(a == 'D') {
			board[index] = score*score;
		}
		else if(a == 'T') {
			board[index] = score*score*score;
		}
		else if(a == '*') {
			if(index != 0) {
				board[index] *= 2;
				board[index-1] *= 2;
			}
			else { 
				board[index] *= 2;
			}
		}
		else {
			board[index] *= -1;
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println("the answer is : "+s.solution("1S*2T*3S"));
		System.out.println("the answer is : "+s.solution("1D2S3T*"));
		System.out.println("the answer is : "+s.solution("1D2S#10S"));
	}
}
