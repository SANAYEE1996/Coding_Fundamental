package java_210630_start.ysp;


//프로그래머스 레벨 2 // 조이스틱 // 탐욕 알고리즘 //
public class Solution3 {
	public int solution(String name) {
        int answer = 0;
        int case1 = -1;
        char a = 0;
        int[] arr = new int[name.length()];
        for(int i = 0; i < name.length(); i++) {
        	a = name.charAt(i); 
        	arr[i]=Math.min((int)a - 65, 91-(int)a);
        	answer += arr[i];
        	case1++;
        } 
           
        int beforemin = 0;
        int min = 1000;
        
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == 0) {
        		if(i != arr.length-1 && arr[i+1] != 0) {
        			beforemin = callReturn(arr,i);
        		}
        		else if(i != arr.length-1 && arr[i+1] == 0) {
        			beforemin = banbokReturn(arr,i+1);
        		}
        		min = Math.min(min, beforemin);
        	}
        }
        min--;
        answer += Math.min(case1,min);
        return answer;
    }
	
	public static int callReturn(int[] arr,int index) {
		int answer = (index-1)*2;
		for(int i = arr.length; i > index; i--) {
			answer++;
		}
		return answer;
	}
	
	public static int banbokReturn(int[] arr, int index) {
		int answer = (index-2)*2;
		int flag = 0;
		for(int i = index+1; i < arr.length; i++) {
			if(arr[i] == arr[i-1]) {
				flag = i;
			}
			else break;
		}
		for(int i = arr.length; i > flag; i--) {
			answer++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		String name = "ABAAAAAAAAABB";
		String name1 = "JEROEN";
		String name2 = "JAN";
		String name3 = "JAZ";
		String name4 = "BAAABAABB";
		System.out.println("the answer is : " +s.solution(name));
		System.out.println("the answer is : " +s.solution(name1));
		System.out.println("the answer is : " +s.solution(name2));
		System.out.println("the answer is : " +s.solution(name3));
		System.out.println("the answer is : " +s.solution(name4));

	}
}
