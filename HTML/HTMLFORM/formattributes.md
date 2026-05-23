# HTML Form Attributes and Elements

This file contains notes about important **form elements**, **form attributes**, and **form field requirements**.

Topics covered:

- Form elements
- Form attributes
- Input attributes
- Validation attributes
- Button attributes
- Accessibility requirements
- Examples
- Common mistakes

## 1. What is a Form?

An HTML form is used to collect data from users.

Examples:

- login form
- registration form
- contact form
- search form
- payment form
- feedback form
- file upload form

Basic syntax:

```html
<form action="/submit" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name">

  <button type="submit">Submit</button>
</form>
```

## 2. Important Form Elements

### `<form>`

The main container for all form controls.

```html
<form action="/register" method="post">
  Form controls go here
</form>
```

### `<label>`

The label describes a form field.

```html
<label for="email">Email:</label>
<input type="email" id="email" name="email">
```

The `for` value should match the input `id`.

### `<input>`

The most common form control.

```html
<input type="text" name="username">
```

Common input types:

- `text`
- `email`
- `password`
- `number`
- `tel`
- `url`
- `search`
- `date`
- `time`
- `datetime-local`
- `month`
- `week`
- `radio`
- `checkbox`
- `file`
- `color`
- `range`
- `hidden`
- `submit`
- `reset`
- `button`
- `image`

### `<textarea>`

Used for multi-line text.

```html
<textarea id="message" name="message" rows="4" cols="30"></textarea>
```

### `<select>`

Creates a dropdown.

```html
<select id="country" name="country">
  <option value="india">India</option>
  <option value="usa">USA</option>
</select>
```

### `<option>`

Creates an option inside `<select>` or `<datalist>`.

```html
<option value="html">HTML</option>
```

### `<optgroup>`

Groups related dropdown options.

```html
<select name="course">
  <optgroup label="Frontend">
    <option value="html">HTML</option>
    <option value="css">CSS</option>
  </optgroup>
</select>
```

### `<button>`

Creates a button.

```html
<button type="submit">Submit</button>
<button type="reset">Reset</button>
<button type="button">Normal Button</button>
```

### `<fieldset>`

Groups related form fields.

```html
<fieldset>
  <legend>Personal Details</legend>
  <input type="text" name="name">
</fieldset>
```

### `<legend>`

Adds a title for a `<fieldset>`.

```html
<legend>Account Details</legend>
```

### `<datalist>`

Provides suggestions for an input field.

```html
<input list="browsers" name="browser">

<datalist id="browsers">
  <option value="Chrome">
  <option value="Firefox">
</datalist>
```

### `<output>`

Displays a calculation result.

```html
<form oninput="result.value = Number(a.value) + Number(b.value)">
  <input type="number" id="a" value="5">
  <input type="number" id="b" value="10">
  <output name="result">15</output>
</form>
```

## 3. Attributes of `<form>`

### `action`

Defines where form data will be sent.

```html
<form action="/submit">
```

### `method`

Defines how data is sent.

```html
<form method="get">
<form method="post">
```

Use `get` for:

- search forms
- filters
- public data
- bookmarkable URLs

Use `post` for:

- login
- registration
- passwords
- private data
- file uploads

### `target`

Defines where the response opens.

Common values:

- `_self`
- `_blank`
- `_parent`
- `_top`

```html
<form action="/submit" target="_blank">
```

### `autocomplete`

Controls browser autofill.

```html
<form autocomplete="on">
<form autocomplete="off">
```

### `enctype`

Defines how form data is encoded.

Common values:

- `application/x-www-form-urlencoded`
- `multipart/form-data`
- `text/plain`

For file upload:

```html
<form method="post" enctype="multipart/form-data">
```

### `novalidate`

Disables browser validation.

```html
<form novalidate>
```

### `name`

Gives a name to the form.

```html
<form name="registrationForm">
```

### `id`

Gives a unique ID to the form.

```html
<form id="loginForm">
```

The form `id` can be used by inputs with the `form` attribute.

## 4. Common Input Attributes

### `type`

Defines the kind of input.

```html
<input type="email">
```

### `name`

Defines the key sent with form data.

```html
<input type="text" name="username">
```

Without `name`, the field value is usually not submitted.

### `id`

Uniquely identifies the element.

```html
<input id="username" name="username">
```

### `value`

Sets the default value.

```html
<input type="text" name="city" value="Kolkata">
```

### `placeholder`

Shows hint text inside a field.

```html
<input type="text" placeholder="Enter your name">
```

Important: placeholder is not a replacement for a label.

### `required`

Makes a field mandatory.

```html
<input type="email" required>
```

### `readonly`

Makes a field visible but not editable.

```html
<input type="text" value="India" readonly>
```

Readonly fields are submitted with the form.

### `disabled`

Disables a field.

```html
<input type="text" value="Not available" disabled>
```

Disabled fields are usually not submitted.

### `maxlength`

Sets maximum character length.

```html
<input type="text" maxlength="20">
```

### `minlength`

Sets minimum character length.

```html
<input type="password" minlength="8">
```

### `min`

Sets minimum value.

```html
<input type="number" min="18">
```

### `max`

Sets maximum value.

```html
<input type="number" max="60">
```

### `step`

Sets valid number intervals.

```html
<input type="number" min="0" max="10" step="2">
```

Valid values:

```text
0, 2, 4, 6, 8, 10
```

### `pattern`

Checks the input value using a regular expression.

```html
<input type="text" pattern="[0-9]{6}">
```

This example accepts exactly 6 digits.

### `title`

Shows extra information. It is useful with `pattern`.

```html
<input
  type="tel"
  pattern="[0-9]{10}"
  title="Enter a 10 digit mobile number"
>
```

### `checked`

Selects a checkbox or radio button by default.

```html
<input type="checkbox" checked>
```

### `selected`

Selects an option by default.

```html
<option value="india" selected>India</option>
```

### `multiple`

Allows multiple values.

```html
<input type="file" multiple>
<select multiple>
```

### `accept`

Defines allowed file types.

```html
<input type="file" accept="image/png, image/jpeg">
```

### `autocomplete`

Controls autofill for a field.

```html
<input type="email" autocomplete="email">
```

Common values:

- `name`
- `email`
- `username`
- `current-password`
- `new-password`
- `tel`
- `street-address`

### `autofocus`

Focuses the field when the page loads.

```html
<input type="text" autofocus>
```

Usually only one element should use `autofocus`.

### `list`

Connects an input with a datalist.

```html
<input list="languages">
<datalist id="languages">
  <option value="HTML">
</datalist>
```

### `form`

Connects a control to a form by form `id`.

```html
<form id="myForm"></form>
<input type="text" name="name" form="myForm">
```

## 5. Button and Submit Attributes

These attributes can override the parent form settings on a specific submit button.

### `formaction`

Sets a different submit URL.

```html
<button type="submit" formaction="/save">Save</button>
```

### `formmethod`

Sets a different method.

```html
<button type="submit" formmethod="post">Submit with POST</button>
```

### `formenctype`

Sets a different encoding type.

```html
<button type="submit" formenctype="multipart/form-data">Upload</button>
```

### `formtarget`

Sets where the response opens.

```html
<button type="submit" formtarget="_blank">Open in New Tab</button>
```

### `formnovalidate`

Submits without browser validation.

```html
<button type="submit" formnovalidate>Skip Validation</button>
```

## 6. Validation Requirements

HTML has built-in validation attributes.

### Required field

```html
<input type="text" required>
```

### Email validation

```html
<input type="email" required>
```

### Password length

```html
<input type="password" minlength="8" maxlength="12" required>
```

### Number range

```html
<input type="number" min="18" max="60">
```

### Phone pattern

```html
<input
  type="tel"
  pattern="[0-9]{10}"
  title="Enter a 10 digit phone number"
>
```

### File type

```html
<input type="file" accept=".pdf,.doc,.docx">
```

Important: browser validation helps the user, but important data must also be validated on the server.

## 7. Accessibility Requirements

Good forms should be easy to use for everyone.

Important points:

- use a `<label>` for every input
- connect label `for` with input `id`
- use unique `id` values
- use `fieldset` and `legend` for grouped fields
- use correct input types
- do not use placeholder as the only label
- clearly mark required fields
- write helpful validation messages
- make buttons clear

Good example:

```html
<label for="email">Email:</label>
<input type="email" id="email" name="email" required>
```

Bad example:

```html
<input type="email" placeholder="Email">
```

## 8. Complete Example

```html
<form action="/register" method="post" autocomplete="on">
  <fieldset>
    <legend>Student Details</legend>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="age">Age:</label>
    <input type="number" id="age" name="age" min="18" max="60">
  </fieldset>

  <fieldset>
    <legend>Course</legend>

    <label for="course">Choose Course:</label>
    <select id="course" name="course" required>
      <option value="">Select course</option>
      <option value="html">HTML</option>
      <option value="css">CSS</option>
    </select>
  </fieldset>

  <button type="reset">Reset</button>
  <button type="submit">Submit</button>
</form>
```

## 9. Common Mistakes

### Using `label` as an attribute

Incorrect:

```html
<input type="text" label="Name">
```

Correct:

```html
<label for="name">Name:</label>
<input type="text" id="name" name="name">
```

### Missing `name`

Incorrect:

```html
<input type="email" id="email">
```

Correct:

```html
<input type="email" id="email" name="email">
```

### Wrong email type

Incorrect:

```html
<input type="mail">
```

Correct:

```html
<input type="email">
```

### Button without type

Inside a form, a button without `type` usually submits the form.

Safer:

```html
<button type="button">Normal Button</button>
```

## 10. Quick Reference

| Attribute | Use |
|---|---|
| `action` | Form submit URL |
| `method` | Submit method, like `get` or `post` |
| `target` | Where response opens |
| `autocomplete` | Browser autofill |
| `enctype` | Form data encoding |
| `novalidate` | Disables browser validation |
| `type` | Input type |
| `name` | Submitted data key |
| `id` | Unique element identifier |
| `value` | Default or submitted value |
| `placeholder` | Hint text |
| `required` | Mandatory field |
| `readonly` | Not editable but submitted |
| `disabled` | Not editable and usually not submitted |
| `minlength` | Minimum text length |
| `maxlength` | Maximum text length |
| `min` | Minimum value |
| `max` | Maximum value |
| `step` | Value interval |
| `pattern` | Regex validation |
| `title` | Helpful extra message |
| `checked` | Default checked radio/checkbox |
| `selected` | Default selected option |
| `multiple` | Allows multiple values |
| `accept` | Allowed file types |
| `autofocus` | Focus on page load |
| `list` | Connects to datalist |
| `form` | Connects control to a form |
| `formaction` | Button-specific action |
| `formmethod` | Button-specific method |
| `formenctype` | Button-specific encoding |
| `formtarget` | Button-specific target |
| `formnovalidate` | Button-specific validation skip |

## 11. Conclusion

Form elements create fields and buttons. Form attributes control how data is collected, validated, and submitted.

Remember:

- use labels properly
- add `name` to fields that should submit data
- use correct input types
- use validation attributes for simple checks
- use `post` for private data
- use `multipart/form-data` for file uploads
- always validate important data on the server also
