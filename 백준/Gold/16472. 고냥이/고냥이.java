import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int start = 0;
        int end = -1;

        // init
        int maxCount = 0;
        int curCount = 0;

        int selectCount = 0;
        int [] alphas = new int[27];

        while(selectCount != N && end < str.length() -1){
            end++;
            if(alphas[str.charAt(end)  -'a'] == 0){
                selectCount++;
            }
            alphas[str.charAt(end) -'a']++;
            curCount++;
        }

        maxCount = curCount;

        while (end < str.length() -1){
            end++;
            if(alphas[str.charAt(end) -'a'] == 0){
                selectCount++;
            }
            alphas[str.charAt(end) -'a']++;
            curCount++;

            while(start < end && selectCount == N+1){
                char removeAlpha = str.charAt(start);

                while(start < end && str.charAt(start) == removeAlpha){
                    start++;
                    curCount--;
                    alphas[removeAlpha -'a']--;
                }

                if(alphas[removeAlpha -'a'] == 0){
                    selectCount--;
                }
            }

            maxCount = Math.max(curCount, maxCount);
        }

        bw.write(maxCount+"");
        bw.flush();
    }
}
