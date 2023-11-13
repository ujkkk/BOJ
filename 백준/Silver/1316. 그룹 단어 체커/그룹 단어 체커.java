
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main
{
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 그룹 단어 : 같은 알파벳이 연속적으로 나와도 됨, 한 번 나왔던 알파벳이 또 나오면 안됨.
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0; i<N; i++){
            char []  data = br.readLine().toCharArray();
            // 문자로 접근
            boolean isOn [] = new boolean[26];
            char preChar = data[0];
            result++;
            for(int j =0; j<data.length; j++){
                if(!isOn[data[j]- 'a'] || preChar == data[j]){
                    isOn[data[j]- 'a'] = true;
                    preChar = data[j];
                    continue;
                }
                result--;
                break;
            }
        }
        bw.write(result+"");


        bw.flush();

        bw.close();
        br.close();

    }
}