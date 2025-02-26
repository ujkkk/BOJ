import java.util.*;


class OutInfo implements Comparable<OutInfo>{
    String carNum;
    int cost;
    
    public OutInfo(String carNum, int cost){
        this.carNum = carNum;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(OutInfo o){
        return this.carNum.compareTo(o.carNum);
    }
}

class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        // 1. 변수 선언
        int baseTime = fees[0];
        int baseCost = fees[1];
        int perTime = fees[2];
        int perCost = fees[3];
        
        HashMap<String, Integer> inCars = new HashMap<String, Integer>();
        TreeMap<String, Integer> outCars = new TreeMap<String, Integer>();
        
        // 2. 레코드 마다 관리
        for(String record : records){
            String [] op = record.split(" ");
            
            int time = getTime(op[0]);
            String carNum = op[1];
            
            if(op[2].equals("IN")){
                // 입차 - 해쉬셋에 (차 번호 : 입차시간) 저장, 입차시간은 분단위
                //System.out.println(String.format("[입차] 차 : %s, 시간 : %d", carNum, time));
                inCars.put(carNum, time);
            }
            else if(op[2].equals("OUT")){
                // 출차 - 입차 시간 계산, 차 삭제, 레코드 저장
                int inTime = inCars.get(carNum);
                //int cost = calcCost(inTime, time);
                
                
                outCars.put(carNum, outCars.getOrDefault(carNum, 0) + (time - inTime));
                inCars.remove(carNum);
            }
           
        }
        
        // 출차되지 않은 차 출차
        for(String car : inCars.keySet()){
            int inTime = inCars.get(car);
            int outTime = 60*23 + 59;
            
            outCars.put(car, outCars.getOrDefault(car, 0) + (outTime - inTime));
        }
        
        
        
        int [] costs = new int[outCars.size()];
        int idx = 0;
        for(String c : outCars.keySet()){
            int t = outCars.get(c);
            int operTime = outCars.get(c);
            if(operTime <= baseTime){
                costs[idx++] = baseCost;
            }
            else{
                costs[idx++] = baseCost + (int)(Math.ceil((operTime - baseTime)*1.0 / perTime)) * perCost;
            }
        
            // System.out.println(String.format("[출차] 차 : %s, 시간 : %d, 비용 : %d", c, t, costs[idx-1]));
            
        }
        return costs;
    }
 
    
    public static int getTime(String time){
        String [] st = time.split(":");
        int h = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        
        return h*60 + m;
    }
}