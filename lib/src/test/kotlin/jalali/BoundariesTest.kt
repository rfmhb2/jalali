package jalali
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import java.time.LocalDateTime

class BoundariesTest {
    val jalali=Jalali(LocalDateTime.now())
    
    @Test
    fun startDay() {
        jalali.startDay()
        println(jalali.formatTime())
        assertTrue(jalali.hour==0)
    }
}


