
import java.util.Scanner;
import java.util.Stack;

public class Main {


	public static void main(String[] args) {
		         
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int [] n = new int[N];
		int num = 1;
		boolean result = true;
		Stack<Integer> stack = new Stack<Integer>();
		StringBuffer bf = new StringBuffer();
		
		for(int i=0;i <n.length; i++) {
			n[i]= sc.nextInt();
		}
		
		for(int i=0; i<n.length; i++) {
			if(num <= n[i]) {
				while(num <= n[i]) {
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			}
			else {
				int p = stack.pop();
				if(p> n[i]) {
					System.out.println("NO");
					result = false;
					break;
				}
				bf.append("-\n");
			}
		}
		if(result) {
			//모든 결과 출력
			System.out.println(bf.toString());
		}
	}
	

}
