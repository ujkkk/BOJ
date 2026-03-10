import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

      int N = Integer.parseInt(br.readLine());
      int sum = 0;

      String str = br.readLine();
      for(int i=0; i<N; i++){
          sum += str.charAt(i) - '0';
      }
        System.out.println(sum);
    }



}