package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BOJ1181_20220111 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		Set<String>[] arr=new HashSet[10001];
		ArrayList<Integer> list=new ArrayList();
		for(int i=0;i<n;i++) {
			String str=br.readLine();
			int len=str.length();
			if(arr[len]==null) {
				arr[len]=new HashSet();
				arr[len].add(str);
				list.add(len);
			}else {
				arr[len].add(str);
			}
		}
		
		
		Collections.sort(list);
		for(int i:list) {
			ArrayList<String> temp=new ArrayList(arr[i]);
			Collections.sort(temp);
			for(String s:temp) {
				System.out.println(s);
			}
		}
	}
}
