package java_210726_210801.ysp;

public class Solution6 {
	
	public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int sum = 0;
        int beforeSum = 0;
        String job = "";
        String beforeJob = "A";
        for(int i = 0; i < table.length; i++) {
        	String[] ass = table[i].split(" ");
        	sum = 0;
        	job = ass[0];
        	for(int j = 0; j < preference.length; j++) {
        		String a = languages[j];
        		for(int k = 0; k < ass.length; k++) {
            		if(a.equals(ass[k])) {
            			sum += preference[j]*(ass.length - k);
            			break;
            		}
            	}
        	}
        	if(sum > beforeSum) {
        		answer = job;
        		beforeSum = sum;
            	beforeJob = job;
        	}
        	else if(sum == beforeSum) {
        		if(beforeJob.charAt(0) > job.charAt(0)) {
        			answer = job;
        			beforeSum = sum;
                	beforeJob = job;
        		}
        		else {
        			answer = beforeJob;
        		}
        	}
        	else {
        		answer = beforeJob;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution6 s = new Solution6();
		String[] a = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] b = {"PYTHON", "C++", "SQL"};
		int[] c = {7, 5, 5};
		
		String[] d = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] e = {"JAVA", "JAVASCRIPT"};
		int[] f = {7,5};
		
		System.out.println(s.solution(a, b, c));
		System.out.println(s.solution(d, e, f));
		
		System.out.println("a".charAt(0) < "b".charAt(0));

	}

}
