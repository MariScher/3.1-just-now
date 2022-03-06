fun main() {
    val userTime: UInt = 12500U

    val convertTime = when (userTime) {
        in 61U..3600U -> userTime / 60u
        in 3601U..86_400U -> userTime / 3600U
        else -> userTime
    }

    val result = agoToText(userTime, convertTime, minutesText(convertTime), hoursText(convertTime))
    println("был(а) $result")
}

fun agoToText(userTime: UInt, convertTime: UInt, minutesText: String, hoursText: String): String {
    return when (userTime) {
        in 0U..60U -> "только что"
        in 61U..3600U -> "$convertTime $minutesText назад"
        in 3601U..86_400U -> "$convertTime $hoursText назад"
        in 86_401U..172_800U -> "сегодня"
        in 172_801U..259_200U -> "вчера"
        else -> "давно"
    }
}

fun minutesText(convertTime: UInt): String {
    return if (convertTime % 10U == 1U && convertTime != 11U) {
        "минуту"
    } else if (convertTime % 10U in 2U..4U) {
        "минуты"
    } else {
        "минут"
    }
}

fun hoursText(convertTime: UInt) = when (convertTime) {
    1U, 21U -> "час"
    in 2U..4U, 22U, 23U, 24U -> "часа"
    else -> "часов"
}