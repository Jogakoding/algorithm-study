package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3752_가능한시험점수 {
	static int n, m;
	static boolean[] check;
	static int[] arr;
	static int sum, answer, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int t = 1; t <= n; t++) {
			m = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[m];
			answer = 0;
			max = 0;
			check = new boolean[10001];
			check[0] = true;
			for (int i = 0; i < m; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max += arr[i];

		        for (int j = max; j >= 0; j--) {
                    if(check[j])
                    	check[j + arr[i]] = true;
                }
//				for (int j = 0; j < max; j++) {
//					if (check[j]) {
//						check[j + arr[i]] = true;
//					}
//				}
				check[arr[i]] = true;
			}
			for (int i = 0; i <= max; i++) {
				if (check[i]) {
					answer++;
				}
			}

			System.out.println("#" + t + " " + answer);
		}
	}

	/*
	 * static void powerset(int[] arrs, int idx, boolean[] sel, int result) {
	 * 
	 * if (idx == arrs.length) { if (check[result]) { return; }else {
	 * check[result]=true; answer++; } return; }
	 * 
	 * sel[idx] = true; powerset(arrs, idx + 1, sel, result + arr[idx]); sel[idx] =
	 * false; powerset(arrs, idx + 1, sel, result); }
	 */
}
