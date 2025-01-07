package com.example.mozanmap.data

data class ClassItem(val title: String, val details: List<String>)

object ClassData {
    val classItems = listOf(
        ClassItem("Class 1", listOf("Detail 1-1", "Detail 1-2", "Detail 1-3")),
        ClassItem("Class 2", listOf("Detail 2-1", "Detail 2-2")),
        ClassItem("Class 3", listOf("Detail 3-1"))
    )
}
