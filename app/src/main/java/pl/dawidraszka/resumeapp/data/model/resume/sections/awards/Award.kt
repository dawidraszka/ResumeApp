package pl.dawidraszka.resumeapp.data.model.resume.sections.awards

import pl.dawidraszka.resumeapp.data.model.resume.SimpleDate
import pl.dawidraszka.resumeapp.data.model.resume.sections.ComplexItem
import pl.dawidraszka.resumeapp.data.model.resume.sections.Complexable

data class Award(
    val title: String? = null,
    val city: String? = null,
    val date: SimpleDate? = null,
    val details: List<String>? = null
) : Complexable {
    override fun toComplexItem(): ComplexItem = ComplexItem(
        title, "$date",
        "$city", details
    )
}