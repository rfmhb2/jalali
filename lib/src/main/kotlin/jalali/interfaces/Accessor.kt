package jalali.interfaces


import jalali.lang.fa
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

interface Accessor : Date {

    fun getGregorianYear(): Int {
        return dateTime.year
    }

    fun getGregorianMonth(): Int {
        return dateTime.monthValue
    }

    fun getGregorianDay(): Int {
        return dateTime.dayOfMonth
    }

    fun getTimestamp(): Long {
        val zoneId = ZoneId.of(fa.zoneId)
        return dateTime.atZone(zoneId).toEpochSecond()
    }

    fun setTimestamp(timestamp: Long) {
        dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of(fa.zoneId))
        loadFromDateTime()
    }


}