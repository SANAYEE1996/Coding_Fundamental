package java_210719_210725.ysp;

import java.util.ArrayList;

public class Solution4 {
	public int solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> A = new ArrayList<>();
        ArrayList<String> B = new ArrayList<>();
        ArrayList<String> AB = new ArrayList<>();
        char a = 0;
        char b = 0;
        for(int i = 0; i < str1.length()-1; i++) {
        	a = Character.toUpperCase(str1.charAt(i));
        	b = Character.toUpperCase(str1.charAt(i+1));
        	if( (65 <=(int) a && (int) a <= 90) && (65 <=(int) b && (int) b <= 90)) {
        		sb.append(a);
        		sb.append(b);
        		A.add(sb.toString());
        		sb.setLength(0);
        	}
        }
        
        a = 0;
        b = 0;
        for(int i = 0; i < str2.length()-1; i++) {
        	a = Character.toUpperCase(str2.charAt(i));
        	b = Character.toUpperCase(str2.charAt(i+1));
        	if( (65 <=(int) a && (int) a <= 90) && (65 <=(int) b && (int) b <= 90)) {
        		sb.append(a);
        		sb.append(b);
        		B.add(sb.toString());
        		sb.setLength(0);
        	}
        }
        double union = A.size() + B.size();
        
        if(A.size() == 0 && B.size() == 0) {
        	return 65536;
        }
        
        if(A.size() < B.size()) {
	        for(String s : A) {
	        	if(B.contains(s)) {
	        		AB.add(s);
	        		B.remove(B.indexOf(s));
	        	}
	        }
        }
        else {
        	for(String s : B) {
	        	if(A.contains(s)) {
	        		AB.add(s);
	        		A.remove(A.indexOf(s));
	        	}
	        }
        }
        double interSection = AB.size();
        union -= interSection;
        int g = (int)Math.floor(interSection*65536/union);
        
        return g;
    }
	
	public static void main(String[] args) {
		Solution4 s = new Solution4();
		System.out.println(s.solution("FRANCE", "french"));
		System.out.println(s.solution("handshake", "shake hands	"));
		System.out.println(s.solution("aa1+aa2", "AAAA12"));
		System.out.println(s.solution("E=M*C^2", "e=m*c^2"));
		System.out.println(s.solution("aa1+aa2", "AA12"));
		System.out.println(s.solution("ab","ba_bd"));
		
	}
}
