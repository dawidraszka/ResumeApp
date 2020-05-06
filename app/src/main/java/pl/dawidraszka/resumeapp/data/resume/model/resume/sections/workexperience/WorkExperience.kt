package pl.dawidraszka.resumeapp.data.resume.model.resume.sections.workexperience

import java.util.*

data class WorkExperience (val jobTitle: String, val company : String, val city : String,
                   val startDate: Date, val endDate: Date?, val details : Array<String>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WorkExperience

        if (jobTitle != other.jobTitle) return false
        if (company != other.company) return false
        if (city != other.city) return false
        if (startDate != other.startDate) return false
        if (endDate != other.endDate) return false
        if (!details.contentEquals(other.details)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = jobTitle.hashCode()
        result = 31 * result + company.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + startDate.hashCode()
        result = 31 * result + (endDate?.hashCode() ?: 0)
        result = 31 * result + details.contentHashCode()
        return result
    }
}