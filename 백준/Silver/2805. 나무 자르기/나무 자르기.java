import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] trees = new int[N];
		
		// 나무의 크기 입력 받기
		int low = 0;
		int high = -1;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			high = Math.max(high, trees[i]);
		}
		
		// 절단기의 최댓값 찾기
		while(low <= high) {
			int mid = (low+high)/2;
			
			long cuttingSum = 0;
			for(int tree : trees) {
				if(tree > mid) {
					// 절단된 나무 더하기
					cuttingSum += (tree - mid);
				}
			}
			
			// 절단된 크기가 원하는 나무의 크기보다 작을 때
			if(cuttingSum < M) {
				high = mid-1;
			}
			// 절단된 크기가 원하는 나무의 크기보다 클 때
			else {
				low = mid +1;
			}
		}
		bw.write(high +"");
		
		bw.flush();
		
		bw.close();
		br.close();
		
	}

}
