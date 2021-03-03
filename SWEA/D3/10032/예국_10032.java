package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10032 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int total = Integer.parseInt(st.nextToken());
			int person = Integer.parseInt(st.nextToken());
			int m;
			if(total%person !=0)
				m = 1;
			else
				m = 0;
			
			sb.append("#").append(testCase).append(" ").append(m).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
