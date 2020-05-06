package pl.dawidraszka.resumeapp.data.resume.model.resume.sections.awards

import java.util.*

data class Award(
    val title: String, val city: String, val date: Date, val details: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Award

        if (title != other.title) return false
        if (city != other.city) return false
        if (date != other.date) return false
        if (!details.contentEquals(other.details)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + details.contentHashCode()
        return result
    }
}