package jalali


object Constants {
    /**
     * The day constants
     */
    const val SATURDAY = 1
    const val SUNDAY = 2
    const val MONDAY = 3
    const val TUESDAY = 4
    const val WEDNESDAY = 5
    const val THURSDAY = 6
    const val FRIDAY = 7

    /**
     * Number unit in date
     */
    val DECADE_PER_CENTURY = 10
    val YEARS_PER_DECADE = 10
    val MONTHS_PER_YEAR = 12
    const val MONTHS_PER_QUARTER: Int = 3
    val WEEKS_PER_YEAR = 52
    val WEEKS_PER_MONTH = 4.35
    val DAYS_PER_WEEK = 7
    val HOURS_PER_DAY = 24
    val MINUTES_PER_HOUR = 60
    val SECONDS_PER_MINUTE = 60

    /**
     * Word use in format datetime.
     */
    val DEFAULT_STRING_FORMAT = "Y-m-d h:i:s";

    /**
     * Word use in format datetime.
     */
    val DEFAULT_LOCALE = "fa"

    val daysMonthGregorian = arrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val daysMonthJalali = arrayOf(31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29)
}