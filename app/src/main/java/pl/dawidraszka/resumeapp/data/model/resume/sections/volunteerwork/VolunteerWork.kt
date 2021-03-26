package pl.dawidraszka.resumeapp.data.model.resume.sections.volunteerwork

import com.google.firebase.Timestamp
import pl.dawidraszka.resumeapp.data.model.resume.SimpleDatePeriod
import pl.dawidraszka.resumeapp.data.model.resume.sections.ComplexItem
import pl.dawidraszka.resumeapp.data.model.resume.sections.Complexable

data class VolunteerWork(
    val title: String? = null,
    val organization: String? = null,
    val city: String? = null,
    val startDateTimestamp: Timestamp? = null,
    val endDateTimestamp: Timestamp? = null,
    val details: List<String>? = null
) : Complexable {
    override fun toComplexItem(): ComplexItem = ComplexItem(
        title, SimpleDatePeriod(startDateTimestamp, endDateTimestamp).toString(),
        "$organization • $city", details
    )
}