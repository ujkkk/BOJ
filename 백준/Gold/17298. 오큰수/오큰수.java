import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N;
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		String [] str = bf.readLine().split(" ");
		int A[] = new int[N];
		int ans[] = new int[N];
		int top =0;
		for(int i =0; i<N; i++) {
			A[i] = Integer.parseInt(str[i]);
		}
		
		stack.push(0);
		for(int index =0; index< N; index++) {  
			top = index;
			while(!stack.empty() && A[stack.peek()] < A[top]) {
				//(A[stack.peek()] <= A[top])
				ans[stack.pop()] = A[top];
			}
			
			stack.push(index);
		}
//			top = index;
//			//스택이 비어있거나 현재 원소가 A[top]보다 작을 때 -> 오큰수가 아니므로 현재 원소 push
//			if(stack.empty() || A[index] < A[top]) {
//				stack.push(index);
//				top = index;
//			}
//			//스택이 비어있지 않고 현재원소가 A[top]보다 클 때 -> 현재 원소의 오큰수 발견
//			else {
//				int b = index;
//				top = index;
//				while(true) {
//					if(!stack.empty()) {
//						//b = stack.pop();
//						if(A[stack.peek()] > A[top]) break;
//						ans[stack.pop()] = A[top];
//					}	
//					else break;
//				}
//				stack.push(b);
//			}
//		}
		while(!stack.empty()) {
			ans[stack.pop()] = -1;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i< ans.length; i++) {
			bw.write(ans[i] + " ");
		}
		bw.write("\n");
		bw.flush();
	}

}
