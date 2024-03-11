package com.castres.breand.block6.p1.androidproject

// CartItem.kt
data class CartItem(
    val productId: String,
    val productName: String,
    val productPrice: Double,
    val productImageResId: Int,
    val productDescription: String,
    var quantity: Int = 1  // Default quantity is 1
)
