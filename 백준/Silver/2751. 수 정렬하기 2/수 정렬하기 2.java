import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 1.입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int [] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        // 2.정렬
        Arrays.sort(A);

        // 3.출력
        for(int i=0; i<N; i++){
            bw.write(A[i]+"\n");
            //System.out.println(A[i]);
        }
        bw.flush();
        bw.close();
    }

}
