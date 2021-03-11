package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9205_맥주마시면서걸어가기 {
	static class Pos {
		int y, x;

		public Pos(int y, int x) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static Pos[] arr;
	static Pos home;
	static Pos rock;
	static boolean visit[];
	static String answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			answer="sad";
			int conv = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			home = new Pos(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			visit=new boolean[conv];
			arr = new Pos[conv];
			for (int i = 0; i < conv; i++) {
				String[] temp = br.readLine().split(" ");
				arr[i] = new Pos(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			}

			str = br.readLine().split(" ");
			rock = new Pos(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			goHome(rock);
			System.out.println(answer);

		}
	}
	//콜라는 필요 없다..
	private static void goHome(Pos start) {
		if(getDistance(start, home)<=1000) {
			answer="happy";
			return;
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			int check=getDistance(start, arr[i]);
			if(!visit[i]&&check<=1000) {
				visit[i]=true;
				goHome(arr[i]);
				
			}
		}
	}
	private static int getDistance(Pos start,Pos dest) {
		
		return Math.abs(start.x-dest.x)+Math.abs(start.y-dest.y);
	}
}
