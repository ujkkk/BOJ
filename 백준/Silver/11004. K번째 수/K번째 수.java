import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 정렬 (퀵 정렬)
        //quick_sort(0, N-1, A, k-1);
        Arrays.sort(A);

        // 3. 출력
        System.out.println(A[k-1]);
    }
}