package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10726 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean on = true;
			for (int i = 0; i < N; i++) {
				if((M & 1<<i) == 0) {
					on = false;
					break;
				}
			}
			sb.append("#").append(testCase).append(" ");
			if(on)	sb.append("ON");
			else	sb.append("OFF");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
