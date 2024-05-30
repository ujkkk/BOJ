import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());       // 파일의 개수

        // 파일 입력받기
        Double [] files = new Double [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            files[i] = Double.parseDouble(st.nextToken());
        }
        // 오름차순 정렬
        Arrays.sort(files);

        long result = 0;
        int curIndex = 0;
        for(int i=0; i<N; i++){
           while(true){
               if(curIndex >= N-1) break;
                if(files[i]*10 < files[curIndex+1] * 9){
                    break;
                } else{
                    curIndex++;
                }
            }
            result += curIndex-i;
        }
        bw.write(result + "");
        bw.flush();
    }



}


