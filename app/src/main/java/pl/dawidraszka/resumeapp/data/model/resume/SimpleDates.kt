package pl.dawidraszka.resumeapp.data.model.resume

import com.google.firebase.Timestamp
import java.util.*

data class SimpleDate(val timestamp: Timestamp?) {
    override fun toString(): String {
        var value = ""
        if (timestamp != null) {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timestamp.seconds * 1000
            val month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US)
            val year = calendar.get(Calendar.YEAR)
            value = "$month $year"
        }
        return value
    }
}

data class SimpleDatePeriod(val startDateTimestamp: Timestamp?, val endDateTimestamp: Timestamp?) {
    override fun toString(): String =
        if (endDateTimestamp == null) "${SimpleDate(startDateTimestamp)} - present"
        else "${SimpleDate(startDateTimestamp)} - ${SimpleDate(endDateTimestamp)}"
}