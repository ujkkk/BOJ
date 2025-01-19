import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        List<Town> townList = new ArrayList<>();
        long sum = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            sum += number;
            townList.add(new Town(pos, number));
        }

        // 위치에 따라 오름차순 정렬
        Collections.sort(townList);

        long lSum = 0;
        int result = 0;
        for(int i=0; i<N; i++){
            Town cur = townList.get(i);
            lSum += cur.number;

            if(lSum >= (sum+1)/2){
                result = cur.pos;
                break;
            }

        }
        System.out.println(result);
    }
}


class Town implements Comparable<Town>{
    int pos;
    int number;

    public Town(int pos, int number) {
        this.pos = pos;
        this.number = number;
    }

    @Override
    public int compareTo(Town o) {
        return this.pos - o.pos;
    }
}