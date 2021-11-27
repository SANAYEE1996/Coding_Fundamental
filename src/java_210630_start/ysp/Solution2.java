package java_210630_start.ysp;

import java.util.PriorityQueue;

public class Solution2 {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
        	pq.add(scoville[i]);
        }
        int count = pq.size();
        int first = 0;
        int second = 0;
        int mix = 0;
        for(int i = 0; i < count; i++) {
        	if(i != count-1 && pq.peek() < K) {
	        	first = pq.peek();
	        	pq.poll();
	        	second = pq.peek();
	        	pq.poll();
	        	mix = first + second*2;
	        	pq.add(mix);
	        	answer++;
	        }
        	else if(i == count-1 && pq.peek() < K){
        		answer = -1;
        		break;
        	}
        	else {
        		break;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[] scoville = {1, 1};
		int K = 7;
		System.out.println("the answer is : " +s.solution(scoville, K));
	}
}
