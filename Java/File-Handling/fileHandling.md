# Java File Handling Roadmap

Welcome to Java File Handling — one of the most important topics in Java development. File handling is the skill of reading data from files, writing data into files, organizing folders, and managing information permanently on disk. In real-world applications, almost everything depends on files: configuration files, logs, images, reports, databases backup, documents, and user data.

Think of file handling as teaching Java how to communicate with the computer’s storage system. When you learn this topic properly, you are not just learning syntax — you are learning how software stores and retrieves data safely and efficiently.

---

## 1. Introduction to File Handling

### What is File Handling?
File handling means working with files and directories in a program. In Java, we can:
- create files
- read data from files
- write data into files
- update existing files
- delete files
- move files from one location to another

### Why do we need file handling?
Without files, applications would lose all information every time the program stops. Files allow programs to:
- store user data permanently
- save settings and preferences
- maintain logs
- process large amounts of data
- exchange information between systems

### File vs Directory
- A file is a single unit of stored data, such as a text document, image, or Java source file.
- A directory (folder) is a container that holds files or other directories.

Example:
- `report.txt` -> file
- `projects/` -> directory

### Absolute vs Relative Path
- Absolute path: full location from the root of the system.
  - Windows: `C:\Users\Name\Documents\file.txt`
  - Linux/Mac: `/home/user/file.txt`
- Relative path: path relative to the current working directory.
  - Example: `data/output.txt`

### Text Files vs Binary Files
- Text files store readable characters, such as `.txt`, `.csv`, `.java`, `.json`.
- Binary files store data in bytes, such as images, PDFs, ZIPs, executable files.

### Character Encoding
Encoding decides how characters are stored in bytes.
- ASCII: older and supports only English characters
- Unicode: universal character set
- UTF-8: modern and widely used encoding for text files

Example:
```java
import java.nio.charset.StandardCharsets;

public class EncodingDemo {
    public static void main(String[] args) {
        System.out.println(StandardCharsets.UTF_8.name());
    }
}
```

---

## 2. File Class (`java.io.File`)

The `File` class represents a file or directory path in Java. It does not read or write data itself. It mainly helps us manage the file system.

### Important uses of `File`
- create a file
- create directories
- delete files
- rename files
- check whether a file exists
- check permissions
- find file size
- get last modified time
- list contents of a folder

### Creating a file
```java
import java.io.File;
import java.io.IOException;

public class FileCreateDemo {
    public static void main(String[] args) {
        File file = new File("demo.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Creating directories
```java
File dir = new File("myFolder");
if (dir.mkdir()) {
    System.out.println("Directory created");
}
```

### Creating nested directories
```java
File nestedDir = new File("folder1/folder2/folder3");
if (nestedDir.mkdirs()) {
    System.out.println("Nested directories created");
}
```

### Deleting files
```java
File file = new File("demo.txt");
if (file.delete()) {
    System.out.println("File deleted");
}
```

### Renaming files
```java
File oldFile = new File("demo.txt");
File newFile = new File("renamed.txt");

if (oldFile.renameTo(newFile)) {
    System.out.println("File renamed");
}
```

### Checking existence
```java
File file = new File("renamed.txt");
System.out.println(file.exists());
```

### Permissions
```java
File file = new File("demo.txt");
System.out.println(file.canRead());
System.out.println(file.canWrite());
System.out.println(file.canExecute());
```

### Hidden files
```java
File file = new File(".secret");
System.out.println(file.isHidden());
```

### File size and last modified time
```java
File file = new File("demo.txt");
System.out.println(file.length());
System.out.println(file.lastModified());
```

### Listing files and folders
```java
File folder = new File(".");
File[] items = folder.listFiles();

if (items != null) {
    for (File item : items) {
        System.out.println(item.getName());
    }
}
```

### Teacher’s note
`File` is a metadata class. It tells you about the file path and properties, but it does not read or write content by itself.

---

## 3. Byte Streams

Byte streams work with raw bytes. They are used for binary data such as images, audio, video, PDFs, and ZIP files.

### Key classes
- `InputStream` → reads bytes
- `OutputStream` → writes bytes
- `FileInputStream` → reads bytes from a file
- `FileOutputStream` → writes bytes to a file

### Reading bytes
```java
import java.io.FileInputStream;
import java.io.IOException;

public class ByteReadDemo {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("input.txt")) {
            int data;
            while ((data = input.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Writing bytes
```java
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteWriteDemo {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("output.txt")) {
            output.write("Hello Byte Streams".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Copying files using byte streams
```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileDemo {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("source.bin");
             FileOutputStream out = new FileOutputStream("copy.bin")) {

            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Binary file handling
Binary files are not meant to be read as text. For example, image files should be processed as bytes.

---

## 4. Character Streams

Character streams are used for text-based data. They work with characters rather than raw bytes.

### Key classes
- `Reader` → reads characters
- `Writer` → writes characters
- `FileReader` → reads text files
- `FileWriter` → writes text files

### Reading characters
```java
import java.io.FileReader;
import java.io.IOException;

public class CharacterReadDemo {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("data.txt")) {
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Writing characters
```java
import java.io.FileWriter;
import java.io.IOException;

public class CharacterWriteDemo {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("data.txt")) {
            writer.write("Hello from character streams\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Appending to files
```java
try (FileWriter writer = new FileWriter("data.txt", true)) {
    writer.write("This line is appended\n");
}
```

### Difference between byte and character streams
- Byte streams handle binary data.
- Character streams handle text data.
- Character streams are more convenient for human-readable files.

---

## 5. Buffered Streams

Buffering improves performance by reducing the number of direct read/write operations.

### Benefits of buffering
- Faster processing
- Less overhead
- Better efficiency for large files

### Key classes
- `BufferedInputStream`
- `BufferedOutputStream`
- `BufferedReader`
- `BufferedWriter`

### BufferedReader example
```java
import java.io.*;

public class BufferedReadDemo {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### BufferedWriter example
```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
    writer.write("First line");
    writer.newLine();
    writer.write("Second line");
}
```

### `readLine()`
`readLine()` reads a full line of text at a time, which makes it very useful for text processing.

### Why buffering matters
Imagine reading one character at a time from a huge file. That would be slow. Buffered classes read chunks of data and improve speed.

---

## 6. Scanner and PrintWriter

### `Scanner`
`Scanner` is used to read input from files, keyboard, or other sources.

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("data.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

### `PrintWriter`
`PrintWriter` writes formatted text easily.

```java
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class PrintWriterDemo {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter("report.txt")) {
            writer.println("Name: John");
            writer.printf("Age: %d\n", 25);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

### `Scanner` vs `BufferedReader`
- `Scanner` is easier for parsing tokens and numbers.
- `BufferedReader` is faster and more memory-efficient for reading large text files.
- `Scanner` is more flexible for input parsing.
- `BufferedReader` is better for high-performance file reading.

---

## 7. Serialization

Serialization means converting an object into a byte stream so it can be stored in a file or sent over a network.

### `Serializable` interface
To serialize an object, the class must implement `Serializable`.

```java
import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        Student s = new Student("Alice", 21);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            out.writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Deserialization
```java
try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"))) {
    Student s = (Student) in.readObject();
    System.out.println(s.name + " " + s.age);
} catch (IOException | ClassNotFoundException e) {
    e.printStackTrace();
}
```

### `serialVersionUID`
This is a version number for the class. It helps Java detect whether the serialized class matches the current class definition.

### `transient` keyword
Fields marked `transient` are not serialized.

```java
class Account implements Serializable {
    String username;
    transient String password;
}
```

### Important idea
Serialization is useful for saving objects, but it should be used carefully because it can be sensitive and version-dependent.

---

## 8. NIO (Modern File API)

Java NIO (New I/O) provides a modern and powerful file API. It is more flexible and often preferred in modern Java applications.

### Key classes
- `Path` → represents a path to a file or directory
- `Paths` → creates `Path` objects
- `Files` → performs file operations

### Creating files and directories
```java
import java.nio.file.*;

public class NioDemo {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("nioFolder");
        Files.createDirectories(path);
        Files.createFile(path.resolve("sample.txt"));
    }
}
```

### Reading files
```java
String content = Files.readString(Paths.get("sample.txt"));
System.out.println(content);
```

### Writing files
```java
Files.writeString(Paths.get("sample.txt"), "Hello NIO\n");
```

### Copying files
```java
Files.copy(Paths.get("source.txt"), Paths.get("copy.txt"));
```

### Moving files
```java
Files.move(Paths.get("old.txt"), Paths.get("new.txt"));
```

### Deleting files
```java
Files.deleteIfExists(Paths.get("old.txt"));
```

### Temporary files
```java
Path temp = Files.createTempFile("demo", ".txt");
System.out.println(temp);
```

### Walking directory trees
```java
try (java.util.stream.Stream<Path> paths = Files.walk(Paths.get("."))) {
    paths.filter(Files::isRegularFile)
         .forEach(System.out::println);
}
```

### Why NIO is important
NIO is modern, cleaner, and provides better support for working with files and directories.

---

## 9. File Attributes

File attributes describe the properties of a file.

### Examples of attributes
- permissions
- owner
- size
- last modified time
- hidden status
- readability/writability/executability

### Using NIO attributes
```java
import java.nio.file.*;
import java.nio.file.attribute.*;

public class AttributeDemo {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("sample.txt");
        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println(attrs.size());
        System.out.println(attrs.lastModifiedTime());
    }
}
```

### Why attributes matter
Attributes help us inspect files before processing them, for example to ensure a file is readable or recently modified.

---

## 10. Random Access

Random access allows you to read and write at any position in a file rather than only from start to end.

### `RandomAccessFile`
```java
import java.io.RandomAccessFile;

public class RandomAccessDemo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("data.bin", "rw");
        file.writeInt(100);
        file.seek(0);
        System.out.println(file.readInt());
        file.close();
    }
}
```

### Key idea
`seek()` moves the pointer to a specific position.

### When to use it
- database-like record access
- updating one part of a file
- large binary data files

---

## 11. Exception Handling with Files

File operations often fail because of missing files, permission issues, disk problems, or invalid paths.

### Common exceptions
- `IOException`
- `FileNotFoundException`
- `EOFException`

### Example
```java
import java.io.*;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("missing.txt");
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Input/Output error");
        }
    }
}
```

### `try-catch-finally`
```java
FileReader reader = null;
try {
    reader = new FileReader("data.txt");
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### `try-with-resources`
This is the best modern approach because resources are closed automatically.

```java
try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## 12. Advanced I/O

### `DataInputStream` and `DataOutputStream`
These classes read and write primitive data types in a machine-readable format.

```java
import java.io.*;

public class DataStreamDemo {
    public static void main(String[] args) throws Exception {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("data.bin"));
        out.writeInt(42);
        out.writeDouble(3.14);
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream("data.bin"));
        System.out.println(in.readInt());
        System.out.println(in.readDouble());
        in.close();
    }
}
```

### `SequenceInputStream`
Combines multiple input streams into one.

### `ByteArrayInputStream` and `ByteArrayOutputStream`
These work with data stored in memory as byte arrays.

### `InputStreamReader` and `OutputStreamWriter`
These convert between bytes and characters using a chosen charset.

---

## 13. Compression

Compression reduces the size of files and is commonly used for ZIP and GZIP formats.

### ZIP files
```java
import java.util.zip.*;
import java.io.*;

public class ZipDemo {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("archive.zip");
        ZipOutputStream zos = new ZipOutputStream(fos);

        ZipEntry entry = new ZipEntry("hello.txt");
        zos.putNextEntry(entry);
        zos.write("Hello ZIP".getBytes());
        zos.closeEntry();
        zos.close();
    }
}
```

### GZIP streams
```java
import java.io.*;
import java.util.zip.GZIPOutputStream;

public class GzipDemo {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("file.gz");
        GZIPOutputStream gos = new GZIPOutputStream(fos);
        gos.write("Compressed data".getBytes());
        gos.close();
    }
}
```

---

## 14. File Traversal

File traversal means visiting files and folders recursively.

### Recursive directory traversal
```java
import java.io.File;

public class TraverseDemo {
    public static void main(String[] args) {
        listFiles(new File("."));
    }

    static void listFiles(File folder) {
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            System.out.println(file.getAbsolutePath());
            if (file.isDirectory()) {
                listFiles(file);
            }
        }
    }
}
```

### File filters
You can filter files by extension or pattern.

### Filename filters
```java
File[] javaFiles = new File(".").listFiles((dir, name) -> name.endsWith(".java"));
for (File f : javaFiles) {
    System.out.println(f.getName());
}
```

---

## 15. Best Practices in File Handling

### 1. Always close resources
Use `try-with-resources` to avoid resource leaks.

### 2. Use buffering for performance
Buffered streams are much faster for large files.

### 3. Choose the correct stream type
- use byte streams for binary data
- use character streams for text data

### 4. Handle exceptions carefully
Files may not exist, may be locked, or may have permission issues.

### 5. Use encoding explicitly
When working with text files, specify encoding such as `UTF-8`.

### 6. Be careful with large files
Read and write in chunks rather than loading everything into memory.

### 7. Think about security
Do not trust user-supplied file paths blindly. Validate input and restrict access where necessary.

### 8. Prefer NIO for modern Java code
It is cleaner and more powerful than older `File`-based APIs in many situations.

---

## Quick Summary

If you remember just a few ideas, remember these:
- Files store data permanently.
- `File` manages paths and metadata.
- Byte streams are for binary data.
- Character streams are for text data.
- Buffering improves speed.
- `Scanner` is great for parsing input, while `BufferedReader` is great for efficient reading.
- NIO is the modern file API.
- Always handle exceptions and close resources properly.

---

## Final Advice for Learning

Do not try to memorize everything at once. Learn in this order:
1. `File` class
2. `FileReader` / `FileWriter`
3. `BufferedReader` / `BufferedWriter`
4. `InputStream` / `OutputStream`
5. NIO (`Path`, `Files`)
6. Exceptions and resource management
7. Serialization and compression

The best way to master file handling is to practice with small programs:
- create a file
- write text into it
- read it back
- copy it
- delete it
- traverse folders
- read a binary file

When you understand these basics, file handling becomes one of the easiest and most useful skills in Java.

---

## Additional Study Resources

You can use these companion files for deeper practice and review:

- [fileHandling_study_note.md](fileHandling_study_note.md) — polished study notes with headings and diagrams
- [fileHandling_classroom_notes.md](fileHandling_classroom_notes.md) — classroom-style notes for revision
- [fileHandling_practice_sheet.md](fileHandling_practice_sheet.md) — interview questions and coding exercises
