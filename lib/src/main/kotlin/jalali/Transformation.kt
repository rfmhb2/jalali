package jalali

import jalali.Constants.daysMonthGregorian
import jalali.Constants.daysMonthJalali
import kotlin.math.floor

object Transformation {
    fun getJalali(g_y: Int, g_m: Int, g_d: Int): Array<Int> {
        val gy = g_y - 1600
        val gm = g_m - 1
        //$g_day_no = (365 * $gy + static::div($gy + 3, 4) - static::div($gy + 99, 100) + static::div($gy + 399, 400));
        //                             153771                          5                   2
        var g_day_no = (365 * gy + div(gy + 3, 4) - div(gy + 99, 100) + div(gy + 399, 400))
        for (i in 0 until gm) {
            g_day_no += daysMonthGregorian[i]
        }
        if (gm > 1 && ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)))
            g_day_no++
        g_day_no += g_d - 1
        var j_day_no = g_day_no - 79
        val j_np = div(j_day_no, 12053) // 12053 = (365 * 33 + 32 / 4)
        j_day_no %= 12053
        var jy = (979 + 33 * j_np + 4 * div(j_day_no, 1461)) // # 1461 = (365 * 4 + 4 / 4)
        j_day_no %= 1461
        if (j_day_no >= 366) {
            jy += div(j_day_no - 1, 365)
            j_day_no = (j_day_no - 1) % 365
        }
        var i = 0
        while (i < 11 && j_day_no >= daysMonthJalali[i]) {
            j_day_no -= daysMonthJalali[i]
            ++i
        }
        return arrayOf(jy, i + 1, j_day_no + 1)
    }

    fun getGregorian(j_y: Int, j_m: Int, j_d: Int): Array<Int> {
        val jy = j_y - 979
        val jm = j_m - 1
        var j_day_no = (365 * jy + div(jy, 33) * 8 + div(jy % 33 + 3, 4))
        for (i in 0 until jm) {
            j_day_no += daysMonthJalali[i]
        }
        j_day_no += j_d - 1
        var g_day_no = j_day_no + 79
        // # 146097 = (365 * 400 + 400 / 4 - 400 / 100 + 400 / 400)
        var gy = (1600 + 400 * div(g_day_no, 146097))
        g_day_no = g_day_no % 146097
        var leap = 1
        if (g_day_no >= 36525) {
            // # 36525 = (365 * 100 + 100 / 4)
            g_day_no--
            gy += (100 * div(g_day_no, 36524)) // # 36524 = (365 * 100 + 100 / 4 - 100 / 100)
            g_day_no %= 36524
            if (g_day_no >= 365) {
                g_day_no++
            } else {
                leap = 0
            }
        }
        gy += (4 * div(g_day_no, 1461)) // # 1461 = (365 * 4 + 4 / 4)
        g_day_no %= 1461
        if (g_day_no >= 366) {
            leap = 0
            g_day_no--
            gy += div(g_day_no, 365)
            g_day_no = (g_day_no % 365)
        }
        var i = 0
        while (g_day_no >= (daysMonthGregorian[i] + if (i == 1 && leap > 0) 1 else 0)) {
            g_day_no -= (daysMonthGregorian[i] + if (i == 1 && leap > 0) 1 else 0)
            i++
        }
        return arrayOf(gy, i + 1, g_day_no + 1)
    }

    fun div(a: Int, b: Int): Int {
        return floor((a / b.toFloat())).toInt()
    }
}


