import java.io.*;
import java.util.*;


public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t <T; t++){
            // 연산 횟수
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operator = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                // 삽입
                if(operator.equals("I")){
                    if(map.containsKey(value)){
                        map.replace(value, map.get(value)+1);
                    }
                    else{
                        map.put(value, 1);
                    }

                }

                // 제거
                else if(operator.equals("D")){
                    if(map.isEmpty()) {
                        continue;
                    }
                    if(value == -1){
                        int firstKey = map.firstKey();
                        if(map.get(firstKey) == 1){
                            map.remove(firstKey);
                        }
                        else{
                            map.replace(firstKey, map.get(firstKey)-1);
                        }
                    }
                    else if(value == 1){
                        int lastKey = map.lastKey();
                        if(map.get(lastKey) == 1){
                            map.remove(lastKey);
                        }
                        else{
                            map.replace(lastKey, map.get(lastKey)-1);
                        }
                    }
                }

            }
            if(map.isEmpty()){
                bw.write("EMPTY\n");
            }else{
                bw.write(map.lastKey()+" "+ map.firstKey()+"\n");
                //System.out.println(set.last()+" "+ set.first());
            }

        }
        bw.flush();
        bw.close();
    }

}

