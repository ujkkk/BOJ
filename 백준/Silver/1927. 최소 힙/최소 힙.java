import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    static final int MIN = 0;
    static final int MAX = 100_000;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연산의 개수
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i =0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            // 가장 작은 값 출력
            if(num == 0) {
                if(pq.isEmpty()){
                    bw.write(0+"\n");
                }else{
                    bw.write(pq.poll()+"\n");
                }
                continue;
            }
            // 요소 추가
            pq.add(num);
        }
        bw.flush();

        bw.close();
        br.close();
    }


}
