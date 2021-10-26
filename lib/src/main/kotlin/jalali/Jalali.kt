package jalali


import jalali.interfaces.*
import jalali.lang.fa
import java.time.LocalDateTime

class Jalali : Accessor, Modification, Formatting, Difference, Comparison {
    override var year: Int = 0
    override var month: Int = 0
    override var day: Int = 0
    override var hour: Int = 0
    override var minute: Int = 0
    override var second: Int = 0

    override var dateTime: LocalDateTime = LocalDateTime.now()
    override var dayOfWeek: Int
        get() = fa.gToPDayOfWeek[dateTime.dayOfWeek.value]!!
        set(value) {}
    override var daysInMonth: Int
        get() = Constants.daysMonthJalali[month]
        set(value) {}

    constructor(year: Int, month: Int, day: Int, hour: Int = 0, minute: Int = 0, second: Int = 0) {
        this.year = year
        this.month = month
        this.day = day
        this.hour = hour
        this.minute = minute
        this.second = second
        setLocalDateTime()
    }

    constructor() {
        now()
    }

    constructor(datetime: LocalDateTime) {
        this.dateTime = datetime
        loadFromDateTime()
    }

    fun now() {
        dateTime = LocalDateTime.now()
        loadFromDateTime()
    }

}