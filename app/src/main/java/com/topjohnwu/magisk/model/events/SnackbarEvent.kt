package com.topjohnwu.magisk.model.events

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

class SnackbarEvent private constructor(
    @StringRes private val messageRes: Int,
    private val messageString: String?,
    val length: Int,
    val f: Toast.() -> Unit
) : ViewEvent() {

    constructor(
        @StringRes messageRes: Int,
        length: Int = Toast.LENGTH_SHORT,
        f: Toast.() -> Unit = {}
    ) : this(messageRes, null, length, f)

    constructor(
        message: String,
        length: Int = Toast.LENGTH_SHORT,
        f: Toast.() -> Unit = {}
    ) : this(-1, message, length, f)

    fun message(context: Context): String = messageString ?: context.getString(messageRes)
}
