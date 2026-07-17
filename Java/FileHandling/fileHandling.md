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

## 16. Path Handling in Real Projects

In small examples, we often write paths like `"data.txt"`. In real projects, path handling needs more care because the program may run from different folders, operating systems, or deployment environments.

### Current working directory
The current working directory is the folder from which the Java program is started.

```java
public class WorkingDirectoryDemo {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
```

If your file path is relative, Java starts looking from this location.

### Building paths safely
Avoid manually joining path parts with `/` or `\`. Use `Path.resolve()`.

```java
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathResolveDemo {
    public static void main(String[] args) {
        Path project = Paths.get(System.getProperty("user.dir"));
        Path file = project.resolve("data").resolve("students.txt");

        System.out.println(file);
    }
}
```

### Normalizing paths
Normalization removes unnecessary parts such as `.` and `..`.

```java
import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizePathDemo {
    public static void main(String[] args) {
        Path path = Paths.get("data/../reports/./result.txt");
        System.out.println(path.normalize());
    }
}
```

### Comparing `File` and `Path`

| Feature | `java.io.File` | `java.nio.file.Path` |
|---|---|---|
| Introduced | Older Java API | Modern Java API |
| Main use | File path and metadata | File path with powerful operations |
| Works with | `FileReader`, `FileWriter`, streams | `Files`, NIO utilities |
| Recommended for new code | Less preferred | More preferred |

### Teacher's note
For old syllabus questions, learn `File`. For modern Java development, become comfortable with `Path` and `Files`.

If you are using Java 8, replace `Path.of("file.txt")` with `Paths.get("file.txt")` in the examples.

---

## 17. File Open Modes

When writing to a file, Java can either overwrite existing content or append new content.

### Overwrite mode
This replaces old content.

```java
import java.io.FileWriter;
import java.io.IOException;

public class OverwriteDemo {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("notes.txt")) {
            writer.write("This replaces old content.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Append mode
This adds new content at the end.

```java
import java.io.FileWriter;
import java.io.IOException;

public class AppendDemo {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("notes.txt", true)) {
            writer.write("\nThis line is added later.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### NIO open options
With NIO, you can clearly specify how a file should be opened.

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NioOpenOptionDemo {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("log.txt");

        Files.writeString(
            path,
            "Application started\n",
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND
        );
    }
}
```

### Common open options

| Option | Meaning |
|---|---|
| `CREATE` | Create file if it does not exist |
| `CREATE_NEW` | Create file only if it does not already exist |
| `APPEND` | Add content to the end |
| `TRUNCATE_EXISTING` | Clear existing content before writing |
| `READ` | Open file for reading |
| `WRITE` | Open file for writing |

---

## 18. Working with Large Files

Small files can be read fully into memory. Large files should usually be processed line by line or in chunks.

### Avoid this for huge files

```java
String content = Files.readString(Path.of("big-file.txt"));
```

This loads the entire file into memory. It is fine for small files, but risky for very large files.

### Better: read line by line

```java
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class LargeFileReadDemo {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("server.log");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ERROR")) {
                    System.out.println(line);
                }
            }
        }
    }
}
```

### Reading bytes in chunks
Use this style for binary files such as images, videos, or PDFs.

```java
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ChunkReadDemo {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("video.mp4");
        byte[] buffer = new byte[8192];

        try (InputStream input = Files.newInputStream(path)) {
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                System.out.println("Read bytes: " + bytesRead);
            }
        }
    }
}
```

### Practical rule
- Use `readString()` for small text files.
- Use `BufferedReader` for large text files.
- Use byte streams with a buffer for large binary files.

---

## 19. CSV File Handling

CSV means Comma-Separated Values. It is commonly used to store table-like data.

Example file:

```text
id,name,marks
1,Alice,87
2,Bob,75
3,Charlie,91
```

### Simple CSV reading

```java
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvReadDemo {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("students.csv");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int marks = Integer.parseInt(parts[2]);

                System.out.println(id + " " + name + " " + marks);
            }
        }
    }
}
```

### Writing CSV data

```java
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvWriteDemo {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("students.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("id,name,marks");
            writer.newLine();
            writer.write("1,Alice,87");
            writer.newLine();
            writer.write("2,Bob,75");
        }
    }
}
```

### Important warning
Simple `split(",")` works only for basic CSV files. Real CSV data may contain commas inside quotes, such as `"New Delhi, India"`. For professional projects, use a CSV library such as OpenCSV or Apache Commons CSV.

---

## 20. Properties Files

Properties files store key-value pairs and are often used for configuration.

Example:

```properties
app.name=Student Management
app.version=1.0
database.url=jdbc:mysql://localhost:3306/school
```

### Reading a properties file

```java
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReadDemo {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();

        try (FileInputStream input = new FileInputStream("app.properties")) {
            props.load(input);
        }

        System.out.println(props.getProperty("app.name"));
        System.out.println(props.getProperty("database.url"));
    }
}
```

### Writing a properties file

```java
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesWriteDemo {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty("theme", "dark");
        props.setProperty("language", "en");

        try (FileOutputStream output = new FileOutputStream("settings.properties")) {
            props.store(output, "User Settings");
        }
    }
}
```

### Why properties files matter
They allow you to change program settings without changing Java code.

---

## 21. Log File Handling

Logs are files that record what happened inside an application.

### Simple log writer

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class SimpleLoggerDemo {
    public static void main(String[] args) throws Exception {
        Path logFile = Path.of("application.log");
        String message = LocalDateTime.now() + " - Application started\n";

        Files.writeString(
            logFile,
            message,
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND
        );
    }
}
```

### Reading only error lines

```java
import java.nio.file.Files;
import java.nio.file.Path;

public class LogSearchDemo {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("application.log");

        try (var lines = Files.lines(path)) {
            lines.filter(line -> line.contains("ERROR"))
                 .forEach(System.out::println);
        }
    }
}
```

### Real-world note
Professional Java applications usually use logging frameworks such as Logback, Log4j2, or `java.util.logging`. Still, understanding file writing helps you understand how logs are stored.

---

## 22. Temporary Files and Cleanup

Temporary files are useful when you need short-lived storage.

### Creating a temporary file

```java
import java.nio.file.Files;
import java.nio.file.Path;

public class TempFileDemo {
    public static void main(String[] args) throws Exception {
        Path temp = Files.createTempFile("upload-", ".tmp");
        Files.writeString(temp, "Temporary data");

        System.out.println(temp);
    }
}
```

### Creating a temporary directory

```java
Path tempDir = Files.createTempDirectory("work-");
System.out.println(tempDir);
```

### Deleting on JVM exit

```java
import java.io.File;

public class DeleteOnExitDemo {
    public static void main(String[] args) throws Exception {
        File temp = File.createTempFile("demo-", ".txt");
        temp.deleteOnExit();
    }
}
```

### Best practice
Temporary files should be deleted when they are no longer needed. Long-running applications should clean them manually instead of relying only on `deleteOnExit()`.

---

## 23. File Locking

File locking helps prevent multiple programs from writing to the same file at the same time.

```java
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockDemo {
    public static void main(String[] args) throws Exception {
        try (RandomAccessFile file = new RandomAccessFile("shared.txt", "rw");
             FileChannel channel = file.getChannel();
             FileLock lock = channel.lock()) {

            file.writeUTF("Safe write with lock");
        }
    }
}
```

### When locking is useful
- shared files
- report generation
- background jobs
- programs that may run multiple instances

### Important note
File locking behavior can vary by operating system. Use it carefully and test on the target system.

---

## 24. WatchService: Monitoring Folder Changes

`WatchService` allows Java to watch a directory for changes such as file creation, modification, or deletion.

```java
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceDemo {
    public static void main(String[] args) throws Exception {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path folder = Path.of("watched");

        folder.register(
            watchService,
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_MODIFY,
            StandardWatchEventKinds.ENTRY_DELETE
        );

        while (true) {
            WatchKey key = watchService.take();

            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.kind() + " " + event.context());
            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }
}
```

### Real-world uses
- auto-reloading configuration
- detecting uploaded files
- monitoring log folders
- triggering background processing

---

## 25. Walking Files with `FileVisitor`

`Files.walk()` is simple, but `FileVisitor` gives more control.

```java
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorDemo {
    public static void main(String[] args) throws Exception {
        Path start = Path.of(".");

        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (file.toString().endsWith(".java")) {
                    System.out.println(file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.out.println("Cannot access: " + file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
```

### Why use `FileVisitor`
It is useful when you need to handle errors, skip folders, count files, delete directory trees, or process files conditionally.

---

## 26. Safe File Deletion

Deleting files is simple, but deleting safely requires checks.

### Delete one file

```java
import java.nio.file.Files;
import java.nio.file.Path;

public class SafeDeleteDemo {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("old-report.txt");

        if (Files.exists(path) && Files.isRegularFile(path)) {
            Files.delete(path);
            System.out.println("Deleted");
        } else {
            System.out.println("File does not exist");
        }
    }
}
```

### Delete if exists

```java
Files.deleteIfExists(Path.of("old-report.txt"));
```

### Safety checklist before deleting
- Is this path inside the expected folder?
- Is it a file or a directory?
- Does the program have permission?
- Should the file be backed up first?
- Is the path coming from user input?

---

## 27. Security in File Handling

File handling becomes dangerous when users can control file paths.

### Path traversal problem
A malicious user may try to access files outside the allowed folder.

```text
../../secret.txt
```

### Safer path validation

```java
import java.nio.file.Path;

public class SafePathDemo {
    public static void main(String[] args) {
        Path baseDir = Path.of("uploads").toAbsolutePath().normalize();
        String userInput = "../secret.txt";

        Path target = baseDir.resolve(userInput).normalize();

        if (!target.startsWith(baseDir)) {
            throw new IllegalArgumentException("Invalid file path");
        }

        System.out.println("Safe path: " + target);
    }
}
```

### Security rules
- Never directly trust file paths from users.
- Restrict file access to a known base directory.
- Validate file extensions.
- Avoid exposing absolute paths in error messages.
- Be careful when extracting ZIP files.
- Do not deserialize untrusted data.

---

## 28. File Handling with Collections

Many programs read file data into collections, process it, and then write it back.

### Reading names into a list

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ListReadDemo {
    public static void main(String[] args) throws Exception {
        List<String> names = Files.readAllLines(Path.of("names.txt"));

        for (String name : names) {
            System.out.println(name.toUpperCase());
        }
    }
}
```

### Sorting and writing back

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class SortFileDemo {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("names.txt");
        List<String> names = Files.readAllLines(path);

        Collections.sort(names);

        Files.write(path, names);
    }
}
```

### Counting word frequency

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class WordCountDemo {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> frequency = new HashMap<>();

        for (String line : Files.readAllLines(Path.of("story.txt"))) {
            String[] words = line.toLowerCase().split("\\W+");

            for (String word : words) {
                if (!word.isBlank()) {
                    frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        System.out.println(frequency);
    }
}
```

---

## 29. Common Mistakes

### Mistake 1: Forgetting to close resources
This can cause memory leaks or locked files.

Correct approach:

```java
try (BufferedReader reader = Files.newBufferedReader(Path.of("data.txt"))) {
    System.out.println(reader.readLine());
}
```

### Mistake 2: Reading binary files as text
Images, PDFs, videos, and ZIP files should be handled with byte streams.

### Mistake 3: Loading huge files fully into memory
Prefer streaming or buffered reading for large files.

### Mistake 4: Ignoring character encoding
If your file contains non-English text, wrong encoding can corrupt the output.

```java
Files.writeString(Path.of("data.txt"), "Hello", java.nio.charset.StandardCharsets.UTF_8);
```

### Mistake 5: Assuming paths work on every operating system
Use `Path`, `Paths`, and `resolve()` instead of hard-coded separators.

### Mistake 6: Swallowing exceptions
Avoid empty catch blocks.

```java
try {
    Files.delete(Path.of("old.txt"));
} catch (IOException e) {
    System.out.println("Could not delete file: " + e.getMessage());
}
```

---

## 30. Interview and Exam Points

### Important questions
- What is file handling?
- What is the difference between a file and a directory?
- What is the difference between absolute and relative paths?
- What is the difference between byte streams and character streams?
- Why are buffered streams faster?
- What is serialization?
- What is the use of `transient`?
- What is `serialVersionUID`?
- What is the difference between `File` and `Files`?
- Why is `try-with-resources` useful?
- How do you read a large file efficiently?
- How do you append data to a file?
- How do you copy a file in Java?
- How do you prevent path traversal attacks?

### Short answers

| Question | Short answer |
|---|---|
| Best class for modern file operations? | `Files` |
| Best object for representing paths? | `Path` |
| Best stream for binary files? | `FileInputStream` / `FileOutputStream` |
| Best classes for text line reading? | `BufferedReader` or `Files.newBufferedReader()` |
| Best way to close files? | `try-with-resources` |
| Best encoding for most text files? | UTF-8 |

---

## 31. Mini Projects for Practice

### Project 1: Student Marks File
Create a program that:
- writes student names and marks to a CSV file
- reads the CSV file
- calculates average marks
- prints the topper

### Project 2: Notes App
Create a command-line notes app that:
- creates a notes folder
- lets the user add a note
- lists all notes
- opens a selected note
- deletes a selected note

### Project 3: Log Analyzer
Create a program that:
- reads a log file
- counts `INFO`, `WARN`, and `ERROR` lines
- writes a summary report
- prints the most recent error

### Project 4: Folder Cleaner
Create a program that:
- scans a folder
- finds files older than a given number of days
- asks for confirmation
- deletes or moves them to an archive folder

### Project 5: File Backup Tool
Create a program that:
- copies all `.txt` files from one folder to another
- creates the destination folder if needed
- skips files that already exist
- writes a backup log

---

## 32. Recommended Learning Order

If you are studying file handling for the first time, follow this path:

1. Understand files, directories, and paths.
2. Practice `File` class methods.
3. Read and write text using `FileReader` and `FileWriter`.
4. Use `BufferedReader` and `BufferedWriter`.
5. Learn byte streams for binary files.
6. Use `try-with-resources` everywhere.
7. Move to modern NIO: `Path` and `Files`.
8. Practice CSV and properties files.
9. Learn serialization only after basic streams are clear.
10. Study security and large-file handling.

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
- Use explicit encoding such as UTF-8 for text files.
- Do not load huge files fully into memory.
- Validate user-supplied paths before reading, writing, or deleting files.

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

## Extra Practice Checklist

Use this checklist after completing the notes:

- create a folder using Java
- create a text file inside that folder
- write five lines into the file
- read the file line by line
- append one more line
- copy the file to another folder
- rename the copied file
- print file size and last modified time
- read a CSV file into objects
- write application settings into a properties file
- search a log file for error lines
- validate a user-given path before opening it
- delete a file only after checking that it exists
