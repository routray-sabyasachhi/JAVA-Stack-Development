# CSS Basics and Property Guide

## What is CSS?

CSS stands for **Cascading Style Sheets**. It is the language used to control the **look, layout, spacing, colors, animation, and responsiveness** of HTML elements on a web page. HTML gives structure, and CSS gives presentation.

With CSS, we can:

- change text color and size
- add margins, padding, and borders
- control width, height, and position
- create layouts with flexbox and grid
- add hover effects, transitions, transforms, and animations
- make pages responsive with media queries
- create gradients, shadows, filters, and modern UI effects

## Why is it called Cascading?

CSS is called cascading because multiple styles can apply to the same element. The browser decides which style wins based on:

- `!important`
- specificity
- source order
- inheritance

## Basic CSS Syntax

```css
selector {
  property: value;
}
```

Example:

```css
h1 {
  color: blue;
  font-size: 32px;
}
```

Here:

- `h1` is the selector
- `color` and `font-size` are properties
- `blue` and `32px` are values

## Ways to Use CSS

### 1. Inline CSS

```html
<p style="color: red;">Hello</p>
```

### 2. Internal CSS

```html
<style>
  p {
    color: red;
  }
</style>
```

### 3. External CSS

```html
<link rel="stylesheet" href="style.css" />
```

External CSS is best because it keeps code clean and reusable.

## Selectors

CSS selectors choose which HTML elements to style.

```css
* {
  box-sizing: border-box;
}

p {
  color: black;
}

.card {
  background: white;
}

#header {
  padding: 20px;
}

input[type="text"] {
  border: 1px solid gray;
}

.box:hover {
  background: orange;
}
```

### Common selectors

- `*` selects all elements
- `element` selects by tag name
- `.class` selects by class
- `#id` selects by id
- `[attribute]` selects by attribute
- `:hover`, `:focus`, `:first-child` are pseudo-classes
- `::before`, `::after` are pseudo-elements

## The `*` Universal Selector

The `*` selector targets **all elements**.

```css
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
```

This is commonly used for a CSS reset so all elements start with consistent spacing.

## Units in CSS

Common CSS units:

- `px` fixed pixels
- `%` percentage
- `em` relative to parent font size
- `rem` relative to root font size
- `vw` viewport width
- `vh` viewport height
- `fr` flexible grid unit
- `deg` degrees for rotate
- `s` and `ms` for time

## Colors in CSS

```css
color: red;
color: #ff0000;
color: rgb(255, 0, 0);
color: rgba(255, 0, 0, 0.5);
color: hsl(0, 100%, 50%);
```

## Background Properties

- `background` shorthand for all background properties
- `background-color` sets background color
- `background-image` adds image or gradient
- `background-repeat` repeats or not
- `background-position` controls image position
- `background-size` controls image size like `cover` or `contain`
- `background-attachment` scroll or fixed
- `background-clip` limits painting area
- `background-origin` sets positioning origin
- `background-blend-mode` blends multiple backgrounds

Example:

```css
.hero {
  background-image: linear-gradient(135deg, #0ea5e9, #1d4ed8);
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}
```

## Gradients

Gradients are treated like images in CSS.

### Linear gradient

```css
background: linear-gradient(to right, red, blue);
```

### Radial gradient

```css
background: radial-gradient(circle, yellow, orange, red);
```

### Conic gradient

```css
background: conic-gradient(red, yellow, green, blue);
```

### Moving gradient

We can animate gradient movement using `background-size`, `background-position`, and `animation`.

```css
.moving-gradient {
  background: linear-gradient(270deg, #ff6b6b, #ffd93d, #6bcB77, #4d96ff);
  background-size: 800% 800%;
  animation: gradientMove 8s ease infinite;
}

@keyframes gradientMove {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}
```

## Text and Font Properties

- `color` text color
- `font` shorthand
- `font-family` font style family
- `font-size` text size
- `font-style` normal, italic
- `font-weight` thickness
- `font-variant` small caps and variants
- `font-stretch` width variation
- `line-height` line spacing
- `letter-spacing` space between letters
- `word-spacing` space between words
- `text-align` left, right, center, justify
- `text-decoration` underline, line-through
- `text-decoration-color`
- `text-decoration-style`
- `text-decoration-thickness`
- `text-transform` uppercase, lowercase
- `text-indent` paragraph indent
- `text-shadow` text shadow effect
- `text-overflow` clip or ellipsis
- `white-space` wrapping behavior
- `overflow-wrap` break long words
- `word-break` word breaking rules
- `writing-mode` horizontal or vertical text
- `direction` ltr or rtl

Example:

```css
h2 {
  font-family: Arial, sans-serif;
  font-size: 28px;
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 2px;
}
```

## Box Model Properties

Every element follows the CSS box model:

- content
- padding
- border
- margin

Important properties:

- `width`
- `height`
- `min-width`
- `max-width`
- `min-height`
- `max-height`
- `padding`
- `padding-top`
- `padding-right`
- `padding-bottom`
- `padding-left`
- `margin`
- `margin-top`
- `margin-right`
- `margin-bottom`
- `margin-left`
- `border`
- `border-width`
- `border-style`
- `border-color`
- `border-radius`
- `box-sizing`
- `outline`
- `outline-offset`
- `box-shadow`

Example:

```css
.card {
  width: 300px;
  padding: 20px;
  margin: 20px auto;
  border: 1px solid #ddd;
  border-radius: 12px;
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
}
```

## Display and Visibility Properties

- `display` controls layout type: `block`, `inline`, `inline-block`, `flex`, `grid`, `none`
- `visibility` visible or hidden
- `opacity` transparency
- `overflow`
- `overflow-x`
- `overflow-y`
- `clip-path` clipping shape

## Position Properties

- `position`: `static`, `relative`, `absolute`, `fixed`, `sticky`
- `top`
- `right`
- `bottom`
- `left`
- `z-index`

Example:

```css
.badge {
  position: absolute;
  top: 10px;
  right: 10px;
}
```

## Flexbox Properties

Flexbox is used for one-dimensional layout: row or column.

### Parent flex container properties

- `display: flex`
- `flex-direction`
- `flex-wrap`
- `flex-flow` shorthand
- `justify-content`
- `align-items`
- `align-content`
- `gap`
- `row-gap`
- `column-gap`

### Child flex item properties

- `flex`
- `flex-grow`
- `flex-shrink`
- `flex-basis`
- `align-self`
- `order`

Example:

```css
.container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  gap: 20px;
  flex-wrap: wrap;
}

.item {
  flex: 1 1 200px;
}
```

## Grid Properties

Grid is used for two-dimensional layout.

- `display: grid`
- `grid-template-columns`
- `grid-template-rows`
- `grid-template-areas`
- `grid-auto-columns`
- `grid-auto-rows`
- `grid-auto-flow`
- `gap`
- `row-gap`
- `column-gap`
- `justify-items`
- `align-items`
- `place-items`
- `justify-content`
- `align-content`
- `place-content`
- `grid-column`
- `grid-row`
- `grid-column-start`
- `grid-column-end`
- `grid-row-start`
- `grid-row-end`
- `grid-area`
- `justify-self`
- `align-self`
- `place-self`

## List and Table Properties

### List properties

- `list-style`
- `list-style-type`
- `list-style-position`
- `list-style-image`

### Table properties

- `border-collapse`
- `border-spacing`
- `caption-side`
- `empty-cells`
- `table-layout`
- `vertical-align`

## Image and Object Properties

- `object-fit`
- `object-position`
- `aspect-ratio`
- `image-rendering`

Example:

```css
img {
  width: 100%;
  height: 250px;
  object-fit: cover;
}
```

## Cursor and Interaction Properties

- `cursor`
- `pointer-events`
- `user-select`
- `caret-color`
- `accent-color`
- `resize`
- `scroll-behavior`

## Transform Properties

Transforms visually change an element without changing normal layout flow.

- `transform`
- `transform-origin`
- `transform-style`
- `perspective`
- `perspective-origin`
- `backface-visibility`

### Common transform functions

- `translate(x, y)`
- `translateX()`
- `translateY()`
- `translateZ()`
- `scale()`
- `scaleX()`
- `scaleY()`
- `rotate()`
- `rotateX()`
- `rotateY()`
- `rotateZ()`
- `skew()`
- `skewX()`
- `skewY()`

Example:

```css
.box {
  transition: transform 0.3s ease;
}

.box:hover {
  transform: translateY(-10px) scale(1.05) rotate(2deg);
}
```

## Transition Properties

Transitions make changes smooth.

- `transition`
- `transition-property`
- `transition-duration`
- `transition-timing-function`
- `transition-delay`

Example:

```css
button {
  background: steelblue;
  color: white;
  transition: background 0.3s ease, transform 0.3s ease;
}

button:hover {
  background: darkblue;
  transform: scale(1.05);
}
```

## Hover and Pseudo-Classes

Pseudo-classes style elements based on state.

Common pseudo-classes:

- `:hover`
- `:focus`
- `:active`
- `:visited`
- `:link`
- `:checked`
- `:disabled`
- `:enabled`
- `:first-child`
- `:last-child`
- `:nth-child()`
- `:not()`

Example:

```css
a:hover {
  color: crimson;
}

input:focus {
  outline: 2px solid blue;
}
```

## Pseudo-Elements

- `::before`
- `::after`
- `::placeholder`
- `::selection`
- `::first-letter`
- `::first-line`
- `::marker`

Example:

```css
.title::after {
  content: "";
  display: block;
  width: 60px;
  height: 4px;
  background: orange;
}
```

## Animation and Keyframes

Animations let us create movement and repeated effects.

### Animation properties

- `animation`
- `animation-name`
- `animation-duration`
- `animation-timing-function`
- `animation-delay`
- `animation-iteration-count`
- `animation-direction`
- `animation-fill-mode`
- `animation-play-state`
- `animation-composition`
- `animation-timeline` in newer specs

### `@keyframes`

`@keyframes` defines the animation stages.

```css
@keyframes bounce {
  0% {
    transform: translateY(0);
  }
  50% {
    transform: translateY(-20px);
  }
  100% {
    transform: translateY(0);
  }
}

.ball {
  animation: bounce 1s ease-in-out infinite;
}
```

## Filter and Visual Effect Properties

- `filter`
- `backdrop-filter`
- `mix-blend-mode`
- `isolation`

Common filter functions:

- `blur()`
- `brightness()`
- `contrast()`
- `drop-shadow()`
- `grayscale()`
- `hue-rotate()`
- `invert()`
- `opacity()`
- `saturate()`
- `sepia()`

## Media Queries

Media queries make websites responsive on mobile, tablet, and desktop.

```css
@media (max-width: 768px) {
  .container {
    flex-direction: column;
  }
}
```

### Common media features

- `width`
- `height`
- `max-width`
- `min-width`
- `max-height`
- `min-height`
- `orientation`
- `aspect-ratio`
- `hover`
- `pointer`
- `prefers-color-scheme`
- `prefers-reduced-motion`

Example:

```css
@media (max-width: 600px) {
  body {
    font-size: 14px;
  }

  .grid {
    grid-template-columns: 1fr;
  }
}
```

## Common Shorthand Properties

- `margin`
- `padding`
- `border`
- `background`
- `font`
- `list-style`
- `transition`
- `animation`
- `flex`
- `grid-area`
- `place-items`
- `place-content`
- `place-self`

## Important Modern Properties

- `box-sizing`
- `aspect-ratio`
- `gap`
- `scroll-snap-type`
- `scroll-snap-align`
- `content-visibility`
- `contain`
- `will-change`
- `appearance`

## Large CSS Property Summary by Category

Below is a broader grouped list of many important CSS properties you should know. This is not limited to only beginner properties and includes modern layout and visual properties.

### Layout and sizing

- `display`
- `width`
- `height`
- `min-width`
- `max-width`
- `min-height`
- `max-height`
- `inline-size`
- `block-size`
- `min-inline-size`
- `max-inline-size`
- `min-block-size`
- `max-block-size`
- `box-sizing`
- `aspect-ratio`

### Spacing

- `margin`
- `margin-top`
- `margin-right`
- `margin-bottom`
- `margin-left`
- `padding`
- `padding-top`
- `padding-right`
- `padding-bottom`
- `padding-left`
- `gap`
- `row-gap`
- `column-gap`

### Border and outline

- `border`
- `border-top`
- `border-right`
- `border-bottom`
- `border-left`
- `border-width`
- `border-style`
- `border-color`
- `border-radius`
- `border-image`
- `outline`
- `outline-color`
- `outline-style`
- `outline-width`
- `outline-offset`

### Position and stacking

- `position`
- `top`
- `right`
- `bottom`
- `left`
- `inset`
- `z-index`
- `float`
- `clear`

### Text

- `color`
- `font-family`
- `font-size`
- `font-weight`
- `font-style`
- `line-height`
- `letter-spacing`
- `word-spacing`
- `text-align`
- `text-transform`
- `text-decoration`
- `text-shadow`
- `white-space`
- `text-overflow`

### Background and effects

- `background`
- `background-color`
- `background-image`
- `background-size`
- `background-repeat`
- `background-position`
- `background-attachment`
- `background-clip`
- `box-shadow`
- `opacity`
- `filter`
- `backdrop-filter`

### Flexbox

- `flex-direction`
- `flex-wrap`
- `justify-content`
- `align-items`
- `align-content`
- `flex-grow`
- `flex-shrink`
- `flex-basis`
- `order`
- `align-self`

### Grid

- `grid-template-columns`
- `grid-template-rows`
- `grid-template-areas`
- `grid-auto-flow`
- `grid-auto-columns`
- `grid-auto-rows`
- `justify-items`
- `align-items`
- `place-items`
- `justify-content`
- `align-content`
- `place-content`

### Motion

- `transform`
- `transform-origin`
- `transition`
- `animation`

### Responsive and behavior

- `overflow`
- `overflow-x`
- `overflow-y`
- `resize`
- `cursor`
- `pointer-events`
- `scroll-behavior`

## Complete Example

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>CSS Demo</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      font-family: Arial, sans-serif;
      background: linear-gradient(135deg, #eef2ff, #dbeafe);
      min-height: 100vh;
      padding: 30px;
    }

    .wrapper {
      display: flex;
      gap: 20px;
      flex-wrap: wrap;
      justify-content: center;
    }

    .card {
      width: 280px;
      padding: 20px;
      border-radius: 16px;
      background: white;
      box-shadow: 0 12px 30px rgba(0, 0, 0, 0.12);
      transition: transform 0.3s ease, box-shadow 0.3s ease;
      animation: fadeUp 0.8s ease;
    }

    .card:hover {
      transform: translateY(-10px) scale(1.03);
      box-shadow: 0 18px 35px rgba(0, 0, 0, 0.18);
    }

    .btn {
      display: inline-block;
      margin-top: 15px;
      padding: 10px 16px;
      background: linear-gradient(90deg, #2563eb, #7c3aed);
      color: white;
      text-decoration: none;
      border-radius: 8px;
    }

    @keyframes fadeUp {
      from {
        opacity: 0;
        transform: translateY(20px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    }

    @media (max-width: 600px) {
      .wrapper {
        flex-direction: column;
      }

      .card {
        width: 100%;
      }
    }
  </style>
</head>
<body>
  <div class="wrapper">
    <div class="card">
      <h2>CSS Card</h2>
      <p>This card uses flexbox, hover, transform, gradient, animation, and media query.</p>
      <a href="#" class="btn">Read More</a>
    </div>
  </div>
</body>
</html>
```

## Final Notes

CSS is a very large language and new properties continue to be added over time. The most important idea is to learn CSS by category:

- selectors
- colors and backgrounds
- text and fonts
- box model
- layout with flexbox and grid
- positioning
- transitions, transforms, and animations
- responsive design with media queries

If you understand these categories and practice them with small examples, you will be able to build modern responsive websites confidently.
