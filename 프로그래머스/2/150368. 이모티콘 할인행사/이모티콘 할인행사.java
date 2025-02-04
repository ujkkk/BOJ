import java.util.*;
// 13:35 구현 시작
class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        // dfs로 할인된 이모티콘 리스트 만들기
        List<Emoticon[]> list = new ArrayList();
        
        int m = emoticons.length;
        
        Emoticon[] discounted = new Emoticon[m];
        bfs(m, 0, emoticons, discounted, list);
        
//         for(Emoticon[] es: list){
//             for(Emoticon e : es){
//                 System.out.print(e.price +" " + e.discount);
//             }
//             System.out.println();
//         }
        
        int max1 = 0;
        int max2 = 0;
        
        for(Emoticon[] es: list){
            int curMax1 = 0;
            int curMax2 = 0;
            
            for(int [] user : users){
                int userDis = user[0];
                int userMax = user[1];
                
                int sum = 0;
                for(Emoticon e : es){
                    if((int)e.discount < userDis){
                        continue;
                    }
                    sum += e.price;
                    if(sum >= userMax){
                        curMax1++;
                        sum = 0;
                        break;
                    }
                }
                curMax2 += sum;
            }
            
            if(max1 < curMax1){
                max1 = curMax1;
                max2 = curMax2;
            }
            else if(max1 == curMax1){
                // for(Emoticon e : es){
                //     System.out.print(e.price +" " + e.discount +"%, ");
                // }
                // System.out.println();
                max2 = Math.max(max2, curMax2);
            }
        }
        
        return new int[]{max1, max2};
    }
    
    void bfs (int size, int depth, int[] emoticons, Emoticon[] discounted, List<Emoticon[]> list){
        if(size == depth){
            list.add(discounted.clone());
            return;
        }
        
        double [] rate = {0.9, 0.8, 0.7, 0.6};
        
        for(int i=0; i<4; i++){
            discounted[depth] = new Emoticon(emoticons[depth]*rate[i], 100-(rate[i]*100));
            bfs(size, depth +1, emoticons, discounted, list);
        }
    }
}



class Emoticon{
    double price;
    double discount;
    
    Emoticon(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
}

