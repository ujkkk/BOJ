import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> [] friends;
    static int N;
    static int M;
    static int [][] kevinValues;
    static boolean [] isVisited;
    static int ans;
    static long kevinMin;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 유저의 수
        N = Integer.parseInt(st.nextToken());
        // 친구 관계의 수
        M = Integer.parseInt(st.nextToken());

        friends = new ArrayList[N+1];
        kevinValues = new int[N+1][N+1];

        for(int i=1; i<=N; i++)
            friends[i] = new ArrayList<>();

        // 친구 관계 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            friends[start].add(end);
            friends[end].add(start);
        }

        // 케빈 값들 초기화
        for(int row=0; row< kevinValues.length; row++){
            for(int col=0; col<kevinValues[0].length; col++){
                kevinValues[row][col] = Integer.MAX_VALUE;
            }
        }
        kevinMin = Long.MAX_VALUE;

        // 차례대로 케빈 값을 구함
        for(int i=1; i<=N; i++){
            int sum = 0;
            isVisited = new boolean[N+1];
            isVisited[i] = true;
            getKevinValues(i);

            // 총 케빈 베이컨의 합
            for(int kevin : kevinValues[i])
                sum += kevin;

            // 작을 때 갱신
            if(kevinMin > sum){
                ans = i;
                kevinMin = sum;
            }

        }
        bw.write(Integer.toString(ans));
        bw.flush();

        bw.close();
        br.close();
    }
    public static void getKevinValues(int start){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start, 0));

        while(!que.isEmpty()){
            Node curNode = que.poll();
            kevinValues[start][curNode.x] = curNode.depth;

            for(int friend : friends[curNode.x]){
                if(!isVisited[friend]){
                    que.add(new Node(friend, curNode.depth +1));
                    isVisited[friend] = true;
                }
            }
        }
    }
}

class Node{
    int x;
    int depth;

    Node(int x, int depth){
        this.x = x;
        this.depth = depth;
    }
}