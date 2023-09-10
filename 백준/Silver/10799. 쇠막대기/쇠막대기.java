import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        // 총 막대기 수
        int sum = 0;
        // 레이저의 수
        int laser = 0;
        int curItem = 0;

        String str = (br.readLine());
        /**
         *  '(' => -1
         *  ') => 0
         *  레이저 => 1 이상의 수
         *  레이저의 수를 스택에 넣기 위해 String<Integer> 사용
         */
        for(int i=0; i< str.length(); i++) {
            if(str.charAt(i) == '('){
                stack.push(-1);
            }
            if (str.charAt(i) == ')'){
                // 레이저가 나올 때
                if(stack.peek() == -1){
                    stack.pop();
                    stack.push(1);
                }
                // 막대기의 끝 발견
                else{
                    laser = 0;
                    // ')' 를 만나면 '('를 만날 때까지 pop,
                    while(!((curItem = stack.pop()) == -1)){
                        // 중간에 만나는 레이저의 수 만큼 누적해서 더함

                        laser += curItem;

                    }
                    // 현재 막대기가 잘리지는 조각 수 = 만난 레이저의 개수 +1)
                    sum += laser +1;
                    // pop한 레이저의 수를 더해서 push
                    stack.push(laser);
                }
            }
        }
        System.out.println(sum);
    }





}

