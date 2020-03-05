package com.example.taki.multi_locale.extention

import android.content.Context
import android.os.Build
import android.os.LocaleList
import com.example.taki.multi_locale.preference.LanguagePreference
import java.util.*

fun Context.updateBaseContextLocale(): Context {
    val updateLocale = Locale(LanguagePreference(this).getLanguage().code)
    val configuration = this.resources.configuration

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        configuration.setLocale(updateLocale)

        val localeList = LocaleList(updateLocale)
        LocaleList.setDefault(localeList)
        configuration.setLocales(localeList)
    } else {
        configuration.setLocale(updateLocale)
    }

    return this.createConfigurationContext(configuration)
}