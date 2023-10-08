import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static BufferedReader br;
    public static int result = 0;
    public static void main(String [] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String mathMatic = br.readLine();

        ArrayList<Character> operator = new ArrayList<Character>();
        ArrayList<Integer> nums = new ArrayList<Integer>();

        char [] charN = new char[6];
        int numSize = 0;

        // 입력 데이터 생성
        for(int i=0; i< mathMatic.length(); i++) {
            char currentChar = mathMatic.charAt(i);
            if(currentChar == '+' || currentChar == '-'){
                if(numSize != 0){
                    nums.add(charArrToInteger(charN));
                    charN = new char[6];
                    numSize = 0;
                }
                operator.add(currentChar);
            }
            else{
                charN[numSize++] = currentChar;
            }
        }
        nums.add(charArrToInteger(charN));


        char preOper = 0;
        result += nums.get(0);
        if(operator.size() > 0 )
            preOper = operator.get(0);

        int i =1;
        while(i < nums.size()){
            if(i-1 >= operator.size())
                break;

            if(preOper == '+'){
                if(operator.get(i-1) == '-'){
                    preOper = '-';
                    result -= nums.get(i);
                }else{
                    result += nums.get(i);
                }

            }
            else{
                result -= nums.get(i);
            }
            i++;
        }

        System.out.println(result);
    }

    public static int charArrToInteger(char[] chars){
        String strN = "";
        int i = 0;
        while(chars[i] != 0 && i < chars.length){
            strN += Character.toString(chars[i]) ;
            i++;
        }
        return  Integer.parseInt(strN);
    }

}
