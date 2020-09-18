package com.husnainjaved.checkly

interface ChecklySelectionListener {
    fun onOptionToggled(option: ChecklyOption) {}
    fun onOptionsUpdated(options: List<ChecklyOption>)
}