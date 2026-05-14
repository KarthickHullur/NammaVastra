package com.nammaVastra.app.model

data class Saree(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val imageUrl: String = "",
    val weaverName: String = "",
    val weaverPhone: String = "",
    val category: String = "",
    val colors: List<String> = emptyList(),
    val timestamp: Long = System.currentTimeMillis()
)
