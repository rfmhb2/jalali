package jalali

import org.junit.Test
import kotlin.test.assertEquals

class Format {
    private val jalali = Jalali(1400, 8, 3, 20, 16, 40)

    @Test
    fun formatTime() {
        assertEquals(jalali.formatTime(), "20:16:40")
    }

    @Test
    fun formatDate() {
        assertEquals(jalali.formatDate(), "1400-8-3")
    }

    @Test
    fun formatDateTime() {
        assertEquals(jalali.formatDateTime(), "1400-8-3 20:16:40")
    }
}