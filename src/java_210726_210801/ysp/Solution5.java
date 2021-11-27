package java_210726_210801.ysp;

public class Solution5 {
	public String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();
        int length;
        int max;
        int min;
        double sum;
        double score = 0;
        for(int i = 0; i < scores[0].length; i++) {
        	length = scores.length;
        	sum = 0;
        	max = scores[0][i];
        	min = scores[0][i];
        	for(int j = 0; j < scores.length; j++) {
        		if(Math.max(max, scores[j][i]) > max) {
        			max = Math.max(max, scores[j][i]);
        		}
        		if(Math.min(min, scores[j][i]) < min) {
        			min = Math.min(min, scores[j][i]);
        		}
        		sum += scores[j][i];
        	}
        	
        	if(scores[i][i] == max){
        		score = (sum-scores[i][i])/(length-1);
        		for(int j = 0; j < scores.length; j++) {
        			if(j != i && scores[j][i] == max) {
        				score = sum/length;
        				break;
        			}
        		}
        	}
        	else if(scores[i][i] == min){
        		score = (sum-scores[i][i])/(length-1);
        		for(int j = 0; j < scores.length; j++) {
        			if(j != i && scores[j][i] == min) {
        				score = sum/length;
        				break;
        			}
        		}
        	}
        	else {
        		score = sum/length;
        	}
        	
        	if(90 <= score)
        		sb.append("A");
        	else if(80 <= score && score < 90) {
        		sb.append("B");
        	}
			else if(70 <= score && score < 80) {
				sb.append("C");    		
			}
			else if(50 <= score && score < 70) {
				sb.append("D");
			}
			else{
				sb.append("F");
			}	
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Solution5 s = new Solution5();
		int[][] a = {
					{100,90,98,88,65},
					{50,45,99,85,77},
					{47,88,95,80,67},
					{61,57,100,80,65},
					{24,90,94,75,65}
					};
		System.out.println(s.solution(a));
	}
}
