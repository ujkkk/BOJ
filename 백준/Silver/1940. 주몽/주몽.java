import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   public static void main(String [] args) throws IOException {
   
	   Scanner sc = new Scanner(System.in);
	   int N = sc.nextInt();
	   long M = sc.nextLong();
	   int [] num = new int[N];
	   
	   for(int i=0; i<N; i++) {
		   num[i] = sc.nextInt();
	   }
	   
	   //오름차순 정렬
	   Arrays.sort(num);
	   
	   int start = 0;
	   int end = N-1;
	   int count = 0;
	   
	   while(start != end) {
		   if(num[start] + num[end]> M) {
			   end--;
		   }else if(num[start] + num[end]< M) {
			   start++;
		   }else {
			   count++;
			   end--;
		   }
	   }
	   System.out.println(count);
   
   
   }
}