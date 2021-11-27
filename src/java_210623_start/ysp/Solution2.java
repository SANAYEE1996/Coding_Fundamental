package java_210623_start.ysp;

public class Solution2 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; i++) {
        	for(int j = 0; j < arr2[0].length; j++) {
        		for(int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[][]arr1 = {	{2, 3, 2},
						{4, 2, 4},
						{3, 1, 4}};
		int[][]arr2 = {	{5, 4},
						{2, 4},
						{3, 1}};
		
		int[][] arr = s.solution(arr1,arr2);
		
		for (int i = 0; i < arr.length; i++) {
			int[] inArr = arr[i];
			for (int j = 0; j < inArr.length; j++) {
				System.out.print(inArr[j] + " ");
			}
			System.out.println();
		}
	}
}

/*
 * arr1의 행 길이는 3 arr1의 열 길이는 3
 * arr2의 행 길이는 3 arr2의 열 길이는 2
 * 
 * */
