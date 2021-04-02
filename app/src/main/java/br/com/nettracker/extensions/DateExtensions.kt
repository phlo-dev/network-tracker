package br.com.nettracker.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.format(pattern: String = "d 'de' MMM 'às' HH:mm"): String = SimpleDateFormat(
    pattern, Locale.getDefault()
).format(this)