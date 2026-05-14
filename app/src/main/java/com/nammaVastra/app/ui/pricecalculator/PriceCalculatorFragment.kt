package com.nammaVastra.app.ui.pricecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.nammaVastra.app.databinding.FragmentPriceCalculatorBinding

class PriceCalculatorFragment : Fragment() {

    private var _binding: FragmentPriceCalculatorBinding? = null
    private val binding get() = _binding!!

    // Cost multipliers per meter based on yarn type
    private val yarnCostPerMeter = mapOf(
        "Pure Silk" to 180.0,
        "Cotton-Silk Blend" to 90.0,
        "Pure Cotton" to 45.0,
        "Art Silk" to 60.0
    )

    // Zari cost per saree
    private val zariCost = mapOf(
        "No Zari" to 0.0,
        "Light Zari Border" to 400.0,
        "Heavy Zari Border" to 900.0,
        "Full Zari Work" to 2000.0
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPriceCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSpinners()

        binding.btnCalculate.setOnClickListener {
            calculatePrice()
        }

        binding.btnReset.setOnClickListener {
            resetFields()
        }
    }

    private fun setupSpinners() {
        val yarnTypes = yarnCostPerMeter.keys.toList()
        val yarnAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, yarnTypes)
        yarnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerYarnType.adapter = yarnAdapter

        val zariTypes = zariCost.keys.toList()
        val zariAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, zariTypes)
        zariAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerZariType.adapter = zariAdapter
    }

    private fun calculatePrice() {
        val lengthStr = binding.etLength.text.toString().trim()
        val daysStr = binding.etWeavingDays.text.toString().trim()

        if (lengthStr.isEmpty()) {
            binding.etLength.error = "Enter saree length"
            return
        }
        if (daysStr.isEmpty()) {
            binding.etWeavingDays.error = "Enter weaving days"
            return
        }

        val length = lengthStr.toDoubleOrNull() ?: 5.5
        val days = daysStr.toDoubleOrNull() ?: 3.0

        val selectedYarn = binding.spinnerYarnType.selectedItem.toString()
        val selectedZari = binding.spinnerZariType.selectedItem.toString()

        val yarnCost = (yarnCostPerMeter[selectedYarn] ?: 90.0) * length
        val zari = zariCost[selectedZari] ?: 0.0
        val labourCost = days * 350.0  // ₹350/day fair wage
        val overheadCost = (yarnCost + zari + labourCost) * 0.10  // 10% overhead
        val totalCost = yarnCost + zari + labourCost + overheadCost
        val profitMargin = totalCost * 0.35  // 35% profit
        val recommendedPrice = totalCost + profitMargin

        binding.tvCostBreakdown.visibility = View.VISIBLE
        binding.tvCostBreakdown.text = buildString {
            appendLine("📊 Cost Breakdown")
            appendLine("─────────────────────────")
            appendLine("🧵 Yarn Cost:      ₹ ${String.format("%,.0f", yarnCost)}")
            appendLine("✨ Zari Cost:       ₹ ${String.format("%,.0f", zari)}")
            appendLine("🙏 Labour Cost:    ₹ ${String.format("%,.0f", labourCost)}")
            appendLine("⚙️  Overhead (10%): ₹ ${String.format("%,.0f", overheadCost)}")
            appendLine("─────────────────────────")
            appendLine("💰 Total Cost:     ₹ ${String.format("%,.0f", totalCost)}")
            appendLine("📈 Profit (35%):   ₹ ${String.format("%,.0f", profitMargin)}")
            appendLine("═════════════════════════")
            append("🏷️  Sell at:         ₹ ${String.format("%,.0f", recommendedPrice)}")
        }

        binding.tvRecommendedPrice.visibility = View.VISIBLE
        binding.tvRecommendedPrice.text = "Recommended Price\n₹ ${String.format("%,.0f", recommendedPrice)}"
    }

    private fun resetFields() {
        binding.etLength.text?.clear()
        binding.etWeavingDays.text?.clear()
        binding.spinnerYarnType.setSelection(0)
        binding.spinnerZariType.setSelection(0)
        binding.tvCostBreakdown.visibility = View.GONE
        binding.tvRecommendedPrice.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
