package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10570 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		boolean[] p = new boolean[1001];

		for (int i = 1; i < 10; i++) {
			String reverse = String.valueOf(i);
			p[i] = true;
			p[Integer.parseInt(reverse+reverse)] = true;
			for (int j = 0; j < 10; j++) {
				String center = String.valueOf(j);
				p[Integer.parseInt(reverse+center+reverse)] = true;
			}
		}
		
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int count = 0;
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			A = (int) Math.ceil(Math.sqrt(A));
			B = (int) Math.sqrt(B);
			for (int i = A; i <= B; i++) {
				if(p[i] && p[i*i])	count++;
			}
			sb.append("#").append(testCase).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

}
