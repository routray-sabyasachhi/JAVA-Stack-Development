import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

public class String_Methods {
    public static void main(String[] args) throws ReflectiveOperationException {
        String text = "Java String";
        String spaced = "  Java  ";
        String blank = "   ";
        String emojiText = "A🙂B";

        section("Basic Methods");
        System.out.println("length(): " + text.length());
        System.out.println("isEmpty(): " + "".isEmpty());
        System.out.println("isBlank(): " + blank.isBlank());
        System.out.println("charAt(1): " + text.charAt(1));
        System.out.println("codePointAt(1): " + emojiText.codePointAt(1));
        System.out.println("codePointBefore(3): " + emojiText.codePointBefore(3));
        System.out.println("codePointCount(0, length): " + emojiText.codePointCount(0, emojiText.length()));
        System.out.println("offsetByCodePoints(0, 2): " + emojiText.offsetByCodePoints(0, 2));

        char[] destination = new char[4];
        text.getChars(0, 4, destination, 0);
        System.out.println("getChars(0, 4, destination, 0): " + Arrays.toString(destination));
        System.out.println("getBytes(UTF_8): " + Arrays.toString("Hi".getBytes(StandardCharsets.UTF_8)));
        System.out.println("toCharArray(): " + Arrays.toString("Java".toCharArray()));

        section("Comparison");
        System.out.println("equals(): " + "java".equals("java"));
        System.out.println("equalsIgnoreCase(): " + "Java".equalsIgnoreCase("java"));
        System.out.println("compareTo(): " + "apple".compareTo("banana"));
        System.out.println("compareToIgnoreCase(): " + "Apple".compareToIgnoreCase("apple"));
        System.out.println("contentEquals(): " + "Java".contentEquals(new StringBuilder("Java")));
        System.out.println("regionMatches(): " + "Java String".regionMatches(5, "Strong", 0, 3));
        System.out.println("regionMatches(ignoreCase): " + "Java String".regionMatches(true, 5, "string", 0, 6));
        System.out.println("startsWith(): " + text.startsWith("Java"));
        System.out.println("endsWith(): " + text.endsWith("ing"));

        section("Searching");
        System.out.println("contains(): " + text.contains("Str"));
        System.out.println("indexOf(): " + text.indexOf("String"));
        System.out.println("lastIndexOf(): " + "banana".lastIndexOf("a"));
        System.out.println("matches(): " + "A123".matches("[A-Z]\\d+"));

        section("Substrings");
        System.out.println("substring(5): " + text.substring(5));
        System.out.println("substring(0, 4): " + text.substring(0, 4));
        System.out.println("subSequence(5, 11): " + text.subSequence(5, 11));

        section("Modification");
        System.out.println("concat(): " + "Hello".concat(" Java"));
        System.out.println("replace(char, char): " + "java".replace('a', 'o'));
        System.out.println("replace(CharSequence, CharSequence): " + "Java is Java".replace("Java", "Python"));
        System.out.println("replaceFirst(): " + "cat cat".replaceFirst("cat", "dog"));
        System.out.println("replaceAll(): " + "a1b2c3".replaceAll("\\d", "#"));
        System.out.println("repeat(): " + "Hi ".repeat(3));
        System.out.println("trim(): [" + spaced.trim() + "]");
        System.out.println("strip(): [" + spaced.strip() + "]");
        System.out.println("stripLeading(): [" + spaced.stripLeading() + "]");
        System.out.println("stripTrailing(): [" + spaced.stripTrailing() + "]");
        System.out.println("indent(4):\n" + "Java\nString".indent(4));
        System.out.println("stripIndent():\n" + "    Java\n    String".stripIndent());
        System.out.println("translateEscapes(): " + "Java\\nString".translateEscapes());
        System.out.println("transform(): " + "java".transform(value -> value.toUpperCase() + " 21"));

        section("Splitting and Joining");
        System.out.println("split(): " + Arrays.toString("red,green,blue".split(",")));
        System.out.println("split(regex, limit): " + Arrays.toString("a-b-c".split("-", 2)));
        System.out.println("join(): " + String.join(" | ", "Java", "Spring", "SQL"));
        System.out.println("lines(): " + "one\ntwo\nthree".lines().toList());

        section("Case Conversion");
        System.out.println("toLowerCase(): " + "JAVA".toLowerCase());
        System.out.println("toUpperCase(): " + "java".toUpperCase());

        section("Formatting");
        System.out.println("formatted(): " + "Name: %s, Age: %d".formatted("Sabyasachhi", 21));
        System.out.println("format(): " + String.format("Price: %.2f", 99.5));

        section("Conversion");
        System.out.println("toString(): " + text.toString());
        String interned = new String("Java").intern();
        System.out.println("intern(): " + (interned == "Java"));
        Optional<String> constable = text.describeConstable();
        System.out.println("describeConstable(): " + constable.orElse("No value"));
        System.out.println("resolveConstantDesc(): " + text.resolveConstantDesc(MethodHandles.lookup()));

        section("Streams");
        System.out.println("chars(): " + "ABC".chars().mapToObj(value -> (char) value).toList());
        System.out.println("codePoints(): " + emojiText.codePoints().mapToObj(Integer::toHexString).toList());

        section("Static Factory Methods");
        System.out.println("valueOf(int): " + String.valueOf(100));
        System.out.println("valueOf(boolean): " + String.valueOf(true));
        System.out.println("copyValueOf(): " + String.copyValueOf(new char[] {'J', 'a', 'v', 'a'}));
        System.out.println("copyValueOf(char[], 1, 3): " + String.copyValueOf(new char[] {'S', 'J', 'D', 'K'}, 1, 3));
    }

    private static void section(String title) {
        System.out.println("\n--- " + title + " ---");
    }
}
