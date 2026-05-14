package com.nammaVastra.app.ui.weaverstory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nammaVastra.app.adapter.WeaverStoryAdapter
import com.nammaVastra.app.databinding.FragmentWeaverStoryBinding
import com.nammaVastra.app.model.WeaverStory

class WeaverStoryFragment : Fragment() {

    private var _binding: FragmentWeaverStoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeaverStoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWeaverList()
    }

    private fun setupWeaverList() {
        val weavers = getSampleWeavers()
        val adapter = WeaverStoryAdapter(weavers)
        binding.rvWeavers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvWeavers.adapter = adapter
    }

    private fun getSampleWeavers(): List<WeaverStory> {
        return listOf(
            WeaverStory(
                id = "1",
                weaverName = "Smt. Kavitha Deshpande",
                village = "Ilkal, Bagalkot District",
                experience = "28 years",
                story = "Kavitha learned weaving at age 10 from her mother. Today she creates intricate kasuti-embroidered Ilkal sarees that are sold across Karnataka. She has trained over 40 women in her village, turning weaving into a sustainable livelihood.",
                specialty = "Ilkal Kasuti Silk Sarees",
                phone = "+919876543210"
            ),
            WeaverStory(
                id = "2",
                weaverName = "Sri. Ramaiah Mudenur",
                village = "Molakalmuru, Chitradurga District",
                experience = "35 years",
                story = "Ramaiah is the third generation of weavers in his family. His Molakalmuru pure silk sarees are known for their exceptional lightness and vibrant natural colors. He recently won the Karnataka State Handicrafts Award 2023.",
                specialty = "Molakalmuru Pure Silk",
                phone = "+919876543211"
            ),
            WeaverStory(
                id = "3",
                weaverName = "Smt. Girija Ranganath",
                village = "Ilkal, Bagalkot District",
                experience = "20 years",
                story = "Girija specializes in bridal Ilkal sarees with heavy gold zari work. After losing her husband, she turned weaving into her full-time profession and now earns ₹25,000 per month, supporting her three children's education.",
                specialty = "Bridal Zari Sarees",
                phone = "+919876543212"
            ),
            WeaverStory(
                id = "4",
                weaverName = "Sri. Manjunath Siddappa",
                village = "Molakalmuru, Chitradurga District",
                experience = "15 years",
                story = "Young and innovative, Manjunath blends traditional Molakalmuru weaving techniques with modern geometric patterns. His fusion sarees have found customers in cities like Bengaluru, Mumbai and even overseas.",
                specialty = "Modern Fusion Silk",
                phone = "+919876543213"
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
