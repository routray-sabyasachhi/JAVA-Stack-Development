
# What Role Does HTML Play on the Web?

## Introduction

HTML stands for **HyperText Markup Language**. It is the standard markup language used to create and structure content on web pages. Whenever you visit a website and see headings, paragraphs, links, images, forms, videos, or other content, HTML is responsible for defining that structure.

HTML serves as the foundation of every webpage. It tells the browser what content exists and how that content should be organized.

---

## Basic HTML Example

```html
<h1>Main Heading Element</h1>

<p>I am a paragraph element.</p>
```

In this example:

* `<h1>` represents a main heading.
* `<p>` represents a paragraph.

The browser reads these elements and displays them accordingly.

---

## HTML Elements

HTML uses **elements** to represent content.

Most HTML elements consist of:

1. Opening tag
2. Content
3. Closing tag

Example:

```html
<p>I am a paragraph element.</p>
```

Here:

* `<p>` is the opening tag.
* `I am a paragraph element.` is the content.
* `</p>` is the closing tag.

---

## Opening and Closing Tags

HTML tags are enclosed within angle brackets (`< >`).

Example:

```html
<p>
</p>
```

The forward slash (`/`) inside the closing tag distinguishes it from the opening tag.

While HTML tags are case-insensitive, modern development follows the convention of writing tags in lowercase.

Recommended:

```html
<p>Paragraph</p>
```

Avoid:

```html
<P>Paragraph</P>
```

---

## Void Elements

Some HTML elements do not require closing tags.

These are called **void elements**.

Example:

```html
<img>
```

Void elements:

* Cannot contain content.
* Only have a start tag.

Another common format is:

```html
<img />
```

Although both forms work, the slash before `>` is optional in HTML.

---

## HTML Attributes

Attributes provide additional information about HTML elements.

Example:

```html
<img src="image.jpg">
```

Here:

* `src` is an attribute.
* It specifies the image location.

Attributes are written inside the opening tag.

General syntax:

```html
<tag attribute="value">
```

---

## Image Example

```html
<img src="https://cdn.freecodecamp.org/curriculum/cat-photo-app/cats.jpg">
```

The browser loads and displays the image from the specified URL.

---

## The Alt Attribute

Images should include an `alt` attribute.

Example:

```html
<img
  src="https://cdn.freecodecamp.org/curriculum/cat-photo-app/cats.jpg"
  alt="Two tabby kittens sleeping together on a couch."
>
```

### Purpose of Alt Text

* Improves accessibility.
* Helps screen readers describe images.
* Displays descriptive text if the image fails to load.
* Improves SEO.

If the image URL is broken, the browser displays the alt text instead.

---

## Is HTML Alone Enough?

For simple practice projects, HTML alone may be sufficient.

Example:

* Personal profile page
* Basic information page
* Simple documentation page

However, modern professional websites require more technologies.

---

## Relationship Between HTML, CSS, and JavaScript

### HTML

Responsible for:

* Content
* Structure
* Semantic meaning

Examples:

* Headings
* Paragraphs
* Images
* Forms
* Tables

### CSS

Responsible for:

* Styling
* Layout
* Colors
* Animations
* Responsive design

### JavaScript

Responsible for:

* Interactivity
* Dynamic updates
* User actions
* API communication
* Application logic

---

## Building Analogy

Think of a website as a building:

### HTML = Structure

* Bricks
* Concrete
* Walls
* Foundation

HTML provides the framework and organization.

### CSS = Design

* Paint
* Furniture
* Decoration
* Interior and exterior appearance

CSS makes the website visually appealing.

### JavaScript = Functionality

* Electricity
* Water system
* Elevators
* Smart devices

JavaScript makes the website interactive and functional.

---

## Summary

HTML is the backbone of the web.

It:

* Defines webpage structure.
* Organizes content.
* Uses elements and attributes.
* Supports images, links, forms, and media.
* Works together with CSS and JavaScript to create modern websites.

Without HTML, browsers would have no structured content to display. It is the first technology every web developer should learn and serves as the foundation for frontend and full-stack development.


# What Are Attributes, and How Do They Work?

## Introduction

HTML attributes provide additional information about HTML elements and control how those elements behave.

Attributes are placed inside the opening tag of an HTML element and usually consist of:

* Attribute name
* Equal sign (`=`)
* Attribute value enclosed in quotes (`""`)

General syntax:

```html
<element attribute="value"></element>
```

Attributes help customize elements, provide resources, improve accessibility, and define behavior.

---

# Basic Attribute Syntax

Example:

```html
<a href="https://www.freecodecamp.org">
  Visit freeCodeCamp
</a>
```

Here:

* `href` is the attribute name.
* `"https://www.freecodecamp.org"` is the attribute value.

The attribute tells the browser where the link should navigate.

---

# The href Attribute

The `href` attribute is commonly used with anchor (`a`) elements.

Example:

```html
<a href="https://www.freecodecamp.org">
  Visit freeCodeCamp
</a>
```

### Purpose

* Specifies the destination URL.
* Creates a functional hyperlink.

Without the `href` attribute:

```html
<a>Visit freeCodeCamp</a>
```

The text would appear, but clicking it would not navigate anywhere.

---

# The target Attribute

The `target` attribute controls where a linked page opens.

Example:

```html
<a href="https://www.freecodecamp.org" target="_blank">
  Visit freeCodeCamp
</a>
```

### Common Values

| Value     | Description                    |
| --------- | ------------------------------ |
| `_self`   | Opens in current tab (default) |
| `_blank`  | Opens in new tab               |
| `_parent` | Opens in parent frame          |
| `_top`    | Opens in full browser window   |

Most developers commonly use:

```html
target="_blank"
```

to open external links in a new tab.

---

# The src Attribute

The `src` attribute specifies the source of external resources such as images.

Example:

```html
<img src="https://cdn.freecodecamp.org/curriculum/cat-photo-app/cats.jpg">
```

### Purpose

* Tells the browser where the image is located.
* Required for displaying images.

Without `src`, the browser has no image to display.

---

# The alt Attribute

The `alt` (alternative text) attribute provides a text description of an image.

Example:

```html
<img
  src="https://cdn.freecodecamp.org/curriculum/cat-photo-app/cats.jpg"
  alt="Two tabby kittens sleeping together on a couch."
>
```

### Why Alt Text Is Important

* Improves accessibility.
* Helps screen readers describe images.
* Displays text if an image fails to load.
* Improves SEO.

Example of a broken image:

```html
<img
  src="invalid-image.jpg"
  alt="Two cats running in the dirt."
>
```

If the image cannot load, the alt text is displayed instead.

---

# Required vs Optional Attributes

Some attributes are essential for functionality.

### Required Example

```html
<img src="image.jpg">
```

The `src` attribute is necessary because it tells the browser which image to display.

### Optional Example

```html
<img src="image.jpg" alt="Description">
```

The image still works without `alt`, but including it is considered best practice.

---

# Boolean Attributes

Some HTML attributes do not require a value.

These are called **boolean attributes**.

Example:

```html
<input type="checkbox" checked>
```

If the attribute exists, it is considered true.

If it does not exist, it is considered false.

---

# The checked Attribute

The `checked` attribute is used with checkboxes and radio buttons.

Example:

```html
<input type="checkbox" checked>
```

Result:

* Checkbox is selected by default.

Without the attribute:

```html
<input type="checkbox">
```

Result:

* Checkbox starts unchecked.

---

# The disabled Attribute

The `disabled` attribute prevents user interaction.

Example:

```html
<input type="text" disabled>
```

Result:

* User cannot type into the field.
* Input appears disabled.

Without the attribute:

```html
<input type="text">
```

Result:

* User can enter data normally.

---

# Other Common Boolean Attributes

### Required

Makes a form field mandatory.

```html
<input type="email" required>
```

The form cannot be submitted until the field is completed.

---

### Readonly

Allows viewing but prevents editing.

```html
<input type="text" value="Admin" readonly>
```

Users can see the value but cannot modify it.

---

### Disabled

Completely disables interaction.

```html
<input type="text" disabled>
```

Users cannot click, edit, or focus on the element.

---

# Multiple Attributes

An element can contain multiple attributes.

Example:

```html
<a
  href="https://www.freecodecamp.org"
  target="_blank"
>
  Visit freeCodeCamp
</a>
```

Another example:

```html
<img
  src="cat.jpg"
  alt="Sleeping cat"
  width="300"
>
```

Attributes work together to customize the element.

---

# Why Attributes Matter

Attributes are essential because they:

* Control element behavior.
* Provide additional information.
* Improve accessibility.
* Connect resources such as images and links.
* Enhance user experience.
* Enable forms and interactive features.

Without attributes, HTML elements would be far less useful and flexible.

---

# Summary

HTML attributes provide extra information and behavior for elements.

Key attributes learned:

| Attribute  | Purpose                    |
| ---------- | -------------------------- |
| `href`     | Link destination           |
| `target`   | Controls where link opens  |
| `src`      | Specifies image source     |
| `alt`      | Describes image content    |
| `checked`  | Marks checkbox as selected |
| `disabled` | Prevents interaction       |
| `required` | Makes form field mandatory |
| `readonly` | Prevents editing           |

Understanding attributes is a fundamental HTML skill because they allow developers to create interactive, accessible, and functional web pages.
