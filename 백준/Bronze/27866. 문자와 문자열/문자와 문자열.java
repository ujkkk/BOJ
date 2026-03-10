import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

      String str = br.readLine();
      int idx = Integer.parseInt(br.readLine());
      System.out.println(str.charAt(idx-1));
    }



}