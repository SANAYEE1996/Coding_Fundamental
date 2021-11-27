package java_210719_210725.ysp;

import java.util.ArrayList;

public class Solution3 {
	public String solution(String m, String[] musicinfos) {
		String answer = "";
		String[] c = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
		ArrayList<String> code = new ArrayList<>();
		for(String i : c) {
			code.add(i);
		}
		m = transCode(code, m);
		ArrayList<String> title = new ArrayList<>();
		ArrayList<Integer> playTime = new ArrayList<>();
        String compare = "";
        int firstIndex = 0;
        int lastIndex = 0;
        int time = 0;
        String[] a = {};
        for(int i = 0; i < musicinfos.length; i++) {
        	a = musicinfos[i].split(",");
        	a[3] = transCode(code,a[3]);
        	time = getTime(a[0],a[1]);
    		compare = getString(a[3],time);
    		if(compare.indexOf(m) > -1) {
        		firstIndex = compare.indexOf(m);
        		lastIndex = firstIndex+m.length();
        		if(m.equals(compare.substring(firstIndex,lastIndex))) {
        			title.add(a[2]);
        			playTime.add(time);
        		}
        	}
        }
        if(title.size() == 0) {
        	return "(None)";
        }
        else {
        	answer = title.get(0);
        	int max = playTime.get(0);
        	for(int i = 1; i < title.size(); i++) {
        		if(max < playTime.get(i)) {
        			max = playTime.get(i);
        			answer = title.get(i);
        		}
        	}
        	return answer;
        }
    }
	
	public static String transCode(ArrayList<String> code, String a) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < a.length(); i++) {
			if(i < a.length()-1 && a.charAt(i) == 'A' && a.charAt(i+1) == '#') {
				sb.append((char)(code.indexOf("A#")+65));
				i++;
			}
			else if(i < a.length()-1 && a.charAt(i) == 'C' && a.charAt(i+1) == '#') {
				sb.append((char)(code.indexOf("C#")+65));
				i++;
			}
			else if(i < a.length()-1 && a.charAt(i) == 'D' && a.charAt(i+1) == '#') {
				sb.append((char)(code.indexOf("D#")+65));
				i++;
			}
			else if(i < a.length()-1 && a.charAt(i) == 'F' && a.charAt(i+1) == '#') {
				sb.append((char)(code.indexOf("F#")+65));
				i++;
			}
			else if(i < a.length()-1 && a.charAt(i) == 'G' && a.charAt(i+1) == '#') {
				sb.append((char)(code.indexOf("G#")+65));
				i++;
			}
			else {
				sb.append((char)(code.indexOf(String.valueOf(a.charAt(i)))+65));
			}
		}
		return sb.toString();
	}
	
	public static int getTime(String a, String b) {
		int time = 0;
		if(a.substring(0,2).equals(b.substring(0,2))) {
			time = Integer.parseInt(b.substring(3)) - Integer.parseInt(a.substring(3));
		}
		else {
			time = (Integer.parseInt(b.substring(0,2)) - Integer.parseInt(a.substring(0,2))-1)*60;
			time += Integer.parseInt(b.substring(3));
			time += 60-Integer.parseInt(a.substring(3));
		}
		return time;
	}
	
	public static String getString(String a, int time) {
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < time/a.length(); j++) {
			sb.append(a);
		}
		sb.append(a.substring(0,time%a.length()));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		String[] a = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		String[] b = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		String[] c = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF","12:47,14:07,NONE,DEFG"};
		System.out.println(s.solution("ABCDEFG", a));
		System.out.println(s.solution("CC#BCC#BCC#BCC#B", b));
		System.out.println(s.solution("ABC", c));
		
	}
}
