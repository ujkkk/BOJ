import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {

        // A의 원소 중 B 집합에 없는 것의 개수를 구하기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        Iterator<Integer> aIterator = A.iterator();
        Iterator<Integer> bIterator = B.iterator();

        while(aIterator.hasNext()){
            if(!B.contains(aIterator.next())){
                result++;
            }
        }

        while(bIterator.hasNext()){
            if(!A.contains(bIterator.next())){
                result++;
            }
        }
        bw.write(result+"");
        bw.flush();
    }



}


