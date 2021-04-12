package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_11725_트리의부모노드 {
	static ArrayList<Integer> arr[];
	static boolean[] visit;
	static int N;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new ArrayList[N+1];
		for(int i=0;i<=N;i++) { 
			arr[i]=new ArrayList();
		}
		
		for(int i=0;i<N-1;i++) {
			String[] str=br.readLine().split(" ");
			int start=Integer.parseInt(str[0]);
			int end=Integer.parseInt(str[1]);
			arr[start].add(end);
			arr[end].add(start);
		}
		visit=new boolean[N+1];
		parents=new int[N+1];
		dfs(1);
		for(int i=2;i<=N;i++) {
			System.out.println(parents[i]);
		}
	}
	public static void dfs(int n){
		for(int i:arr[n]) {
			if(!visit[i]) {
				visit[i]=true;
				parents[i]=n;
				dfs(i);
			}
		}
	}
}
