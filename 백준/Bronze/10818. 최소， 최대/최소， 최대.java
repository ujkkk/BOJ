import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

       int N = Integer.parseInt(br.readLine());
       int max = -1_000_001;
       int min = 1_000_001;

       StringTokenizer st = new StringTokenizer(br.readLine());
       for(int i=0; i<N; i++){
           int n = Integer.parseInt(st.nextToken());
           max = Math.max(n, max);
           min = Math.min(n, min);
       }

        System.out.println(min +" " + max);


    }



}