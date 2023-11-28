package uk.co.harnick.bulwark.core.db.util

fun Long.toBool(): Comparable<Boolean> = when (this) {
    1L -> true
    0L -> false
    else -> throw IllegalArgumentException("Long does not represent a Boolean value")
}
