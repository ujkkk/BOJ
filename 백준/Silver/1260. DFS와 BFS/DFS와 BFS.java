
import java.io.*;
import java.util.*;

/*
 * BFS와DFS로 방문한 순서 출력하
 */
public class Main {
	
	public static BufferedWriter bw;
	public static BufferedReader br;

	static int N;
	static int M;
	static boolean [][] graph;

	
	public static void main(String[] args) throws Exception {
		
		br  = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		graph = new boolean [N+1][N+1];
		
		// 간선 정보 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u][v] = true;
			graph[v][u] = true;
			
		}
		
		boolean[] isVisited  = new boolean [N+1];
		isVisited[start] = true;
		DFS(start, isVisited);
		bw.write("\n");
	
		isVisited  = new boolean [N+1];
		BFS(start, isVisited);
		bw.write("\n");
		bw.flush();
	}
	
	// DFS 탐색 시작
	public static void DFS(int start,boolean[] isVisited) throws IOException {
		bw.write(start+" ");
		
		for(int i=1; i<=N; i++) {
			if(graph[start][i] == false || isVisited[i])
				continue;
			
			isVisited[i] = true;
			DFS(i, isVisited);
		}
		
	}
	
	// BFS 탐색 시작
	public static void BFS(int start,boolean[] isVisited) throws IOException {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(start);
		isVisited[start] = true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			bw.write(cur+" ");
			
			for(int i=1; i<=N; i++) {
				if(graph[cur][i] == false || isVisited[i])
					continue;
				isVisited[i] = true;
				que.add(i);
			}
		}
	}

	
}





