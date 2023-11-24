import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> [] graph;
    static int [][] array;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 변수 선언, 초기화
        int N = Integer.parseInt(br.readLine());
        array = new int[N+1][N+1];


        // 간선 추가
        for(int row=1; row<=N; row++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int col=1; col<=N; col++){
                array[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // i에서 j까지 갈 수 있는가?
        // i에서 k로 가고, k에서 j로 갈 수 있는가?
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(array[i][k] == 1 && array[k][j] == 1)
                        array[i][j] = 1;
                }
            }
        }

        for(int row=1; row<=N; row++) {
            for (int col = 1; col <= N; col++) {
                bw.write(array[row][col] +" ");
            }
            bw.write("\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

}
