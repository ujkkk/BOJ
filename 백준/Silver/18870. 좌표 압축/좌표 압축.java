import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 리스트 생성
		HashSet<Integer> duplicate = new HashSet<>();
		int [] input = new int [N];
		int [] sorted = new int [N];
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			input[i] = sorted[i] = num;
		}
		
		//리스트 정렬
		Arrays.sort(sorted);
		
		//결과 해쉬맵에 넣기
		HashMap<Integer, Integer> resultMap = new HashMap<>();
		int index =0;
		for(int num : sorted) {
			if(!resultMap.containsKey(num)) {
				resultMap.put(num, index++);
			}
		}
		
		//출력
		for(int num : input) {
			bw.write(resultMap.get(num)+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}



}


