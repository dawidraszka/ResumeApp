package pl.dawidraszka.resumeapp.data.model.resume.sections.awards

data class AwardsSection (val awards: Array<Award>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AwardsSection

        if (!awards.contentEquals(other.awards)) return false

        return true
    }

    override fun hashCode(): Int {
        return awards.contentHashCode()
    }
}