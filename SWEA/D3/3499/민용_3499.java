package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int t=1;t<=n;t++) {
			
			
			int m = Integer.parseInt(br.readLine());
			String[] str=br.readLine().split(" ");
			
			// 0 1 2 3 4
			sb.append("#"+t+" ");
			if(m%2==0) {
				for(int i=0;i<str.length/2;i++) {
					sb.append(str[i]).append(" ").append(str[i+str.length/2]).append(" ");
				}
				sb.append("\n");
			}else {
				for(int i=0;i<str.length/2;i++) {
					sb.append(str[i]).append(" ").append(str[str.length/2+1+i]).append(" ");
				}
				sb.append(str[str.length/2]+"\n");
				
			}
			
		}
		System.out.println(sb);
	}
}
