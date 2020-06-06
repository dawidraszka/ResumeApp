package pl.dawidraszka.resumeapp.data.model.resume.sections.volunteerwork

import pl.dawidraszka.resumeapp.data.model.resume.SimpleDate

data class VolunteerWork(
    val title: String? = null,
    val organization: String? = null,
    val city: String? = null,
    val startDate: SimpleDate? = null,
    val endDate: SimpleDate? = null,
    val details: List<String>? = null
)
