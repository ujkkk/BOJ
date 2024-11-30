import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++){
            que.add(i);
        }

        bw.write("<");
        int count = 0;
        while(!que.isEmpty()){
            int cur = que.poll();
            if(count == K-1){
                if(que.isEmpty()){
                    bw.write(cur+">");
                }
                else{
                    bw.write(cur + ", ");
                }
                count = 0;
            }
            else{
                count++;

                que.add(cur);
            }
        }
        bw.flush();
    }
}
