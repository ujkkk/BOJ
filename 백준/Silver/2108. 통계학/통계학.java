import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br;
    public static void main(String [] args) throws IOException {
        if(br == null){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int count = Integer.parseInt(br.readLine());
        int [] nums = new int[count];
        int sum = 0;
        int max_count = 1;

        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int i =0; i< count; i++){
            nums[i] = Integer.parseInt(br.readLine());
            if(hashMap.containsKey(nums[i])){
                int value = hashMap.get(nums[i])+1;
                hashMap.replace(nums[i], value);
                if(value > max_count){
                    max_count = value;
                }
            }else{
                hashMap.put(nums[i], 1);
            }
            sum += nums[i];
        }

        Arrays.sort(nums);


        // 1. 평군
        double ave = (double)sum/count;
        if(0 < ave && ave < -1){
            if(Math.round(ave) == 0){
                System.out.println("-0");
            }
            else{
                System.out.println("-1");
            }
        } else{
            System.out.println(Math.round(ave));
        }

        // 2. 중앙값
        System.out.println(nums[nums.length/2]);
        // 3. 최빈값
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        List p = new ArrayList<Integer>();

        while(iterator.hasNext()){
            int key = iterator.next();
            if(hashMap.get(key) == max_count){
                p.add(key);
            }
        }
        if(p.size() == 1){
            System.out.println(p.get(0));
        } else{
            p.sort(Comparator.naturalOrder());
            System.out.println(p.get(1));
        }

        //4. 범위
        System.out.println(nums[nums.length-1] - nums[0]);
    }
}
