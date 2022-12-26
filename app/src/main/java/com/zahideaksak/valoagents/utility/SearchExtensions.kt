package com.zahideaksak.valoagents.utility


fun String.addSearchPrefix(prefix: String): String {
    return prefix.plus(this)
}

infix fun String.okWith(bound: Int) = length > bound