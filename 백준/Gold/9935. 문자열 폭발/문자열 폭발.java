import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        char [] str = br.readLine().toCharArray();
        char [] find = br.readLine().toCharArray();

        // 전체 다 stack에 넣기
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for(char cur : str){
            stack.add(cur);
        }

        int count = 0;
        while(!stack.isEmpty()){
            // 연속성 확인
            char cur = stack.pop();

            if(cur == find[find.length-1- count]){
                count++;
            }
            else{   // 아니면 연속성 초기화
                if(cur == find[find.length-1]){
                    count = 1;
                }
                else{
                    count = 0;
                }
            }

            temp.add(cur);

            // 문자열 찾았을 때
            if(count == find.length){
                for(int i=0; i<find.length; i++){
                    count--;
                    temp.pop();
                }
                // 남은 것들 다시 본 stack에 넣기\
                for(int i=0; i<find.length; i++){
                    if(temp.isEmpty()){
                        break;
                    }
                    stack.add(temp.pop());
                }
            }
        }


        if(temp.isEmpty()){
            bw.write("FRULA");
        }
        else{
            while(!temp.isEmpty()){
                bw.write(temp.pop()+"");
            }
        }
        bw.flush();
    }


}

