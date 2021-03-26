package pl.dawidraszka.resumeapp.data.model.resume.sections.awards

import com.google.firebase.Timestamp
import pl.dawidraszka.resumeapp.data.model.resume.SimpleDate
import pl.dawidraszka.resumeapp.data.model.resume.sections.ComplexItem
import pl.dawidraszka.resumeapp.data.model.resume.sections.Complexable

data class Award(
    val title: String? = null,
    val city: String? = null,
    val dateTimestamp: Timestamp? = null,
    val details: List<String>? = null
) : Complexable {
    override fun toComplexItem(): ComplexItem = ComplexItem(
        title, SimpleDate(dateTimestamp).toString(),
        "$city", details
    )
}