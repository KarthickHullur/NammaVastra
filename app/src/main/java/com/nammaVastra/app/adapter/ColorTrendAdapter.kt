package com.nammaVastra.app.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nammaVastra.app.databinding.ItemColorSwatchBinding

class ColorTrendAdapter(private val colors: List<Pair<String, String>>) :
    RecyclerView.Adapter<ColorTrendAdapter.ColorViewHolder>() {

    inner class ColorViewHolder(val binding: ItemColorSwatchBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val binding = ItemColorSwatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ColorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val (hex, name) = colors[position]
        with(holder.binding) {
            tvColorLabel.text = name
            try {
                viewSwatch.setBackgroundColor(Color.parseColor(hex))
            } catch (e: Exception) {
                viewSwatch.setBackgroundColor(Color.LTGRAY)
            }
        }
    }

    override fun getItemCount() = colors.size
}
