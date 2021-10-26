package jalali.interfaces


import jalali.Constants
import jalali.Jalali
import jalali.lang.fa

interface Comparison : Date {

    fun isValidDate(year: Int, month: Int, day: Int): Boolean {
        if (year < 0 || year > 32766) {
            return false
        }
        if (month < 1 || month > 12) {
            return false
        }
        val dayLastMonthJalali =
            if (isLeapYear(year) && (month == 12)) 30 else Constants.daysMonthJalali[month - 1]
        if (day < 1 || day > dayLastMonthJalali) {
            return false
        }
        return true
    }

    fun isValidTime(hour: Int, minute: Int, second: Int): Boolean {
        return hour in 0..23
                && minute >= 0 && minute <= 59
                && second >= 0 && second <= 59
    }

    fun equalTo(Jalali: Jalali): Boolean {
        return dateTime.isEqual(Jalali.dateTime)
    }

    fun greaterThan(Jalali: Jalali): Boolean {
        return dateTime.isAfter(Jalali.dateTime)
    }

    fun greaterThanOrEqual(Jalali: Jalali): Boolean {
        return (greaterThan(Jalali) || equalTo(Jalali))
    }

    fun lessThan(Jalali: Jalali): Boolean {
        return dateTime.isBefore(Jalali.dateTime)
    }

    fun lessThanOrEqual(Jalali: Jalali): Boolean {
        return (lessThan(Jalali) || equalTo(Jalali))
    }

    fun between(jalali1: Jalali, jalali2: Jalali, equal: Boolean = true): Boolean {
        var v1 = jalali1
        var v2 = jalali2
        if (v1.greaterThan(v2)) {
            v1 = jalali2
            v2 = jalali1
        }
        if (equal) {
            return greaterThanOrEqual(v1) && lessThanOrEqual(v2)
        }

        return greaterThan(v1) && lessThan(v2)
    }

    fun isWeekend(): Boolean {
        return fa.weekendDays.contains(dayOfWeek)
    }

    private fun isSameDate(Jalali: Jalali): Boolean {
        return Jalali.year == year && Jalali.month == month && Jalali.day == day
    }

    fun isYesterday(): Boolean {
        val Jalali = Jalali()
        Jalali.subDay()
        return isSameDate(Jalali)
    }

    fun isToday(): Boolean {
        val today = Jalali()
        return isSameDate(today)
    }

    fun isTomorrow(): Boolean {
        val tomorrow = Jalali()
        tomorrow.addDay()
        return isSameDate(tomorrow)
    }

    fun isSaturday(): Boolean {
        val dayOfWeek: Int = fa.gToPDayOfWeek[dateTime.dayOfWeek.value]!!
        return dayOfWeek == Constants.SATURDAY
    }

    fun isSunday(): Boolean {
        val dayOfWeek: Int = fa.gToPDayOfWeek[dateTime.dayOfWeek.value]!!
        return dayOfWeek == Constants.SUNDAY
    }

    fun isMonday(): Boolean {
        val dayOfWeek: Int = fa.gToPDayOfWeek[dateTime.dayOfWeek.value]!!
        return dayOfWeek == Constants.MONDAY
    }

    fun isTuesday(): Boolean {
        val dayOfWeek: Int = fa.gToPDayOfWeek[dateTime.dayOfWeek.value]!!
        return dayOfWeek == Constants.TUESDAY
    }

    fun isWednesday(): Boolean {
        val dayOfWeek: Int = fa.gToPDayOfWeek[dateTime.dayOfWeek.value]!!
        return dayOfWeek == Constants.WEDNESDAY
    }

    fun isThursday(): Boolean {
        val dayOfWeek: Int = fa.gToPDayOfWeek[dateTime.dayOfWeek.value]!!
        return dayOfWeek == Constants.THURSDAY
    }

    fun isFriday(): Boolean {
        val dayOfWeek: Int = fa.gToPDayOfWeek[dateTime.dayOfWeek.value]!!
        return dayOfWeek == Constants.FRIDAY
    }
}