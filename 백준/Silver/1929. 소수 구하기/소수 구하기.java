
import java.io.*;
import java.util.*;


public class Main {
	
	public static BufferedWriter bw;
	public static BufferedReader br;

	static int N;
	static int M;
	static boolean [][] graph;

	
	public static void main(String[] args) throws Exception {
		
		br  = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		boolean isPrime [] = new boolean[N+1];
		Arrays.fill(isPrime, true);
		
		boolean [] ans =prime(isPrime);
		for(int i=M; i<=N; i++) {
			if(isPrime[i])
				bw.write(i+"\n");
		}
		
		bw.flush();
			
	}
	
	public static boolean [] prime(boolean [] isPrime) {
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2; i<= isPrime.length/2; i++) {
			if(!isPrime[i])
				continue;
			isPrime[i] = true;
			for(int j=i+i; j<=N; j=j+i){
				isPrime[j] = false;
			}
		}
		return isPrime;
	}
	
	


	
}





