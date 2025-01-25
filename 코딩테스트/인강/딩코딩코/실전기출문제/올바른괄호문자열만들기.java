package 인강.딩코딩코.실전기출문제;

// https://fern-freeze-290.notion.site/5-57ada1b094714e5e80eeedeb25d255e9#f66156f75e0d4d66b3f074b06cbe7bbe
// https://school.programmers.co.kr/learn/courses/30/lessons/60058
public class 올바른괄호문자열만들기 {
    public static void main(String[] args) {
        String balancedParenthesesString = "()))((()";

        System.out.println(getCorrectParentheses(balancedParenthesesString));  // "()(())()"가 반환 되어야 합니다!

        System.out.println("정답 = (((()))) / 현재 풀이 값 = " + getCorrectParentheses(")()()()("));
        System.out.println("정답 = ((((()())))) / 현재 풀이 값 = " + getCorrectParentheses(")()()()(())("));
        System.out.println("정답 = () / 현재 풀이 값 = " + getCorrectParentheses(")("));
    }


    public static String getCorrectParentheses(String balancedParenthesesString) {
        return processbalancedParenthesesString(balancedParenthesesString);
    }

    private static String processbalancedParenthesesString(String balancedParenthesesString) {
        if (balancedParenthesesString.isEmpty()) {
            return "";
        }

        StringBuilder u = new StringBuilder();
        String v = "";

        boolean isCorrect = true;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < balancedParenthesesString.length(); i++) {
            u.append(balancedParenthesesString.charAt(i));

            if (balancedParenthesesString.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if (rightCount > leftCount) {
                isCorrect = false;
            }

            if (i == balancedParenthesesString.length() - 1) {
                break;
            }

            if (leftCount != 0 && rightCount != 0 && leftCount == rightCount) {
                v = balancedParenthesesString.substring(i+1, balancedParenthesesString.length());
                break;
            }
        }

        String recursiveV;
        recursiveV = processbalancedParenthesesString(v);

        if (!isCorrect) {
            StringBuilder newU = new StringBuilder();
            newU.append("(").append(recursiveV).append(")");
            for(int i = u.length() - 2; i > 0; i--) {
                newU.append(u.charAt(i));
            }
            return newU.toString();
        }

        return u.append(recursiveV).toString();
    }
}

