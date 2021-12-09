import java.util.Scanner;

/*
2021.12.09 x
https://programmers.co.kr/learn/courses/30/lessons/60058?language=java

입력 예시			출력 예시
"(()())()"		"(()())()"
")("			"()"
"()))((()"		"()(())()"
 */
public class 괄호변환 {
	public String solution(String p){
		String answer = "";
		if (p.equals("")){
			return answer;
		}
		int index = balancedIndex(p);
		String u = p.substring(0, index + 1);
		String v = p.substring(index + 1);
		// 올바른 괄호 문자열이면, v에 대해 함수를 수행한 결과를 붙여 반환
		if (checkProper(u)){
			answer = u + solution(v);
		}
		// 올바른 괄호 문자열이 아니라면 아래의 과정을 수행
		else {
			StringBuilder builder = new StringBuilder();
			builder.append("(");
			builder.append(solution(v));
			builder.append(")");

			for (int i = 1; i < u.length() -1 ; i++){
				if (u.charAt(i) == '('){
					builder.append(")");
				} else {
					builder.append("(");
				}
			}
			answer += builder.toString();
		}

		return answer;
	}

	// 올바른 괄호 문자열인지 판단
	private boolean checkProper(String p){
		int count = 0; // 왼쪽 괄호의 개수
		for (int i = 0; i < p.length(); i++){
			if (p.charAt(i) == '('){
				count += 1;
			} else {
				if ( count == 0) {	// 쌍이 맞지 않는 경우 false 반환
					return false;
				}
				count -= 1;
			}
		}
		return true; // 쌍이 맞는 경우 true 반환
	}

	// 균현잡힌 괄호 문자열의 인덱스 반환
	private int balancedIndex(String p){
		int count = 0;
		for (int i = 0; i < p.length(); i++){
			if (p.charAt(i) == '('){
				count ++;
			} else {
				count --;
			}

			if (count == 0){
				return i;
			}
		}

		return -1;
	}
}
