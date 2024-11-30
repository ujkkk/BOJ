import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int [] counts = new int[10];
            LinkedList<Document> que = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int n = Integer.parseInt(st.nextToken());
                counts[n]++;

                que.add(new Document(i, n));
            }

            int result = 1;
            while(!que.isEmpty()){
                Document cur = que.poll();

                if(isAblePrint(cur, counts)){
                    if(cur.order == M){
                        break;
                    }
                    result++;

                    counts[cur.priority]--;
                    continue;
                }
                que.addLast(cur);
            }
            bw.write(result+"\n");
        }
        bw.flush();
    }

    private static boolean isAblePrint(Document cur, int[] counts) {
        for(int i=cur.priority+1; i<= 9; i++){
            if(counts[i] != 0){
                return false;
            }
        }
        return true;
    }
}

class Document{
    int order;
    int priority;

    public Document(int order, int priority) {
        this.order = order;
        this.priority = priority;
    }
}
