import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        // 1. 소수 구하기
       ArrayList<Integer> primes = getPrime(N);

//       for(int p : primes){
//           System.out.print(p+" ");
//       }

       // 2. 경우의 수 찾기
        int sum = 0;
        int end = -1;
        int start = -1;
        int count = 0;

       while(true){
           if(sum <= N){
               if(end == primes.size()-1){
                   break;
               }
               end++;
               sum += primes.get(end);

           }
           else if(sum > N){
               start++;
               sum -= primes.get(start);

               if(start >= end){
                   break;
               }
           }

           if(sum == N){
               count++;
           }
       }

        System.out.println(count);
    }

    private static ArrayList<Integer> getPrime(int N){
        boolean isNotPrime [] = new boolean[N+1];

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i=2; i*i <= N+1; i++){
            if(isNotPrime[i]){
                continue;
            }

            for(int j=i+i; j<=N; j+=i){
                isNotPrime[j] = true;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<isNotPrime.length; i++){
            if(!isNotPrime[i]){
                result.add(i);
            }
        }
        return result;
    }

}

