package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931 {
	static class lecture implements Comparable<lecture>{
		int start;
		int end;
		
		public lecture(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(lecture o) {
			if(this.end == o.end)
				return this.start - o.start;
			return this.end - o.end;
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		lecture[] lectureList = new lecture[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			lectureList[i] = new lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(lectureList);
		int max = 0;
		
		int idx = 0;
		while(idx<N) {
			max++;
			int end = lectureList[idx].end;
			//System.out.println(idx+" "+end);
				while(++idx<N && lectureList[idx].start<end) {
					//System.out.println(idx+"  >> "+lectureList[idx].start);
				}
		}
		
		System.out.println(max);
	}

}
