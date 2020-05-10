package pl.dawidraszka.resumeapp.data.model.resume.sections.education

import java.util.*

data class School(
    val title: String? = null,
    val name: String? = null,
    val city: String? = null,
    val startDate: Date? = null,
    val endDate: Date? = null,
    val details: List<String>? = null
)