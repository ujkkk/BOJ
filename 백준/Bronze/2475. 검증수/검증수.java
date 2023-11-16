import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main
{
	
	static long blueAns = 0;
	static long whiteAns = 0;
	static boolean [][] isBlue;
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
		// 색종이 정보 채우기
		for(int i=0; i<5; i++) {
            int n = Integer.parseInt(st.nextToken());
			sum += n*n;
			
		}
		bw.write(sum%10 +"\n");
		
		
		bw.flush();
		
		bw.close();
		br.close();
	}

}




