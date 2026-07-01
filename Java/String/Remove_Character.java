public class Remove_Character {
    public static void main(String[] args) {

        //Input string as a string builder
        StringBuilder sb = new StringBuilder("sabyasachhi");

        // Remove character 'b' from the string
        removeChar(sb, 's');
        System.out.println(sb);

    }

    public static void removeChar(StringBuilder sb, char ch) {
    for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) == ch) {
            sb.deleteCharAt(i);
            i--; // check the new character shifted into this position
        }
    }
}
}
