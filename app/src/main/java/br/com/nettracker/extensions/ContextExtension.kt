package br.com.nettracker.extensions

import android.content.Context
import android.widget.Toast


private var toast: Toast? = null
fun Context.showToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    toast?.cancel()
    toast = Toast.makeText(this, message, duration)
    toast?.show()
}