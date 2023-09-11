import java.io.*;
import java.text.DecimalFormat;
import java.util.*;


public class Main {

    public static void main(String [] args) throws IOException{

        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        String input;
        while ((input = br.readLine())!= null){

            if(input.isEmpty()) break;
            count++;
            if(hash.containsKey(input)){
                hash.put(input, hash.get(input)+1);
            }
            else{
                hash.put(input,1);
            }
        }

       List<String> keys = new ArrayList<>(hash.keySet());
       keys.sort((s1,s2)-> s1.compareTo(s2) );

       for(int i=0; i< keys.size(); i++){
           double ratio = ((hash.get(keys.get(i))/(count*1.0)))*100;

           System.out.println(keys.get(i) +" " + String.format("%.4f", ratio));
       }



    }


}
