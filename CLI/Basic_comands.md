# Basic CLI Commands

This file covers basic Command Line Interface commands for **Windows Command Prompt (`cmd`)**.

## What is CLI

CLI stands for **Command Line Interface**.  
It lets us interact with the computer by typing commands instead of clicking with a mouse.

Example:

```cmd
C:\Users\sabya>whoami
desktop-name\sabya
```

## Tab Auto Completion

Use the `Tab` key to auto-complete file and folder names.

Example:

```cmd
C:\Users\sabya>D[Tab]
C:\Users\sabya>Desktop

C:\Users\sabya>cd Des[Tab]
C:\Users\sabya>cd Desktop
```

## Basic Navigation Commands

### `cd`
Changes the current directory.

```cmd
cd Desktop
cd ..
cd \
```

### `dir`
Shows files and folders in the current directory.

```cmd
dir
dir /w
dir /p
```

### `cls`
Clears the screen.

```cmd
cls
```

### `pwd`
`pwd` is common in Linux/PowerShell, but in `cmd` we usually use:

```cmd
cd
```

This prints the current directory path.

## File and Folder Commands

### `mkdir` or `md`
Creates a new folder.

```cmd
mkdir projects
md notes
```

### `rmdir` or `rd`
Removes an empty folder.

```cmd
rmdir test
```

Remove a folder and all its contents:

```cmd
rmdir /s /q test
```

### `type`
Displays the contents of a text file.

```cmd
type notes.txt
```

### `copy`
Copies files.

```cmd
copy file1.txt file2.txt
copy notes.txt D:\Backup\
```

### `xcopy`
Copies files and folders.

```cmd
xcopy source destination /e /i
```

### `robocopy`
Advanced copy command for folders.

```cmd
robocopy source destination /e
```

### `move`
Moves a file or folder.

```cmd
move file.txt Documents\
```

### `ren`
Renames a file or folder.

```cmd
ren oldname.txt newname.txt
```

### `del` or `erase`
Deletes files.

```cmd
del notes.txt
del *.tmp
```

## File Creation Commands

### `echo`
Prints text to the terminal or writes text to a file.

```cmd
echo Hello
echo Hello > file.txt
echo Second line >> file.txt
```

### `copy con`
Creates a file from keyboard input.

```cmd
copy con notes.txt
```

Then type your text and press `Ctrl + Z`, then `Enter`.

## Viewing and Searching

### `more`
Displays output one screen at a time.

```cmd
type largefile.txt | more
```

### `find`
Searches for text in a file.

```cmd
find "hello" notes.txt
```

### `findstr`
Searches text in files with more options.

```cmd
findstr "error" log.txt
findstr /s /i "react" *.txt
```

## System Information Commands

### `whoami`
Shows the current logged-in user.

```cmd
whoami
```

### `hostname`
Shows the computer name.

```cmd
hostname
```

### `ver`
Shows the Windows version.

```cmd
ver
```

### `systeminfo`
Shows full system information.

```cmd
systeminfo
```

### `tasklist`
Shows running processes.

```cmd
tasklist
```

### `taskkill`
Stops a running process.

```cmd
taskkill /im notepad.exe /f
```

## Network Commands

### `ipconfig`
Shows network configuration.

```cmd
ipconfig
ipconfig /all
```

### `ping`
Tests network connectivity.

```cmd
ping google.com
```

### `tracert`
Shows the route packets take to a host.

```cmd
tracert google.com
```

### `nslookup`
Finds DNS information.

```cmd
nslookup google.com
```

## Disk and Drive Commands

### `diskpart`
Disk management tool.

```cmd
diskpart
```

### `chkdsk`
Checks a disk for errors.

```cmd
chkdsk
```

### `tree`
Shows folders in tree format.

```cmd
tree
tree /f
```

## Help Commands

### `help`
Lists many available commands.

```cmd
help
```

### `command /?`
Shows help for a specific command.

```cmd
dir /?
copy /?
ipconfig /?
```

## Useful Shortcuts

### `Tab`
Auto-completes file and folder names.

### `Up Arrow`
Shows the previous command.

### `Down Arrow`
Shows the next command in history.

### `Ctrl + C`
Stops a running command.

### `cls`
Clears the screen.

## Common Examples

### Open a folder

```cmd
cd Desktop
dir
```

### Create a folder and file

```cmd
mkdir demo
cd demo
echo Hello World > hello.txt
type hello.txt
```

### Copy and rename a file

```cmd
copy hello.txt hello-copy.txt
ren hello-copy.txt welcome.txt
```

### Delete a file

```cmd
del welcome.txt
```

## Important Notes

- `cmd` commands are not always the same as Linux commands.
- Be careful with `del`, `rmdir /s`, and `taskkill` because they can remove files or stop programs.
- Use `command /?` whenever you want to learn more about a command.
