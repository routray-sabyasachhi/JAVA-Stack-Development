# What Role Does HTML Play on the Web?

HTML stands for **HyperText Markup Language**.  
It is the **basic structure** of every web page.

HTML tells the browser:

- what content is on the page
- which part is a heading
- which part is a paragraph
- which part is an image
- which part is a link
- which part is a form, button, list, table, or section

In simple words, HTML is the **skeleton of a website**.

## Role of HTML on the Web

HTML plays a very important role on the web because it gives **meaning and structure** to content.

### 1. It structures web content

HTML organizes the content of a webpage.

Example:

```html
<h1>Welcome to My Website</h1>
<p>This is my first webpage.</p>
```

Here:

- `<h1>` defines a main heading
- `<p>` defines a paragraph

### 2. It works with CSS and JavaScript

HTML is usually used together with:

- **CSS** to style the page
- **JavaScript** to make the page interactive

Example:

- HTML creates a button
- CSS changes its color and size
- JavaScript makes it respond when clicked

### 3. It helps browsers display content correctly

Browsers read HTML code and show it as a web page.

For example:

```html
<img src="photo.jpg" alt="A nature photo">
```

The browser understands that it must display an image.

### 4. It gives meaning to content

HTML is not only about showing content. It also tells what the content **means**.

Example:

```html
<h1>Main Title</h1>
<p>This is a paragraph.</p>
<a href="https://example.com">Visit Site</a>
```

This tells the browser and search engines:

- this is a heading
- this is text content
- this is a clickable link

### 5. It supports SEO and accessibility

Good HTML helps:

- search engines understand your page
- screen readers read content for visually impaired users
- developers create clean and meaningful websites

Using correct tags like `<header>`, `<nav>`, `<main>`, `<section>`, and `<footer>` improves structure.

## A Simple Real-World Idea

Think of a webpage like a house:

- **HTML** = structure of the house
- **CSS** = design and decoration
- **JavaScript** = actions and behavior

Without HTML, the browser would not know what content to display.

# What Are Attributes, and How Do They Work?

Attributes give **extra information** about HTML elements.

They are written inside the opening tag.

Example:

```html
<a href="https://google.com">Google</a>
```

Here:

- `<a>` is the anchor tag
- `href` is an attribute
- `"https://google.com"` is the attribute value

The `href` attribute tells the browser where the link should go.

## Syntax of Attributes

Basic syntax:

```html
<tagname attribute="value">Content</tagname>
```

Example:

```html
<img src="cat.jpg" alt="A cute cat">
```

Here:

- `src` tells the image file location
- `alt` gives alternative text for the image

## How Attributes Work

Attributes modify the behavior, appearance, or meaning of an element.

### 1. They provide extra details

Example:

```html
<input type="text" placeholder="Enter your name">
```

Here:

- `type="text"` tells the browser this is a text input
- `placeholder="Enter your name"` shows hint text inside the box

### 2. They can control behavior

Example:

```html
<a href="https://example.com" target="_blank">Open Site</a>
```

Here:

- `href` sets the link address
- `target="_blank"` opens the link in a new tab

### 3. They can identify elements

Example:

```html
<p id="intro" class="text">Hello World</p>
```

Here:

- `id` gives a unique name to the element
- `class` groups elements for styling or JavaScript

## Common HTML Attributes

### `href`
Used in links.

```html
<a href="https://example.com">Visit</a>
```

### `src`
Used in images, scripts, and other files.

```html
<img src="image.jpg" alt="Sample image">
```

### `alt`
Alternative text for images.

```html
<img src="bird.jpg" alt="A flying bird">
```

### `title`
Shows extra information when the mouse is placed over an element.

```html
<p title="This is extra info">Move your mouse here</p>
```

### `id`
Gives a unique identifier.

```html
<div id="header">Welcome</div>
```

### `class`
Groups similar elements together.

```html
<p class="note">Important note</p>
```

### `style`
Adds inline CSS styling.

```html
<h1 style="color: blue;">Hello</h1>
```

### `type`
Defines the type of input or button.

```html
<input type="email">
```

### `placeholder`
Shows hint text inside an input field.

```html
<input type="text" placeholder="Enter username">
```

### `value`
Sets a default value.

```html
<input type="text" value="Sabya">
```

## Boolean Attributes

Some attributes do not need a value in the usual way. These are called **boolean attributes**.

Example:

```html
<input type="checkbox" checked>
<button disabled>Submit</button>
```

Here:

- `checked` means the checkbox is selected
- `disabled` means the button cannot be clicked

## Example with Multiple Attributes

```html
<img src="car.jpg" alt="Red car" width="300" height="200">
```

This element uses multiple attributes:

- `src` for image path
- `alt` for alternative text
- `width` for width
- `height` for height

## Important Notes

- Attributes are always written in the opening tag.
- Most attributes use the format `name="value"`.
- One element can have multiple attributes.
- Attributes give extra information or control behavior.
- Some attributes are specific to certain tags.

## Summary

- HTML gives structure and meaning to web pages.
- It works with CSS and JavaScript to create complete websites.
- Attributes provide extra information about HTML elements.
- Attributes help control links, images, forms, styling, and behavior.

HTML creates the structure, and attributes make that structure more useful and powerful.
