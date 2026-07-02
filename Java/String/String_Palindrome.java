public class String_Palindrome {
    public static void main(String[] args) {
        StringBuilder name = new StringBuilder("sabya");
        checkPalindrome(name);
    }

    public static void checkPalindrome(StringBuilder text) {

    String original = text.toString();
    String reversed = new StringBuilder(text).reverse().toString();

    if (original.equals(reversed))
        System.out.println("Palindrome String");
    else
        System.out.println("Not Palindrome String");
}
}
