import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

   public static void main(String args[]) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int N = Integer.parseInt(br.readLine());
       int [] tops = new int[N];
       int [] ans = new int[N];

       StringTokenizer st = new StringTokenizer(br.readLine());
       for(int i=0; i<N; i++){
           tops[i] = Integer.parseInt(st.nextToken());
       }

       Stack<Data> stack = new Stack<>();
       stack.add(new Data(N-1, tops[N-1]));
       for(int i=N-2; i>=0; i--){
           if(stack.isEmpty())
               continue;
           if(tops[i] > stack.peek().height){
               while(!stack.isEmpty() &&tops[i] > stack.peek().height){
                   ans[stack.pop().index] = i+1;
               }
           }
           stack.add(new Data(i, tops[i]));
       }

       for(int n : ans){
           bw.write(n+" ");
       }
       bw.flush();
   }

}

class Data{
    int index;
    int height;

    public Data(int index, int height){
        this.index = index;
        this.height = height;
    }
}