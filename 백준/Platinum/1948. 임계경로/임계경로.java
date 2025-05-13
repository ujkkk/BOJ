import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static ArrayList<City>[] parent;
    static ArrayList<City>[] child;
    static int [] inDegree;
    static int [] outDegree ;
    static int [] maxDis;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());    // 도시의 개수
        M = Integer.parseInt(br.readLine());    // 도로의 개수

        parent = new ArrayList[N+1];
        child = new ArrayList[N+1];
        inDegree = new int[N+1];
        outDegree = new int[N+1];
        maxDis = new int[N+1];

        for(int i=0; i<=N; i++){
            parent[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            parent[start].add(new City(end, cost));
            inDegree[end]++;

            child[end].add(new City(start, cost));
            outDegree[start]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        // 임계 거리 구함
        calcDis(start);

        // 총 거리가 max인 경로 구하기
        System.out.println(maxDis[end]);
        System.out.println(counting(end));
    }

    private static int counting(int start){
        int count = 0;
        boolean [] isVisited = new boolean[N+1];
        Queue<Integer> que = new LinkedList<>();
        // 진입 지수가 0인 것 삽입
        que.add(start);

        while(!que.isEmpty()){
            int cur = que.poll();

            for(City next : child[cur]){
                if(maxDis[next.n] == maxDis[cur] - next.cost){
                    count++;

                    if(!isVisited[next.n]){
                        que.add(next.n);
                        isVisited[next.n] = true;
                    }
                }

            }
        }
        return count;
    }

    private static void calcDis(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        maxDis[start] = 0;
        while(!que.isEmpty()){
            int cur = que.poll();

            for(City next : parent[cur]){
                inDegree[next.n]--;
                maxDis[next.n] = Math.max(maxDis[cur] + next.cost, maxDis[next.n]);
                if(inDegree[next.n] == 0){
                    que.add(next.n);
                }
            }
        }
    }
}

class City{
    int n;
    int cost;

    public City(int n, int cost) {
        this.n = n;
        this.cost = cost;
    }
}