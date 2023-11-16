import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
		
		// 중복값을 제거한 값으로 채워 리스트 생성
		HashSet<Integer> duplicate = new HashSet<>();
		int [] input = new int [N];
		List<Integer> noDuplicateData = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			input[i] = num;
			if(duplicate.contains(num))
				continue;
			duplicate.add(num);
			noDuplicateData.add(num);
			
		}
		
		//리스트 정렬
		noDuplicateData.sort(Comparator.naturalOrder());
		
		//결과 해쉬맵에 넣기
		HashMap<Integer, Integer> resultMap = new HashMap<>();
		Iterator<Integer> iterator = noDuplicateData.iterator();
		int index =0;
		while(iterator.hasNext()) {
			resultMap.put(iterator.next(), index++);
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


