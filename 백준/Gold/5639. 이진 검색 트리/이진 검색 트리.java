import org.w3c.dom.Node;

import java.io.*;
import java.sql.Array;
import java.util.*;


public class Main {
    static class Node{
        int node; Node left; Node right;

        Node(int node){
            this.node = node;
        }
        Node(int node, Node left, Node right){
            this.node = node;
            this.left = left;
            this.right = right;
        }

        void insert(int num){
            if(num < this.node)
                if(this.left == null)
                    this.left = new Node(num);
                else
                    this.left.insert(num);
            else{
                if(this.right == null)
                    this.right = new Node(num);
                else
                    this.right.insert(num);

            }
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String str;
        while(true){
            str = br.readLine();
            if(str == null || str.equals(""))
                break;

            root.insert(Integer.parseInt(str));
        }
        postOrder(root);
    }

    static void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.node);
    }
}
