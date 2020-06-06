package pl.dawidraszka.resumeapp.data.model.resume.sections

data class ComplexItem(val title: String?, val dates: String?, val description: String?, val details: List<String>?)

interface Complexable{
    fun toComplexItem() : ComplexItem
}