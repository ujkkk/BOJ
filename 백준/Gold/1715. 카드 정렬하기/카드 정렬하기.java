import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i=0;i<N; i++){
            que.add(Integer.parseInt(br.readLine()));
        }

        // 작은거 두개씩 합치면 됨.
        int count = 0;
        while(que.size() != 1){
            int card1 = que.poll();
            int card2 = que.poll();

            count += (card1 + card2);
            
            que.add((card1 + card2));
        }
        System.out.println(count);
    }
}
