package 인강.딩코딩코.이진탐색과재귀;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(is_palindrome("소주만병만주소"));
    }

    public static boolean is_palindrome(String word) {
        System.out.println(word);
        if (word.length() <= 1) return true;
        if (word.charAt(0) != word.charAt(word.length()-1)) return false;

        return is_palindrome(word.substring(1, word.length()-1));
    }
}
