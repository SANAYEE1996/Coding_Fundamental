package java_210625.ysp;

//프로그래머스 레벨 1 // 소수만들기 // 정초희님 참고하시기 바랍니다.
public class Sosu {
	public int solution(int[] nums) {
		int answer = 0;
		int sum = 0;
		for(int i = 0; i <nums.length-2; i++) {
			for(int j = i+1; j < nums.length-1; j++) {
				for(int k = j+1; k < nums.length; k++) {
					sum = nums[i]+nums[j]+nums[k];
					if(isSosu(sum)) {
						answer++;
					}
				}
			}
		}
		return answer;
	}
	
	public static boolean isSosu(int a) {
		boolean isSosu = true;
		for(int i = 2; i <= Math.sqrt(a)+1; i++) {
			if(a %i == 0) {
				isSosu = false;
				break;
			}
		}
		return isSosu;
	}
	
	public static void main(String[] args) {
		Sosu s = new Sosu();
		int[] nums = {1,2,7,6,4};
		System.out.println("the answer is : " +s.solution(nums));
	}
}
