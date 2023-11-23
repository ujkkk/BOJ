import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String [] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);

            int year = getYear(M,N,x,y);
            if(year == 0)
                year = -1;
            bw.write(year +"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    public static int getYear(int M, int N, int x, int y){
        int nextY =y%N;
        int nextX = x%M;
        while(nextY <= M*N){
            if((nextY-nextX)%M == 0 && nextY!= 0)
                return nextY;
            nextY += N;
        }
        return -1;
    }
}

