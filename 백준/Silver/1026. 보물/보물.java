import java.io.*;
import java.util.*;

public class Main{

    public static BufferedReader br;
    public static BufferedWriter bw;


    public static void main(String [] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        // a 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            a.add(Integer.parseInt(st.nextToken()));
        }
        // 오름차순 정렬
        Collections.sort(a);

        // b 입력 받기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            b.add(Integer.parseInt(st.nextToken()));
        }
        // 내림차순 정렬
        Collections.sort(b, (o1, o2) -> o2-o1);

        long result = 0L;
        for(int i=0; i<N; i++){
            result += a.get(i)*b.get(i);
        }
        bw.write(result+"\n");
        bw.flush();
    }

}

