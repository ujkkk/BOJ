import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            char [] str = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] alphaIdxs = new ArrayList[26];
            for(int i=0; i<26; i++){
                alphaIdxs[i] = new ArrayList<>();
            }

            for(int i=0; i<str.length; i++){
                alphaIdxs[str[i] - 'a'].add(i);
            }

            // 가장 짧은 문자 구하기
            int result1 = 20_000;
            int result2 = -1;
            for(ArrayList<Integer> curAlphaIdxs : alphaIdxs){
                if(curAlphaIdxs.size() < K)
                    continue;

                for(int j=0; j<=curAlphaIdxs.size() - K; j++){
                    result1 = Math.min(curAlphaIdxs.get(j+K-1)- curAlphaIdxs.get(j) +1, result1);
                    result2 = Math.max(curAlphaIdxs.get(j+K-1)- curAlphaIdxs.get(j) +1, result2);
                }
            }

            if(result1 == 20_000){
                bw.write(-1+"\n");
            }
            else{
                bw.write(result1 +" " + result2+"\n");
            }
        }
        bw.flush();
    }
}
