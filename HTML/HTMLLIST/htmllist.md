# HTML Lists

HTML lists are used to group related items. They make content easier to read and also give the browser, search engines, and screen readers a clear structure.

## Types of Lists

HTML has three main list types:

1. Unordered list: `<ul>`
2. Ordered list: `<ol>`
3. Description list: `<dl>`

## Unordered List

Use an unordered list when the order of items does not matter.

```html
<ul>
    <li>Coffee</li>
    <li>Tea</li>
    <li>Milk</li>
</ul>
```

Default marker: bullet points.

Common uses:

- Menus
- Feature lists
- Shopping items
- Any group where sequence is not important

## Ordered List

Use an ordered list when the order of items matters.

```html
<ol>
    <li>Open the browser</li>
    <li>Search for HTML lists</li>
    <li>Practice examples</li>
</ol>
```

Default marker: numbers.

Common uses:

- Steps
- Rankings
- Instructions
- Recipes

## Description List

Use a description list for terms and their meanings.

```html
<dl>
    <dt>HTML</dt>
    <dd>HyperText Markup Language</dd>

    <dt>CSS</dt>
    <dd>Cascading Style Sheets</dd>
</dl>
```

Tags used:

- `<dl>` creates the description list.
- `<dt>` creates the term or name.
- `<dd>` creates the description or explanation.

## List Item

The `<li>` tag means list item. It is used inside `<ul>` and `<ol>`.

Correct:

```html
<ul>
    <li>Coffee</li>
    <li>Tea</li>
</ul>
```

Incorrect:

```html
<ul>
    <p>Coffee</p>
    <p>Tea</p>
</ul>
```

Inside `<ul>` and `<ol>`, direct children should usually be `<li>` elements.

## Nested Lists

A nested list is a list inside another list item.

```html
<ul>
    <li>
        Drinks
        <ul>
            <li>Coffee</li>
            <li>Tea</li>
        </ul>
    </li>
    <li>
        Snacks
        <ul>
            <li>Biscuits</li>
            <li>Chips</li>
        </ul>
    </li>
</ul>
```

Important rule: place the child list inside an `<li>`, not directly beside an `<li>`.

## Lists with Description Details

You can combine list items and description lists when each item needs more details.

```html
<ul>
    <li>
        <strong>Coffee</strong>
        <dl>
            <dt>Type</dt>
            <dd>Black hot coffee</dd>
        </dl>
    </li>
</ul>
```

## Lists with Images

Images can be placed inside list items.

```html
<ul>
    <li>
        <img src="coffee.png" alt="Cup of coffee">
        <span>Coffee</span>
    </li>
    <li>
        <img src="tea.png" alt="Cup of tea">
        <span>Tea</span>
    </li>
</ul>
```

Always write useful `alt` text for images.

## List Grid with CSS

A list can be displayed as a grid using CSS.

```html
<ul class="list-grid">
    <li>Coffee</li>
    <li>Tea</li>
    <li>Milk</li>
</ul>
```

```css
.list-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    gap: 16px;
    padding: 0;
    list-style: none;
}

.list-grid li {
    padding: 16px;
    border: 1px solid #cccccc;
}
```

`auto-fit` makes the grid responsive. `minmax(200px, 1fr)` means each column should be at least `200px`, then grow to share available space.

## Circular Logo or Image

Use `border-radius: 50%` to make an image circular. The image should have equal width and height.

```html
<img src="logo.png" alt="My logo" class="logo">
```

```css
.logo {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    object-fit: cover;
}
```

`object-fit: cover` keeps the image from looking stretched.

## Changing List Markers

Use `list-style-type` to change markers.

```css
ul {
    list-style-type: square;
}

ol {
    list-style-type: upper-roman;
}
```

Common unordered markers:

- `disc`
- `circle`
- `square`
- `none`

Common ordered markers:

- `decimal`
- `decimal-leading-zero`
- `lower-alpha`
- `upper-alpha`
- `lower-roman`
- `upper-roman`

## Removing List Markers

Navigation menus often remove list markers.

```css
nav ul {
    margin: 0;
    padding: 0;
    list-style: none;
}
```

## Horizontal Navigation List

```html
<nav>
    <ul class="nav-list">
        <li><a href="#home">Home</a></li>
        <li><a href="#about">About</a></li>
        <li><a href="#contact">Contact</a></li>
    </ul>
</nav>
```

```css
.nav-list {
    display: flex;
    gap: 12px;
    list-style: none;
}
```

Using Flexbox is cleaner than using `float` for navigation.

## Useful List Attributes

### Ordered List `type`

```html
<ol type="A">
    <li>First</li>
    <li>Second</li>
</ol>
```

Values include:

- `1` for numbers
- `A` for uppercase letters
- `a` for lowercase letters
- `I` for uppercase Roman numerals
- `i` for lowercase Roman numerals

### Ordered List `start`

```html
<ol start="5">
    <li>Fifth item</li>
    <li>Sixth item</li>
</ol>
```

### Ordered List `reversed`

```html
<ol reversed>
    <li>Third</li>
    <li>Second</li>
    <li>First</li>
</ol>
```

### List Item `value`

```html
<ol>
    <li value="10">Item ten</li>
    <li>Item eleven</li>
</ol>
```

## Styling List Spacing

```css
ul {
    margin: 16px 0;
    padding-left: 24px;
}

li {
    margin-bottom: 8px;
}
```

Use `margin` for outside spacing and `padding` for inside spacing.

## Best Practices

- Use `<ul>` when order does not matter.
- Use `<ol>` when order matters.
- Use `<dl>` for terms and descriptions.
- Put list content inside `<li>` elements.
- Use `alt` text for images inside lists.
- Use CSS Grid or Flexbox for layout.
- Do not use lists only for spacing.
- Do not place `<dl>` directly inside `<ul>` unless it is inside an `<li>`.
- Use `list-style: none` only when you provide another clear visual structure.

## Full Example

```html
<ul class="list-grid">
    <li>
        <img src="coffee.png" alt="Coffee">
        <strong>Coffee</strong>
        <dl>
            <dt>Type</dt>
            <dd>Black hot coffee</dd>
        </dl>
    </li>
    <li>
        <img src="tea.png" alt="Tea">
        <strong>Tea</strong>
        <dl>
            <dt>Type</dt>
            <dd>Green tea</dd>
        </dl>
    </li>
</ul>
```

```css
.list-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    gap: 16px;
    padding: 0;
    list-style: none;
}

.list-grid li {
    padding: 16px;
    border: 1px solid #cccccc;
    border-radius: 8px;
}

.list-grid img {
    width: 72px;
    height: 72px;
    border-radius: 50%;
    object-fit: cover;
}
```
