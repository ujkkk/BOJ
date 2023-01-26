
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int n= 0;
		int last = 0;
		Queue<Integer> que = new LinkedList<>();
		//1~N 까지 큐에 데이터 삽입
		for(int i=0; i< N; i++) {
			que.add(i+1);
		}
		while(true) {
			last = que.remove();
			if(que.peek() == null) break;
			n  = que.remove();
			que.add(n);
		}
		System.out.println(last);
		
	}
	
}
