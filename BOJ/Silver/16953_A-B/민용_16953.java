import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		int cnt=0;
		while(true) {
			
			if(n>m) {
				System.out.println(-1);
				break;
			}
			if(n==m) {
				System.out.println(cnt+1);
				break;
			}
			
			// n에서 m으로 가는 것이 아닌,  m에서 n으로 가는 것이 더 빠르다.
			// n의 오른쪽 끝에 1을 붙이는 것 = m의 오른쪽 끝이 1일때 10으로 나눠준다.
			// n에 2배 해주는 것 = m이 2로 나누어지는 것
			// 위의 두가지 모두 불가능할 경우 -1 return
			if(m%10==1) {
				m/=10;
			}else if(m%2==0) {
				m/=2;
			}else {
				System.out.println(-1);
				break;
			}
			
			cnt++;
			
			
			
			
		}
	}

	
}
