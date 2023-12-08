import java.io.*;
import java.util.StringTokenizer;

public class Main{

    BufferedReader br;
    BufferedWriter bw;

    static int N;
    static int honey [];
    long maxHoneyAmount;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        maxHoneyAmount = 0;
    }

    public void run() throws IOException {
        input();
        solution();
        output();

    }
    public void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        honey = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());

        // 장소마다 꿀의 양 입력받음
        for(int i=0; i<N; i++){
            honey[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void solution(){
        //1. 벌들이 같은 방향
        //1.1 벌이 오른쪽 -> 왼쪽으로 향할 때
        long result = getHoneyLeftToRight();
        maxHoneyAmount = Math.max(result, maxHoneyAmount);

        //1.2 벌이 왼쪽 -> 오른쪽으로 향할 때
        result = getHoneyRightToLeft();
        maxHoneyAmount = Math.max(result, maxHoneyAmount);

        //2. 벌들이 양옆에서 올 때
        result = getHoneyCenter();
        maxHoneyAmount = Math.max(result, maxHoneyAmount);
    }

    public void output() throws IOException {
        bw.write(maxHoneyAmount +"\n");
        bw.flush();

        bw.close();
        br.close();
    }

    public long getHoneyLeftToRight(){
        long honeySum [] = new long[N];
        long lossHoney = Integer.MAX_VALUE;

        for(int i=1; i<N; i++){
            honeySum[i] = honeySum[i-1] + honey[i];
            if(lossHoney > honeySum[i] + honey[i]){
                lossHoney = honeySum[i] + honey[i];
            }
        }

        return honeySum[N-1]*2 - lossHoney;
    }

    public long getHoneyRightToLeft(){
        long honeySum [] = new long[N];
        long lossHoney = Integer.MAX_VALUE;

        for(int i=N-2; i>=0; i--){
            honeySum[i] = honeySum[i+1] + honey[i];
            if(lossHoney > honeySum[i] + honey[i]){
                lossHoney = honeySum[i] + honey[i];
            }
        }
        return honeySum[0]*2 - lossHoney;
    }

    public long getHoneyCenter(){
        long honeySum = 0;
        long maxHoney = 0;

        for(int i=1; i<N-1; i++){
            honeySum += honey[i];
            if(maxHoney < honey[i]){
                maxHoney = honey[i];
            }
        }

        return honeySum + maxHoney;
    }

    public static void main(String [] args) throws Exception{

        new Main().run();



    }



}


