import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

   public static void main(String args[]) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int ans = 0;
       int N = Integer.parseInt(br.readLine());
       int blueN = 0;
       int redN = 0;
       boolean [] isBlue = new boolean[N];

       String  str =  br.readLine();
       ArrayList<String> bstr = new ArrayList<>();
       ArrayList<String> rstr = new ArrayList<>();


//      Spilt은 빈칸도 취급
//      StringTokenizer는 빈칸은 취급 안함
       //R를 구분자로 파싱
       StringTokenizer st = new StringTokenizer(str, "R");

       while(st.hasMoreTokens()){
           bstr.add(st.nextToken());
       }

       //B를 구분자로 파싱
       st = new StringTokenizer(str, "B");

       while(st.hasMoreTokens()){
           rstr.add(st.nextToken());
       }

       System.out.println(1+Math.min(rstr.size(), bstr.size()));

   }

}