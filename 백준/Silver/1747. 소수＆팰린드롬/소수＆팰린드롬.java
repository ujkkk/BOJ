import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        boolean[] X = new boolean[1_000_0000+1];
        Arrays.fill(X, true);
        X[1] = false;

        for(int i=2; i<(X.length); i++){
            if(!X[i]) continue;

            for (int j = i + i; j < X.length; j += i) {
                X[j] = false;
            }
        }

        for(int i=N; i<(1_000_0000); i++){
            if(!X[i]) continue;

            // 소수 일 때
            char [] num = String.valueOf(i).toCharArray();
            int j =0;
            for(j=0; j<num.length/2; j++){
                if(num[j] != num[num.length-1-j]) break;
            }
            if(j == num.length/2){
                System.out.println(i);
                return;
            }
        }

    }
}