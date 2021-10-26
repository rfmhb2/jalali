package jalali

import org.junit.Test
import kotlin.test.assertEquals

class Modification {
    val jalali = Jalali(1400, 8, 3, 20, 52, 1)

    @Test
    fun addYears() {
        jalali.addYears(5)
        assertEquals("1405-8-3 20:52:1", jalali.formatDateTime())

        jalali.addYears(20)
        assertEquals("1425-8-3 20:52:1", jalali.formatDateTime())
    }

    @Test
    fun subYears() {
        jalali.subYears(5)
        assertEquals("1395-8-3 20:52:1", jalali.formatDateTime())

        jalali.subYears(20)
        assertEquals("1375-8-3 20:52:1", jalali.formatDateTime())
    }

    @Test
    fun addMonths() {
        jalali.addMonths(5)
        assertEquals("1401-1-3 20:52:1", jalali.formatDateTime())

        jalali.addMonths(12)
        assertEquals("1402-1-3 20:52:1", jalali.formatDateTime())

        jalali.addMonths(2)
        assertEquals("1402-3-3 20:52:1", jalali.formatDateTime())

        jalali.addMonths(23)
        assertEquals("1404-2-3 20:52:1", jalali.formatDateTime())

        jalali.addMonths(1)
        assertEquals("1404-3-3 20:52:1", jalali.formatDateTime())
    }

    @Test
    fun subMonths() {
        jalali.subMonths(5)
        assertEquals("1400-3-3 20:52:1", jalali.formatDateTime())

        jalali.subMonths(12)
        assertEquals("1399-3-3 20:52:1", jalali.formatDateTime())

        jalali.subMonths(2)
        assertEquals("1399-1-3 20:52:1", jalali.formatDateTime())
    }

    @Test
    fun addHours() {
        jalali.addHours(1)
        assertEquals("1400-8-3 21:52:1", jalali.formatDateTime())

        jalali.addHours(5)
        assertEquals("1400-8-4 2:52:1", jalali.formatDateTime())

        jalali.addHours(48)
        assertEquals("1400-8-6 2:52:1", jalali.formatDateTime())

        jalali.addHours(5)
        assertEquals("1400-8-6 7:52:1", jalali.formatDateTime())
    }

    @Test
    fun subHours() {
        jalali.subHours(1)
        assertEquals("1400-8-3 19:52:1", jalali.formatDateTime())

        jalali.subHours(18)
        assertEquals("1400-8-3 1:52:1", jalali.formatDateTime())

        jalali.subHours(1)
        assertEquals("1400-8-3 0:52:1", jalali.formatDateTime())

        jalali.subHours(1)
        assertEquals("1400-8-2 23:52:1", jalali.formatDateTime())
    }

}