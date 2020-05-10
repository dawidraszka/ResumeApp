package pl.dawidraszka.resumeapp.data.model.resume.sections.skills

data class SkillsSection(val skills : Array<String>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SkillsSection

        if (!skills.contentEquals(other.skills)) return false

        return true
    }

    override fun hashCode(): Int {
        return skills.contentHashCode()
    }
}