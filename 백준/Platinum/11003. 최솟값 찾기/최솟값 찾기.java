import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int [] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int [] D = new int[N];
        Deque<Node> deque = new LinkedList<>();

        // 더 앞에있고 값이 크면 그 데이터는 절대 최소가 될 수 없음 => 제거
        for(int i=0; i<N; i++){

            while(true){
                if(deque.isEmpty()) break;
                if(deque.getLast().n <= nums[i]) break;
                // 햔재 값보다 크면 제거
                deque.pollLast();
            }

            // 넣기
            deque.add(new Node(i, nums[i]));

            // 범위를 벗어나면 제거
            if(deque.peekFirst().idx < i-L+1){
                deque.pollFirst();
            }

            D[i] = deque.peekFirst().n;
        }

        StringBuilder sb = new StringBuilder();
        for(int d : D){
            sb.append(d).append(" ");
        }
        System.out.println(sb);
    }

}

class Node{
    int idx;
    int n;

    public Node(int idx, int n) {
        this.idx = idx;
        this.n = n;
    }
}
