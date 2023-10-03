import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    static Node root;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN;

        // 입력 데이터가 없을 때까지 입력 받음
        while((strN = br.readLine()) != null && !strN.isEmpty()){
            if(root == null){
                // root 생성
                root = new Node(Integer.parseInt(strN));
                continue;
            }

            Node curNode = new Node(Integer.parseInt(strN));
            insertNode(root, curNode);
        }

        // 후위 순회
        postOrder(root);

        br.close();
    }

    static void insertNode(Node root, Node insertedNode){
        // 왼쪽으로
        if(root.value > insertedNode.value){
            if(root.left == null){
                root.left = insertedNode;
                return;
            }
            insertNode(root.left, insertedNode);
        }

        // 오른쪽으로
        else if(root.value < insertedNode.value){
            if(root.right == null){
                root.right = insertedNode;
                return;
            }
            insertNode(root.right, insertedNode);
        }
    }

    static void postOrder(Node node){
        if(node.left != null){
            postOrder(node.left);
        }
        if(node.right != null){
            postOrder(node.right);
        }
        System.out.println(node.value);
    }

}

class Node{
    int value;
    Node left;
    Node right;

    Node(int value){
        this.value=  value;
    }


}


