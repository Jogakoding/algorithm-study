import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int totalDamage = 0;
             
            for (int cnt = 0; cnt < N; cnt++) {
                totalDamage += D + D*cnt*L/100;
            }
            sb.append("#").append(testCase).append(" ").append(totalDamage).append("\n");
        }
        System.out.println(sb);
    }
 
}
