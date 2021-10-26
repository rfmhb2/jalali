package jalali

import java.time.LocalDateTime
import kotlin.test.Test
import kotlin.test.assertEquals

class AccessTest {
    private val datetime: LocalDateTime = LocalDateTime.of(2021, 10, 24, 20, 12, 50)

    @Test
    fun getProperty() {
        val jalali = Jalali(datetime)
        assertEquals(jalali.year, 1400)
        assertEquals(jalali.month, 8)
        assertEquals(jalali.day, 2)
        assertEquals(jalali.hour, 20)
        assertEquals(jalali.minute, 12)
        assertEquals(jalali.second, 50)
        assertEquals(jalali.dayOfWeek, 2)
        assertEquals(jalali.daysInMonth, 30)
        assertEquals(jalali.getTimestamp(), 1635093770)
    }

    @Test
    fun setProperty() {
        val jalali = Jalali(datetime)
        jalali.year = 1398
        assertEquals(jalali.year, 1398)

        jalali.month = 12
        assertEquals(jalali.month, 12)

        jalali.day = 15
        assertEquals(jalali.day, 15)

        jalali.hour = 13
        assertEquals(jalali.hour, 13)

        jalali.minute = 50
        assertEquals(jalali.minute, 50)

        jalali.second = 45
        assertEquals(jalali.second, 45)

        jalali.setTimestamp(1546382684)
        assertEquals(jalali.getTimestamp(), 1546382684)
    }

    @Test
    fun setDateTime() {
        val jalali = Jalali(datetime)
        jalali.setDateTime(1390, 11, 15, 12, 10, 8)
        assertEquals(1390, jalali.year)
        assertEquals(11, jalali.month)
        assertEquals(15, jalali.day)
        assertEquals(12, jalali.hour)
        assertEquals(10, jalali.minute)
        assertEquals(8, jalali.second)
    }

    @Test
    fun setDate() {
        val jalali = Jalali(datetime)
        jalali.setDate(1390, 11, 15)
        assertEquals(1390, jalali.year)
        assertEquals(11, jalali.month)
        assertEquals(15, jalali.day)
    }

    @Test
    fun setTime() {
        val jalali = Jalali(datetime)
        jalali.setTime(12, 10, 8)
        assertEquals(12, jalali.hour)
        assertEquals(10, jalali.minute)
        assertEquals(8, jalali.second)
    }

}