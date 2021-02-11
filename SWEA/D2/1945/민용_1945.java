package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1945 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int t = 1; t <= N; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[5];
			int[] mox = { 2, 3, 5, 7, 11 };
			for (int i = 0; i < 5; i++) {
				while (true) {
					if (n % mox[i] == 0) {
						arr[i] += 1;
						n = n / mox[i];
					} else {
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ");
			for(int k=0;k<5;k++) {
				sb.append(arr[k]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
