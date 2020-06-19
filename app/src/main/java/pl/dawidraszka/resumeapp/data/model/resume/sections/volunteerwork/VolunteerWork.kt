package pl.dawidraszka.resumeapp.data.model.resume.sections.volunteerwork

import pl.dawidraszka.resumeapp.data.model.resume.SimpleDate
import pl.dawidraszka.resumeapp.data.model.resume.sections.ComplexItem
import pl.dawidraszka.resumeapp.data.model.resume.sections.Complexable

data class VolunteerWork(
    val title: String? = null,
    val organization: String? = null,
    val city: String? = null,
    val startDate: SimpleDate? = null,
    val endDate: SimpleDate? = null,
    val details: List<String>? = null
) : Complexable {
    override fun toComplexItem(): ComplexItem = ComplexItem(
        title, "$startDate - $endDate",
        "$organization • $city", details
    )
}