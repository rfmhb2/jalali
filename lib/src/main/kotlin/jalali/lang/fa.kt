package jalali.lang

import jalali.Constants

class fa {
    companion object {
        val numbers = arrayOf(
            "۰",
            "۱",
            "۲",
            "۳",
            "۴",
            "۵",
            "۶",
            "۷",
            "۸",
            "۹"
        )

        val year_months = mapOf(
            1 to "فروردین",
            2 to "اردیبهشت",
            3 to "خرداد",
            4 to "تیر",
            5 to "مرداد",
            6 to "شهریور",
            7 to "مهر",
            8 to "آبان",
            9 to "آذر",
            10 to "دی",
            11 to "بهمن",
            12 to "اسفند",
        )

        val weekdays = mapOf(
            1 to "شنبه",
            2 to "یکشنبه",
            3 to "دوشنبه",
            4 to "سه شنبه",
            5 to "چهارشنبه",
            6 to "پنج شنبه",
            7 to "جمعه",
        )
        val date_units = mapOf(
            "second" to "ثانیه",
            "mintue" to "دقیقه",
            "hour" to "ساعت",
            "day" to "روز",
            "week" to "هفته",
            "month" to "ماه",
            "yaer" to "سال",
            "decade" to "دهه",
            "century" to "قرن"
        )
        val phrase = mapOf(
            "am" to "ق ظ",
            "pm" to "ب ظ",
            "ante_meridiem" to "قبل از ظهر",
            "post_meridiem" to "بعد از ظهر",
            "th" to "ام",
            "ago" to "قبل",
            "now" to "الان",
            "later" to "بعد",
        )

        val gToPDayOfWeek = mapOf(
            1 to 3,
            2 to 4,
            3 to 5,
            4 to 6,
            5 to 7,
            6 to 1,
            7 to 2
        )

        val weekendDays = arrayOf(Constants.THURSDAY, Constants.FRIDAY)

        val zoneId = "Asia/Tehran"
    }
}