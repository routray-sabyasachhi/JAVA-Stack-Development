# Basic Git Commands

This file covers basic **Git commands** used for version control.

## What is Git

Git is a **version control system**.  
It helps us track changes in code, save project history, and work with teams.

Example:

```cmd
git --version
git config --global user.name "Sabya"
git config --global user.email "sabya@example.com"
```

## Check Git Installation

### `git --version`
Shows the installed Git version.

```cmd
git --version
```

## Configure Git

### `git config --global user.name`
Sets your Git username.

```cmd
git config --global user.name "Sabya"
```

### `git config --global user.email`
Sets your Git email.

```cmd
git config --global user.email "sabya@example.com"
```

### `git config --list`
Shows current Git configuration.

```cmd
git config --list
```

## Create or Open a Repository

### `git init`
Creates a new Git repository in the current folder.

```cmd
git init
```

### `git clone`
Downloads an existing repository from GitHub or another remote source.

```cmd
git clone https://github.com/user/project.git
```

## Check Repository Status

### `git status`
Shows changed, staged, and untracked files.

```cmd
git status
```

### `git status -s`
Shows a short status output.

```cmd
git status -s
```

## Add Files

### `git add file-name`
Stages one file.

```cmd
git add index.html
```

### `git add .`
Stages all changed files in the current folder.

```cmd
git add .
```

## Save Changes

### `git commit -m`
Saves staged changes with a message.

```cmd
git commit -m "Add login page"
```

### `git commit -am`
Stages and commits tracked files in one command.

```cmd
git commit -am "Update styles"
```

## View History

### `git log`
Shows commit history.

```cmd
git log
```

### `git log --oneline`
Shows a short one-line history.

```cmd
git log --oneline
```

### `git show`
Shows details of a commit.

```cmd
git show
git show <commit-id>
```

### `git diff`
Shows unstaged changes.

```cmd
git diff
```

### `git diff --staged`
Shows staged changes.

```cmd
git diff --staged
```

## Branch Commands

### `git branch`
Lists all local branches.

```cmd
git branch
```

### `git branch branch-name`
Creates a new branch.

```cmd
git branch feature-login
```

### `git checkout branch-name`
Switches to another branch.

```cmd
git checkout feature-login
```

### `git checkout -b branch-name`
Creates and switches to a new branch.

```cmd
git checkout -b feature-navbar
```

### `git switch`
Modern command to switch branches.

```cmd
git switch main
git switch -c feature-api
```

### `git branch -d branch-name`
Deletes a branch.

```cmd
git branch -d feature-navbar
```

## Merge Commands

### `git merge branch-name`
Merges another branch into the current branch.

```cmd
git merge feature-login
```

## Remote Repository Commands

### `git remote -v`
Shows connected remote repositories.

```cmd
git remote -v
```

### `git remote add origin`
Connects the local repository to a remote repository.

```cmd
git remote add origin https://github.com/user/project.git
```

### `git push`
Uploads commits to the remote repository.

```cmd
git push origin main
```

### `git push -u origin main`
Pushes code and sets upstream branch.

```cmd
git push -u origin main
```

### `git pull`
Downloads and merges latest changes from remote.

```cmd
git pull origin main
```

### `git fetch`
Downloads changes from remote without merging.

```cmd
git fetch
```

## Undo and Restore Commands

### `git restore file-name`
Restores file changes in the working directory.

```cmd
git restore app.js
```

### `git restore --staged file-name`
Unstages a file.

```cmd
git restore --staged app.js
```

### `git reset`
Unstages all staged files.

```cmd
git reset
```

### `git reset --hard`
Removes changes and resets files completely.

```cmd
git reset --hard
```

### `git revert`
Creates a new commit that reverses an older commit.

```cmd
git revert <commit-id>
```

## Stash Commands

### `git stash`
Temporarily saves uncommitted changes.

```cmd
git stash
```

### `git stash list`
Shows saved stashes.

```cmd
git stash list
```

### `git stash pop`
Restores the latest stash and removes it from the stash list.

```cmd
git stash pop
```

## Remove Files from Git

### `git rm`
Removes a file from Git and the working directory.

```cmd
git rm oldfile.txt
```

### `git rm --cached`
Removes a file from Git tracking but keeps it in the folder.

```cmd
git rm --cached secret.txt
```

## Tag Commands

### `git tag`
Shows all tags.

```cmd
git tag
```

### `git tag tag-name`
Creates a tag.

```cmd
git tag v1.0
```

### `git push origin tag-name`
Pushes a tag to remote.

```cmd
git push origin v1.0
```

## Help Commands

### `git help`
Shows Git help.

```cmd
git help
```

### `git command --help`
Shows help for a specific Git command.

```cmd
git status --help
git commit --help
git branch --help
```

## Common Examples

### Create a new repository

```cmd
mkdir myproject
cd myproject
git init
```

### Add and commit files

```cmd
git add .
git commit -m "Initial commit"
```

### Connect to GitHub and push

```cmd
git remote add origin https://github.com/user/project.git
git branch -M main
git push -u origin main
```

### Create and switch to a new branch

```cmd
git checkout -b feature-contact-form
```

### Pull latest changes

```cmd
git pull origin main
```

## Important Notes

- `git add` stages changes, but it does not save them permanently until you run `git commit`.
- `git push` sends your local commits to the remote repository.
- Be careful with `git reset --hard`, `git rm`, and `git restore` because they can remove changes.
- Use `git status` often to understand what is happening in your repository.
- Use `git command --help` whenever you want to learn more about a command.
