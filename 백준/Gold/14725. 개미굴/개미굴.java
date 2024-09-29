import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static class TrieNode{
        // 자식을 저장하는 맵
        Map<String, TrieNode> childNode = new HashMap<>();

        public void insert(String strs){
            // 계속 첫 번째 자식을 가리키게 함
            TrieNode trieNode = this;
            String [] str = strs.split(",");
            for(String s : str){
                // 현재 노드의 자식으로 없으면 새로운 노드 할당
                trieNode.childNode.putIfAbsent(s, new TrieNode());
                // 다음 depth를 위해 자식을 가리키도록 함
                trieNode = trieNode.childNode.get(s);
            }
        }

        public void print(TrieNode cur, int depth) throws IOException{
            TrieNode trieNode = cur;
            if(trieNode.childNode != null){
                List<String> list = new ArrayList<>(trieNode.childNode.keySet());

                // 사전 순 정렬
                Collections.sort(list);
                for(String str : list){
                    for(int i=0; i<depth; i++){
                        bw.write("--");
                    }
                    bw.write(str+"\n");
                    print(trieNode.childNode.get(str), depth +1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TrieNode trie = new TrieNode();
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);

            StringBuilder sb = new StringBuilder();
            for(int j=1; j<k+1; j++) {
                sb.append(input[j]+",");
            }

            trie.insert(sb.toString());
        }

        trie.print(trie,0);
        bw.flush();
    }
}


