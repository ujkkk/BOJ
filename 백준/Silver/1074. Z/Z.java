import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
	
	static int r = 0;
	static int c = 0;
	static long ans = 0;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		solution(N,0,0);
		
		System.out.println(ans);
		
	}
	
	public static void solution(int N, double row, double col) {
		boolean isRowOver = false;
		boolean isColOver = false;
		
		if(N == 0 || row == r && col == c)
			return;
		
		if(r >= row + Math.pow(2, N-1)) {
			isRowOver = true;
		}
		if(c >= col + Math.pow(2, N-1)) {
			isColOver = true;
		}
		
		// 1사분면
		if(!isRowOver && !isColOver) {
			solution(N-1, row, col);
		}
		// 2사분면
		else if(!isRowOver && isColOver) {
			ans += Math.pow(2, N-1)* Math.pow(2, N-1);
			solution(N-1, row, col +  Math.pow(2, N-1));
			
		}// 3사분면
		else if(isRowOver && !isColOver) {
			ans += Math.pow(2, N-1)*Math.pow(2, N-1)*2;
			solution(N-1, row +  Math.pow(2, N-1), col);
			
		}// 4사분면
		else if(isRowOver && isColOver) {
			ans += Math.pow(2, N-1)*Math.pow(2, N-1)*3;
			solution(N-1, row +  Math.pow(2, N-1), col +  Math.pow(2, N-1));
		}
		
	}
}


