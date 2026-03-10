import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

       int T = Integer.parseInt(br.readLine());
       StringBuilder result = new StringBuilder();

       for(int t=0; t<T; t++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           int H = Integer.parseInt(st.nextToken());
           int W = Integer.parseInt(st.nextToken());
           int N = Integer.parseInt(st.nextToken());

           int Y = N%H;
           int X = N%H == 0? N/H : N/H+1;

           result.append(Y == 0? H:Y).append(String.format("%02d", X)).append("\n");
       }
        System.out.println(result);


    }



}