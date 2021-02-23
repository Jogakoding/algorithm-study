package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4047_영준이의카드카운팅 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int t = 1; t <= n; t++) {
			boolean[][] visit = new boolean[4][14];
			boolean flag=false;
			int[] arr = { 13, 13, 13, 13 };
			String str = br.readLine();
			// S D H C
			for (int i = 0; i < str.length(); i += 3) {
				int idx = what(str.charAt(i));
				char a = str.charAt(i + 1);
				char b = str.charAt(i + 2);
				int num = 0;
				if (a == '0') {
					num = b - '0';
				} else {
					num = 10 + (b - '0');
				}

				if (visit[idx][num]) {
					System.out.println("#"+t+" ERROR");
					flag=true;
					break;
				}
				visit[idx][num] = true;
				arr[idx]-=1;
			}
			if(flag)continue;
			System.out.println("#"+t+" "+arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
		}
	}

	private static int what(char a) {

		if (a == 'S') {
			return 0;
		} else if (a == 'D') {
			return 1;
		} else if (a == 'H') {
			return 2;
		} else {
			return 3;
		}

	}
}
