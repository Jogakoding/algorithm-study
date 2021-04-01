package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_18870_좌표압축 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr= new int[N];
		int[] temp;
		String[] str=br.readLine().split(" ");
		Map<Integer,Integer> map=new HashMap<>();
		StringBuilder sb=new StringBuilder();
		
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(str[i]);
		}
		temp=arr.clone();
		Arrays.sort(temp);
		int idx=0;
		for(int i : temp) {
			if(!map.containsKey(i)) {
				map.put(i, idx++);
			}
			
		}
		
		for(int i=0;i<N;i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
