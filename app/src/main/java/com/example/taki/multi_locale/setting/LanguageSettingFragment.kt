package com.example.taki.multi_locale.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taki.multi_locale.databinding.FragmentLanguageSettingBinding
import com.example.taki.multi_locale.setting.menu.Language

class LanguageSettingFragment : Fragment() {

    private lateinit var binding: FragmentLanguageSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLanguageSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SettingRecyclerViewAdapter(Language.values().first().code).apply {
            itemClickListener = { _, item ->
                val selectedLanguage = item as Language
            }

            submitList(Language.values().toList())
        }

        binding.recyclerView.let {
            it.layoutManager = LinearLayoutManager(this.context)
            it.adapter = adapter
        }
    }
}