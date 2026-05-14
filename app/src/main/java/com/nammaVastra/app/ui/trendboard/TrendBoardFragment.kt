package com.nammaVastra.app.ui.trendboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nammaVastra.app.adapter.ColorTrendAdapter
import com.nammaVastra.app.adapter.TrendAdapter
import com.nammaVastra.app.databinding.FragmentTrendBoardBinding
import com.nammaVastra.app.model.Trend

class TrendBoardFragment : Fragment() {

    private var _binding: FragmentTrendBoardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrendBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTrendList()
        setupColorPalette()
    }

    private fun setupTrendList() {
        val trends = getSampleTrends()
        val adapter = TrendAdapter(trends)
        binding.rvTrends.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTrends.adapter = adapter
    }

    private fun setupColorPalette() {
        val colors = listOf(
            Pair("#D4AF37", "Golden"),
            Pair("#8B0000", "Deep Red"),
            Pair("#228B22", "Forest Green"),
            Pair("#000080", "Navy Blue"),
            Pair("#FF6B35", "Saffron"),
            Pair("#4B0082", "Indigo"),
            Pair("#C71585", "Rose"),
            Pair("#2F4F4F", "Dark Teal")
        )
        val adapter = ColorTrendAdapter(colors)
        binding.rvColors.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.rvColors.adapter = adapter
    }

    private fun getSampleTrends(): List<Trend> {
        return listOf(
            Trend(
                id = "1",
                title = "Earthy Tones Revival",
                description = "Terracotta, mustard, and sage green are dominating the 2024 handloom season. Perfect for Ilkal silk sarees.",
                colorHex = "#C17B49",
                colorName = "Terracotta",
                season = "Summer 2024"
            ),
            Trend(
                id = "2",
                title = "Geometric Borders",
                description = "Bold geometric patterns in Molakalmuru silk are trending in urban fashion weeks across India.",
                colorHex = "#8B0000",
                colorName = "Deep Red",
                season = "All Season"
            ),
            Trend(
                id = "3",
                title = "Pastel Zari Work",
                description = "Soft pastel backgrounds with rich zari borders are highly demanded in bridal collections.",
                colorHex = "#FFB6C1",
                colorName = "Pastel Pink",
                season = "Wedding Season"
            ),
            Trend(
                id = "4",
                title = "Nature-Inspired Motifs",
                description = "Lotus, peacock, and mango (paisley) motifs woven in contrasting threads are a bestseller.",
                colorHex = "#228B22",
                colorName = "Forest Green",
                season = "Festive 2024"
            ),
            Trend(
                id = "5",
                title = "Indigo & White Contrast",
                description = "Classic indigo dyed threads with crisp white create a timeless look beloved by minimalists.",
                colorHex = "#4B0082",
                colorName = "Indigo",
                season = "Year Round"
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
