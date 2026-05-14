package com.nammaVastra.app.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nammaVastra.app.databinding.ItemWeaverStoryBinding
import com.nammaVastra.app.model.WeaverStory

class WeaverStoryAdapter(private val weavers: List<WeaverStory>) :
    RecyclerView.Adapter<WeaverStoryAdapter.WeaverViewHolder>() {

    inner class WeaverViewHolder(val binding: ItemWeaverStoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaverViewHolder {
        val binding = ItemWeaverStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeaverViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeaverViewHolder, position: Int) {
        val weaver = weavers[position]
        with(holder.binding) {
            tvWeaverName.text = weaver.weaverName
            tvVillage.text = "📍 ${weaver.village}"
            tvExperience.text = "🕐 ${weaver.experience} of experience"
            tvSpecialty.text = "🧵 ${weaver.specialty}"
            tvStory.text = weaver.story

            // WhatsApp button
            btnWhatsApp.setOnClickListener {
                val cleanPhone = weaver.phone.replace("+", "").replace(" ", "")
                val message = "Hello ${weaver.weaverName}! I found your profile on Namma-Vastra app. I'm interested in your ${weaver.specialty}. Could you please share available sarees?"
                val url = "https://wa.me/$cleanPhone?text=${Uri.encode(message)}"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                intent.setPackage("com.whatsapp")
                try {
                    it.context.startActivity(intent)
                } catch (e: Exception) {
                    it.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                }
            }
        }
    }

    override fun getItemCount() = weavers.size
}
