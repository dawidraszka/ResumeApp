package pl.dawidraszka.resumeapp.data.model.resume.sections.workexperience

import pl.dawidraszka.resumeapp.data.model.resume.SimpleDate
import pl.dawidraszka.resumeapp.data.model.resume.sections.ComplexItem
import pl.dawidraszka.resumeapp.data.model.resume.sections.Complexable

data class WorkExperience(
    val jobTitle: String? = null,
    val company: String? = null,
    val city: String? = null,
    val startDate: SimpleDate? = null,
    val endDate: SimpleDate? = null,
    val details: List<String>? = null
): Complexable {
    override fun toComplexItem(): ComplexItem = ComplexItem(
        jobTitle, "$startDate - $endDate",
        "$company*$city", details
    )
}