# Checkly

A simple, modern and intuitive implementation of selectable tags.

[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/Naereen/StrapDown.js/graphs/commit-activity)

![](https://s1.gifyu.com/images/checkly-demo-1.gif)

# Why Checkly?

  - Easier, more fun selection
  - Enhance UX
  - Encourage & increase interactions
  - Visually appealing
  - Great performance
  - Clean code

# Gradle
Easily add the dependency through Gradle.

```
allprojects {
	repositories {
		...
	  	maven { url 'https://jitpack.io' }
	}
}
```
```
dependencies {
	implementation 'com.github.HusnainJaved:checkly-android:1.0.0'
}
```

# Usage

##### ChecklyView
The main view presented to the user, containing a list of options.
| Function | Input | Output | Explanation |
|-	|-	|-	|- |
| createTag() | String | ChecklyOption | Create a ChecklyOption from a label
| addTag() | String | void | Create a tag from given label using createTag() and add it to view
| addOption() | ChecklyOption | void | Add given ChecklyOption to the view
| setOptions() | `List<ChecklyOption>` | void | Replace all options with a new list of ChecklyOption
| createTagList() | `List<String>` | `List<ChecklyOption>` | Create list of ChecklyOption given a list of labels
| setLabels() | `List<String>` | void | Replace existing options with a list of newly created ChecklyOption from a list of labels

##### ChecklyOption
Data model used by ChecklyView.
| Field | Type | Explanation |
|-	|-	|-
| id | String | A randomly generated identifier assigned to each option 
| name | String | Name/label for the tag
| selected | Boolean | Indicates whether the option is selected/unselected

### Example

```kotlin
val choices = listOf(
        "Business",
        "Entertainment",
        "Finance",
        "Marketing",
        "Technology",
        "Sports"
    )

val checkly = findViewById<ChecklyView>(R.id.checkly)

// Create and set options from a list of strings
checkly.setLabels(choices)

checkly.selectionListener = object : ChecklySelectionListener {
    override fun onOptionToggled(option: ChecklyOption) {
        ...
    }
    
    override fun onOptionsUpdated(options: List<ChecklyOption>) {
        ...
    }
}
````

# License

[![MIT license](https://img.shields.io/badge/License-MIT-blue.svg)](https://lbesson.mit-license.org/) [![Open Source Love svg1](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/)

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
