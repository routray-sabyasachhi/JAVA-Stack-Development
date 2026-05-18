# HTML Basics Notes

This file contains beginner-friendly notes on important HTML basics.

Topics covered:

- Elements and Tags
- HTML Boilerplate
- Working With Text
- Lists
- Links and Messages
- Commit Messages
- Conclusion

## 1. Elements and Tags

HTML is made of **elements**.

An HTML element usually has:

- an opening tag
- content
- a closing tag

Example:

```html
<p>This is a paragraph.</p>
```

Here:

- `<p>` is the opening tag
- `This is a paragraph.` is the content
- `</p>` is the closing tag

### What is a Tag?

A tag is the part written inside angle brackets.

Examples:

```html
<h1>
</h1>
<div>
</div>
```

### What is an Element?

An element is the complete structure:

```html
<h1>Hello</h1>
```

This full line is an element.

### Types of Elements

#### 1. Container elements

These have opening and closing tags.

Example:

```html
<p>Hello World</p>
```

#### 2. Empty or void elements

These do not have closing tags.

Examples:

```html
<br>
<hr>
<img src="photo.jpg" alt="Photo">
<input type="text">
```

### Nested Elements

HTML elements can be placed inside other elements. This is called **nesting**.

Example:

```html
<p>This is <strong>important</strong> text.</p>
```

Here:

- `<strong>` is nested inside `<p>`

### Parent and Child Elements

Example:

```html
<div>
  <p>Hello</p>
</div>
```

Here:

- `<div>` is the parent element
- `<p>` is the child element

### Attributes in Tags

Tags can contain attributes that provide extra information.

Example:

```html
<a href="https://example.com">Visit</a>
```

Here:

- `<a>` is the tag
- `href` is the attribute
- `"https://example.com"` is the value

### Common HTML Tags

```html
<h1>Heading</h1>
<p>Paragraph</p>
<a href="#">Link</a>
<img src="image.jpg" alt="Image">
<ul><li>Item</li></ul>
<div>Block</div>
<span>Inline</span>
```

### Block and Inline Elements

#### Block elements

These usually start on a new line and take full width.

Examples:

- `<div>`
- `<p>`
- `<h1>` to `<h6>`
- `<ul>`
- `<ol>`
- `<li>`

#### Inline elements

These usually stay in the same line.

Examples:

- `<span>`
- `<a>`
- `<strong>`
- `<em>`

### Important Notes

- Tags are the building blocks of HTML.
- Elements define the structure of content.
- Some elements have content, and some are empty.
- Elements can be nested inside other elements.

## 2. HTML Boilerplate

HTML boilerplate is the **basic structure** of an HTML document.

Every proper HTML page usually starts with this:

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>My Web Page</title>
</head>
<body>
  <h1>Hello World</h1>
</body>
</html>
```

### Explanation of Boilerplate

#### `<!DOCTYPE html>`

Tells the browser that this document is an HTML5 document.

#### `<html>`

This is the root element of the whole page.

Example:

```html
<html lang="en">
```

The `lang="en"` attribute tells the browser that the page language is English.

#### `<head>`

Contains important information about the page, but this content is not directly shown on the page.

Inside `<head>` we commonly add:

- page title
- meta tags
- CSS links
- script links

#### `<meta charset="UTF-8">`

Defines character encoding so the browser can correctly display text.

#### `<meta name="viewport" content="width=device-width, initial-scale=1.0">`

Makes the page responsive on mobile devices.

#### `<title>`

Sets the page title shown in the browser tab.

Example:

```html
<title>HTML Basics</title>
```

#### `<body>`

Contains all the visible content of the web page.

Examples of body content:

- headings
- paragraphs
- images
- links
- lists
- forms

### Why Boilerplate is Important

- It gives proper structure to the page.
- It helps browsers understand the document correctly.
- It ensures the page is ready for styling and scripting.
- It is the starting point for almost every HTML page.

## 3. Working With Text

HTML provides different tags to display text in meaningful ways.

### Headings

HTML has six heading levels:

```html
<h1>Main Heading</h1>
<h2>Sub Heading</h2>
<h3>Smaller Heading</h3>
<h4>Heading 4</h4>
<h5>Heading 5</h5>
<h6>Heading 6</h6>
```

Notes:

- `<h1>` is the most important heading
- `<h6>` is the least important heading

### Paragraph

Use the `<p>` tag for paragraphs.

```html
<p>This is a paragraph.</p>
```

### Bold Text

```html
<b>Bold text</b>
<strong>Important text</strong>
```

Notes:

- `<b>` makes text bold
- `<strong>` gives strong importance

### Italic Text

```html
<i>Italic text</i>
<em>Emphasized text</em>
```

Notes:

- `<i>` changes the appearance
- `<em>` adds emphasis

### Underline

```html
<u>Underlined text</u>
```

### Line Break

Use `<br>` to break a line.

```html
<p>Hello<br>World</p>
```

### Horizontal Line

Use `<hr>` to create a horizontal line.

```html
<hr>
```

### Small Text

```html
<small>Small text</small>
```

### Marked Text

```html
<mark>Highlighted text</mark>
```

### Deleted and Inserted Text

```html
<del>Old text</del>
<ins>New text</ins>
```

### Superscript and Subscript

```html
<p>x<sup>2</sup></p>
<p>H<sub>2</sub>O</p>
```

### Preformatted Text

Use `<pre>` when spacing and line breaks should stay exactly as typed.

```html
<pre>
Line 1
Line 2
Line 3
</pre>
```

### Code Text

Use `<code>` for code snippets.

```html
<code>console.log("Hello");</code>
```

### Quotes

#### Short quote

```html
<q>This is a short quote.</q>
```

#### Block quote

```html
<blockquote>
  This is a long quotation.
</blockquote>
```

## 4. Lists

Lists are used to group related items.

There are mainly three types of lists in HTML:

- unordered list
- ordered list
- description list

### Unordered List

An unordered list uses bullets.

```html
<ul>
  <li>HTML</li>
  <li>CSS</li>
  <li>JavaScript</li>
</ul>
```

Here:

- `<ul>` means unordered list
- `<li>` means list item

### Ordered List

An ordered list uses numbers.

```html
<ol>
  <li>Open editor</li>
  <li>Write code</li>
  <li>Save file</li>
</ol>
```

### Description List

Used for terms and their descriptions.

```html
<dl>
  <dt>HTML</dt>
  <dd>HyperText Markup Language</dd>
</dl>
```

Here:

- `<dl>` is description list
- `<dt>` is description term
- `<dd>` is description detail

### Nested Lists

Lists can be placed inside other lists.

```html
<ul>
  <li>Frontend
    <ul>
      <li>HTML</li>
      <li>CSS</li>
    </ul>
  </li>
</ul>
```

### Why Lists are Useful

- They organize information clearly.
- They improve readability.
- They are useful for menus, steps, notes, and grouped items.

## 5. Links and Messages

Links connect one page to another page, website, file, section, email, or phone action.

Messages are the text or information shown to the user using HTML elements such as headings, paragraphs, notes, warnings, or status text.

### Creating a Link

Use the `<a>` tag to create a link.

```html
<a href="https://example.com">Visit Example</a>
```

Here:

- `<a>` is the anchor tag
- `href` tells where the link goes

### Open Link in a New Tab

```html
<a href="https://example.com" target="_blank">Open Site</a>
```

### Link to Another Page

```html
<a href="about.html">About Page</a>
```

### Link to a Section in the Same Page

```html
<a href="#contact">Go to Contact</a>

<h2 id="contact">Contact Section</h2>
```

### Email Link

```html
<a href="mailto:someone@example.com">Send Email</a>
```

### Phone Link

```html
<a href="tel:+919999999999">Call Now</a>
```

### Download Link

```html
<a href="notes.pdf" download>Download Notes</a>
```

### Message Text in HTML

Messages can be shown using simple text elements.

Example:

```html
<p>Welcome to the website.</p>
<p>Your form has been submitted successfully.</p>
<p>Please enter a valid email address.</p>
```

### Highlighting Important Messages

```html
<p><strong>Success:</strong> Your account was created.</p>
<p><strong>Warning:</strong> Password is too short.</p>
<p><strong>Note:</strong> All fields are required.</p>
```

### Message Areas Using Containers

```html
<div class="message">Welcome back!</div>
<div class="error">Something went wrong.</div>
<div class="success">Saved successfully.</div>
```

### Why Links and Messages Matter

- Links help users move from one place to another.
- Messages help users understand what is happening.
- Both improve user experience.

## 6. Commit Messages

Commit messages are not HTML tags, but they are very important when working on HTML projects with Git.

A **commit message** explains what changes you saved in your project.

Example:

```cmd
git commit -m "Add basic HTML boilerplate"
```

### Why Commit Messages Matter

- They help track project history.
- They make teamwork easier.
- They tell what was changed in each step.

### Good Commit Message Examples

```cmd
git commit -m "Add HTML boilerplate"
git commit -m "Add headings and paragraph examples"
git commit -m "Create lists section in HTML notes"
git commit -m "Add links and message examples"
git commit -m "Fix typo in HTML basics notes"
```

### Tips for Writing Good Commit Messages

- Keep the message short and clear.
- Describe what changed.
- Use action words like `Add`, `Fix`, `Update`, `Remove`, `Create`.

### Bad Commit Message Examples

```cmd
git commit -m "work"
git commit -m "done"
git commit -m "changes"
```

These messages are not clear.

## 7. Conclusion

HTML is the foundation of web development.

From these basics we learned:

- elements and tags build the structure of a webpage
- boilerplate creates the starting structure of an HTML document
- text tags help display content clearly
- lists organize related items
- links connect pages and messages communicate with users
- commit messages help track project changes while building HTML files

If you understand these basics well, it becomes much easier to learn the next parts of web development like:

- attributes
- images
- tables
- forms
- semantic tags
- CSS
- JavaScript

## Final Summary

- HTML uses elements and tags to create web pages.
- Boilerplate is the standard starting structure of HTML.
- Text tags help organize and format content.
- Lists help arrange information in an easy way.
- Links connect resources, and messages guide users.
- Commit messages help manage project progress properly.

These are the core basics every beginner should understand before moving to advanced HTML topics.
