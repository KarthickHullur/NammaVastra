package com.nammaVastra.app.ui.loomgallery

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.nammaVastra.app.R
import com.nammaVastra.app.databinding.ActivityUploadSareeBinding

class UploadSareeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUploadSareeBinding
    private var selectedImageUri: Uri? = null

    private val imagePickerLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            selectedImageUri = it
            binding.ivSareePreview.load(it) {
                crossfade(true)
                placeholder(R.drawable.ic_image_placeholder)
            }
            binding.tvSelectImage.text = "Image Selected ✓"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadSareeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Upload Your Saree"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.cardSelectImage.setOnClickListener {
            imagePickerLauncher.launch("image/*")
        }

        binding.btnUpload.setOnClickListener {
            validateAndUpload()
        }
    }

    private fun validateAndUpload() {
        val name = binding.etSareeName.text.toString().trim()
        val description = binding.etDescription.text.toString().trim()
        val price = binding.etPrice.text.toString().trim()
        val weaverName = binding.etWeaverName.text.toString().trim()
        val phone = binding.etPhone.text.toString().trim()

        when {
            name.isEmpty() -> binding.etSareeName.error = "Enter saree name"
            description.isEmpty() -> binding.etDescription.error = "Enter description"
            price.isEmpty() -> binding.etPrice.error = "Enter price"
            weaverName.isEmpty() -> binding.etWeaverName.error = "Enter your name"
            phone.isEmpty() -> binding.etPhone.error = "Enter phone number"
            selectedImageUri == null -> Toast.makeText(this, "Please select a saree image", Toast.LENGTH_SHORT).show()
            else -> {
                // In production this uploads to Firebase Storage + Firestore
                Toast.makeText(this, "Saree '${name}' uploaded successfully! 🎉", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
