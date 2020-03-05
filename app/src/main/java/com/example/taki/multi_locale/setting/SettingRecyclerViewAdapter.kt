package com.example.taki.multi_locale.setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taki.multi_locale.databinding.ListRadioButtonCellBinding
import com.example.taki.multi_locale.setting.menu.Setting
import com.example.taki.multi_locale.R

class SettingRecyclerViewAdapter(var selected: String = "") :
    ListAdapter<Setting, SettingRecyclerViewAdapter.ViewHolder>(DIFF_CALLBACK) {

    var itemClickListener: (view: View, setting: Setting) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_radio_button_cell, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Setting>() {
            override fun areItemsTheSame(oldItem: Setting, newItem: Setting): Boolean {
                return oldItem.code == newItem.code
            }

            override fun areContentsTheSame(oldItem: Setting, newItem: Setting): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ListRadioButtonCellBinding? = DataBindingUtil.bind(view)

        fun bind(item: Setting) {
            binding!!.text = item.displayName
            binding.showImage = selected == item.code
            binding.onClick = View.OnClickListener {
                itemClickListener(it, item)
                selected = item.code
                notifyDataSetChanged()
            }

            binding.executePendingBindings()
        }
    }
}