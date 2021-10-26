package jalali.interfaces

import java.time.LocalDateTime
import jalali.Transformation.getGregorian as getGregorian

interface Modification : Date {

    fun addDay() {
        dateTime = dateTime.plusDays(1)
        loadFromDateTime()
    }

    fun subDay() {
        dateTime = dateTime.minusDays(1)
        loadFromDateTime()
    }

    fun isLeapYear(): Boolean {
        return (year % 33) in arrayOf(1, 5, 9, 13, 17, 22, 26, 30)
    }

    fun addMonths(value: Int) {
        month += value
        if (month > 12) {
            year += month / 12
            month %= 12
        } else if (month < 1) {
            year += (month / 12) - 1
            month = 12 + (month % 12)
        }
        if (month == 0) {
            year--
            month = 12
        }
        if (month > 6 && month < 12 && day == 31) {
            day--
        } else {
            if (month == 12 && (day == 30 || day == 31)) {
                day = if (isLeapYear()) 30 else 29
            }
        }
        val (gyear, gmonth, gday) = getGregorian(
            year,
            month,
            day
        )
        this.dateTime = LocalDateTime.of(gyear, gmonth, gday, dateTime.hour, dateTime.minute)
    }

    fun addMonth() {
        addMonths(1)
    }

    fun subMonths(value: Int) {
        addMonths(value * -1)
    }

    fun subMonth() {
        addMonths(-1)
    }

    fun addYear() {
        addYears(1)
    }

    fun addYears(value: Long) {
        year += value.toInt()
        setLocalDateTime()
    }

    fun subYears(value: Long) {
        year -= value.toInt()
        setLocalDateTime()
    }

    fun subYear() {
        subYears(1)
    }

    fun addHours(value: Long) {
        dateTime = dateTime.plusHours(value)
        loadFromDateTime()
    }

    fun addHour() {
        addHours(1)
    }

    fun subHours(value: Long) {
        dateTime = dateTime.minusHours(value)
        loadFromDateTime()
    }

    fun subHour() {
        subHours(1)
    }

    fun addMinutes(value: Long) {
        dateTime = dateTime.plusMinutes(value)
        loadFromDateTime()
    }

    fun addMinute() {
        addMinutes(1)
    }

    fun subMinutes(value: Long) {
        dateTime = dateTime.minusMinutes(value)
        loadFromDateTime()
    }

    fun subMinute() {
        subMinutes(1)
    }

    fun addSeconds(value: Long) {
        dateTime = dateTime.plusSeconds(value)
        loadFromDateTime()
    }

    fun addSecond() {
        addSeconds(1)
    }

    fun subSeconds(value: Long) {
        dateTime = dateTime.minusSeconds(value)
        loadFromDateTime()
    }

    fun subSecond() {
        subSeconds(1)
    }

}