package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18429_근손실 {
	static int[] arr;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		arr = new int[N];
		str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		boolean[] visit = new boolean[N];
			back(500,visit,0);
		System.out.println(answer);
	}

	static int answer = 0;
	public static void back(int health,boolean[] visit,int cnt) {
		if(cnt>=N) {
			answer++;
			return;
		}
		
		health-=K;
		for(int i=0;i<N;i++) {
			
			if(!visit[i]) {
				if(health+arr[i]<500) {
					continue;
				}
				health+=arr[i];
				visit[i]=true;
				back(health,visit,cnt+1);
				health-=arr[i];
				visit[i]=false;
			}
		}
		
	
		
	}

}
