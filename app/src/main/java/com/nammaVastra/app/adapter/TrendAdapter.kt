package com.nammaVastra.app.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nammaVastra.app.databinding.ItemTrendBinding
import com.nammaVastra.app.model.Trend

class TrendAdapter(private val trends: List<Trend>) :
    RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {

    inner class TrendViewHolder(val binding: ItemTrendBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        val binding = ItemTrendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        val trend = trends[position]
        with(holder.binding) {
            tvTrendTitle.text = trend.title
            tvTrendDescription.text = trend.description
            tvSeason.text = trend.season
            tvColorName.text = trend.colorName
            try {
                viewColorSwatch.setBackgroundColor(Color.parseColor(trend.colorHex))
            } catch (e: Exception) {
                viewColorSwatch.setBackgroundColor(Color.GRAY)
            }
        }
    }

    override fun getItemCount() = trends.size
}
