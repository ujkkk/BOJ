import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        int digit = 10;
        int n = 1;
        for(int i=1; i<=N; i++){
            if(digit == i){
                digit *= 10;
                n++;
            }
            count += n;
        }
        System.out.println(count);
    }

}