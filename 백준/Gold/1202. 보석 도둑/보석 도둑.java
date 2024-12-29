import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import javax.swing.JWindow;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> jewelryPriorityQueue = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewelryPriorityQueue.add(new Jewelry(weight, value));
        }

        List<Integer> maxWeight = new ArrayList<>();
        for(int i=0; i<K; i++){
            maxWeight.add(Integer.parseInt(br.readLine()));
        }

        // 무게순으로 오름차순
        Collections.sort(maxWeight);

        long ans = 0;
        // value에 대해서 내림차순
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<K; i++){

            while(!jewelryPriorityQueue.isEmpty() && jewelryPriorityQueue.peek().weight <= maxWeight.get(i)){
                que.add(jewelryPriorityQueue.poll().value);
            }

            if(que.isEmpty()){
                continue;
            }
            ans += que.poll();
        }

        System.out.println(ans);
    }
}

class Jewelry implements Comparable<Jewelry>{

    int weight;
    int value;

    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewelry o) {
        if(this.weight == o.weight){
            // 가치에 대해서 내림차순
            return o.value - this.value;
        }
        // 무게에 대해서 오름차순
        return this.weight - o.weight;
    }
}

