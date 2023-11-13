
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main
{
    public static HashSet<Character> set;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = null;
        set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        while(!(str = br.readLine()).equals("end")){
            boolean result = false;

            if(containMoum(str) && sequitial(str) && doubleStr(str)) {
                bw.write(String.format("<%s> is acceptable.\n", str));
            }
            else{
                bw.write(String.format("<%s> is not acceptable.\n", str));
            }

        }

        bw.flush();

        bw.close();
        br.close();

    }

    public static boolean containMoum(String data){
        int i;
        // 모음 체크
        for(i=0; i<data.length(); i++){
            char ch = data.charAt(i);
            if(set.contains(ch))
                return true;
        }
        // 모음이 하나도 없음
        return  false;
    }

    public static boolean sequitial(String data){
        int moumCount = 0;
        int jaumCount = 0;
        for(int i=0; i<data.length(); i++){
            if(set.contains(data.charAt(i))){
                jaumCount = 0;
                moumCount++;
            } else{
                moumCount = 0;
                jaumCount++;
            }
            if(moumCount ==3 || jaumCount == 3)
                return false;
        }
        return  true;
    }

    public static boolean doubleStr(String data){
        char preChar = data.charAt(0);
        for(int i=1; i<data.length(); i++){
            if(data.charAt(i) != 'e' && data.charAt(i) != 'o'){
                if(preChar == data.charAt(i)){
                    return false;
                }
            }
            preChar = data.charAt(i);
        }
        return true;
    }
}

