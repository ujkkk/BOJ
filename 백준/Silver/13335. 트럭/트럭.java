import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, W, L;
    static Queue<Integer> trucks = new LinkedList<>();
    static Queue<Truck> passing = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {

       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());    // 트럭 개수
       W = Integer.parseInt(st.nextToken());    // 다리 길이
       L = Integer.parseInt(st.nextToken());    // 최대 하중

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int curSum = 0;
        while(true){
            if(trucks.size() == 0 && passing.size() == 0){
                break;
            }
            time++;
           // System.out.println("=========" + time);

            // 1. 지나간 거리 업데이트
            for(Truck t : passing){
                t.dis++;
            }

            // 2. 다리에 내림
            if(!passing.isEmpty() && passing.peek().dis > W){
                curSum -= passing.poll().w;
                //System.out.println(passing.poll() + " 다리에 내림" + ", curSUm: " + curSum);
            }

            // 3. 다리에 올림
            if(!trucks.isEmpty() && curSum + trucks.peek() <= L){
                int curTruckW = trucks.poll();
                passing.add(new Truck(curTruckW, 1));
                curSum += curTruckW;
                //System.out.println(trucks.poll()+ "다리에 올림" + ", curSUm: " + curSum);
            }

        }

        System.out.println(time);
    }


}

class Truck{
    int w;
    int dis;

    public Truck(int w, int dis) {
        this.w = w;
        this.dis = dis;
    }

}

