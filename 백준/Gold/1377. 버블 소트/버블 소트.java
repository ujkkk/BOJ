import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>();

        for(int i=0; i<N; i++){
            int n= Integer.parseInt(br.readLine());
            nodes.add(new Node(n, i));
        }

//        for(Node node : nodes){
//            System.out.print(node.n+" ");
//        }
//        System.out.println();

        Collections.sort(nodes);

        int max = 0;
        for(int i=0; i<N; i++){
            Node cur = nodes.get(i);
            max = Math.max(max, (cur.idx-i));

//            System.out.println(String.format("[%d] %d에서 %d로, %d",
//                cur.n, cur.idx, i, (cur.idx-i)));
        }

//        for(Node node : nodes){
//            System.out.print(node.n+" ");
//        }
//        System.out.println();
        System.out.println(max+1);
    }

}

class Node implements Comparable<Node>{
    int n;
    int idx;

    public Node(int n, int idx) {
        this.n = n;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node o) {
        return this.n - o.n;
    }
}
