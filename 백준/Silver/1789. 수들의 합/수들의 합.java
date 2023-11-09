
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		
		long partSum = 0;
		long i=1;
		long cnt = 0;
		while(partSum <= N) {
			partSum += i++;
			cnt++;
		}
		bw.write(cnt-1 + "");
		
		bw.flush();
		
		bw.close();
		br.close();
		
	}

}
