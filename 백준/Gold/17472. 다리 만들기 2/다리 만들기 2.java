import java.io.*;
import java.util.*;

/*
    입력 받은 인접행렬을 이용하여 모든 간선들을 추가한다
    유니온으로 집합을 구성한다
    간선 조건 : 길이가 2이상이고 직선이다. 양 끝 점을 포함한다
    가중치가 작은 순으로 정렬한다
    + 조건 : N-1개를 사이클이 형성되지 않도록 뽑음
 */
public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int N;
    static int M;
    static int map [][];
    static int [] parent;
    static ArrayList<ArrayList<Point>> allGroup;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로 크기
        N = Integer.parseInt(st.nextToken());
        // 가로 크기
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int data = Integer.parseInt(st.nextToken());
                if(data == 1){
                    map[i][j] = 1;
                }
            }
        }

        boolean [][] isVisited = new boolean[N][M];
        allGroup = new ArrayList<>();
        int initValue = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!isVisited[i][j] && map[i][j] != 0){
                    ArrayList<Point> group =  BFS(new Point(i,j), map, isVisited);
                    allGroup.add(group);
                }
            }
        }
        parent = new int[allGroup.size()];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        //간선 추가하기
        PriorityQueue<Edge> edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        Point start =null,end = null;
        int cost = 0;
        // 세로 방향 간선추가
        for(int i=0; i<N; i++){
            start = null;
            cost = 0;
            for(int j=0; j<M; j++){
                if(map[i][j] != 0){
                    if(start != null && map[i][j-1] == 0){
                        end = new Point(i,j);
                        if(cost >=2)
                            edges.add(new Edge(start, end, cost));
                    }
                    start = new Point(i,j);
                    cost=0;

                } else{
                    cost++;
                }
            }
        }

        // 가로 방향 간선 추가
        for(int i=0; i<M; i++){
            start = null;
            cost = 0;
            for(int j=0; j<N; j++){
                if(map[j][i] != 0){
                    if(start != null && map[j-1][i] == 0) {
                        end = new Point(j, i);
                        if (cost >= 2)
                            edges.add(new Edge(start, end, cost));
                    }
                    start = new Point(j,i);
                    cost=0;
                } else{
                    cost++;
                }
            }
        }

        bw.write(MST(edges, allGroup.size())+"");

        bw.flush();
        br.close();
        bw.close();

    }
    public static int getGroup(Point p){
        for(int i=0; i<allGroup.size(); i++) {
            if (allGroup.get(i).contains(p))
                return i;
        }
        return -1;
    }

    public static ArrayList<Point> BFS(Point start, int [][] map, boolean[][] isVisited){
        ArrayList group = new ArrayList();
        group.add(start);
        Queue<Point> que = new LinkedList<>();
        isVisited[start.r][start.c] = true;
        que.add(start);

        int [] dr = {1,0, -1, 0};
        int [] dc = {0, 1, 0, -1};
        while(!que.isEmpty()){
            Point cur = que.poll();
            group.add(cur);

            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(isRange(nextR, nextC) && !isVisited[nextR][nextC] && map[nextR][nextC] != 0){
                    que.add(new Point(nextR, nextC));
                    isVisited[nextR][nextC] = true;
                }
            }
        }
        return group;
    }

    public static boolean isRange(int r, int c){
        if(r >=0 && r<N && c>=0 && c<M)
            return true;
        return false;
    }


    public static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b)
            return;

        parent[b] =a;
    }
    public static int MST(PriorityQueue<Edge> edges, int groupCount){
        int count = 0;
        int result = 0;

        while(!edges.isEmpty()){
            Edge cur = edges.poll();
            int a = find(getGroup(cur.start));
            int b = find(getGroup(cur.end));
            if(a != b){
                result += cur.weight;
                union(a,b);
                count++;
            }
        }
        if(count == groupCount -1)
            return result;
        else
            return -1;
        //return result;
    }
}

class Point{
    int r;
    int c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object p){
        Point point = (Point)p;
        if(this.r == point.r && this.c == point.c)
            return true;
        return false;
    }
}
class Edge{
    Point start;
    Point end;
    int weight;

    Edge(Point start, Point end, int weight){
        this.start = start;
        this.end = end;
        this.weight= weight;
    }


}

