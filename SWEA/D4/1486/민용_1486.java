package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class SWEA_1486_장훈이의높은선반 {
	static int n, min, target;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		for (int t = 1; t <= n; t++) {
			min = Integer.MAX_VALUE;
			String[] str = br.readLine().split(" ");
			int num = Integer.parseInt(str[0]);
			target = Integer.parseInt(str[1]);

			int[] arr = new int[num];
			String[] tmp = br.readLine().split(" ");
			for (int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(tmp[i]);
			}
			powerset(arr, 0, new boolean[arr.length]);
			System.out.println("#" + t + " " + (min - target));

		}

	}

	static void powerset(int[] arr, int idx, boolean[] sel) {
		int sum = 0;
		if (idx == arr.length) {

			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					sum += arr[i];
				}
			}
			if (sum >= target) {
				min = Math.min(sum, min);
			}
			return;
		}

		sel[idx] = true;
		powerset(arr, idx + 1, sel);
		sel[idx] = false;
		powerset(arr, idx + 1, sel);
	}

}