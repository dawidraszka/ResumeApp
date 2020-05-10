package pl.dawidraszka.resumeapp.data.model.resume.sections.workexperience

import java.util.*

data class WorkExperience(
    val jobTitle: String? = null,
    val company: String? = null,
    val city: String? = null,
    val startDate: Date? = null,
    val endDate: Date? = null,
    val details: List<String>? = null
)