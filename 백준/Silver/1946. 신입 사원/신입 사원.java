import java.io.*;
import java.lang.String;
import java.util.*;

class Main {
    static int [] minLoss;
    public static void main(String [] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t< T; t++){
            int n = Integer.parseInt(br.readLine());
            int docsRanking [] = new int[n+1];

            if(n == 1){
                br.readLine();
                bw.write("1\n");
            }
            else{
                for(int i=1; i<=n; i++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int docs = Integer.parseInt(st.nextToken());
                    int interview = Integer.parseInt(st.nextToken());

                    docsRanking[docs] = interview;
                }

                int count = 1;
                int inteviewRanking = docsRanking[1];
                for(int i=2; i<= n; i++){
                    if(docsRanking[i] < inteviewRanking){
                        count++;
                        inteviewRanking = docsRanking[i];
                    }
                }
                bw.write(count +"\n");
            }
        }
        bw.flush();

    }

}
class Person{
    int docs;
    int interview;

    public Person(int docs, int interview){
        this.docs = docs;
        this.interview = interview;
    }
}


