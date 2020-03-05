package com.example.taki.multi_locale.setting

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.taki.multi_locale.R

class SettingFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_preference, rootKey)
    }

    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        return when (preference?.key) {
            resources.getString(R.string.language_key) -> {
                findNavController().navigate(R.id.navigate_to_language_setting)
                true
            }
            else -> {
                false
            }
        }
    }
}
