package pl.dawidraszka.resumeapp.data.model.resume.sections.awards

import java.util.*

data class Award(
    val title: String? = null,
    val city: String? = null,
    val date: Date? = null,
    val details: List<String>? = null
)