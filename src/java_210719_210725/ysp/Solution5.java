package java_210719_210725.ysp;

import java.util.Arrays;
import java.util.Comparator;

public class Solution5 {
	public String[] solution(String[] files) {
		String a = "";
		String[][] type = new String[files.length][4];
		for(int i = 0; i < files.length; i++) {
			a = getNum(files[i]);
			type[i][0] = files[i].substring(0, files[i].indexOf(a)).toUpperCase();
			type[i][1] = a;
			type[i][2] = files[i].substring(files[i].indexOf(a)+a.length()).toUpperCase();
			type[i][3] = files[i];
		}
		
		Arrays.sort(type, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])) {
                    if(Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])) {
                		return 1;
                	}
                    else if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
                    	return 0;
                    }
                	else 
                		return -1;
                }
                else
                    return o1[0].compareTo(o2[0]);
            }			
        });
		
        String[] answer = new String[files.length];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = type[i][3];
        }
        return answer;
    }
	
	public static String getNum(String a) {
		StringBuilder sb = new StringBuilder();
		END:
		for(int i = 0; i < a.length(); i++) {
			if(Character.isDigit(a.charAt(i))) {
				if(i+5 < a.length()) {
					for(int j = i; j < i+5; j++) {
						if(Character.isDigit(a.charAt(j))) {
							sb.append(a.charAt(j));
							if(j == i+4) break END;
						}
						else 
							break END;
					}
				}
				else {
					for(int j = i; j < a.length(); j++) {
						if(Character.isDigit(a.charAt(j))) {
							sb.append(a.charAt(j));
							if(j == a.length()-1) break END;
						}
						else 
							break END;
					}
				}
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Solution5 s = new Solution5();
		String[] a = {"img12.png", "img10.png", "img02.png", "img1.png","IMG01.GIF", "img2.JPG"};
		String[] b = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat","F-15"};
		String[] c = {"foo010bar020.zip","foo011b030.png"};
		String[] d = {"ABC12","AbC12","aBc12"};
		String[] e = {"abc0000011111","abc0000111111","abc0001111111","abc10002","abc10001"};
		String[] f = {"muzi1.txt", "MUZI1.txt", "muzi001.txt", "muzi1.TXT"};
		System.out.println(Arrays.toString(s.solution(a)));
		System.out.println(Arrays.toString(s.solution(b)));
		System.out.println(Arrays.toString(s.solution(c)));
		System.out.println(Arrays.toString(s.solution(d)));
		System.out.println(Arrays.toString(s.solution(e)));
		System.out.println(Arrays.toString(s.solution(f)));
	}
}
