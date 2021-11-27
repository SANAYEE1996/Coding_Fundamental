package java_210701_210711.ysp;

import java.util.Arrays;

public class Solution10 {
	public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = 1;
        }
        Character[][] check = new Character[5][5];
        for(int i = 0; i < answer.length; i++) {
        	for(int j = 0; j < 5; j++) {
        		for(int k = 0; k < 5; k++) {
        			check[j][k] = places[i][j].charAt(k);
        		}
        	}
        	print(check,i,answer);
        }
        return answer;
    }
 	
 	public static void print(Character[][] check,int index, int[] answer) {
 		char a = 0;
 		END:
 		for(int i = 0; i < 5; i++) {
 			for(int j = 0; j<5; j++) {
 				a = check[i][j];
				if(i < 4 && j < 4) {
					if(a == 'P') {
 						if(check[i+1][j+1] == 'P' && (check[i+1][j] !='X' || check[i][j+1] != 'X')) {
 							answer[index] = 0;
 							break END;
 						}
					}
				}
				if(i < 4) {
					if(a == 'P') {
 						if(check[i+1][j] == 'P') {
 							answer[index] = 0;
 							break END;
 						}
					}
				}
				if(j < 4) {
					if(a == 'P') {
 						if(check[i][j+1] == 'P') {
 							answer[index] = 0;
 							break END;
 						}
					}
				}
				if(j > 0 && i < 4) {
					if(a == 'P') {
						if(check[i+1][j-1] == 'P' && (check[i+1][j] !='X' || check[i][j-1] != 'X')) {
 							answer[index] = 0;
 							break END;
 						}
					}
				}
				if(i < 3) {
					if(a == 'P') {
 						if(check[i+2][j] == 'P' && check[i+1][j] != 'X') {
 							answer[index] = 0;
 							break END;
 						}
					}
				}
				if(j < 3) {
					if(a == 'P') {
						if(check[i][j+2] == 'P' && check[i][j+1] != 'X') {
 							answer[index] = 0;
 							break END;
 						}
					}
				}
 			}
 		}
 	}
	
	public static void main(String[] args) {
		Solution10 s = new Solution10();
		String[][] places = {	{	"POOOP", 
									"OXXOX", 
									"OPXPX", 
									"OOXOX", 
									"POXXP"},
				
								{	"POOPX", 
									"OXPXP", 
									"PXXXO", 
									"OXXXO", 
									"OOOPP"}, 
								
								{	"PXOPX", 
									"OXOXP", 
									"OXPOX", 
									"OXXOP", 
									"PXPOX"},
								
								{	"OOOXX", 
									"XOOOX", 
									"OOOXX", 
									"OXOOX", 
									"OOOOO"},
								
								{	"PXPXP", 
									"XPXPX", 
									"PXPXP", 
									"XPXPX", 
									"PXPXP"},
								
								{	"OOPOO",
									"OPOOO",
									"OOOOO",
									"OOOOO",
									"OOOOO"},
								
								{	"OOOOO",
									"OPOOO",
									"OOOPO",
									"OOOOO",
									"OOOPO"}
							};
		
		System.out.println("the answer is : " +Arrays.toString(s.solution(places)));
	}
}
