import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] isPrime = new int[10000001];
        for(int i=0; i< isPrime.length; i++){
            isPrime[i] = i;
        }

        isPrime[0] = 0;
        isPrime[1] = 0;
        for(int i=2; i< Math.sqrt(isPrime.length); i++){
            if(isPrime[i] == 0)
                continue;

            for(int j=i*i; j< isPrime.length; j=i+j){
                isPrime[j] = 0;
            }

        }

        // 팰린드롬
        for(int i = N; i< isPrime.length; i++){
            if(i == 79197){
                System.out.println("d");
            }
            if(isPrime[i] != 0){
                if(isPalindrom(i)){

                    System.out.println(i);
                    break;
                }
            }
        }

    }

    static boolean isPalindrom(int n){
        char []  strN = String.valueOf(n).toCharArray();
        int length = strN.length;
        int i =0;
        while(i < length/2){
            if(strN[i] !=  strN[length-i-1])
                break;
            i++;
        }
        if(i== length/2)
            return true;
        else
            return false;
    }
}
