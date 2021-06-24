package com.example.mvpapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpapp.R
import com.example.mvpapp.databinding.RecyclerViewItemBinding
import com.example.mvpapp.model.ColorsModel

class RecyclerViewAdapter(val copyHex: (hex: String) -> Unit) :
    ListAdapter<ColorsModel, RecyclerViewAdapter.ItemViewHolder>(DiffCallback()) {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = RecyclerViewItemBinding.bind(itemView)

        fun bind(item: ColorsModel) = with(itemView) {
            binding.colorHexTextView.text = item.hex
            binding.colorNameTextView.text = item.colorName
            binding.colorImageView.setImageResource(item.color)
            binding.copyButton.setOnClickListener { copyHex(item.hex) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class DiffCallback : DiffUtil.ItemCallback<ColorsModel>() {

    override fun areItemsTheSame(
        oldItem: ColorsModel,
        newItem: ColorsModel
    ): Boolean = oldItem.hex == newItem.hex

    override fun areContentsTheSame(
        oldItem: ColorsModel,
        newItem: ColorsModel
    ): Boolean = oldItem == newItem

}