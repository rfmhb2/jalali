package jalali.interfaces


interface Boundaries : Date {
    fun startMinute() {
        setTime(hour, minute, 0)
    }

    fun endMinute() {
        setTime(hour, minute, 59)
    }

    fun startHour() {
        setTime(hour, 0, 0)
    }

    fun endHour() {
        setTime(hour, 59, 59)
    }

    fun startDay() {
        setTime(0, 0, 0)
    }

    fun endDay() {
        setTime(23, 59, 59)
    }

    fun startMonth() {
        setDateTime(year, month, 1, 0, 0, 0)
    }

    fun endMonth() {
        setDateTime(year, month, daysInMonth, 23, 59, 59)
    }

    fun startYear() {
        setDateTime(year, 1, 1, 0, 0, 0)
    }

    fun endYear() {
        val day = if (isLeapYear(year)) {
            30
        } else {
            29
        }
        setDateTime(year, 12, day, 23, 59, 59)
    }
}