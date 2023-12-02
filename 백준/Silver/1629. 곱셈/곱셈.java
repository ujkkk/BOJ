import java.io.*;
import java.util.*;

public class Main{


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bw.write(getResult(A,C, B)+"\n");
        bw.flush();
    }

    public static long getResult(int A, int C, int B){
        if(B==0)
            return 1;
        if(B == 1)
            return A%C;

        long n = getResult(A, C,B/2);
        if(B%2==0)
            return n*n%C;
        return n*(n*A%C)%C;
    }
}
