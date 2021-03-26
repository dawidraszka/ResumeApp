package pl.dawidraszka.resumeapp.data.model.resume.sections.workexperience

import com.google.firebase.Timestamp
import pl.dawidraszka.resumeapp.data.model.resume.SimpleDatePeriod
import pl.dawidraszka.resumeapp.data.model.resume.sections.ComplexItem
import pl.dawidraszka.resumeapp.data.model.resume.sections.Complexable

data class WorkExperience(
    val jobTitle: String? = null,
    val company: String? = null,
    val city: String? = null,
    val startDateTimestamp: Timestamp? = null,
    val endDateTimestamp: Timestamp? = null,
    val details: List<String>? = null
) : Complexable {
    override fun toComplexItem(): ComplexItem =
        ComplexItem(
            jobTitle,
            SimpleDatePeriod(startDateTimestamp, endDateTimestamp).toString(),
            "$company • $city",
            details
        )

}