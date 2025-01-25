package 인강.딩코딩코.실전기출문제;

public class 문자열압축 {
    public static void main(String[] args) {
        String input = "abcabcabcabcdededededede";

        System.out.println(stringCompression(input)); // 14가 출력되어야 합니다!

        System.out.println("정답 = 1 / 현재 풀이 값 = " + stringCompression("a"));  // a
        System.out.println("정답 = 3 / 현재 풀이 값 = " + stringCompression("JAAA"));  // J3A
        System.out.println("정답 = 9 / 현재 풀이 값 = " + stringCompression("AZAAAZDWAAA")); // AZ3AZDW3A
        System.out.println("정답 = 12 / 현재 풀이 값 = " + stringCompression("BBAABAAADABBBD"));   //2B2AB3ADA4BD
        System.out.println("정답 = 7 / 현재 풀이 값 = " + stringCompression("aabbaccc"));   //2a2ba3c
        System.out.println("정답 = 9 / 현재 풀이 값 = " + stringCompression("ababcdcdababcdcd"));
        System.out.println("정답 = 8 / 현재 풀이 값 = " + stringCompression("abcabcdede"));
        System.out.println("정답 = 14 / 현재 풀이 값 = " + stringCompression("abcabcabcabcdededededede"));
        System.out.println("정답 = 17 / 현재 풀이 값 = " + stringCompression("xababcdcdababcdcd"));
    }

    public static int stringCompression(String string) {

        int result = Integer.MAX_VALUE;

        if (string.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= string.length() / 2; i++) {
            result = Math.min(result, countString(string, i));
        }

        return result;
    }

    public static int countString(String string, int splitLength) {
        int start = 0;
        int end = splitLength;
        String startString = string.substring(start, end);
        StringBuilder compressedString = new StringBuilder();

        int compressCount = 0;
        while (end <= string.length()) {
            start = end;
            end = Math.min(end + splitLength, string.length());

            String nextString = string.substring(start, end);
            if (startString.equals(nextString)) {
                compressCount++;
            } else {
                if (compressCount != 0) {
                    compressedString.append((compressCount + 1));
                }
                compressedString.append(startString);

                compressCount = 0;
                startString = nextString;
            }

            if (end == string.length()) {
                if (compressCount != 0) {
                    compressedString.append((compressCount + 1));
                }
                compressedString.append(startString);
                break;
            }
        }

        return compressedString.toString().length();
    }

}
// 문자열을 자르는 개수를 1개~문자열/2개까지 전체를 확인하여 가장 작은 값 출력