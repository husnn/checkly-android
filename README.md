# Checkly

Checkly allows simpler, modern and intuitive implementation of selectable tags.

![](https://s1.gifyu.com/images/checkly-demo-1.gif)

# Features

  - Easier, more fun selection
  - Enhance UX
  - Encourage & increase interactions

# Why Checkly?

  - Visually appealing
  - Great performance
  - Clean code

# Gradle
Easily add the dependency through Gradle by adding the line below in your build.gradle file.

```
dependencies {
    implementation "com.husnainjaved.checkly:1.0.0"
}
```

# Usage

##### ChecklyView
The main view presented to the user, containing a list of options.
| Function | Input | Output | Explanation |
|-	|-	|-	|- |
| createTag() | String | ChecklyOption | Create a ChecklyOption from a label
| addTag() | String | null | Create a tag from given label using createTag() and add it to view
| addOption() | ChecklyOption | null | Add given ChecklyOption to the view
| setOptions() | List<ChecklyOption> | null | Replace all options with a new list of ChecklyOption
| createTagList() | List<String> | List<ChecklyOption> | Create list of ChecklyOption given a list of labels
| setLabels() | List<String> | null | Replace existing options with a list of newly created ChecklyOption from a list of labels

##### ChecklyOption
Data model used by ChecklyView.
| Field | Type | Explanation |
|-	|-	|-
| id | String | A randomly generated identifier assigned to each option 
| name | String | Name/label for the tag
| selected | Boolean | Indicates whether the option is selected/unselected

### Example

```
val checkly = findViewById<ChecklyView>(R.id.checkly)

val choices = listOf(
        "Business",
        "Entertainment",
        "Finance",
        "Marketing",
        "Technology",
        "Sports"
    )

// Create and set options from a list of string labels
checkly.setLabels(choices)

checkly.selectionListener = object : ChecklySelectionListener {
    override fun onOptionToggled(option: ChecklyOption) {
        ...
        // EXAMPLE - Show toast when a tag is selected/unselected
        val selectedText = if (option.selected) "selected" else "unselected"
        Toast.makeText(applicationContext, "${option.name} was $selectedText", Toast.LENGTH_SHORT).show()
    }
    
    override fun onOptionsUpdated(options: List<ChecklyOption>) {
        ...
        // EXAMPLE - Filter out the selected options and make an array out of their names/labels
        selectedInterests = options.filter { it.selected }.map { it.name }
    }
}
````

# License

```
MIT License

Copyright (c) 2020 Husnain Javed

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```