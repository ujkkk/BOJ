import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static String origin;
    public static TreeSet<String> result;

    public static void main(String[] args) throws IOException {

        origin = br.readLine();
        result = new TreeSet<>();
        Stack<Integer> stack = new Stack<>();
        List<Pair> pairs = new ArrayList<>();

        // 괄호 쌍 찾기
        for(int i=0; i< origin.length(); i++){
            char cur = origin.charAt(i);

            if(cur == '('){
                stack.add(i);
            }
            else if(cur == ')'){
                pairs.add(new Pair(i, stack.pop()));
            }
        }

        for(int i=1; i<=10; i++){
            select(pairs, 0, 0, i, new HashSet<>());
        }

        for(String str: result){
            bw.write(str+"\n");
        }
        bw.flush();
    }

    // 선택하기
    private static void select(List<Pair> pairs, int idx, int depth, int k, HashSet<Integer> set){
        if(depth == k){
            result.add(extractStr(set));
            return;
        }

        int size = pairs.size();
        for(int i=idx; i<size; i++){
            int idx1 = pairs.get(i).idx1;
            int idx2 = pairs.get(i).idx2;
            set.add(idx1);
            set.add(idx2);

            select(pairs, i+1, depth+1, k, set);

            set.remove(idx1);
            set.remove(idx2);
        }
    }


    public static String extractStr(HashSet<Integer> set){
        char [] chars = new char[origin.length()-set.size()];
        int idx = 0;

        for(int i=0; i<origin.length(); i++){
            if(set.contains(i)){
                continue;
            }
            chars[idx++] = origin.charAt(i);
        }
        return new String(chars);
    }
}

class Pair{
    int idx1;
    int idx2;

    public Pair(int idx1, int idx2) {
        this.idx1 = idx1;
        this.idx2 = idx2;
    }
}