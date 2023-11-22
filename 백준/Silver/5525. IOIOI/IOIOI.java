import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int ans = 0;
        int i =0;
        int count = 0;
        while(i<S.length()-2){
            if(S.charAt(i)=='I' && S.charAt(i+1)=='O' && S.charAt(i+2)=='I'){
                i += 2;
                count++;
                if(count == N){
                    ans ++;
                    count--;
                }
                continue;
            }
            i++;
            count = 0;
        }

        bw.write(ans +"\n");
        bw.flush();

        bw.close();
        br.close();
    }


}

