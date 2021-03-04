import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_9778 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			int[] deck = {0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 16, 4};
			int N = Integer.parseInt(br.readLine());

			int hand = 0;
			for (int i=1; i<=N; i++) {
				int card = Integer.parseInt(br.readLine());
				hand += card;
				deck[card] = deck[card]-1;
			}
			
			
			int go = 0;
			for (int i=2; i<=21-hand; i++) {
				go += deck[i];
			}
			
			int stop = 0;
			for (int i=21-hand+1; i<=11; i++) {
				stop += deck[i];
			}
			
			String result = "";
			if (go>stop) {
				result = "GAZUA";
			} else {
				result = "STOP";
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}