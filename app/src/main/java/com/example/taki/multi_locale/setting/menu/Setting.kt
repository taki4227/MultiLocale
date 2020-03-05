package com.example.taki.multi_locale.setting.menu

interface Setting {
    val code: String
    val displayName: String

    override fun equals(other: Any?): Boolean
}