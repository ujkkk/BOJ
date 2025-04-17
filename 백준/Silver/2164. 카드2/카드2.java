import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();
        // N .. 3 2 1
        for(int i=1; i<=N; i++){
            que.add(i);
        }

        while(que.size() != 1){
            que.poll();
            que.add(que.poll());
        }

        System.out.println(que.poll());
    }

}