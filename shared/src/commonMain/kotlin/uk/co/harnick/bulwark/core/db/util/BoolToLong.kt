package uk.co.harnick.bulwark.core.db.util

fun Boolean.toLong(): Long = if (this) 1L else 0L