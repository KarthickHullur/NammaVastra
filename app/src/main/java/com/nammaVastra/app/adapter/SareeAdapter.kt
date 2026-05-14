package com.nammaVastra.app.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nammaVastra.app.R
import com.nammaVastra.app.databinding.ItemSareeBinding
import com.nammaVastra.app.model.Saree

class SareeAdapter(
    private val sarees: List<Saree>,
    private val onItemClick: (Saree) -> Unit
) : RecyclerView.Adapter<SareeAdapter.SareeViewHolder>() {

    inner class SareeViewHolder(val binding: ItemSareeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SareeViewHolder {
        val binding = ItemSareeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SareeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SareeViewHolder, position: Int) {
        val saree = sarees[position]
        with(holder.binding) {
            tvSareeName.text = saree.name
            tvPrice.text = "₹ ${String.format("%,.0f", saree.price)}"
            tvWeaverName.text = saree.weaverName
            tvCategory.text = saree.category

            // Set color indicators
            val colorViews = listOf(viewColor1, viewColor2)
            saree.colors.forEachIndexed { index, colorHex ->
                if (index < colorViews.size) {
                    try {
                        colorViews[index].setBackgroundColor(Color.parseColor(colorHex))
                        colorViews[index].visibility = android.view.View.VISIBLE
                    } catch (e: Exception) {
                        colorViews[index].visibility = android.view.View.GONE
                    }
                }
            }

            // Set placeholder icon based on category
            val iconRes = if (saree.category == "Ilkal") R.drawable.ic_saree_ilkal else R.drawable.ic_saree_molakalmuru
            ivSaree.setImageResource(iconRes)

            root.setOnClickListener { onItemClick(saree) }
        }
    }

    override fun getItemCount() = sarees.size
}
