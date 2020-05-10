package pl.dawidraszka.resumeapp.data.model.resume.sections.volunteerwork

data class VolunteerWorkSection (val volunteerWork : Array<VolunteerWork>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VolunteerWorkSection

        if (!volunteerWork.contentEquals(other.volunteerWork)) return false

        return true
    }

    override fun hashCode(): Int {
        return volunteerWork.contentHashCode()
    }
}