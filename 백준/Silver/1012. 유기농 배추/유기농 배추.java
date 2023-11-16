import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main
{
	static boolean isBaecu [][];
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 가로 길이
			int M = Integer.parseInt(st.nextToken());
			// 세로 길이
			int N = Integer.parseInt(st.nextToken());
			// 배추 위치 개
			int K = Integer.parseInt(st.nextToken());
			
			// 배추밭 정보 생성
			isBaecu = new boolean[N+2][M+2];
			
			for(int k=0; k<K; k++) {
				// 배추 위치 정보
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				isBaecu[y+1][x+1] = true;
			}
			
			bw.write(solution() + "\n");
		
			
		}
		bw.flush();
	}
	
	public static int solution(){
		int row = isBaecu.length;
		int col = isBaecu[0].length;
		int count = 0;
		
		boolean [][] isVisited = new boolean[row][col];
		
		for(int y=1; y<row; y++) {
			for(int x = 1; x<col; x++) {
				// 새로운 그룹 발견
				if(!isVisited[y][x] && isBaecu[y][x] == true) {
					searchGroup(isVisited, x, y);
					count++;
				}
			}
		}
		return count;
	}
	
	// 한 그룹 탐색
	public static void searchGroup(boolean [][] isVisited, int x, int y) {
		Queue<Point> que = new LinkedList<>();
		int [] dx = {0,1,0,-1};
		int [] dy = {1,0, -1,0};
		
		que.add(new Point(x,y));
		isVisited[y][x] = true;
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			
			for(int i=0; i<4; i++) {
				int nextX = cur.x+dx[i];
				int nextY = cur.y+dy[i];
		
				if(!isVisited[nextY][nextX]&& isBaecu[nextY][nextX] == true) {
					que.add(new Point(nextX, nextY));
					isVisited[nextY][nextX] = true;
				}
			}
		}
	}

}

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}