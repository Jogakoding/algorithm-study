package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3499 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			String[] first;
			if(num%2 == 1)	first = new String[num/2+1];
			else 	first = new String[num/2];
			
			String[] second = new String[num/2];
			
			int fIdx = 0;
			int sIdx = 0;
			for (int i = 0; i < num; i++) {
				if(i < first.length )	first[fIdx++] = st.nextToken();
				else 	second[sIdx++] = st.nextToken();
			}
			
			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < num/2; i++) {
				sb.append(first[i]).append(" ").append(second[i]).append(" ");
			}
			
			if(num%2 == 1)	sb.append(first[fIdx-1]);
			else	sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
