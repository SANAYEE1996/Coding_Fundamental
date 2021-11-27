package java_210726_210801.ysp;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
	public long solution(String expression) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char a = 0;
        END:
        for(int i = 0; i < expression.length(); i++) {
        	sb.setLength(0);
        	a = expression.charAt(i);
        	if(Character.isDigit(a)) {
        		sb.append(a);
        		for(int j = i+ 1; j < expression.length(); j++) {
					a = expression.charAt(j);
					if (Character.isDigit(a)) {
						sb.append(a);
						if (j == expression.length() - 1) {
							list.add(sb.toString());
							break END;
						}
					} else {
						i += (j - i - 1);
						break;
					}
				}
				list.add(sb.toString());
			} else {
				list.add(String.valueOf(a));
			}
		}
		Long[] answer = { gmp(list), gpm(list), mgp(list), mpg(list), pgm(list), pmg(list) };
		Arrays.sort(answer);
		return answer[5];
	}

	public static long gmp(ArrayList<String> list) {
		ArrayList<String> copy = new ArrayList<>();
		copy.addAll(list);
		Gob(copy);
		Minus(copy);
		Plus(copy);
		return Math.abs(Long.parseLong(copy.get(0)));
	}

	public static long gpm(ArrayList<String> list) {
		ArrayList<String> copy = new ArrayList<>();
		copy.addAll(list);
		Gob(copy);
		Plus(copy);
		Minus(copy);
		return Math.abs(Long.parseLong(copy.get(0)));
	}

	public static long mgp(ArrayList<String> list) {
		ArrayList<String> copy = new ArrayList<>();
		copy.addAll(list);
		Minus(copy);
		Gob(copy);
		Plus(copy);
		return Math.abs(Long.parseLong(copy.get(0)));
	}

	public static long mpg(ArrayList<String> list) {
		ArrayList<String> copy = new ArrayList<>();
		copy.addAll(list);
		Minus(copy);
		Plus(copy);
		Gob(copy);
		return Math.abs(Long.parseLong(copy.get(0)));
	}

	public static long pgm(ArrayList<String> list) {
		ArrayList<String> copy = new ArrayList<>();
		copy.addAll(list);
		Plus(copy);
		Gob(copy);
		Minus(copy);
		return Math.abs(Long.parseLong(copy.get(0)));
	}

	public static long pmg(ArrayList<String> list) {
		ArrayList<String> copy = new ArrayList<>();
		copy.addAll(list);
		Plus(copy);
		Minus(copy);
		Gob(copy);
		return Math.abs(Long.parseLong(copy.get(0)));
	}

	public static void Gob(ArrayList<String> list) {
		long a = 0;
		long b = 0;
		while (list.contains("*")) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				if (list.get(i).equals("*")) {
					a = Long.parseLong(list.get(i - 1));
					b = Long.parseLong(list.get(i + 1));
					a = a * b;
					list.set(i - 1, String.valueOf(a));
					list.remove(i);
					list.remove(i);
					break;
				}
			}
		}
	}

	public static void Minus(ArrayList<String> list) {
		long a = 0;
		long b = 0;
		while (list.contains("-")) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				if (list.get(i).equals("-")) {
					a = Long.parseLong(list.get(i - 1));
					b = Long.parseLong(list.get(i + 1));
					a = a - b;
					list.set(i - 1, String.valueOf(a));
					list.remove(i);
					list.remove(i);
					break;
				}
			}
		}
	}

	public static void Plus(ArrayList<String> list) {
		long a = 0;
		long b = 0;
		while (list.contains("+")) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				if (list.get(i).equals("+")) {
					a = Long.parseLong(list.get(i - 1));
					b = Long.parseLong(list.get(i + 1));
					a = a + b;
					list.set(i - 1, String.valueOf(a));
					list.remove(i);
					list.remove(i);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.solution("100-200*300-500+20"));
		System.out.println(s.solution("50*6-3*2"));
		System.out.println(s.solution("200-300-500-600*40+500+500"));
		System.out.println(s.solution("2-990-5+2"));
		System.out.println(s.solution("177-661*999*99-133+221+334+555-166-144-551-166*166-166*166-133*88*55-11*4+55*888*454*12+11-66+444*99"));
	}
}
