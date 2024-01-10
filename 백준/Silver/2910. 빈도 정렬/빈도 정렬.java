import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> first = new HashMap<>();
        //Arrays.fill(first, -1);

        st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        while(st.hasMoreElements()){
            int key = Integer.parseInt(st.nextToken());
            if(!map.containsKey(key)){
                // key가 처음 나온 인덱스 저장 => 중복 처리에 사용
                first.put(key, idx);
            }
            map.put(key, map.getOrDefault(key, 0) +1);
            idx++;
        }

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        // 내림차순 정렬
        Collections.sort(keys, (o1, o2) -> {
            if(map.get(o2) ==  map.get(o1))
                return first.get(o1) - first.get(o2);
            return map.get(o2) - map.get(o1);
        });

        for(int key : keys){
            int count = map.get(key);
            for(int i=0; i<count; i++)
                bw.write(key+" ");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}
