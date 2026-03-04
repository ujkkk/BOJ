import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N;
    String [] strs;
    boolean [] isUsed = new boolean[26];

    void run() throws IOException{
        input();
        solution();
    }

    private void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        strs = new String[N];
        for(int i=0; i<N; i++){
            strs[i] = br.readLine();
        }
    }

    private void solution(){
        StringBuilder sb = new StringBuilder();
        for(String str : strs){

            // 1. 단어 단위로
            String result = selectKeyByWord(str);
            if(result.equals("")){
                // 2. 알파멧 단위로
                result = selectKeyByAlphabet(str);
            }

            sb.append(result.equals("")? str : result).append("\n");
        }
        System.out.println(sb);
    }

    /*
        단어 단위로 넘기면서 단축키 찾음
     */
    String selectKeyByWord(String str){
        StringBuilder sb = new StringBuilder();

        String [] words = str.split(" ");
        boolean isFind = false;

        for(String word : words){
            char firstAlpha = word.charAt(0);
            int key = Character.toLowerCase( firstAlpha) - 'a';

            if(isFind || isUsed[key]){
                sb.append(word).append(" ");
                continue;
            }

            // 단축키 찾음
            isUsed[key] = true;
            isFind = true;
            sb.append("[").append(firstAlpha).append("]");
            for(int i=1; i<word.toCharArray().length; i++){
                sb.append(word.charAt(i));
            }
            sb.append(" ");
        }
        return isFind? sb.toString() : "";
    }


    String selectKeyByAlphabet(String str){
        StringBuilder sb = new StringBuilder();

        String [] words = str.split(" ");
        boolean isFind = false;

        for(String word : words){
            for(char alpha : word.toCharArray()){
                int key = Character.toLowerCase(alpha) - 'a';

                if(isUsed[key] || isFind){
                    sb.append(alpha);
                    continue;
                }

                // 단축키 찾음
                isUsed[key] = true;
                isFind = true;
                sb.append("[").append(alpha).append("]");
            }
            sb.append(" ");
        }
        return isFind? sb.toString() : "";
    }

}

public class Main {

    /*
        단축키는 알파벳 하나.
        1. 단어 단위로 끊음. 모든 구별은 소문자로
        2. 알파벳 단위로 끊음.
        출력 : 단축키로 지정된 알파멧 위치에 '[]' 표시 해야 함
     */
    public static void main(String[] args) throws IOException {

        new Solution().run();

    }

}