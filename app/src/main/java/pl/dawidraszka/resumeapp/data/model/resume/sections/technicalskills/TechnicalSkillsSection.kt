package pl.dawidraszka.resumeapp.data.model.resume.sections.technicalskills

data class TechnicalSkillsSection(val technicalSkills : Array<String>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TechnicalSkillsSection

        if (!technicalSkills.contentEquals(other.technicalSkills)) return false

        return true
    }

    override fun hashCode(): Int {
        return technicalSkills.contentHashCode()
    }
}