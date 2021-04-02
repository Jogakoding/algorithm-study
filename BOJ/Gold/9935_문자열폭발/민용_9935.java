package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
	static int bombSize;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();

		
//			mirkovC4nizCC44 을 거꾸로 넣어줌
//			C4
		
		// 스택
		// 4
		// 4 4
		// 4 4 C
		//     ~              
		//  bomb[0]과 같은 것 발견. bomb.lenght만큼 스택에서 확인
		
		// 4 4 C 
		//   ~ ~
		//  bomb와 일치. flag가 true이므로, bomb길이만큼 pop

		//남은 문자열 mirkovC4nizC4
		// 4 
		// 4 C
		// ~ ~
		//  bomb와 일치. flag가 true이므로, bomb길이만큼 pop
		
		//남은 문자열 mirkovC4niz
		// z
		// z i
		// z i n
		// z i n 4
		// z i n 4 C
		//       ~ ~ Bomb!
		// z i n
		// z i n v o k r i m
		// 스택이므로 반대 순서로 출력
		
		
		Stack<Character> stack = new Stack<>();
		for (int i = str.length() - 1; i >= 0; i--) {
			boolean flag = false;
			char c = str.charAt(i);
			stack.push(c);

			
			//해당 인덱스의 문자가 폭탄문자 첫글자와 같다면 ?
			// 스택에 들어있는것들을 확인한다.
			// 폭탄은 0인덱스부터 폭탄 길이까지.
			// 스택이므로 꼭대기부터 폭탄길이까지 뺴면서..
			if (c == bomb.charAt(0) && stack.size() >= bomb.length()) {
				System.out.println(c);
				//한번이라도 다른글자가 나오면 false.
				flag = true;
				for (int j = 0; j < bomb.length(); j++) {
					if (bomb.charAt(j) != stack.get(stack.size() - 1 - j)) {
						flag = false;
						break;
					}
				}
				
				//flase가 아니라는 것은 스택에 폭탄문자가있다는것..그만큼 빼준다
				if (flag) {
					for (int k = 0; k < bomb.length(); k++) {
						stack.pop();
					}
				}

			}
		}
		StringBuilder sb = new StringBuilder();
		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			for (int i = stack.size() - 1; i >= 0; i--) {
				sb.append(stack.pop());
			}
		}
		System.out.println(sb);
	}

}
