package com.example.taki.multi_locale.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import java.util.*
import com.example.taki.multi_locale.R
import com.example.taki.multi_locale.setting.menu.Language

class LanguagePreference(context: Context) {

    private val sharedPreferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    private val languageKey = context.resources.getString(R.string.language_key)

    fun setLanguage(language: Language) {
        sharedPreferences.edit().putString(languageKey, language.code).apply()
    }

    /**
     * 言語設定を取得する
     * 未設定の場合、端末の言語設定で選択された言語を返す
     */
    fun getLanguage(): Language {
        val deviceLanguage = Locale.getDefault().language
        val defaultLanguage = Language.getLanguage(deviceLanguage)?.code ?: Language.EN.code

        val code = sharedPreferences.getString(languageKey, defaultLanguage)
        val language = Language.getLanguage(code!!)

        return language ?: Language.EN
    }

}