
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        Set<Integer> set = new HashSet<>();
        int cnt = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for(int c=0; c<cnt; c++){
            String [] cmds = br.readLine().split(" ");

            switch(cmds[0]){
                case "add":{
                    set.add(Integer.parseInt(cmds[1]));
                    break;
                }
                case "remove": {
                    set.remove(Integer.parseInt(cmds[1]));
                    break;
                }
                case "check": {
                    int x = Integer.parseInt(cmds[1]);
                    if(set.contains(x)){
                        result.append(1).append("\n");
                    }
                    else{
                        result.append(0).append("\n");
                    }
                    break;
                }
                case "toggle": {
                    int x = Integer.parseInt(cmds[1]);
                    if(set.contains(x)){
                        set.remove(x);
                    }
                    else{
                        set.add(x);
                    }
                    break;
                }
                case "all":{
                    set.clear();
                    for(int i=1; i<=20 ;i++){
                        set.add(i);
                    }
                    break;
                }
                case "empty":{
                    set.clear();
                }
            }
        }
        System.out.println(result);

    }



}