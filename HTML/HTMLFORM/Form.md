# HTML Form Notes

This file contains beginner-friendly notes about **HTML forms**, form tags, form attributes, input types, validation, and important requirements.

Topics covered:

- What is an HTML form?
- Basic form syntax
- Important form tags
- Important form attributes
- Input types
- Input attributes
- Labels and accessibility
- Required fields and validation
- Buttons in forms
- GET and POST methods
- Complete form example
- Common mistakes
- Best practices

## 1. What is an HTML Form?

An HTML form is used to collect information from a user.

Examples of information collected by forms:

- name
- email
- password
- phone number
- gender
- date of birth
- address
- feedback
- file upload
- search text
- login details

Forms are commonly used in:

- registration pages
- login pages
- contact pages
- payment pages
- search bars
- feedback forms
- surveys

Example:

```html
<form>
  <input type="text" placeholder="Enter your name">
  <input type="submit" value="Submit">
</form>
```

## 2. Basic Form Syntax

```html
<form action="/submit" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username">

  <button type="submit">Submit</button>
</form>
```

Here:

- `<form>` creates the form.
- `action` tells where the form data will be sent.
- `method` tells how the data will be sent.
- `<label>` gives a name to the input field.
- `<input>` creates a field for user input.
- `<button>` creates a clickable button.

## 3. Important Form Tags

### `<form>`

The `<form>` tag is the main container for form controls.

```html
<form action="/register" method="post">
  Form elements go here
</form>
```

Common attributes:

- `action`
- `method`
- `target`
- `autocomplete`
- `enctype`
- `novalidate`
- `name`

### `<input>`

The `<input>` tag creates many types of form fields.

It is a void element, so it does not need a closing tag.

```html
<input type="text">
<input type="email">
<input type="password">
```

### `<label>`

The `<label>` tag gives a readable name to an input.

```html
<label for="email">Email:</label>
<input type="email" id="email" name="email">
```

The `for` attribute of the label should match the `id` of the input.

This is important because:

- it improves accessibility
- it helps screen readers
- clicking the label focuses the input
- it makes forms easier to use

### `<textarea>`

The `<textarea>` tag is used for multi-line text input.

```html
<label for="message">Message:</label>
<textarea id="message" name="message" rows="5" cols="30"></textarea>
```

Common uses:

- comments
- feedback
- address
- long messages

### `<select>`

The `<select>` tag creates a dropdown list.

```html
<label for="country">Country:</label>
<select id="country" name="country">
  <option value="">Select country</option>
  <option value="india">India</option>
  <option value="usa">USA</option>
  <option value="uk">UK</option>
</select>
```

### `<option>`

The `<option>` tag defines one option inside a dropdown.

```html
<option value="html">HTML</option>
```

The `value` is the data sent when the form is submitted.

### `<optgroup>`

The `<optgroup>` tag groups related options inside a dropdown.

```html
<select name="course">
  <optgroup label="Frontend">
    <option value="html">HTML</option>
    <option value="css">CSS</option>
  </optgroup>
  <optgroup label="Backend">
    <option value="java">Java</option>
    <option value="spring-boot">Spring Boot</option>
  </optgroup>
</select>
```

### `<button>`

The `<button>` tag creates a button.

```html
<button type="submit">Submit</button>
<button type="reset">Reset</button>
<button type="button">Click Me</button>
```

Button types:

- `submit` submits the form
- `reset` clears the form
- `button` is used for JavaScript actions

### `<fieldset>`

The `<fieldset>` tag groups related form fields.

```html
<fieldset>
  <legend>Personal Details</legend>

  <label for="name">Name:</label>
  <input type="text" id="name" name="name">
</fieldset>
```

### `<legend>`

The `<legend>` tag gives a title to a `<fieldset>`.

```html
<legend>Login Details</legend>
```

### `<datalist>`

The `<datalist>` tag provides suggestions for an input field.

```html
<label for="browser">Choose browser:</label>
<input list="browsers" id="browser" name="browser">

<datalist id="browsers">
  <option value="Chrome">
  <option value="Firefox">
  <option value="Edge">
</datalist>
```

### `<output>`

The `<output>` tag displays the result of a calculation.

```html
<form oninput="result.value = Number(a.value) + Number(b.value)">
  <input type="number" id="a" value="10">
  +
  <input type="number" id="b" value="20">
  =
  <output name="result">30</output>
</form>
```

## 4. Important `<form>` Attributes

### `action`

The `action` attribute defines where the form data will be sent.

```html
<form action="/submit-form">
```

If `action` is empty or missing, the form usually submits to the same page.

### `method`

The `method` attribute defines how form data is sent.

Common values:

- `get`
- `post`

Example:

```html
<form method="get">
```

```html
<form method="post">
```

### `GET` method

The `get` method sends form data in the URL.

Example URL:

```text
example.com/search?query=html
```

Use `GET` for:

- search forms
- filters
- non-sensitive data
- data that can be bookmarked

Do not use `GET` for passwords or private data.

### `POST` method

The `post` method sends form data inside the request body.

Use `POST` for:

- login forms
- registration forms
- password forms
- payment forms
- file uploads
- private data

### `target`

The `target` attribute defines where to open the response after form submission.

Common values:

- `_self` opens in the same tab
- `_blank` opens in a new tab
- `_parent` opens in the parent frame
- `_top` opens in the full window

Example:

```html
<form action="/submit" target="_blank">
```

### `autocomplete`

The `autocomplete` attribute allows or stops browser autofill.

```html
<form autocomplete="on">
```

```html
<form autocomplete="off">
```

It can also be used on individual inputs.

### `enctype`

The `enctype` attribute defines how form data is encoded before being sent.

It is mainly used with `method="post"`.

Common values:

- `application/x-www-form-urlencoded`
- `multipart/form-data`
- `text/plain`

For file uploads, use:

```html
<form method="post" enctype="multipart/form-data">
```

### `novalidate`

The `novalidate` attribute disables browser validation.

```html
<form novalidate>
```

This means fields like `required`, `email`, `minlength`, and `pattern` will not be checked by the browser before submission.

### `name`

The `name` attribute gives a name to the form.

```html
<form name="registrationForm">
```

## 5. Input Types

The `type` attribute decides what kind of input field will be shown.

### Text input

```html
<input type="text" name="username">
```

Used for normal single-line text.

### Email input

```html
<input type="email" name="email">
```

Used for email addresses.

The browser checks if the entered value looks like an email.

Correct:

```text
user@example.com
```

Incorrect:

```text
userexample.com
```

### Password input

```html
<input type="password" name="password">
```

Used for passwords.

The entered characters are hidden.

### Number input

```html
<input type="number" name="age" min="18" max="60">
```

Used for numeric values.

### Telephone input

```html
<input type="tel" name="phone">
```

Used for phone numbers.

It does not automatically validate all phone number formats because every country uses different formats.

### URL input

```html
<input type="url" name="website">
```

Used for website URLs.

### Search input

```html
<input type="search" name="query">
```

Used for search boxes.

### Date input

```html
<input type="date" name="dob">
```

Used to select a date.

### Time input

```html
<input type="time" name="meetingTime">
```

Used to select a time.

### Date and time input

```html
<input type="datetime-local" name="appointment">
```

Used to select date and time together.

### Month input

```html
<input type="month" name="joiningMonth">
```

Used to select a month and year.

### Week input

```html
<input type="week" name="week">
```

Used to select a week.

### Radio input

```html
<input type="radio" id="male" name="gender" value="male">
<label for="male">Male</label>

<input type="radio" id="female" name="gender" value="female">
<label for="female">Female</label>
```

Radio buttons are used when the user should select only one option from a group.

Important:

- radio buttons in the same group must have the same `name`
- each radio button should have a different `value`
- each radio button should have a unique `id`

### Checkbox input

```html
<input type="checkbox" id="terms" name="terms" value="accepted">
<label for="terms">I accept the terms and conditions</label>
```

Checkboxes are used when the user can select one or more options.

### File input

```html
<input type="file" name="profilePhoto">
```

Used for uploading files.

For file uploads, the form should use:

```html
<form method="post" enctype="multipart/form-data">
```

### Color input

```html
<input type="color" name="favoriteColor">
```

Used to choose a color.

### Range input

```html
<input type="range" name="volume" min="0" max="100">
```

Used to select a value from a range.

### Hidden input

```html
<input type="hidden" name="userId" value="123">
```

Used to send hidden data with the form.

Important:

- hidden inputs are not visible on the page
- users can still inspect or change them using developer tools
- never store secret or trusted data only in hidden inputs

### Submit input

```html
<input type="submit" value="Register">
```

Submits the form.

### Reset input

```html
<input type="reset" value="Clear">
```

Resets form fields to their original values.

### Button input

```html
<input type="button" value="Click Me">
```

Creates a button, usually used with JavaScript.

### Image input

```html
<input type="image" src="submit.png" alt="Submit">
```

Creates an image button for submitting a form.

## 6. Important Input Attributes

### `type`

Defines the input type.

```html
<input type="email">
```

### `name`

Defines the key used when form data is submitted.

```html
<input type="text" name="username">
```

If an input does not have a `name`, its value is usually not sent with the form.

### `id`

Gives a unique identifier to an element.

```html
<input id="email" type="email" name="email">
```

The `id` is commonly used with:

- labels
- CSS
- JavaScript

### `value`

Defines the default value of an input.

```html
<input type="text" name="city" value="Kolkata">
```

For radio and checkbox inputs, `value` defines what data is submitted.

```html
<input type="radio" name="gender" value="male">
```

### `placeholder`

Shows hint text inside an input.

```html
<input type="text" placeholder="Enter your name">
```

Important:

- placeholder is not a replacement for label
- placeholder disappears when the user types

### `required`

Makes a field mandatory.

```html
<input type="email" name="email" required>
```

The form cannot be submitted until this field is filled.

### `readonly`

Makes the input visible but not editable.

```html
<input type="text" value="India" readonly>
```

Readonly values are submitted with the form.

### `disabled`

Disables the input.

```html
<input type="text" value="Disabled field" disabled>
```

Important:

- disabled fields cannot be edited
- disabled fields are usually not submitted with the form

### `maxlength`

Sets the maximum number of characters.

```html
<input type="text" maxlength="20">
```

### `minlength`

Sets the minimum number of characters.

```html
<input type="password" minlength="8">
```

### `min`

Sets the minimum value for number, date, time, range, and similar inputs.

```html
<input type="number" min="1">
```

### `max`

Sets the maximum value.

```html
<input type="number" max="100">
```

### `step`

Defines valid number intervals.

```html
<input type="number" min="0" max="10" step="2">
```

Allowed values:

```text
0, 2, 4, 6, 8, 10
```

### `pattern`

Defines a regular expression that the input value must match.

```html
<input type="text" name="pin" pattern="[0-9]{6}">
```

This example accepts exactly 6 digits.

### `title`

Provides extra information. It is often used with `pattern` to explain the requirement.

```html
<input
  type="text"
  name="pin"
  pattern="[0-9]{6}"
  title="Enter a 6 digit PIN code"
>
```

### `checked`

Makes a radio button or checkbox selected by default.

```html
<input type="checkbox" name="subscribe" checked>
```

### `selected`

Makes an option selected by default.

```html
<option value="india" selected>India</option>
```

### `multiple`

Allows multiple values.

For file input:

```html
<input type="file" name="documents" multiple>
```

For email input:

```html
<input type="email" name="emails" multiple>
```

For select:

```html
<select name="skills" multiple>
  <option value="html">HTML</option>
  <option value="css">CSS</option>
</select>
```

### `accept`

Defines allowed file types for file upload.

```html
<input type="file" name="photo" accept="image/*">
```

Examples:

```html
<input type="file" accept=".pdf">
<input type="file" accept="image/png, image/jpeg">
```

### `size`

Defines the visible width of an input in characters.

```html
<input type="text" size="30">
```

### `autocomplete`

Controls browser autofill for an input.

```html
<input type="email" name="email" autocomplete="email">
```

Common autocomplete values:

- `name`
- `email`
- `username`
- `new-password`
- `current-password`
- `tel`
- `street-address`
- `country`

### `autofocus`

Automatically focuses an input when the page loads.

```html
<input type="text" name="username" autofocus>
```

Use it carefully. Usually only one element should have `autofocus`.

### `list`

Connects an input to a `<datalist>`.

```html
<input list="languages" name="language">

<datalist id="languages">
  <option value="HTML">
  <option value="CSS">
  <option value="JavaScript">
</datalist>
```

### `form`

Connects an input to a form by using the form's `id`.

```html
<form id="loginForm"></form>

<input type="text" name="username" form="loginForm">
```

This allows an input to belong to a form even if it is outside the `<form>` tag.

### `formaction`

Changes the submission URL for a specific submit button.

```html
<button type="submit" formaction="/save-draft">Save Draft</button>
```

### `formmethod`

Changes the method for a specific submit button.

```html
<button type="submit" formmethod="post">Submit with POST</button>
```

### `formenctype`

Changes the encoding type for a specific submit button.

```html
<button type="submit" formenctype="multipart/form-data">Upload</button>
```

### `formtarget`

Changes where the response opens for a specific submit button.

```html
<button type="submit" formtarget="_blank">Open Result in New Tab</button>
```

### `formnovalidate`

Skips validation for a specific submit button.

```html
<button type="submit" formnovalidate>Submit Without Validation</button>
```

## 7. Form Validation

Form validation checks if the user entered correct data before submitting.

There are two common types:

- client-side validation
- server-side validation

### Client-side validation

Client-side validation happens in the browser.

Examples:

```html
<input type="email" required>
<input type="password" minlength="8">
<input type="number" min="18">
```

Client-side validation gives quick feedback to the user.

### Server-side validation

Server-side validation happens on the backend server.

It is required because users can bypass browser validation.

Important rule:

Always validate important data on the server also.

## 8. Common Validation Requirements

### Required field

```html
<input type="text" name="name" required>
```

### Email requirement

```html
<input type="email" name="email" required>
```

### Password length requirement

```html
<input type="password" name="password" minlength="8" maxlength="12" required>
```

### Number range requirement

```html
<input type="number" name="age" min="18" max="60" required>
```

### Date range requirement

```html
<input type="date" name="dob" min="1990-01-01" max="2026-12-31">
```

### Pattern requirement

```html
<input
  type="text"
  name="username"
  pattern="[A-Za-z0-9_]{4,12}"
  title="Username must be 4 to 12 characters and can contain letters, numbers, and underscore"
  required
>
```

### Phone number requirement example

```html
<input
  type="tel"
  name="phone"
  pattern="[0-9]{10}"
  title="Enter a 10 digit phone number"
  required
>
```

### Terms and conditions requirement

```html
<input type="checkbox" id="terms" name="terms" required>
<label for="terms">I accept the terms and conditions</label>
```

## 9. Labels and Accessibility Requirements

Good forms should be easy for everyone to use.

Important requirements:

- every input should have a label
- label `for` should match input `id`
- each `id` should be unique
- related radio buttons and checkboxes should be grouped with `<fieldset>`
- fieldsets should have a `<legend>`
- do not use placeholder as the only label
- required fields should be clearly marked
- error messages should be clear
- use correct input types like `email`, `tel`, `number`, and `date`

Good example:

```html
<label for="email">Email:</label>
<input type="email" id="email" name="email" required>
```

Bad example:

```html
<input type="text" placeholder="Email">
```

The bad example has no proper label.

## 10. Name, ID, and Label Difference

### `name`

Used when submitting form data.

```html
<input name="email">
```

Submitted data:

```text
email=user@example.com
```

### `id`

Used to uniquely identify the element in HTML, CSS, JavaScript, and labels.

```html
<input id="email">
```

### `label for`

Used to connect a label to an input.

```html
<label for="email">Email</label>
<input id="email" name="email">
```

## 11. Form Data Example

HTML:

```html
<form action="/register" method="post">
  <input type="text" name="username" value="john">
  <input type="email" name="email" value="john@example.com">
  <button type="submit">Submit</button>
</form>
```

Submitted data:

```text
username=john
email=john@example.com
```

Only form controls with a `name` attribute are submitted.

## 12. Buttons in Forms

### Submit button

```html
<button type="submit">Submit</button>
```

Submits the form.

### Reset button

```html
<button type="reset">Reset</button>
```

Resets the form.

### Normal button

```html
<button type="button">Show Password</button>
```

Used with JavaScript.

Important:

Inside a form, a `<button>` without a `type` usually behaves like `type="submit"`.

So it is safer to write the type clearly.

```html
<button type="button">Normal Button</button>
```

## 13. Complete Registration Form Example

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registration Form</title>
</head>
<body>
  <h1>Registration Form</h1>

  <form action="/register" method="post" autocomplete="on">
    <fieldset>
      <legend>Personal Details</legend>

      <label for="fullname">Full Name:</label>
      <input
        type="text"
        id="fullname"
        name="fullname"
        placeholder="John Doe"
        required
      >
      <br><br>

      <label for="email">Email:</label>
      <input
        type="email"
        id="email"
        name="email"
        placeholder="john@example.com"
        autocomplete="email"
        required
      >
      <br><br>

      <label for="phone">Phone:</label>
      <input
        type="tel"
        id="phone"
        name="phone"
        pattern="[0-9]{10}"
        title="Enter a 10 digit phone number"
        required
      >
      <br><br>

      <label for="dob">Date of Birth:</label>
      <input type="date" id="dob" name="dob" required>
    </fieldset>

    <br>

    <fieldset>
      <legend>Account Details</legend>

      <label for="username">Username:</label>
      <input
        type="text"
        id="username"
        name="username"
        minlength="4"
        maxlength="12"
        required
      >
      <br><br>

      <label for="password">Password:</label>
      <input
        type="password"
        id="password"
        name="password"
        minlength="8"
        maxlength="12"
        required
      >
    </fieldset>

    <br>

    <fieldset>
      <legend>Gender</legend>

      <input type="radio" id="male" name="gender" value="male" required>
      <label for="male">Male</label>

      <input type="radio" id="female" name="gender" value="female">
      <label for="female">Female</label>

      <input type="radio" id="other" name="gender" value="other">
      <label for="other">Other</label>
    </fieldset>

    <br>

    <label for="course">Choose Course:</label>
    <select id="course" name="course" required>
      <option value="">Select a course</option>
      <option value="html">HTML</option>
      <option value="css">CSS</option>
      <option value="javascript">JavaScript</option>
    </select>

    <br><br>

    <label for="message">Message:</label>
    <br>
    <textarea id="message" name="message" rows="4" cols="30"></textarea>

    <br><br>

    <input type="checkbox" id="terms" name="terms" required>
    <label for="terms">I accept the terms and conditions</label>

    <br><br>

    <button type="reset">Reset</button>
    <button type="submit">Register</button>
  </form>
</body>
</html>
```

## 14. File Upload Form Example

```html
<form action="/upload" method="post" enctype="multipart/form-data">
  <label for="resume">Upload Resume:</label>
  <input type="file" id="resume" name="resume" accept=".pdf,.doc,.docx" required>

  <button type="submit">Upload</button>
</form>
```

Important requirements for file upload:

- use `method="post"`
- use `enctype="multipart/form-data"`
- use `input type="file"`
- use `accept` if only certain file types are allowed
- validate file type and file size on the server also

## 15. Login Form Example

```html
<form action="/login" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" autocomplete="username" required>

  <br><br>

  <label for="password">Password:</label>
  <input
    type="password"
    id="password"
    name="password"
    autocomplete="current-password"
    required
  >

  <br><br>

  <button type="submit">Login</button>
</form>
```

## 16. Search Form Example

```html
<form action="/search" method="get">
  <label for="query">Search:</label>
  <input type="search" id="query" name="query" placeholder="Search here">

  <button type="submit">Search</button>
</form>
```

Search forms commonly use `method="get"` because search results can be shared or bookmarked.

## 17. Common Mistakes

### Mistake 1: Using `label` as an input attribute

Incorrect:

```html
<input type="text" label="Enter name">
```

Correct:

```html
<label for="name">Enter name:</label>
<input type="text" id="name" name="name">
```

### Mistake 2: Using `type="mail"`

Incorrect:

```html
<input type="mail">
```

Correct:

```html
<input type="email">
```

### Mistake 3: Spelling `minlength` incorrectly

Incorrect:

```html
<input type="password" minlengh="8">
```

Correct:

```html
<input type="password" minlength="8">
```

### Mistake 4: Not adding `name`

Incorrect:

```html
<input type="email" id="email">
```

Correct:

```html
<input type="email" id="email" name="email">
```

Without `name`, the input value is usually not submitted.

### Mistake 5: Giving different names to radio buttons in the same group

Incorrect:

```html
<input type="radio" name="male">
<input type="radio" name="female">
```

Correct:

```html
<input type="radio" name="gender" value="male">
<input type="radio" name="gender" value="female">
```

### Mistake 6: Using placeholder instead of label

Incorrect:

```html
<input type="text" placeholder="Username">
```

Correct:

```html
<label for="username">Username:</label>
<input type="text" id="username" name="username" placeholder="Enter username">
```

### Mistake 7: Sending passwords with GET

Incorrect:

```html
<form method="get">
  <input type="password" name="password">
</form>
```

Correct:

```html
<form method="post">
  <input type="password" name="password">
</form>
```

## 18. Best Practices

- Use the correct input type.
- Always use labels for inputs.
- Use `name` for every field that should be submitted.
- Use unique `id` values.
- Use `required` for mandatory fields.
- Use `minlength`, `maxlength`, `min`, and `max` where needed.
- Use `pattern` only when a simple input type is not enough.
- Use `fieldset` and `legend` for grouped fields.
- Use `POST` for private or sensitive data.
- Use `GET` for search and filter forms.
- Use `enctype="multipart/form-data"` for file uploads.
- Do not trust only browser validation.
- Validate important data on the server.
- Do not use placeholder as the only label.
- Clearly set button types.
- Keep forms simple and easy to understand.

## 19. Quick Reference Table

| Tag or Attribute | Use |
|---|---|
| `<form>` | Creates a form |
| `<input>` | Creates an input field |
| `<label>` | Adds a label for an input |
| `<textarea>` | Creates a multi-line text box |
| `<select>` | Creates a dropdown |
| `<option>` | Adds an option in dropdown |
| `<button>` | Creates a button |
| `<fieldset>` | Groups related form fields |
| `<legend>` | Gives a title to a fieldset |
| `action` | Defines where form data is sent |
| `method` | Defines how form data is sent |
| `name` | Defines the submitted data key |
| `id` | Uniquely identifies an element |
| `type` | Defines input type |
| `value` | Defines input value |
| `placeholder` | Shows hint text |
| `required` | Makes field mandatory |
| `readonly` | Makes field non-editable but submitted |
| `disabled` | Disables field and usually prevents submission |
| `minlength` | Minimum text length |
| `maxlength` | Maximum text length |
| `min` | Minimum numeric/date value |
| `max` | Maximum numeric/date value |
| `step` | Number interval |
| `pattern` | Regex validation rule |
| `checked` | Default selected checkbox/radio |
| `selected` | Default selected option |
| `multiple` | Allows multiple values |
| `accept` | Defines accepted file types |
| `autocomplete` | Controls browser autofill |

## 20. Conclusion

HTML forms are used to collect user input. A good form should be clear, accessible, and validated properly.

Remember:

- `<form>` is the main container.
- `<input>`, `<textarea>`, `<select>`, and `<button>` are common form controls.
- `name` is required for submitted data.
- labels are important for usability and accessibility.
- browser validation helps, but server validation is still required.
