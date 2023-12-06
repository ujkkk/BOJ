import java.io.*;
import java.nio.file.LinkPermission;
import java.util.*;

public class Main{


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean [][] isBlack = new boolean[N][M];
        for(int i=0; i<N; i++){
            String [] info = br.readLine().split("");
            for(int j=0; j<M; j++){
                if(info[j].equals("W"))
                    isBlack[i][j] = false;
                else
                    isBlack[i][j] = true;
            }
        }

        // 경우의 수는 두가지
        int result = Integer.MAX_VALUE;
        for(int r=0; r+8 <= N; r++){
            for(int c =0; c+8<=M; c++){
                int count = 0;
                //1. 첫 칸이 블랙
                boolean ans = true;
                for(int i=r; i<r+8; i++){
                    for(int j=c; j<c+8; j++){
                        if(isBlack[i][j] != ans)
                            count++;
                        ans = !ans;
                    }
                    ans = !ans;
                }
                result = Math.min(result, count);

                //2. 첫 칸이 화이트
                count = 0;
                ans = false;
                for(int i=r; i<r+8; i++){
                    for(int j=c; j<c+8; j++){
                        if(isBlack[i][j] != ans)
                            count++;
                        ans = !ans;
                    }
                    ans = !ans;
                }
                result = Math.min(result, count);
            }
        }


        bw.write(result +"\n");
        bw.flush();

    }

}

