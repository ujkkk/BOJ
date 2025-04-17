import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> que = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0){
                if(que.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append(que.poll().n)
                        .append("\n");
                }
            }
            else{
                que.add(new Node(n));
            }
        }
        System.out.println(sb);
    }

}

class Node implements Comparable<Node>{
    int n;

    public Node(int n) {
        this.n = n;
    }

    @Override
    public int compareTo(Node o) {
        if(Math.abs(this.n) ==  Math.abs(o.n)){
            return this.n <0? -1 : 1;
        }
        return Math.abs(this.n) - Math.abs(o.n);
    }
}