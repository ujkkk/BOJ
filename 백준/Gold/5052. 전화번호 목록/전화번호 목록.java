import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            HashSet<String> set = new HashSet();
            String [] curNum = new String[N];
            // 수 입력
            for(int i=0; i<N; i++) {
                curNum[i] = br.readLine();
                set.add(curNum[i]);
            }

            int i;
            boolean isFind = false;
            for(i=0; i<N; i++){
                for(int j=1; j <curNum[i].length(); j++) {
                    if(set.contains(curNum[i].substring(0, j))) {
                        isFind = true;
                        break;
                    }
                }
            }
            if(!isFind){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}


