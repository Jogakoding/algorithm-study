package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_10912 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String input = br.readLine();
			boolean empty = true;
			String[] list = new String[input.length()];
			for (int i = 0; i < list.length; i++) {
				list[i] = String.valueOf(input.charAt(i));
			}
			Arrays.sort(list);
			sb.append("#").append(testCase).append(" ");
			
			for (int i = 0; i < list.length;) {
				if(i==list.length-1 || !list[i].equals(list[i+1])) {
					empty = false;
					sb.append(list[i]);
					i++;
				}else{
					i += 2;
				}
			}
			if(empty)	sb.append("Good");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
