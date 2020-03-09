package com.topjohnwu.magisk.extensions

import android.app.Activity
import android.view.View
import android.widget.Toast

var toast:Toast? = null;

fun Activity.snackbar(
    view: View,
    message: String,
    length: Int = Toast.LENGTH_SHORT,
    f: Toast.() -> Unit = {}
) {
    toast?.cancel()
    toast = Toast.makeText(view.context, message, length)
    toast!!
    .apply(f)
    .show()
}
