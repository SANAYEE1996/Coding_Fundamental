package java_210712_210718.ysp;

import java.util.LinkedList;
import java.util.Queue;

public class Solution6 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        int i = 1;
        int sum = 0;
        boolean go = true;
        q.add(truck_weights[0]);
        while(q.size() != 0) {
        	time++;
        	if(go) {
	        	q.add(truck_weights[i]);
	        	sum += truck_weights[i];
        	}
        	
        	if(i+1 < truck_weights.length && sum + truck_weights[i+1] < weight && q.size() < bridge_length) {
        		i++;
        		go = true;
        	}
        	else {
        		go = false;
        	}
        	System.out.println(q);
        	if(q.size() == bridge_length) {
        		q.poll();
        		sum -= truck_weights[i];
        		go = true;
        	}
        	if(q.size() == 0 || time == 10) {
        		break;
        	}
        }
        answer = time;
        return answer;
    }
	
	public static void main(String[] args) {
		Solution6 s = new Solution6();
		int bridge_length = 2; 
		int weight = 10; 
		int[] truck_weights = {7,4,5,6};
		System.out.println(s.solution(bridge_length, weight, truck_weights));
	}
}
