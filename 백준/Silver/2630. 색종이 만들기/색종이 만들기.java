
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main
{
	
	static long blueAns = 0;
	static long whiteAns = 0;
	static boolean [][] isBlue;
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		isBlue = new boolean[N][N];
		// 색종이 정보 채우기
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				if(Integer.parseInt(st.nextToken())== 1) {
					isBlue[i][j] = true;
					continue;
				}
				isBlue[i][j] = false;
			}
		}
		
		solution(new Point(0,0), N);
		
		bw.write(whiteAns +"\n");
		bw.write(blueAns +"\n");
		
		bw.flush();
		
		bw.close();
		br.close();
	}


	public static void solution(Point start, int length) {
		boolean isAllBlue = isBlue[start.x][start.y];
		if(length != 1) {
			for(int i= start.x; i<start.x + length; i++) {
				for(int j= start.y; j<start.y + length; j++) {
					if(isBlue[i][j] != isAllBlue) {
						solution(start, length/2);
						solution(new Point(start.x + length/2, start.y), length/2);
						solution(new Point(start.x + length/2, start.y + length/2), length/2);
						solution(new Point(start.x, start.y + length/2), length/2);
						return;
					}
				}
			}
		}
		
		if(isAllBlue)
			blueAns++;
		else
			whiteAns++;
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

