package com.husnainjaved.checkly

data class ChecklyOption(
    val id: String,
    val name: String,
    var selected: Boolean = false
)