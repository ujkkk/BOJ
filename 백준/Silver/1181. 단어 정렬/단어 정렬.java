
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main
{
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 중복 여부 따지면서 넣기
        HashMap <String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String data = br.readLine();
            if(!map.containsKey(data))
                map.put(data, 1);
        }
        
        Arrays.stream(map.keySet().toArray(new String[0])).sorted(new MyCompartor())
                .forEach(key -> System.out.println(key));
        
        bw.flush();

        bw.close();
        br.close();

    }
}

class MyCompartor implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        if(o1.length() - o2.length() == 0){
           int result;
           int i=0;
           while(i<o1.length()){
               if(o1.charAt(i) == o2.charAt(i)){
                   i++;
                   continue;
               }
               return o1.charAt(i) - o2.charAt(i);
           }
        }
        return o1.length() - o2.length();
    }
}