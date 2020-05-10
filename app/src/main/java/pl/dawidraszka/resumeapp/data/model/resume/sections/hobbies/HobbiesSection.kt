package pl.dawidraszka.resumeapp.data.model.resume.sections.hobbies

data class HobbiesSection (val hobbies : Array<String>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HobbiesSection

        if (!hobbies.contentEquals(other.hobbies)) return false

        return true
    }

    override fun hashCode(): Int {
        return hobbies.contentHashCode()
    }
}