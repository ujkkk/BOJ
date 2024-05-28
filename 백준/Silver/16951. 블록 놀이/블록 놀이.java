import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //개수
        int K = Integer.parseInt(st.nextToken()); //차

        st = new StringTokenizer(br.readLine());
        int [] blocks = new int[N];

        for(int i=0; i<N; i++){
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int result = N;
        boolean isCheck = true;

        for(int i=0; i<N; i++){
            isCheck = true;
            int curHeight = blocks[i];
            int count = 0;

            for(int j=i-1; j>=0; j--){
                curHeight -= K;
                if(curHeight < 1){
                    isCheck = false;
                    break;
                }

                if(blocks[j] != curHeight)
                    count++;
            }
            if(!isCheck)
                continue;

            curHeight = blocks[i];
            // 현재 i블록이 현재 상태일 때 고쳐야하는 개수
            for(int j=i+1; j<N; j++){
                curHeight += K;
                if(blocks[j] != curHeight)
                    count++;
            }

            result = Math.min(result, count);

        }

        bw.write(result+"");
        bw.flush();
    }



}


