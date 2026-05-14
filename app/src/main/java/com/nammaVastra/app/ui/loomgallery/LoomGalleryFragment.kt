package com.nammaVastra.app.ui.loomgallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.nammaVastra.app.adapter.SareeAdapter
import com.nammaVastra.app.databinding.FragmentLoomGalleryBinding
import com.nammaVastra.app.model.Saree

class LoomGalleryFragment : Fragment() {

    private var _binding: FragmentLoomGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoomGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupGallery()

        binding.fabUpload.setOnClickListener {
            startActivity(Intent(requireContext(), UploadSareeActivity::class.java))
        }
    }

    private fun setupGallery() {
        val sarees = getSampleSarees()
        val adapter = SareeAdapter(sarees) { saree ->
            val intent = Intent(requireContext(), SareeDetailActivity::class.java).apply {
                putExtra("saree_name", saree.name)
                putExtra("saree_description", saree.description)
                putExtra("saree_price", saree.price)
                putExtra("saree_weaver", saree.weaverName)
                putExtra("saree_phone", saree.weaverPhone)
                putExtra("saree_category", saree.category)
            }
            startActivity(intent)
        }
        binding.rvGallery.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvGallery.adapter = adapter
    }

    private fun getSampleSarees(): List<Saree> {
        return listOf(
            Saree(
                id = "1", name = "Ilkal Kasuti Silk",
                description = "Traditional Ilkal saree with intricate kasuti embroidery. Pure silk with gold zari borders.",
                price = 4500.0, weaverName = "Ramaiah M", weaverPhone = "+919876543210",
                category = "Ilkal", colors = listOf("#D4AF37", "#8B0000")
            ),
            Saree(
                id = "2", name = "Molakalmuru Pure Silk",
                description = "Lightweight Molakalmuru silk with vibrant temple border. Ideal for festivals.",
                price = 6200.0, weaverName = "Kavitha D", weaverPhone = "+919876543211",
                category = "Molakalmuru", colors = listOf("#228B22", "#FFD700")
            ),
            Saree(
                id = "3", name = "Ilkal Cotton Blend",
                description = "Comfortable cotton-silk blend perfect for everyday wear. Natural dyes used.",
                price = 2800.0, weaverName = "Shivanna K", weaverPhone = "+919876543212",
                category = "Ilkal", colors = listOf("#FF6B35", "#FFFFFF")
            ),
            Saree(
                id = "4", name = "Molakalmuru Bridal",
                description = "Exquisite bridal saree with heavy zari work and traditional motifs. Pure mulberry silk.",
                price = 12000.0, weaverName = "Girija R", weaverPhone = "+919876543213",
                category = "Molakalmuru", colors = listOf("#8B0000", "#D4AF37")
            ),
            Saree(
                id = "5", name = "Ilkal Geometric Design",
                description = "Modern geometric patterns woven on traditional Ilkal loom. Perfect fusion wear.",
                price = 3800.0, weaverName = "Manjunath S", weaverPhone = "+919876543214",
                category = "Ilkal", colors = listOf("#4B0082", "#FFFFFF")
            ),
            Saree(
                id = "6", name = "Molakalmuru Pastel",
                description = "Soft pastel silk with fine zari border. Trending bridal choice for 2024.",
                price = 8500.0, weaverName = "Sumathi P", weaverPhone = "+919876543215",
                category = "Molakalmuru", colors = listOf("#FFB6C1", "#D4AF37")
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
