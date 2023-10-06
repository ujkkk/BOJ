import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;

        StringTokenizer st =  new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int p = Integer.parseInt(st.nextToken());
            if(p != 1){
                if(isPrime(p))
                    result++;
            }

        }

        System.out.println(result);
    }

    public static boolean isPrime(int n){
        for(int i=2; i<= Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

}




