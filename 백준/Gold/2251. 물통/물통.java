
import java.io.*;
import java.util.*;
import java.util.logging.Handler;

public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int sum;
    static int [] bottle;
    static int [] capacity;
    static ArrayList<Integer> result;
    static HashSet<Data> visited;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bottle = new int[3];
        capacity = new int[3];
        result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        capacity[0] = Integer.parseInt(st.nextToken());
        capacity[1] = Integer.parseInt(st.nextToken());
        capacity[2] = Integer.parseInt(st.nextToken());

        bottle[2] = capacity[2];
        sum = capacity[2];

        result.add(sum);

        visited = new HashSet<>();
        DFS();

        Collections.sort(result);
        for(int n : result){
            bw.write(n+" ");
        }
        bw.flush();
        br.close();
        bw.close();

    }

    public static void DFS(){
        if(bottle[0] == 0 && !result.contains(bottle[2])){
            result.add(bottle[2]);
        }

        for(int i=0; i<3; i++){
            // 옮길 물이 없으므로 패스
            if(bottle[i]==0)
                continue;

            for(int j= 0; j<3; j++){
                if(i == j)
                    continue;

                int water;
                // i병에 담겨진 물은 j병에 담을 때 초과될 때, 용량만큼만 담는다.
                if(bottle[i]+ bottle[j] > capacity[j]){
                    water = capacity[j]-bottle[j];
                    bottle[i] -= water;
                    bottle[j] += water;

                }
                // i병의 물을 j병에 다 옮길 수 있을 때
                else{
                    water = bottle[i];
                    bottle[j] += water;
                    bottle[i] -= water;
                }

                Data data = new Data(bottle[0], bottle[1],bottle[2] );
                // 해보지 않는 경우에 대해서 탐색 진행
                if(!visited.contains(data)){
                    visited.add(data);
                    DFS();
                }
                // 원상복귀
                bottle[i] += water;
                bottle[j] -= water;
            }
        }
    }

}

class Data{
    int A;
    int B;
    int C;

    public Data(int a, int b, int c){
        this.A = a;
        this.B = b;
        this.C= c;
    }

    @Override
    public boolean equals(Object data){
        Data d = (Data)data;
        if(d.A == A && d.B == B && d.C == C)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(A);
        result = 31 * result + Integer.hashCode(B);
        result = 31 * result + Integer.hashCode(C);
        return result;
    }
}


