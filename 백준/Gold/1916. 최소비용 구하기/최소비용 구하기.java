import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedWriter bw;
	public static BufferedReader br;
	
	static ArrayList<Edge>[] graph;
	static int [] ans;
	
	

	public static void main(String[] args) throws Exception {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 도시의 개수
		int N = Integer.parseInt(br.readLine());
		// 버스의 개수
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		ans = new int[N+1];
		// 그래프 초기
		for(int i=1; i<=N; i++) {
			ans[i] = Integer.MAX_VALUE;
			graph[i] = new ArrayList();
		}
		
		StringTokenizer st;
		// 간선 입력 받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Edge(v, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		bw.write(sort(start, end, N)+"\n");
		bw.flush();
		bw.close();
		
		
	}
	
	public static int sort(int start, int end, int N) {
		
		boolean [] isVisited = new boolean[N+1];
		PriorityQueue<Edge> que = new PriorityQueue();
		
		que.add(new Edge(start, 0));
		ans[start] = 0;
		
		while(!que.isEmpty()) {
			Edge curNode = que.poll();
			int vertex = curNode.vertex;
		
			if(vertex == end) {
				return ans[end];
			}
			if(isVisited[vertex])
				continue;
			
			isVisited[vertex] = true;
			for(Edge next : graph[vertex]) {
				
				if(ans[next.vertex] > ans[vertex] + next.cost) {
					ans[next.vertex] = ans[vertex] + next.cost;
					que.add(new Edge(next.vertex,ans[next.vertex]));
				}
			}
			
		}
		return 0;
	}

}

class Edge implements Comparable<Edge>{
	int vertex;
	int cost;
	
	public Edge(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}
