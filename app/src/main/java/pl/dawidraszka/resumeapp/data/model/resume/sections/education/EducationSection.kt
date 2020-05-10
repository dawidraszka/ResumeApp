package pl.dawidraszka.resumeapp.data.model.resume.sections.education

data class EducationSection(val schools : Array<School>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EducationSection

        if (!schools.contentEquals(other.schools)) return false

        return true
    }

    override fun hashCode(): Int {
        return schools.contentHashCode()
    }
}