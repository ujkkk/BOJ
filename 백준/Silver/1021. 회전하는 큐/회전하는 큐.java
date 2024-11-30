import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> que = new LinkedList<>();
        for(int i=0; i<N; i++){
            que.add(i+1);
        }

        List<Integer> finds = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            finds.add(Integer.parseInt(st.nextToken()));
        }

        // 찾기
        int count = 0;
        for(int find : finds){
            int idx = que.indexOf(find);

            if(que.get(0) == find){
                que.poll();
                continue;
            }
            int front = idx;
            int back = que.size() -idx +1;

            if(front < back){
                while(que.get(0) != find){
                    que.add(que.poll());
                    count++;
                }
            }
            else{
                while(que.get(0) != find){
                    que.addFirst(que.pollLast());
                    count++;
                }
            }
            que.poll();
        }
        bw.write(count+"\n");
        bw.flush();
    }
}
