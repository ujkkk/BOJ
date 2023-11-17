import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    static final int MIN = 0;
    static final int MAX = 100_000;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연산의 개수
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(int i =0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            // 가장 작은 값 출력
            if(num == 0) {
                try {
                    int key = treeMap.firstEntry().getKey();
                    int value = treeMap.firstEntry().getValue();
                    if (value > 1) {
                        treeMap.replace(key, value - 1);
                    } else {
                        treeMap.remove(key);
                    }
                    bw.write(key + "\n");
                } catch (IllegalStateException e) {
                    bw.write(0 + "\n");
                } catch (NullPointerException e){
                    bw.write(0 + "\n");
                }
                continue;
            }
            // 요소 추가
            int value = treeMap.getOrDefault(num, 0) +1;
            treeMap.put(num, value);
        }
        bw.flush();

        bw.close();
        br.close();
    }


}
