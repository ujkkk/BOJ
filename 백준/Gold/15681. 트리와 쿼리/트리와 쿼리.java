
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    ArrayList<Integer> [] tree;
    public static int N;
    public static int R;
    public static int Q;
    int [] subTreeN;
    boolean [] isVisited;

    public void run () throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 트리 정점의 수
        R = Integer.parseInt(st.nextToken());   // 루트 번호
        Q = Integer.parseInt(st.nextToken());   // 쿼리의 수

        tree = new ArrayList[N+1];
        for(int i=0; i<tree.length; i++){
            tree[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        subTreeN = new int[N+1];
        isVisited = new boolean[N+1];

        getSubTreeN(R);
        // 쿼리 실행
        for(int i=0; i<Q; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(subTreeN[n]+"\n");
        }
        bw.flush();
    }

    public int getSubTreeN(int n){
        isVisited[n] = true;
        // 말단 노드
        if(tree[n].size() == 1 && n != R){
            return (subTreeN[n] = 1);
        }

        for(int child : tree[n]){
            if(isVisited[child]){
                continue;
            }
            subTreeN[n] += getSubTreeN(child);
        }
        isVisited[n] = false;

        // 현재 노드를 개수에 포함
        return subTreeN[n] = subTreeN[n] + 1;
    }


    public static void main(String[] args) throws IOException {

        new Main().run();
    }
}


