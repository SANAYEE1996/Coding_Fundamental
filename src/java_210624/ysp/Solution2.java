package java_210624.ysp;

//N개의 최소 공배수
public class Solution2 {
	public int solution(int[] arr) {
        int answer = 0;
        if(arr.length >1) {
        	for(int i = 0; i < arr.length-1; i++) {
        		answer = lcm(arr[i],arr[i+1]);
        		arr[i+1] = answer;
        	}
        }else {
        	answer = arr[0];
        }
        return answer;
    }
	
	public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }
	public static int lcm(int a, int b) {
		return (a*b)/gcd(a,b);
	}
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[] arr = {1,2,3};
		System.out.println("the answer is : "+s.solution(arr));
	}

}
