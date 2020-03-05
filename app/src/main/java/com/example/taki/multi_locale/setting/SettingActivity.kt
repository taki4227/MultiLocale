package com.example.taki.multi_locale.setting

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.taki.multi_locale.R
import com.example.taki.multi_locale.databinding.ActivitySettingBinding
import com.example.taki.multi_locale.extention.updateBaseContextLocale

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.updateBaseContextLocale())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_setting
        )

        val navController = findNavController(R.id.nav_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_fragment).navigateUp()

    companion object {
        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, SettingActivity::class.java))
        }
    }
}