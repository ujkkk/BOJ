
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int N, M;
    static ArrayList [] graph;
    static int [] inDegree;


    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 학생들의 수
        int N = Integer.parseInt(st.nextToken());
        // 비교한 회수
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList();
        }
        inDegree = new int[N+1];

        // 간선 입력 받기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 간선 추가
            graph[A].add(B);
            // B를 가리키는 노드 수 +1
            inDegree[B]++;
        }

        // 위상 정렬 시작
        List<Integer> ans = topologicalSorting(graph, inDegree);
        for(int node : ans){
            bw.write(node+" ");
        }

        bw.flush();
        br.close();
        bw.close();

    }

    // 위상정렬
    public static List<Integer> topologicalSorting(ArrayList<Integer>[] graph, int [] inDegree){

        List<Integer> sortedNode = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        // 가리키는 간선의 수가 0인 노드를 삽입
        for(int i=1; i<inDegree.length; i++){
            if(inDegree[i] == 0)
                que.add(i);
        }

        while(!que.isEmpty()){
            int cur = que.poll();
            sortedNode.add(cur);

            // 현재 노드가 가리키는 간선을 끊어줌
            for(int child : graph[cur]){
                inDegree[child]--;
                // 가리키는 간선의 수가 0이라면 큐에 삽입
                if(inDegree[child] == 0)
                    que.add(child);
            }
        }
        return sortedNode;
    }

}

