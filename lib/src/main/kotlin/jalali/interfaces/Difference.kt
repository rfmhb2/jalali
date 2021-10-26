package jalali.interfaces

import jalali.Constants
import jalali.Jalali
import java.time.Duration
import java.time.temporal.ChronoUnit

interface Difference : Date {
    fun diffYears(jalali: Jalali): Long {
        return ChronoUnit.YEARS.between(dateTime, jalali.dateTime)
    }

    fun diffMonths(jalali: Jalali): Long {
        return ChronoUnit.MONTHS.between(dateTime, jalali.dateTime)
    }

    fun diffDays(jalali: Jalali): Long {
        return ChronoUnit.DAYS.between(dateTime, jalali.dateTime)
    }

    fun diffWeeks(jalali: Jalali): Long {
        return ChronoUnit.DAYS.between(dateTime, jalali.dateTime).div(7)
    }

    fun diffSeconds(jalali: Jalali): Long {
        return ChronoUnit.SECONDS.between(dateTime, jalali.dateTime)
    }

    fun diffMinutes(jalali: Jalali): Long {
        return diffSeconds(jalali) / Constants.SECONDS_PER_MINUTE
    }

    fun diffHour(jalali: Jalali): Long {
        return diffMinutes(jalali) / Constants.MINUTES_PER_HOUR
    }
}