
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	구해야 하는 것 : 연속된 정보, 너비
	너비 : 쌓아야 한다. -> 365 배열을 만들고 포함되면 count 한다
	연속 정보 :입력 정보를 받고 시작일 기준으로 정렬 후 연속 날 합치
 */
public class Main {
	
	public static BufferedWriter bw;
	public static BufferedReader br;
	
	public static int [] counts;
	public static PriorityQueue<Schedule> schedules;
		
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		counts = new int[366];
		schedules = new PriorityQueue<Schedule>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for(int day=start; day<=end; day++) {
				counts[day]++;
			}
			
			schedules.add(new Schedule(start, end));
		}
		
		// 연속된 일정 합치기
		int sum = 0;
		
		Schedule cur = schedules.poll();
		int preStart = cur.start;
		int preEnd = cur.end;
		
		while(!schedules.isEmpty()) {
			cur = schedules.poll();
			
			// 새로운 일정 시작
			if(cur.start > preEnd+1) {
				
				// 전의 일정 직사각형 구하기
				int max = -1;
				for(int i=preStart; i<=preEnd; i++) {
					max = Math.max(counts[i], max);
				}
				sum += (preEnd - preStart +1)*max;
				
				// 새로운 일정으로 업데이트
				preStart = cur.start;
				preEnd = cur.end;
			}
			// 연속적인 일정일 때
			else {
				preEnd = Math.max(cur.end, preEnd);
			}
		}
		// 마지막 일정 직사각형 구하기
		int max = -1;
		for(int i=preStart; i<=preEnd; i++) {
			max = Math.max(counts[i], max);
		}
		sum += (preEnd - preStart +1)*max;
		
		System.out.println(sum);
	}
}
class Schedule implements Comparable<Schedule>{
	int start;
	int end;
	
	public Schedule(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Schedule o) {
		if(this.start == o.start) {
			return  (o.end-o.start)-(this.end-this.start);
		}
		return this.start - o.start;
	}
	
	
}




