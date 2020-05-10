package pl.dawidraszka.resumeapp.data.model.resume.sections.volunteerwork

import java.util.*

data class VolunteerWork(
    val title: String, val organization: String, val city: String,
    val startDate: Date, val endDate: Date?, val details: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VolunteerWork

        if (title != other.title) return false
        if (organization != other.organization) return false
        if (city != other.city) return false
        if (startDate != other.startDate) return false
        if (endDate != other.endDate) return false
        if (!details.contentEquals(other.details)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + organization.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + startDate.hashCode()
        result = 31 * result + (endDate?.hashCode() ?: 0)
        result = 31 * result + details.contentHashCode()
        return result
    }
}