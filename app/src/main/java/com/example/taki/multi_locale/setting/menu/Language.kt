package com.example.taki.multi_locale.setting.menu

enum class Language(
    override val code: String,
    override val displayName: String
) : Setting {
    JA("ja", "日本語"),
    EN("en", "English");

    companion object {
        fun getLanguage(code: String): Language? {
            return values().firstOrNull { it.code == code }
        }
    }
}