import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int L, C;
    static HashSet<Character> vowels;
    static char [] chars ;
    static int opCount = 0;

    public static void main(String[] args) throws IOException {
        // 모음 사전 구성
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());   // 암호 길이
        C = Integer.parseInt(st.nextToken());   // 문자 개수
        st = new StringTokenizer(br.readLine());

        chars = new char[C];
        for(int i=0; i<C; i++){
            chars[i] = st.nextToken().charAt(0);
        }
        // 문자들 정렬
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        setPassword(0, 0, new char[L], sb);

        System.out.println(sb.toString());
        //System.out.println("opCount : " + opCount);
    }

    public static void setPassword(int depth, int idx, char [] password, StringBuilder sb){
        if(depth == L){
            if(validate(password)){
                sb.append(new String(password));
                sb.append("\n");
            }
            return;
        }

        for(int i=idx; i<C; i++){
            password[depth] = chars[i];
            setPassword(depth+1, i+1, password, sb);

            opCount++;
        }
    }

    public static boolean validate(char [] password){
        // 모음 최소 한 개, 자음 최소 두 개
        int count = 0;
        for(int i=0; i<password.length; i++){
           if(vowels.contains(password[i])){
               count++;
           }
        }
        if(count < 1)
            return false;
        if(password.length - count < 2)
            return false;

        return true;
    }
}
