package pl.dawidraszka.resumeapp.data.model.resume

data class SimpleDate(val month: Month? = null, val year: Int? = null){
    override fun toString(): String {
        return "${month?.shortMonth} $year"
    }
}

enum class Month (val shortMonth: String){
    January ("Jan"),
    February("Feb"),
    March("Mar"),
    April("Apr"),
    May("May"),
    June("Jun"),
    July("Jul"),
    August("Aug"),
    September("Sep"),
    October("Oct"),
    November("Nov"),
    December("Dec")
}