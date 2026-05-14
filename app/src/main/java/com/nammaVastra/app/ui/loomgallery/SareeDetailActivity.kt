package com.nammaVastra.app.ui.loomgallery

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nammaVastra.app.databinding.ActivitySareeDetailBinding

class SareeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySareeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySareeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("saree_name") ?: "Saree"
        val description = intent.getStringExtra("saree_description") ?: ""
        val price = intent.getDoubleExtra("saree_price", 0.0)
        val weaverName = intent.getStringExtra("saree_weaver") ?: ""
        val phone = intent.getStringExtra("saree_phone") ?: ""
        val category = intent.getStringExtra("saree_category") ?: ""

        supportActionBar?.title = name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.tvSareeName.text = name
        binding.tvDescription.text = description
        binding.tvPrice.text = "₹ ${String.format("%,.0f", price)}"
        binding.tvWeaverName.text = "Weaver: $weaverName"
        binding.tvCategory.text = "Category: $category"

        binding.btnWhatsApp.setOnClickListener {
            openWhatsApp(phone, name, price)
        }

        binding.btnCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
            startActivity(callIntent)
        }
    }

    private fun openWhatsApp(phone: String, sareeName: String, price: Double) {
        val cleanPhone = phone.replace("+", "").replace(" ", "")
        val message = "Hello! I'm interested in purchasing your *$sareeName* saree listed on Namma-Vastra app for ₹${String.format("%,.0f", price)}. Could you please share more details?"
        val url = "https://wa.me/$cleanPhone?text=${Uri.encode(message)}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.setPackage("com.whatsapp")
        try {
            startActivity(intent)
        } catch (e: Exception) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
