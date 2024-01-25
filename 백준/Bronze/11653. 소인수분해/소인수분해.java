import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> primes = new ArrayList<>();

        if(N == 1){
           return;
        }

        List<Integer> ans = new ArrayList<>();
        while(N!= 1){
            boolean isGet = false;
            for(int i=2; i<=N; i++){
                if(N%i == 0 && isPrime(i)){
                    while(N%i == 0){
                        ans.add(i);
                        N /= i;
                    }
                    isGet = true;
                    break;
                }
            }
            if(!isGet){
                System.out.println("-1");
                return;
            }
        }

        Collections.sort(ans);
        for(int a : ans){
            bw.write(a+"\n");
        }
        bw.flush();

        bw.close();
        br.close();

    }

    public static boolean isPrime(int n){
        for(int i=2; i<= Math.sqrt(n); i++){
            if(n%2 == 0)
                return false;
        }
        // 소수이다.
        return true;
    }

}