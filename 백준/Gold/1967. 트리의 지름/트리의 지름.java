import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int max = 0;
    public static int ans = 0;
    public static int result = 0;
    public static boolean [] isVisited;
    public static  ArrayList<Node>[] nodes;

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

       nodes = new ArrayList[N+1];
        for(int i=0; i<N+1; i++)
            nodes[i] = new ArrayList<>();

        // 입력 - 트리 완성
        String input;
        for(int i=0; i<N-1; i++){
            String [] nums = br.readLine().split(" ");
            int parent = Integer.parseInt(nums[0]);
            int child = Integer.parseInt(nums[1]);
            int weight = Integer.parseInt(nums[2]);

            nodes[parent].add(new Node(child, weight));
            nodes[child].add(new Node(parent, weight));
        }
        for(int i=1; i<N+1; i++){
            isVisited = new boolean[N+1];
            dfs(i, 0);

        }

        System.out.println(max);
    }


    public static void dfs(int n, int sum) {
        isVisited[n] = true;
        Iterator<Node> iterator = nodes[n].iterator();
        while (iterator.hasNext()) {
            Node curNode = iterator.next();
            if (!isVisited[curNode.value]) {

                dfs(curNode.value, sum + curNode.weight);
            }
            max = Math.max(max, sum);
        }
    }
}
class Node{
    int value;
    int weight;

    public Node(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}