package com.gmail.beprogressive.it.testlab

import timber.log.Timber

inline fun <reified T> T.log(message: String) {
    Timber.v(message)
}