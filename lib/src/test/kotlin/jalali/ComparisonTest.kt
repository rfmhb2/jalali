package jalali

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ComparisonTest {
    private val jalali1 = Jalali(1400, 8, 1, 12, 1, 1)
    private val jalaliGreater = Jalali(1400, 9, 1, 12, 1, 1)
    private val jalaliLess = Jalali(1400, 6, 18, 13, 12, 10)

    @Test
    fun validDate() {
        assertTrue(jalali1.isValidDate(1390, 11, 1))
        assertFalse(jalali1.isValidDate(-1390, 11, 1))
        assertFalse(jalali1.isValidDate(1390, 13, 1))
        assertFalse(jalali1.isValidDate(1390, 12, 32))
    }

    @Test
    fun validTime() {
        assertTrue(jalali1.isValidTime(20, 40, 30))
        assertFalse(jalali1.isValidTime(25, 40, 30))
        assertFalse(jalali1.isValidTime(21, 61, 30))
        assertFalse(jalali1.isValidTime(22, 40, 70))
    }

    @Test
    fun equalTo() {
        assertTrue(jalali1.equalTo(jalali1))
        assertFalse(jalali1.equalTo(jalaliGreater))
        assertFalse(jalali1.equalTo(jalaliLess))
    }

    @Test
    fun greaterThan() {
        assertTrue(jalaliGreater.greaterThan(jalali1))
        assertTrue(jalaliGreater.greaterThan(jalaliLess))
        assertFalse(jalaliLess.greaterThan(jalaliGreater))
        assertFalse(jalaliLess.greaterThan(jalali1))
    }

    @Test
    fun lessThan() {
        assertFalse(jalaliGreater.lessThan(jalali1))
        assertFalse(jalaliGreater.lessThan(jalaliLess))
        assertTrue(jalaliLess.lessThan(jalaliGreater))
        assertTrue(jalaliLess.lessThan(jalali1))
    }

    @Test
    fun between() {
        assertTrue(jalali1.between(jalaliGreater, jalaliLess))
        assertFalse(jalaliLess.between(jalaliGreater, jalali1))
        assertFalse(jalaliGreater.between(jalaliLess, jalali1))
    }

    @Test
    fun isWeekend() {
        assertFalse(jalali1.isWeekend())
        assertTrue(Jalali(1400, 7, 30).isWeekend())
        assertTrue(Jalali(1400, 7, 29).isWeekend())
    }

    @Test
    fun isDay() {
        assertTrue(jalali1.isSaturday())
        assertFalse(jalali1.isSunday())
        assertFalse(jalali1.isMonday())
        assertFalse(jalali1.isTuesday())
        assertFalse(jalali1.isWednesday())
        assertFalse(jalali1.isTuesday())
        assertFalse(jalali1.isFriday())

        assertFalse(jalali1.isTomorrow())
        assertFalse(jalaliLess.isYesterday())
        assertFalse(jalali1.isToday())
    }
}

