package pl.dawidraszka.resumeapp.data.resume.model.resume.sections.workexperience

data class WorkExperienceSection(val workExperience : Array<WorkExperience>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WorkExperienceSection

        if (!workExperience.contentEquals(other.workExperience)) return false

        return true
    }

    override fun hashCode(): Int {
        return workExperience.contentHashCode()
    }
}