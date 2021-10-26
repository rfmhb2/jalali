package jalali.interfaces

import jalali.Transformation
import java.time.LocalDateTime

interface Date {
    var year: Int
    var month: Int
    var day: Int
    var hour: Int
    var minute: Int
    var second: Int
    var dateTime: LocalDateTime
    var dayOfWeek: Int
    var daysInMonth: Int
    fun loadFromDateTime() {
        val (pyear, pmonth, pday) = Transformation.getJalali(
            dateTime.year,
            dateTime.monthValue,
            dateTime.dayOfMonth
        )
        this.year = pyear
        this.month = pmonth
        this.day = pday
        this.hour = dateTime.hour
        this.minute = dateTime.minute
        this.second = dateTime.second
    }

    fun setLocalDateTime() {
        val (gyear, gmonth, gday) = Transformation.getGregorian(year, month, day)
        dateTime = LocalDateTime.of(gyear, gmonth, gday, hour, minute, second)
    }

    fun setDate(year: Int, month: Int, day: Int) {
        this.year = year
        this.month = month
        this.day = day
        setLocalDateTime()
    }

    fun setTime(hour: Int, minute: Int, second: Int) {
        this.hour = hour
        this.minute = minute
        this.second = second
        setLocalDateTime()
    }

    fun setDateTime(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int) {
        this.year = year
        this.month = month
        this.day = day
        this.hour = hour
        this.minute = minute
        this.second = second
        setLocalDateTime()
    }

    fun isLeapYear(year: Int): Boolean {
        return (year % 33) in arrayOf(1, 5, 9, 13, 17, 22, 26, 30)
    }

}