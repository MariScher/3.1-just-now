fun main() {
    val userTime = 12500

    val convertTime = when (userTime) {
        in 61..3600 -> userTime / 60
        in 3601..86_400 -> userTime / 3600
        else -> userTime
    }

    val result = agoToText(userTime, convertTime, minutesText(convertTime), hoursText(convertTime))
    println("был(а) $result")
}

fun agoToText(userTime: Int, convertTime: Int, minutesText: String, hoursText: String): String {
    return when (userTime) {
        in 0..60 -> "только что"
        in 61..3600 -> "$convertTime $minutesText назад"
        in 3601..86_400 -> "$convertTime $hoursText назад"
        in 86_401..172_800 -> "сегодня"
        in 172_801..259_200 -> "вчера"
        else -> "давно"
    }
}

fun minutesText(convertTime: Int): String {
    return if (convertTime % 10 == 1 && convertTime != 11) {
        "минуту"
    } else if (convertTime % 10 in 2..4) {
        "минуты"
    } else {
        "минут"
    }
}

fun hoursText(convertTime: Int) = when (convertTime) {
    1 -> "час"
    in 2..4 -> "часа"
    else -> "часов"
}