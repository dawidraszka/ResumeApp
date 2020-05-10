package pl.dawidraszka.resumeapp.data.model.resume.sections.volunteerwork

import java.util.*

data class VolunteerWork(
    val title: String? = null,
    val organization: String? = null,
    val city: String? = null,
    val startDate: Date? = null,
    val endDate: Date? = null,
    val details: List<String>? = null
)
