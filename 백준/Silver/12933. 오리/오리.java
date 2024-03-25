import java.io.*;
import java.util.*;

public class Main {

    // q -> u -> a -> c -> k 순
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char [] list = new char[2501];
        boolean [] isDuck = new boolean[2501];
        int duckSize = 0;

        for(int i=0; i<str.length(); i++){
            char cur = str.charAt(i);

            boolean isFind = false;
            for(int j=0; j<duckSize; j++){
                // q일 때
                if(cur == 'q'){
                    if(list[j] == 'k'){
                        isFind = true;
                        list[j] = 'q';
                        break;
                    }
                }
                else if(cur == 'u'){
                    if(list[j] == 'q'){
                        isFind = true;
                        list[j] = 'u';
                        break;
                    }
                }
                else if(cur == 'a'){
                    if(list[j] == 'u'){
                        isFind = true;
                        list[j] = 'a';
                        break;
                    }
                }
                else if(cur == 'c'){
                    if(list[j] == 'a'){
                        isFind = true;
                        list[j] = 'c';
                        break;
                    }
                }
                else if(cur == 'k'){
                    if(list[j] == 'c'){
                        isFind = true;
                        list[j] = 'k';

                        // 실제 오리가 맞음
                        isDuck[j] = true;
                        break;
                    }
                }

            }
            // 새로운 오리 추가
            if(!isFind && cur == 'q'){
                list[duckSize] = cur;
                duckSize++;
            }
            if(!isFind && cur != 'q'){
                System.out.println(-1);
                return;
            }
        }
        if(str.charAt(str.length()-1) != 'k'){
            System.out.println(-1);
            return;
        }


        int result = 0;
        for(int i=0; i<duckSize; i++){
            if(isDuck[i])
                result++;
        }
        if(result == 0 || result != duckSize)
            System.out.println(-1);
        else
            System.out.println(result);


    }


}


