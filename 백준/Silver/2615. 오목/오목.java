

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static final int DIA1 = 0;
	public static final int LEFT = 1;
	public static final int DIA2 = 2;
	public static final int BOTTOM = 3;
	
	public static BufferedWriter bw;
	public static BufferedReader br;
		
	static int map[][];
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		map = new int[20][20];
		
		StringTokenizer st;
		for(int i=0;i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int p=0; p<4; p++){
			boolean [][] isVisited = new boolean[20][20];
			
			for(int i=0; i<19;i++) {
				for(int j=0; j<19; j++) {
					if(map[i][j] == 0 || isVisited[i][j])
						continue;
		
					isVisited[i][j] = true;
					if(BFS(i,j, p,isVisited)){
						// 검은색 승
						if(map[i][j] == 1) {
							bw.write("1\n");
							
						} else {
							bw.write("2\n");
						}
						if(p==0)
							bw.write((i+1+4)+" "+ (j+1 - 4) +"\n");
						else
							bw.write((i+1)+" "+ (j+1) +"\n");
						bw.flush();
						return;
					
						
						
						
					}
					
				}
			}
		
		}
		bw.write(0+"");
	
		bw.flush();
	}
	
	public static boolean BFS(int r, int c, int p, boolean [][] isVisited) {
		int dr [] = {1, 0, 1, 1};
		int dc [] = {-1, 1, 1, 0};
		int maxDepth = 0;
		
		Queue<Point> que = new LinkedList();
		
		que.add(new Point(r,c,1));
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			// 연속된 5개 - 승
			if(cur.depth >= 5) {
				maxDepth = cur.depth;
			}

			int nextR = cur.r + dr[p];
			int nextC = cur.c + dc[p];
			
			if(isRange(nextR, nextC) && map[cur.r][cur.c]== map[nextR][nextC]) {
				que.add(new Point(nextR, nextC, cur.depth+1));
				isVisited[nextR][nextC] = true;
			}
				
		}
		if(maxDepth == 5)
			return true;
		
		return false;
	}
		
	public static boolean isRange(int r, int c) {
		if(r>=0 && r<20 && c>=0 && c<20)
			return true;
		return false;
	}
}

class Point{
	int r;
	int c;
	int depth;
	
	public Point(int r, int c, int depth) {
		this.r =r;
		this.c= c;
		this.depth = depth;
	}
}



