package jalali.interfaces

import jalali.Constants
import jalali.lang.fa

interface Formatting : Date {
    private fun characterFormat(char: Char): String {
        return when (char) {
            'Y' -> year.toString()
            'y' -> year.toString().substring(2)
            'm' -> month.toString()
            'M' -> fa.year_months[month]!!
            'd' -> day.toString()
            'h' -> hour.toString()
            'l' -> (if (hour > 12) hour - 12 else hour).toString()
            'i' -> minute.toString()
            's' -> second.toString()
            'w' -> fa.gToPDayOfWeek[dateTime.dayOfWeek.value].toString()
            'W' -> fa.weekdays[fa.gToPDayOfWeek[dateTime.dayOfWeek.value]]!!
            'a' -> fa.weekdays[fa.gToPDayOfWeek[dateTime.dayOfWeek.value]]!!.substring(0, 1)
            else -> char.toString()
        }
    }

    fun format(pattern: String): String {
        var result = ""
        var index = 0
        while (pattern.length > index) {
            result += characterFormat(pattern[index])
            index++
        }
        return result
    }

    fun formatDate(): String {
        return format("Y-m-d")
    }

    fun formatTime(): String {
        return format("h:i:s")
    }

    fun formatDateTime(): String {
        return format(Constants.DEFAULT_STRING_FORMAT)
    }
}