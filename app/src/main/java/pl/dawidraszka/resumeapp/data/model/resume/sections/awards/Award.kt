package pl.dawidraszka.resumeapp.data.model.resume.sections.awards

import pl.dawidraszka.resumeapp.data.model.resume.SimpleDate

data class Award(
    val title: String? = null,
    val city: String? = null,
    val date: SimpleDate? = null,
    val details: List<String>? = null
)