# Java String Methods

Short documentation and quick examples for commonly used `String` methods.

## Basic Methods

| Method | Use | Short example |
| --- | --- | --- |
| `length()` | Counts characters stored in the string. | `"Java".length()` -> `4` |
| `isEmpty()` | Checks if length is `0`. | `"".isEmpty()` -> `true` |
| `isBlank()` | Checks if the string is empty or only whitespace. | `"   ".isBlank()` -> `true` |
| `charAt(index)` | Returns the character at an index. | `"Java".charAt(1)` -> `'a'` |
| `codePointAt(index)` | Returns Unicode code point at index. | `"A🙂".codePointAt(1)` |
| `codePointBefore(index)` | Returns Unicode code point before index. | `"A🙂".codePointBefore(1)` |
| `codePointCount(begin, end)` | Counts Unicode code points in a range. | `"A🙂B".codePointCount(0, 4)` -> `3` |
| `offsetByCodePoints(index, offset)` | Moves index by code points. | `"A🙂B".offsetByCodePoints(0, 2)` -> `3` |
| `getChars(srcBegin, srcEnd, dst, dstBegin)` | Copies characters into a char array. | `"Java".getChars(0, 2, arr, 0)` |
| `getBytes()` | Converts string to bytes. | `"Hi".getBytes(StandardCharsets.UTF_8)` |
| `toCharArray()` | Converts string to char array. | `"Java".toCharArray()` |

## Comparison

| Method | Use | Short example |
| --- | --- | --- |
| `equals()` | Compares exact text. | `"java".equals("java")` -> `true` |
| `equalsIgnoreCase()` | Compares text ignoring case. | `"Java".equalsIgnoreCase("java")` -> `true` |
| `compareTo()` | Lexicographic comparison. | `"apple".compareTo("banana")` -> negative |
| `compareToIgnoreCase()` | Lexicographic comparison ignoring case. | `"A".compareToIgnoreCase("a")` -> `0` |
| `contentEquals()` | Compares string with `StringBuilder`, `StringBuffer`, or another character sequence. | `"Java".contentEquals(new StringBuilder("Java"))` |
| `regionMatches()` | Compares part of one string with part of another. | `"Java String".regionMatches(5, "Strong", 0, 3)` |
| `startsWith()` | Checks starting text. | `"Java".startsWith("Ja")` -> `true` |
| `endsWith()` | Checks ending text. | `"Java".endsWith("va")` -> `true` |

## Searching

| Method | Use | Short example |
| --- | --- | --- |
| `contains()` | Checks if text exists. | `"Java String".contains("String")` -> `true` |
| `indexOf()` | First index of text or character. | `"banana".indexOf("a")` -> `1` |
| `lastIndexOf()` | Last index of text or character. | `"banana".lastIndexOf("a")` -> `5` |
| `matches()` | Checks full string against regex. | `"A123".matches("[A-Z]\\d+")` -> `true` |

## Substrings

| Method | Use | Short example |
| --- | --- | --- |
| `substring(begin)` | Returns text from begin index to end. | `"Java String".substring(5)` -> `"String"` |
| `substring(begin, end)` | Returns text from begin index to end index minus one. | `"Java".substring(0, 2)` -> `"Ja"` |
| `subSequence(begin, end)` | Returns a `CharSequence` part. | `"Java".subSequence(1, 3)` -> `"av"` |

## Modification

| Method | Use | Short example |
| --- | --- | --- |
| `concat()` | Joins another string at the end. | `"Hello".concat(" Java")` |
| `replace()` | Replaces characters or text. | `"java".replace('a', 'o')` -> `"jovo"` |
| `replaceFirst()` | Replaces first regex match. | `"cat cat".replaceFirst("cat", "dog")` |
| `replaceAll()` | Replaces all regex matches. | `"a1b2".replaceAll("\\d", "#")` |
| `repeat()` | Repeats string. | `"Hi ".repeat(3)` |
| `trim()` | Removes leading and trailing characters up to Unicode U+0020. | `"  Java  ".trim()` |
| `strip()` | Removes leading and trailing Unicode whitespace. | `"  Java  ".strip()` |
| `stripLeading()` | Removes leading Unicode whitespace. | `"  Java  ".stripLeading()` |
| `stripTrailing()` | Removes trailing Unicode whitespace. | `"  Java  ".stripTrailing()` |
| `indent()` | Adds or removes indentation and normalizes line endings. | `"Java\nString".indent(4)` |
| `stripIndent()` | Removes common indentation from multiline text. | `"    Java\n    String".stripIndent()` |
| `translateEscapes()` | Converts escape sequences like `\n` into real characters. | `"Java\\nString".translateEscapes()` |
| `transform()` | Sends the string into a function and returns the result. | `"java".transform(s -> s.toUpperCase())` |

## Splitting and Joining

| Method | Use | Short example |
| --- | --- | --- |
| `split()` | Splits string by regex. | `"a,b,c".split(",")` |
| `join()` | Joins strings with delimiter. | `String.join("-", "a", "b")` -> `"a-b"` |
| `lines()` | Returns stream of lines. | `"one\ntwo".lines().toList()` |

## Case Conversion

| Method | Use | Short example |
| --- | --- | --- |
| `toLowerCase()` | Converts to lowercase. | `"JAVA".toLowerCase()` -> `"java"` |
| `toUpperCase()` | Converts to uppercase. | `"java".toUpperCase()` -> `"JAVA"` |

## Formatting

| Method | Use | Short example |
| --- | --- | --- |
| `formatted()` | Formats using the current string as template. | `"Name: %s".formatted("Sam")` |
| `format()` | Static formatting method. | `String.format("%.2f", 10.5)` -> `"10.50"` |

## Conversion

| Method | Use | Short example |
| --- | --- | --- |
| `toString()` | Returns the same string object. | `"Java".toString()` |
| `intern()` | Returns canonical string from string pool. | `new String("Java").intern()` |
| `describeConstable()` | Returns optional constant description. | `"Java".describeConstable()` |
| `resolveConstantDesc()` | Resolves constant description with lookup. | `"Java".resolveConstantDesc(MethodHandles.lookup())` |

## Streams

| Method | Use | Short example |
| --- | --- | --- |
| `chars()` | Returns an `IntStream` of UTF-16 char values. | `"ABC".chars()` |
| `codePoints()` | Returns an `IntStream` of Unicode code points. | `"A🙂B".codePoints()` |

## Static Factory Methods

| Method | Use | Short example |
| --- | --- | --- |
| `valueOf()` | Converts values to string. | `String.valueOf(100)` -> `"100"` |
| `copyValueOf()` | Creates string from char array. | `String.copyValueOf(new char[] {'J', 'a', 'v', 'a'})` |

## Notes

- `String` is immutable, so methods like `replace()`, `trim()`, and `toUpperCase()` return a new string.
- Index positions start from `0`.
- Many search methods return `-1` when text is not found.
- Regex methods include `matches()`, `replaceFirst()`, `replaceAll()`, and `split()`.
